package cc.hyperium.mods.orangemarshall.enhancements.modules;

import net.minecraft.client.*;
import cc.hyperium.mods.orangemarshall.enhancements.config.*;
import cc.hyperium.mods.orangemarshall.enhancements.util.*;
import net.minecraftforge.common.*;
import net.minecraftforge.client.event.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.potion.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ArmorPotential
{
    public static final String credit_goes_to = "KevyPorter";
    private Minecraft mc;
    private Config config;
    private String lastMessage;
    private static ArmorPotential instance;
    private Cooldown cooldown;
    
    public static ArmorPotential instance() {
        return ArmorPotential.instance;
    }
    
    public ArmorPotential() {
        this.mc = Minecraft.func_71410_x();
        this.config = Config.instance();
        this.lastMessage = "";
        this.cooldown = Cooldown.getNewCooldownMiliseconds(300);
        ArmorPotential.instance = this;
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @SubscribeEvent
    public void onRenderGameOverlayPost(final GuiScreenEvent.DrawScreenEvent.Post e) {
        if (e.gui instanceof GuiInventory || e.gui instanceof GuiContainerCreative) {
            final ScaledResolution scaledresolution = new ScaledResolution(this.mc);
            final int color = 16777215;
            final String message = this.getAsString();
            this.lastMessage = message;
            this.mc.field_71462_r.func_73731_b(this.mc.field_71466_p, message, 10, scaledresolution.func_78328_b() - 16, color);
        }
    }
    
    public String getAsString() {
        if (!this.cooldown.attemptReset()) {
            return this.lastMessage;
        }
        final double ap = this.roundDecimals(this.getArmorPotential(false), 2);
        final double app = this.roundDecimals(this.getArmorPotential(true), 2);
        if (!this.config.showProtectionInInventory || !this.config.showProjProtectionInInventory) {
            String lastMessage;
            final String s = this.config.showProtectionInInventory ? (lastMessage = ap + "%") : (this.config.showProjProtectionInInventory ? (lastMessage = app + "%") : (lastMessage = ""));
            this.lastMessage = lastMessage;
            return s;
        }
        if (ap == app) {
            return this.lastMessage = ap + "%";
        }
        return this.lastMessage = ap + "% | " + app + "%";
    }
    
    private double roundDecimals(double num, final int a) {
        if (num == 0.0) {
            return num;
        }
        num = (int)(num * Math.pow(10.0, a));
        num /= Math.pow(10.0, a);
        return num;
    }
    
    private double getArmorPotential(final boolean getProj) {
        final EntityPlayer player = (EntityPlayer)this.mc.field_71439_g;
        double armor = 0.0;
        int epf = 0;
        int resistance = 0;
        if (player.func_70644_a(Potion.field_76429_m)) {
            resistance = player.func_70660_b(Potion.field_76429_m).func_76458_c() + 1;
        }
        for (final ItemStack itemStack : player.field_71071_by.field_70460_b) {
            if (itemStack != null) {
                if (itemStack.func_77973_b() instanceof ItemArmor) {
                    final ItemArmor armorItem = (ItemArmor)itemStack.func_77973_b();
                    armor += armorItem.field_77879_b * 0.04;
                }
                if (itemStack.func_77948_v()) {
                    epf += this.getEffProtPoints(EnchantmentHelper.func_77506_a(0, itemStack), 0.75);
                }
                if (getProj && itemStack.func_77948_v()) {
                    epf += this.getEffProtPoints(EnchantmentHelper.func_77506_a(4, itemStack), 0.75);
                }
            }
        }
        epf = ((epf < 25) ? epf : 25);
        final double avgdef = this.addArmorProtResistance(armor, this.calcProtection(epf), resistance);
        final double avg = this.roundDouble(avgdef * 100.0);
        return avg;
    }
    
    private int getEffProtPoints(final int level, final double typeModifier) {
        return (level != 0) ? ((int)Math.floor((6 + level * level) * typeModifier / 3.0)) : 0;
    }
    
    private double calcProtection(final double armorEpf) {
        double protection = 0.0;
        for (int i = 50; i <= 100; ++i) {
            protection += ((Math.ceil(armorEpf * i / 100.0) < 20.0) ? Math.ceil(armorEpf * i / 100.0) : 20.0);
        }
        return protection / 51.0;
    }
    
    private double addArmorProtResistance(final double armor, final double prot, final int resi) {
        double protTotal = armor + (1.0 - armor) * prot * 0.04;
        protTotal += (1.0 - protTotal) * resi * 0.2;
        return (protTotal < 1.0) ? protTotal : 1.0;
    }
    
    private double roundDouble(final double number) {
        final double x = Math.round(number * 10000.0);
        return x / 10000.0;
    }
}
