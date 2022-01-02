package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class Wand implements Listener
{
    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent e)
    {
        Action action = e.getAction();

        if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR)
        {

            Player p = e.getPlayer();
            ItemStack item = p.getInventory().getItemInHand();
            if (p.getItemInHand().getType() == Material.STICK)
            {

                if(item.hasItemMeta() &&
                item.getItemMeta().hasDisplayName() &&
                item.getItemMeta().getDisplayName().equals(ChatColor.AQUA + ChatColor.BOLD.toString() + "Lightning Wand"))
                {

                    p.getWorld().strikeLightning(p.getTargetBlock((Set<Material>) null, 200).getLocation());

                }
            }
        }
    }
}
