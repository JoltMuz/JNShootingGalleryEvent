package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;


public class Pogo implements Listener
{
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();

        if (CheckItem.CheckItem(p.getInventory().getItemInHand(), Material.BLAZE_ROD, ChatColor.GREEN + ChatColor.BOLD.toString() + "Pogo Stick"))
            {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
                {
                    p.setVelocity(new Vector(0, 5, 0));
                }
                if (e.getAction() == Action.LEFT_CLICK_BLOCK)
                {
                    p.setVelocity(p.getEyeLocation().getDirection().multiply(30));
                }
            }

    }
}
