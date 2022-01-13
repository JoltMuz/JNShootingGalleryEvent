package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.Set;

public class BridgeEgg implements Listener
{
    private BukkitTask task;
    @EventHandler
    public void ThrowBridge(PlayerInteractEvent e)
    {
        if (e.getAction() == Action.RIGHT_CLICK_AIR)
        {
            if (CheckItem.CheckItem(e.getPlayer().getItemInHand(), Material.EGG, ChatColor.GREEN + ChatColor.BOLD.toString() + "Bridge Egg" ))
            {
                e.setCancelled(true);
                e.getPlayer().getInventory().removeItem(UI.BridgeEgg);
                Egg egg = e.getPlayer().getWorld().spawn(e.getPlayer().getTargetBlock((Set<Material>) null, 1).getLocation(), Egg.class);
                egg.setCustomName(ChatColor.GREEN + "Bridge Egg");
                egg.setVelocity(e.getPlayer().getLocation().getDirection());
                BukkitRunnable runnable = new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        egg.getLocation().add(new Vector(0,-2,0)).getBlock().setType(Material.BRICK);

                    }

                };
                task = runnable.runTaskTimer(Main.plugin,0L,1L);
            }
        }
    }
    @EventHandler
    public void EggHit(ProjectileHitEvent e)
    {
        if (e.getEntity() instanceof Egg)
        {
            if (e.getEntity().getCustomName() != null && e.getEntity().getCustomName().equals(ChatColor.GREEN + "Bridge Egg"))
            {
                task.cancel();
            }
        }
    }
}
