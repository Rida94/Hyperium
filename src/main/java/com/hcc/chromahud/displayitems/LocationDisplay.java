package com.hcc.chromahud.displayitems;

import com.hcc.HCC;
import com.hcc.chromahud.ElementRenderer;
import com.hcc.chromahud.api.Dimension;
import com.hcc.chromahud.api.DisplayItem;
import com.hcc.utils.JsonHolder;
import net.minecraft.client.Minecraft;


/**
 * Created by mitchellkatz on 5/30/17.
 */
public class LocationDisplay extends DisplayItem {

    public LocationDisplay(JsonHolder raw, int ordinal) {
        super(raw, ordinal);
    }


    @Override
    public Dimension draw(int starX, double startY, boolean ignored) {
        String string = "Location: " + HCC.INSTANCE.getHandlers().getLocationHandler().getLocation();
        ElementRenderer.draw(starX, startY, string);
        return new Dimension(Minecraft.getMinecraft().fontRendererObj.getStringWidth(string), 10);
    }


}