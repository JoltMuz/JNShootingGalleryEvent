package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Set;

public class Railgun implements Listener
{
    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        Action action = e.getAction();

        if (action == Action.RIGHT_CLICK_AIR)
        {

            Player p = e.getPlayer();
            World w = p.getWorld();
            if(CheckItem.CheckItem(p.getItemInHand(), Material.GOLD_HOE, ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Railgun"))
            {
                ArrayList<Location> Locations = new ArrayList<>();
                for ( int i =2 ; i < 11; i += 1)
                {
                    Locations.add(p.getTargetBlock((Set<Material>) null, i).getLocation());
                }
                for ( int i = 0 ; i < Locations.size(); i ++)
                {
                    w.playEffect(Locations.get(i), Effect.HEART, null);
                    for (Entity en : Locations.get(i).getChunk().getEntities())
                    {
                        if (en.getLocation().distance(Locations.get(i)) < 1.5)
                        {
                            if (en instanceof Damageable)
                            {
                                ((Damageable) en).damage(5);
                            }
                        }
                    }
                }
            }
        }
    }
}
