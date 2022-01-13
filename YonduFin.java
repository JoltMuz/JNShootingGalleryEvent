package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;



public class YonduFin implements Listener
{
    private BukkitTask task;
    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent e)
    {
        Action action = e.getAction();

        if (action == Action.RIGHT_CLICK_AIR)
        {
            Player p = e.getPlayer();
            if (CheckItem.CheckItem(e.getPlayer().getItemInHand(), Material.ARROW, ChatColor.RED + ChatColor.BOLD.toString() + "Yondu's Fin"))
            {
                p.getInventory().removeItem(UI.YonduFin);
                Arrow a = p.launchProjectile(Arrow.class);
                a.setCustomName(ChatColor.RED + "Yondu's Fin");

                BukkitRunnable runnable = new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        a.setVelocity((p.getLocation().getDirection().multiply(0.5)));
                        a.getWorld().playEffect(a.getLocation(), Effect.WITCH_MAGIC, null);
                        if (a.getLocation().getY() < 1)
                        {
                            this.cancel();
                            p.getInventory().addItem(UI.YonduFin);
                        }
                        if (a.getLocation().getY() > 255)
                        {
                            this.cancel();
                            p.getInventory().addItem(UI.YonduFin);
                        }
                    }
                };
                 task = runnable.runTaskTimer(Main.plugin, 0L, 1L);
            }
        }
    }

    @EventHandler
    private void FinHit(ProjectileHitEvent e)
    {
        if (e.getEntityType() == EntityType.ARROW)
        {
            if (e.getEntity().getCustomName().equals(ChatColor.RED + "Yondu's Fin"))
            {
                ((Player) e.getEntity().getShooter()).getInventory().addItem(UI.YonduFin);
                task.cancel();
            }
        }
    }
}
