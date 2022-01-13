package io.github.JoltMuz.joltitems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CheckItem
{
    public static boolean CheckItem(ItemStack item, Material material, String displayname)
    {
        if (item != null && item.getType() == material)
        {
           if (item.hasItemMeta() &&
                   item.getItemMeta().hasDisplayName() &&
                   item.getItemMeta().getDisplayName().equals(displayname))
            {
                return true;
            }
        }
        return false;
    }
}
