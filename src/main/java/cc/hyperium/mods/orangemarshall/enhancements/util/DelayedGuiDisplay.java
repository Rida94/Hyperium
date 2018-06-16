package cc.hyperium.mods.orangemarshall.enhancements.util;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.client.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class DelayedGuiDisplay
{
    private int delayTicks;
    private Minecraft mcClient;
    private GuiScreen screen;
    
    public DelayedGuiDisplay(final int delayTicks, final GuiScreen screen) {
        this.delayTicks = delayTicks;
        this.mcClient = FMLClientHandler.instance().getClient();
        this.screen = screen;
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
        if (event.phase.equals((Object)TickEvent.Phase.START)) {
            return;
        }
        if (--this.delayTicks <= 0) {
            this.mcClient.func_147108_a(this.screen);
            MinecraftForge.EVENT_BUS.unregister((Object)this);
        }
    }
}
