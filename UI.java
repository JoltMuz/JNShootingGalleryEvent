package io.github.JoltMuz.joltitems;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class UI implements CommandExecutor, Listener
{
    public static Inventory joltItems = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "J" + ChatColor.RED + "o" + ChatColor.GOLD + "l" + ChatColor.YELLOW + "t" + ChatColor.GREEN + "I" + ChatColor.AQUA + "t" + ChatColor.BLUE + "e" + ChatColor.DARK_BLUE + "m" + ChatColor.DARK_PURPLE + "s");
    public static ItemStack Incinerator;
    public static ItemStack Wand;
    public static ItemStack Pogo;
    public static ItemStack Swifts;
    public static ItemStack Jetpack;
    static
    {
        Incinerator = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta IncineratorMeta = Incinerator.getItemMeta();
        IncineratorMeta.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Incinerator");
        ArrayList<String> incineratorLore = new ArrayList<>();
        incineratorLore.add(ChatColor.DARK_AQUA+ ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Incineration");
        incineratorLore.add(ChatColor.WHITE + "Burns everything " + ChatColor.DARK_GREEN + "5 blocks ");
        incineratorLore.add(ChatColor.WHITE + "ahead of you");
        IncineratorMeta.setLore(incineratorLore);
        Incinerator.setItemMeta(IncineratorMeta);

        Wand = new ItemStack(Material.STICK);
        ItemMeta wandMeta = Wand.getItemMeta();
        wandMeta.setDisplayName(ChatColor.AQUA + ChatColor.BOLD.toString() + "Lightning Wand");
        ArrayList<String> wandLore = new ArrayList<>();
        wandLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Thunder Bolt");
        wandLore.add(ChatColor.WHITE + "Summons a " + ChatColor.LIGHT_PURPLE + "Lightning Bolt ");
        wandLore.add(ChatColor.WHITE + "where you aim");
        wandMeta.setLore(wandLore);
        Wand.setItemMeta(wandMeta);

        Pogo = new ItemStack(Material.BLAZE_ROD);
        ItemMeta pogoMeta = Pogo.getItemMeta();
        pogoMeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + "Pogo Stick");
        ArrayList<String> pogoLore = new ArrayList<>();
        pogoLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Launch");
        pogoLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Up!");
        pogoLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Left-Click: " + ChatColor.WHITE + "In looking direction");
        pogoMeta.setLore(pogoLore);
        Pogo.setItemMeta(pogoMeta);

        Swifts = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta swiftsMeta = Swifts.getItemMeta();
        swiftsMeta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Swifts");
        ArrayList<String> swiftsLore = new ArrayList<>();
        swiftsLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Sonic");
        swiftsLore.add(ChatColor.WHITE + "Makes you " + ChatColor.DARK_GREEN + " quick" + ChatColor.WHITE + " and");
        swiftsLore.add(ChatColor.WHITE+ "leaves a tiny trail");
        swiftsMeta.setLore(swiftsLore);
        Swifts.setItemMeta(swiftsMeta);

        Jetpack = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta jetpackMeta = Swifts.getItemMeta();
        jetpackMeta.setDisplayName(ChatColor.BLUE + ChatColor.BOLD.toString() + "Jetpack");
        ArrayList<String> jetpackLore = new ArrayList<>();
        jetpackLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Flight");
        jetpackLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Sneak: " + ChatColor.WHITE + "Recharge");
        jetpackLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Double-Jump: " + ChatColor.WHITE + "Flyyyy!");
        jetpackMeta.setLore(jetpackLore);
        Jetpack.setItemMeta(jetpackMeta);

        joltItems.setItem(2, Incinerator);
        joltItems.setItem(3, Wand);
        joltItems.setItem(4, Pogo);
        joltItems.setItem(5, Swifts);
        joltItems.setItem(6, Jetpack);
    }
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String s, String[] strings)
    {
        if (Sender instanceof Player)
        {
            Player player = (Player) Sender;
            player.openInventory(joltItems);

        }
        return true;
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        if (inventory.getName().equals(joltItems.getName())) {
            event.setCancelled(true);
            if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + ChatColor.BOLD.toString() + "Incinerator"))
            {
                player.getInventory().addItem(Incinerator);
            }
            if (clicked.getItemMeta().getDisplayName().equals(ChatColor.AQUA + ChatColor.BOLD.toString() + "Lightning Wand"))
            {
                player.getInventory().addItem(Wand);
            }
            if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GREEN + ChatColor.BOLD.toString() + "Pogo Stick"))
            {
                player.getInventory().addItem(Pogo);
            }
            if (clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + ChatColor.BOLD.toString() + "Swifts"))
            {
                player.getInventory().addItem(Swifts);
            }
            if (clicked.getItemMeta().getDisplayName().equals(ChatColor.BLUE + ChatColor.BOLD.toString() + "Jetpack"))
            {
                player.getInventory().addItem(Jetpack);
            }
        }
    }
}
