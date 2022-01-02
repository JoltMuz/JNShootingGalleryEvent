package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Incinerator implements Listener
{
    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        Action action = e.getAction();

        if (action == Action.RIGHT_CLICK_AIR)
        {

            Player p = e.getPlayer();
            World w = p.getWorld();
            ItemStack item = p.getInventory().getItemInHand();
            if(item != null && item.getType() == Material.DIAMOND_SWORD)
            {
                if(item.hasItemMeta() &&
                        item.getItemMeta().hasDisplayName() &&
                        item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + ChatColor.BOLD.toString() + "Incinerator"))
                {
                    Location loc = p.getLocation();
                    Vector v1 = loc.getDirection().multiply(1);
                    Vector v2 = loc.getDirection().multiply(2);
                    Location l1 = loc.add(v2);
                    w.playEffect(l1, Effect.MOBSPAWNER_FLAMES, null);
                    w.playEffect(l1, Effect.MOBSPAWNER_FLAMES, null);
                    for (Entity en1 : l1.getChunk().getEntities())
                    {
                        if (en1.getLocation().distance(l1) < 1)
                        {
                            en1.setFireTicks(100);
                            Damageable d1 = (Damageable) en1;
                            d1.damage(5);
                        }

                    }
                    Location l2 = l1.add(v1);
                    w.playEffect(l2, Effect.MOBSPAWNER_FLAMES, null);
                    w.playEffect(l2, Effect.MOBSPAWNER_FLAMES, null);
                    for (Entity en2 : l2.getChunk().getEntities())
                    {
                        if (en2.getLocation().distance(l2) < 1)
                        {
                            en2.setFireTicks(100);
                            Damageable d2 = (Damageable) en2;
                            d2.damage(5);
                        }

                    }
                    Location l3 = l2.add(v1);
                    w.playEffect(l3, Effect.MOBSPAWNER_FLAMES, null);
                    w.playEffect(l3, Effect.MOBSPAWNER_FLAMES, null);
                    for (Entity en3 : l3.getChunk().getEntities())
                    {
                        if (en3.getLocation().distance(l3) < 1)
                        {
                            en3.setFireTicks(100);
                            Damageable d3 = (Damageable) en3;
                            d3.damage(5);
                        }
                    }
                    Location l4 = l3.add(v1);
                    w.playEffect(l4, Effect.MOBSPAWNER_FLAMES, null);
                    w.playEffect(l4, Effect.MOBSPAWNER_FLAMES, null);
                    for (Entity en4 : l4.getChunk().getEntities())
                    {
                        if (en4.getLocation().distance(l4) < 1)
                        {
                            en4.setFireTicks(100);
                            Damageable d4 = (Damageable) en4;
                            d4.damage(5);
                        }
                    }
                }
            }
        }
    }
}
