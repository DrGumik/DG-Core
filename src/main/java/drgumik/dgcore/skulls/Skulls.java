package drgumik.dgcore.skulls;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

/**
 * Class for creating custom skulls (heads) with textures from the internet
 *
 * @author Jakub Tenk (DrGumik)
 * @version 1.0.0
 */
public class Skulls {

    /**
     * Create skull item with textures, display name, lore. Then return it.
     * Texture from: https://minecraft-heads.com/custom-heads/
     * @param SkullTextureBase64 - base64 string of texture (from url under Loot table:)
     * @param displayName - display name of item
     * @param lore - lore of item
     * @return - created skull item
     */
    public static ItemStack createSkull(String SkullTextureBase64, String displayName, String[] lore) {
        // Create skull item
        final ItemStack skull = new ItemStack(Material.PLAYER_HEAD);

        // Create skull metadata
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        assert meta != null;

        // Create new game profile
        GameProfile profile = new GameProfile(UUID.randomUUID(), displayName);

        // Set texture on profile
        profile.getProperties().put("textures", new Property("textures", SkullTextureBase64));

        // Try to set profile to metadata
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Set item display name
        meta.setDisplayName(displayName);

        // Set item lore
        if (!lore[0].equals("")) {
            meta.setLore(Arrays.asList(lore));
        }

        // Set metadata to item
        skull.setItemMeta(meta);

        // Return created skull
        return skull;
    }
}
