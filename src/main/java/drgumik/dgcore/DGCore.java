package drgumik.dgcore;

import drgumik.dgcore.colors.GradientColorText;
import drgumik.dgcore.configs.ConfigData;
import drgumik.dgcore.consoleLog.Log;
import drgumik.dgcore.skulls.Skulls;
import drgumik.dgcore.updater.Updater;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class of the plugin DGCore
 *
 * @author Jakub Tenk (DrGumik)
 * @version 1.0.0
 */

public final class DGCore extends JavaPlugin {
    public Log log;
    public ConfigData configData;
    public GradientColorText colors;
    public Skulls skulls;

    /**
     * Method for loading the plugin
     */
    @Override
    public void onEnable() {
        // Plugin startup logic

        // Init lib
        log = new Log();
        configData = new ConfigData();
        colors = new GradientColorText();
        skulls = new Skulls();

        // Print start up to the console log
        String[] author = getDescription().getAuthors().toString().replace("[", "").replace("]", "").replace("-", " ").split(", ");
        Log.sendLog("", ChatColor.AQUA + "-----------------------------");
        Log.sendLog("", ChatColor.GREEN + "API has been enabled!");
        Log.sendLog("", "Version: " + getDescription().getVersion());
        Log.sendLog("", "Author: " + author[0] + " (" + author[1] + ")");
        Log.sendLog("", "Website: " + getDescription().getWebsite());
        Log.sendLog("", "Store: " + getDescription().getWebsite() + "/store");
        Log.sendLog("", "Discord: " + getDescription().getWebsite() + "/discord");
        Log.sendLog("", ChatColor.AQUA + "-----------------------------");

        // Check for plugin updates
        Updater.checkForUpdates(getDescription().getVersion(), getDescription().getName(), "", ChatColor.AQUA);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Log.sendLog("", ChatColor.AQUA + "-----------------------------");
        Log.sendLog("", ChatColor.RED + "API has been disabled!");
        Log.sendLog("", "See you later, bye!");
        Log.sendLog("", ChatColor.AQUA + "-----------------------------");
    }
}
