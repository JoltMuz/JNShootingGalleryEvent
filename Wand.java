package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Set;

import static io.github.JoltMuz.joltitems.Cooldown.*;

public class Wand implements Listener
{

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent e)
    {
        Action action = e.getAction();

    if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR)
    {
        Player p = e.getPlayer();
        if (CheckItem.CheckItem(p.getInventory().getItemInHand(),Material.STICK, ChatColor.AQUA + ChatColor.BOLD.toString() + "Lightning Wand"))
            {
                if (checkCooldown(p.getName(), wand, 2))
                {

                    p.getWorld().strikeLightning(p.getTargetBlock((Set<Material>) null, 200).getLocation());

                }
                else
                {
                    double cooldown = 2 - ((double)System.currentTimeMillis()/(double)1000 - (Double) wand.get(p.getName()));
                    p.sendMessage(ChatColor.RED + "Lightning Wand Cooldown: " + Math.round(cooldown*10.0)/10.0 + " second(s).");
                }
            }
        }
    }
}
