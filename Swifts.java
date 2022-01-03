package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Swifts implements Listener
{
    @EventHandler
    public void onMove(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();
        if (p.getInventory().getBoots() != null)
        {
            if (p.getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.RED + ChatColor.BOLD.toString() + "Swifts")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 2));
                p.getWorld().playEffect(p.getLocation(), Effect.COLOURED_DUST, 10);

            }
        }
    }
}
