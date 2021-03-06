package cc.hyperium.utils;

import cc.hyperium.installer.InstallerFrame;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class StaffUtils {
    private static final HashMap<UUID, DotColour> STAFF_CACHE = new HashMap<>();

    public static boolean isStaff(UUID uuid) {
        return STAFF_CACHE.keySet().contains(uuid);
    }

    public static DotColour getColor(UUID uuid) {
        return STAFF_CACHE.get(uuid);
    }

    public static HashMap<UUID, DotColour> getStaff() throws IOException {
        HashMap<UUID, DotColour> staff = new HashMap<>();
        String content = InstallerFrame.get("https://raw.githubusercontent.com/HyperiumClient/Hyperium-Repo/master/files/staff.json");
        JSONArray array = new JSONArray(content);
        for (int i = 0; i < array.length(); i++) {
            JSONObject item = array.getJSONObject(i);
            UUID uuid = UUID.fromString(item.getString("uuid"));
            String colourStr = item.getString("color").toUpperCase();
            DotColour colour;
            if (colourStr.equals("CHROMA")) {
                colour = new DotColour(true, ChatColor.WHITE);
            } else {
                colour = new DotColour(false, ChatColor.valueOf(colourStr));
            }
            staff.put(uuid, colour);
        }
        return staff;
    }

    public static void clearCache() throws IOException {
        STAFF_CACHE.clear();
        STAFF_CACHE.putAll(getStaff());
    }

    public static class DotColour {
        public boolean isChroma = false;
        public ChatColor baseColour;

        public DotColour(boolean isChroma, ChatColor baseColour) {
            this.isChroma = isChroma;
            this.baseColour = baseColour;
        }
    }
}
