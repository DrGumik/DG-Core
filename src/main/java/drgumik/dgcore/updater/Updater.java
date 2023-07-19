package drgumik.dgcore.updater;

import drgumik.dgcore.consoleLog.Log;
import org.bukkit.ChatColor;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Class for checking if there is a new version of the plugin
 *
 * @author Jakub Tenk (DrGumik)
 * @version 1.0.0
 */
public class Updater {

    /**
     * Method for checking if there is a new version of the plugin
     * @param currentVersion Current version of the plugin
     *                       (use getDescription().getVersion() from the plugin's main class)
     * @param pluginName Name of the plugin
     * @param pluginPrefix Prefix of the plugin
     * @param separatorColor Color of the separator
     */
    public static void checkForUpdates(String currentVersion, String pluginName, String pluginPrefix, ChatColor separatorColor) {
        pluginName = pluginName.toLowerCase();

        // Check for plugin updates
        try {
            URL url = new URL("https://drgumik.xyz/libs/" + pluginName + "-version.txt");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode == 200) {
                Scanner sc = new Scanner(url.openStream());
                String latestVersion = sc.nextLine();
                sc.close();

                if (!latestVersion.equals(currentVersion)) {
                    Log.sendLog(pluginPrefix, ChatColor.YELLOW + "There is a new version (" + latestVersion + ") of the plugin available!");

                    if (pluginName.equals("dgcore")) {
                        Log.sendLog(pluginPrefix, ChatColor.YELLOW + "Some plugins with old version can get errors!");
                        Log.sendLog(pluginPrefix, ChatColor.YELLOW + "Download new version here: https://drgumik.xyz/libs/DGCore.jar");
                    }

                    Log.sendLog(pluginPrefix, separatorColor + "-----------------------------");
                }
            }
        } catch (Exception ignored) {}
    }
}
