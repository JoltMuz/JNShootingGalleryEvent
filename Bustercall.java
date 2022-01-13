package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitTask;


public class Bustercall implements Listener
{
    private BukkitTask task;
    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent e)
    {
        Action action = e.getAction();

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)
        {
            Player p = e.getPlayer();
            if (CheckItem.CheckItem(p.getItemInHand(), Material.FIREBALL, ChatColor.GOLD + ChatColor.BOLD.toString() + "Buster Call"))
            {
                p.getInventory().removeItem(UI.Bustercall);
                Fireball fb = p.launchProjectile(Fireball.class);
                fb.setCustomName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Buster Call");
                fb.setYield(10);
                fb.setVelocity(fb.getVelocity().multiply(1.5));
            }

        }
    }
    @EventHandler
    public void BusterHit(ProjectileHitEvent e)
    {
        if (e.getEntity() instanceof  Fireball && e.getEntity().getCustomName().equals(ChatColor.GOLD + ChatColor.BOLD.toString() + "Buster Call"))
        {
            if (e.getEntity().getShooter() instanceof Player)
            {
                Bukkit.broadcastMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + ((Player) e.getEntity().getShooter()).getName() + ChatColor.YELLOW + " called a Buster Call at " + ChatColor.GOLD + e.getEntity().getLocation().getBlockX() + "," + e.getEntity().getLocation().getBlockY() + "," + e.getEntity().getLocation().getBlockZ());
            }
        }
    }
}
