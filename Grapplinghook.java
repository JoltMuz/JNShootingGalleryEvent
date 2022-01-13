package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;


public class Grapplinghook implements Listener
{
    @EventHandler
    private void Grapple(PlayerFishEvent e)
    {

        if (CheckItem.CheckItem(e.getPlayer().getInventory().getItemInHand(), Material.FISHING_ROD, ChatColor.GREEN + ChatColor.BOLD.toString() + "Grappling Hook"))
        {
            e.getHook().setCustomName(ChatColor.GREEN + "Grappling Hook's Hook");
            e.getHook().setBounce(false);
        }
    }

    @EventHandler
    private void HookSend(ProjectileHitEvent e)
    {
        if (e.getEntity() instanceof FishHook)
        {
            if (e.getEntity().getCustomName().equals(ChatColor.GREEN + "Grappling Hook's Hook"))
            {
                e.getEntity().setFallDistance(0);
                if (e.getEntity().getShooter() instanceof Player)
                {
                    ((Player) e.getEntity().getShooter()).setVelocity(e.getEntity().getLocation().toVector().subtract(((Player) e.getEntity().getShooter()).getLocation().toVector()).multiply(0.25));
                }
            }
        }
    }
}
