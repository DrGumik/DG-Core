package drgumik.dgcore.consoleLog;

import org.bukkit.ChatColor;
import static drgumik.dgcore.colors.GradientColorText.generateGradient;
import static org.bukkit.Bukkit.getServer;

/**
 * Class for making logs to the console easier and colored!
 *
 * @author Jakub Tenk (DrGumik)
 * @version 1.0.0
 */
public class Log {
    public static void sendLog(String prefix, String message) {
        switch (prefix.toLowerCase()) {
            case "talismans":
                prefix = generateGradient("[Talismans]", false, "#FB1F1F", "#FD7E48");
                break;
            case "betteritemrecycler":
                prefix = generateGradient("[BetterItemRecycler]", false, "#00AA00", "#55FF55", "#83FF8F");
                break;
            default:
                prefix = generateGradient("[DG-Core]", false, "#04F89F", "#04FFD2", "#01C2FF");
                break;
        }

        getServer().getConsoleSender().sendMessage(prefix + " " + ChatColor.WHITE + message);
    }
}
