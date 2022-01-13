package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

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
                w.playEffect(p.getTargetBlock((Set<Material>) null, 2).getLocation(), Effect.HEART,null);
                w.playEffect(p.getTargetBlock((Set<Material>) null, 3).getLocation(), Effect.HEART,null);
                w.playEffect(p.getTargetBlock((Set<Material>) null, 4).getLocation(), Effect.HEART,null);
                w.playEffect(p.getTargetBlock((Set<Material>) null, 5).getLocation(), Effect.HEART,null);
                w.playEffect(p.getTargetBlock((Set<Material>) null, 6).getLocation(), Effect.HEART,null);
                w.playEffect(p.getTargetBlock((Set<Material>) null, 7).getLocation(), Effect.HEART,null);
                w.playEffect(p.getTargetBlock((Set<Material>) null, 8).getLocation(), Effect.HEART,null);
            }
        }
    }
}
