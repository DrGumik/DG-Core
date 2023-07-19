package drgumik.dgcore.configs;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import java.io.File;

/**
 * Class for loading configs for plugins from the plugin's folder
 *
 * @author Jakub Tenk (DrGumik)
 * @version 2.0.0
 */
public class ConfigData {

    public static YamlConfiguration loadConfig(Plugin plugin, String configName) {
        // Load file config.yml and check if it exists
        // If it doesn't exist, create it
        // If it does exist, load it
        File file = new File(plugin.getDataFolder(), configName);

        if (!file.exists()) {
            plugin.saveResource(configName, false);
        }

        // Load talismans.yml and save it to yaml configuration
        return YamlConfiguration.loadConfiguration(file);
    }
}
