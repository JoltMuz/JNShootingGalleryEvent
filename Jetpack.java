package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class Jetpack implements Listener
{
    HashMap<String, Integer> Fuels = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Fuels.put(e.getPlayer().getName(),0);

    }
    @EventHandler
    public void Recharge(PlayerMoveEvent e)
    {

        Player p = e.getPlayer();

        if (p.getGameMode() == GameMode.SURVIVAL){
            if (CheckItem.CheckItem(p.getInventory().getChestplate(), Material.DIAMOND_CHESTPLATE, ChatColor.BLUE + ChatColor.BOLD.toString() + "Jetpack"))
            {

                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            {
                                if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)
                                {
                                    if (p.isSneaking())
                                    {

                                        if (Fuels.containsKey(e.getPlayer().getName()) && Fuels.get(e.getPlayer().getName()) < 100)
                                        {
                                            Fuels.put((e.getPlayer().getName()),Fuels.get(e.getPlayer().getName()) + 1);
                                            new ActionBar(ChatColor.YELLOW + ChatColor.BOLD.toString() + new String(new char[Fuels.get(e.getPlayer().getDisplayName()) / 5]).replace("\0", "▇")).sendToPlayer(p);
                                        }
                                        if (Fuels.containsKey(e.getPlayer().getName()) && Fuels.get(e.getPlayer().getName()) == 100)
                                        {
                                            new ActionBar(ChatColor.GOLD + ChatColor.BOLD.toString() + "Fuel Fully Recharged!").sendToPlayer(p);
                                            this.cancel();
                                        }
                                    }

                                    if (Fuels.containsKey(e.getPlayer().getName()) && (Fuels.get(e.getPlayer().getName())) == 0)
                                    {
                                        if (p.isFlying())
                                            {p.setFlying(false);}
                                        p.setAllowFlight(false);
                                        new ActionBar(ChatColor.DARK_GRAY + ChatColor.BOLD.toString() + "Sneak to Recharge Fuel").sendToPlayer(p);
                                    }
                                }
                            }
                        }
                    }.runTaskTimer(Main.plugin, 80L, 100L);

                    if (p.getVelocity().getY() > 0)
                    {

                        if (Fuels.containsKey(e.getPlayer().getName()) && Fuels.get(e.getPlayer().getName()) == 100)
                        {
                            p.setAllowFlight(true);

                        }
                    }

            }
        }
    }
    @EventHandler
    public void Fly(PlayerToggleFlightEvent e)
    {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.SURVIVAL){
            if (Fuels.containsKey(e.getPlayer().getName()) && Fuels.get(e.getPlayer().getName()) == 100)
            {
                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        Fuels.put((e.getPlayer().getName()),Fuels.get(e.getPlayer().getName()) - 10);
                        p.setVelocity(p.getVelocity().add(new Vector(0, 0.5, 0)));
                        p.setVelocity(p.getLocation().getDirection().multiply(1.5));
                        if (!p.isFlying()) {p.setAllowFlight(true);p.setFlying(true);}
                        new ActionBar(ChatColor.YELLOW + ChatColor.BOLD.toString() + new String(new char[Fuels.get(e.getPlayer().getName()) / 5]).replace("\0", "▇")).sendToPlayer(p);
                        p.getWorld().playEffect(p.getLocation().add(new Vector(0,1,0)) ,Effect.LAVA_POP,  0);
                        p.getWorld().playEffect(p.getLocation().add(new Vector(0,1,0)) ,Effect.LAVADRIP,  0);
                        if (Fuels.get(e.getPlayer().getName()) == 0)
                        {
                            p.setAllowFlight(false);
                            p.setFlying(false);
                            this.cancel();
                        }
                        if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)
                        {
                            p.setAllowFlight(false);
                            p.setFlying(false);
                            this.cancel();
                        }
                    }
                }.runTaskTimer(Main.plugin, 0L, 2L);
            }
        }
    }
    @EventHandler
    public void FallDamageCancel(final EntityDamageEvent e)
    {
        if (!(e.getEntity() instanceof Player))
        {
            return;
        }
        Player p = (Player) e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
        {
            if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate() == UI.Jetpack)
            {

                e.setCancelled(true);

            }
        }
    }
}
