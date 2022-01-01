package io.github.JoltTheBolt.joltitems;

import java.util.ArrayList;
import java.util.Set;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;

public final class JoltItems extends JavaPlugin implements Listener
{
	@Override
    public void onEnable() 
    {
    	getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("incinerator");
		this.getCommand("wand");
		this.getCommand("pogo");
		this.getCommand("swifts");
    }
    @Override
    public void onDisable() 
    {
    	getLogger().info("onDisable has been invoked!");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {
    	if (cmd.getName().equalsIgnoreCase("incinerator")) 
        {
       	    ItemStack Incinerator = new ItemStack(Material.DIAMOND_SWORD);
    		ItemMeta Incineratormeta = Incinerator.getItemMeta();
    		Incineratormeta.setDisplayName(ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "Incinerator");
    		ArrayList<String> lore = new ArrayList<String>();
    		lore.add(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA.toString() + "Incineration");
    		lore.add(ChatColor.WHITE.toString() + "Burns everything " + ChatColor.DARK_GREEN.toString() + "5 blocks ");
    		lore.add(ChatColor.WHITE.toString() + "ahead of you");
    		Incineratormeta.setLore(lore);
       		Incinerator.setItemMeta(Incineratormeta);
    		sender.sendMessage(ChatColor.GOLD + "You have been bestowed the power of Incinerator!");
    		Player player = (Player) sender;
    		Inventory inventory = player.getInventory();
    		inventory.addItem(Incinerator);
    		return true;
    	}
    		
    	if (cmd.getName().equalsIgnoreCase("wand")) 
        {
    	    ItemStack wand = new ItemStack(Material.STICK);
    		ItemMeta wandmeta = wand.getItemMeta();
    		wandmeta.setDisplayName(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "Lightning Wand");
    		ArrayList<String> lore2 = new ArrayList<String>();
    		lore2.add(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA.toString() + "Thunder Bolt");
    		lore2.add(ChatColor.WHITE.toString() + "Summons a " + ChatColor.LIGHT_PURPLE.toString() + "Lightning Bolt ");
    		lore2.add(ChatColor.WHITE.toString() + "where you aim");
    		wandmeta.setLore(lore2);
    	   	wand.setItemMeta(wandmeta);
    		sender.sendMessage(ChatColor.DARK_AQUA + "You are worthy enough to posses the Lightning Wand!");
    		Player player = (Player) sender;
    		Inventory inventory = player.getInventory();
    		inventory.addItem(wand);
    		return true;

    	}
    	if (cmd.getName().equalsIgnoreCase("pogo")) 
        {
    	    ItemStack pogo = new ItemStack(Material.BLAZE_ROD);
    		ItemMeta pogometa = pogo.getItemMeta();
    		pogometa.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Pogo Stick");
    		ArrayList<String> lore3 = new ArrayList<String>();
    		lore3.add(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA.toString() + "Bounce");
    		lore3.add(ChatColor.WHITE.toString() + "Launches you " + ChatColor.DARK_GREEN.toString() + "20 blocks ");
    		lore3.add(ChatColor.WHITE.toString() + "in the sky");
    		pogometa.setLore(lore3);
    	   	pogo.setItemMeta(pogometa);
    		sender.sendMessage(ChatColor.DARK_GREEN + "Henceforth, You will be having the Pogo Stick! ");
    		Player player = (Player) sender;
    		Inventory inventory = player.getInventory();
    		inventory.addItem(pogo);
    		return true;
    		
    	}
    	if (cmd.getName().equalsIgnoreCase("swifts")) 
        {
    	    ItemStack swifts = new ItemStack(Material.DIAMOND_BOOTS);
    		ItemMeta swiftsmeta = swifts.getItemMeta();
    		swiftsmeta.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "Swifts");
    		ArrayList<String> lore4 = new ArrayList<String>();
    		lore4.add(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA.toString() + "Sonic");
    		lore4.add(ChatColor.WHITE.toString() + "Makes you " + ChatColor.DARK_GREEN.toString() + "quick" + ChatColor.WHITE.toString() + " and");
    		lore4.add(ChatColor.WHITE.toString() + "leave a tiny trail");
    		swiftsmeta.setLore(lore4);
    	   	swifts.setItemMeta(swiftsmeta);
    		sender.sendMessage(ChatColor.DARK_GREEN + "Alright kid, here are your sneakers ");
    		Player player = (Player) sender;
    		Inventory inventory = player.getInventory();
    		inventory.addItem(swifts);
    		return true;
    		
    	}
    		
    	return false; 
    	
    }	
    
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
                item.getItemMeta().getDisplayName().equals(ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "Incinerator")) 
                {
                    p.sendMessage(ChatColor.GOLD + "Ability Used!");
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

    @EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent e2) 
    {
    	Action action = e2.getAction();

        if (action == Action.RIGHT_CLICK_BLOCK) 
        {

            Player p = e2.getPlayer();
            World w = p.getWorld();
            ItemStack item = p.getInventory().getItemInHand();
            if (p.getItemInHand().getType() == Material.STICK) 
            {
                if(item.hasItemMeta() && 
                        item.getItemMeta().hasDisplayName() && 
                        item.getItemMeta().getDisplayName().equals(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "Lightning Wand")) 
                        {
                            p.sendMessage(ChatColor.AQUA + "Ability Used!");
                            p.getWorld().strikeLightning(p.getTargetBlock((Set<Material>) null, 200).getLocation());
                        }
            }
        }
    }        

    @EventHandler
    public void onPlayerInteractBlock2(PlayerInteractEvent e3) 
    {
    	Action action = e3.getAction();

        if (action == Action.RIGHT_CLICK_AIR) 
        {

            Player p = e3.getPlayer();
            World w = p.getWorld();
            ItemStack item = p.getInventory().getItemInHand();
            if (p.getItemInHand().getType() == Material.STICK) 
            {
                if(item.hasItemMeta() && 
                        item.getItemMeta().hasDisplayName() && 
                        item.getItemMeta().getDisplayName().equals(ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "Lightning Wand")) 
                        {
                            p.sendMessage(ChatColor.AQUA + "Ability Used!");
                            p.getWorld().strikeLightning(p.getTargetBlock((Set<Material>) null, 10).getLocation());
                        }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractBlock3(PlayerInteractEvent e4) 
    {
    	Action action = e4.getAction();

        if (action == Action.RIGHT_CLICK_BLOCK) 
        {

            Player p = e4.getPlayer();
            World w = p.getWorld();
            ItemStack item2 = p.getInventory().getItemInHand();
            if (item2.getType() == Material.BLAZE_ROD) 
            {
                if(item2.hasItemMeta() && 
                        item2.getItemMeta().hasDisplayName() && 
                        item2.getItemMeta().getDisplayName().equals(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Pogo Stick")) 
                        {
                            p.sendMessage(ChatColor.BLUE + "Ability Used!");
                            p.setVelocity(new Vector(0, 5, 0));

                        }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractBlock4(PlayerInteractEvent e5) 
    {
    	Action action = e5.getAction();

        if (action == Action.LEFT_CLICK_BLOCK) 
        {

            Player p = e5.getPlayer();
            World w = p.getWorld();
            ItemStack item2 = p.getInventory().getItemInHand();
            if (item2.getType() == Material.BLAZE_ROD) 
            {
                if(item2.hasItemMeta() && 
                item2.getItemMeta().hasDisplayName() && 
                item2.getItemMeta().getDisplayName().equals(ChatColor.GREEN.toString() + ChatColor.BOLD.toString() + "Pogo Stick")) 
                {
                    p.sendMessage(ChatColor.BLUE + "Ability Used!");
                    p.setVelocity(p.getEyeLocation().getDirection().multiply(30));

                }
            }
        }
    }

    @EventHandler
    public void onEgg(PlayerEggThrowEvent e6) 
    {
    	Egg egg = e6.getEgg();
    	egg.getLocation().getBlock().setType(Material.WOOD);
     
    }

    @EventHandler
    public void onWear(PlayerMoveEvent e7) 
    {
    	ItemStack feet = e7.getPlayer().getInventory().getBoots();
    	Player p = e7.getPlayer();
        if (feet.getType() == Material.DIAMOND_BOOTS) 
        {
        	if(feet.hasItemMeta() && 
                feet.getItemMeta().hasDisplayName() && 
                feet.getItemMeta().getDisplayName().equals(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "Swifts")) 
                    {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 2));
                        Location loca = p.getLocation();
                        Vector vector = p.getLocation().getDirection().multiply(-1);
                        Location loca2 = loca.add(vector);
                        p.getWorld().playEffect(loca2, Effect.SMOKE, null);
                    }
        }
    }

}
