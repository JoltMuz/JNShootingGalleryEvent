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
    public static Inventory joltItems = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "J" + ChatColor.RED + "o" + ChatColor.GOLD + "l" + ChatColor.YELLOW + "t" + ChatColor.GREEN + "I" + ChatColor.AQUA + "t" + ChatColor.BLUE + "e" + ChatColor.DARK_BLUE + "m" + ChatColor.DARK_PURPLE + "s");
    public static ItemStack Incinerator;
    public static ItemStack Wand;
    public static ItemStack Pogo;
    public static ItemStack Swifts;
    public static ItemStack Jetpack;
    public static ItemStack Railgun;
    public static ItemStack YonduFin;
    public static ItemStack Bustercall;
    public static ItemStack BridgeEgg;
    public static ItemStack GrapplingHook;
    static
    {
        Incinerator = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta IncineratorMeta = Incinerator.getItemMeta();
        IncineratorMeta.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Incinerator");
        ArrayList<String> incineratorLore = new ArrayList<>();
        incineratorLore.add(ChatColor.DARK_AQUA+ ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Incineration");
        incineratorLore.add("");
        incineratorLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Burns " + ChatColor.DARK_GREEN + "5 blocks ");
        incineratorLore.add(ChatColor.WHITE + "ahead of you");
        IncineratorMeta.setLore(incineratorLore);
        Incinerator.setItemMeta(IncineratorMeta);

        Wand = new ItemStack(Material.STICK);
        ItemMeta wandMeta = Wand.getItemMeta();
        wandMeta.setDisplayName(ChatColor.AQUA + ChatColor.BOLD.toString() + "Lightning Wand");
        ArrayList<String> wandLore = new ArrayList<>();
        wandLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Thunder Bolt");
        wandLore.add("");
        wandLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Summons a " + ChatColor.LIGHT_PURPLE + "Lightning ");
        wandLore.add(ChatColor.LIGHT_PURPLE + "Bolt " + ChatColor.WHITE + "where you aim");
        wandMeta.setLore(wandLore);
        Wand.setItemMeta(wandMeta);

        Pogo = new ItemStack(Material.BLAZE_ROD);
        ItemMeta pogoMeta = Pogo.getItemMeta();
        pogoMeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + "Pogo Stick");
        ArrayList<String> pogoLore = new ArrayList<>();
        pogoLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Woosh!");
        pogoLore.add("");
        pogoLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Up!");
        pogoLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Left-Click: " + ChatColor.WHITE + "In looking direction");
        pogoMeta.setLore(pogoLore);
        Pogo.setItemMeta(pogoMeta);

        Swifts = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta swiftsMeta = Swifts.getItemMeta();
        swiftsMeta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Swifts");
        ArrayList<String> swiftsLore = new ArrayList<>();
        swiftsLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Sonic");
        swiftsLore.add("");
        swiftsLore.add(ChatColor.WHITE + "Makes you " + ChatColor.DARK_GREEN + " quick" + ChatColor.WHITE + " and");
        swiftsLore.add(ChatColor.WHITE+ "leaves a tiny trail");
        swiftsMeta.setLore(swiftsLore);
        Swifts.setItemMeta(swiftsMeta);

        Jetpack = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta jetpackMeta = Jetpack.getItemMeta();
        jetpackMeta.setDisplayName(ChatColor.BLUE + ChatColor.BOLD.toString() + "Jetpack");
        ArrayList<String> jetpackLore = new ArrayList<>();
        jetpackLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Yeet");
        jetpackLore.add("");
        jetpackLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Sneak: " + ChatColor.WHITE + "Recharge");
        jetpackLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Double-Jump: " + ChatColor.WHITE + "Flyyyy!");
        jetpackMeta.setLore(jetpackLore);
        Jetpack.setItemMeta(jetpackMeta);

        Railgun = new ItemStack(Material.GOLD_HOE);
        ItemMeta RailgunMeta = Railgun.getItemMeta();
        RailgunMeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Railgun");
        ArrayList<String> RailgunLore = new ArrayList<>();
        RailgunLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Shoooot");
        RailgunLore.add("");
        RailgunLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Shoot");
        RailgunLore.add(ChatColor.WHITE + "a line of" + ChatColor.DARK_RED + " Laser");
        RailgunMeta.setLore(RailgunLore);
        Railgun.setItemMeta(RailgunMeta);

        YonduFin = new ItemStack(Material.ARROW);
        ItemMeta FinMeta = YonduFin.getItemMeta();
        FinMeta.setDisplayName(ChatColor.RED + ChatColor.BOLD.toString() + "Yondu's Fin");
        ArrayList<String> FinLore = new ArrayList<>();
        FinLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Telekinesis");
        FinLore.add("");
        FinLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Shoot a");
        FinLore.add(ChatColor.WHITE + "controllable" + ChatColor.DARK_RED + " Arrow");
        FinMeta.setLore(FinLore);
        YonduFin.setItemMeta(FinMeta);

        Bustercall = new ItemStack(Material.FIREBALL);
        ItemMeta Bustercallmeta = Bustercall.getItemMeta();
        Bustercallmeta.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Buster Call");
        ArrayList<String> BustercallLore = new ArrayList<>();
        BustercallLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Island Destroyer");
        BustercallLore.add("");
        BustercallLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Launch a");
        BustercallLore.add(ChatColor.WHITE + "nuclear" + ChatColor.DARK_RED + " Fireball");
        Bustercallmeta.setLore(BustercallLore);
        Bustercall.setItemMeta(Bustercallmeta);

        BridgeEgg = new ItemStack(Material.EGG);
        ItemMeta BridgeEggMeta = BridgeEgg.getItemMeta();
        BridgeEggMeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + "Bridge Egg");
        ArrayList<String> BridgeEggLore = new ArrayList<>();
        BridgeEggLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Instant Bridge");
        BridgeEggLore.add("");
        BridgeEggLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Launch a");
        BridgeEggLore.add(ChatColor.WHITE + "egg making a" + ChatColor.DARK_GREEN + " Bridge");
        BridgeEggMeta.setLore(BridgeEggLore);
        BridgeEgg.setItemMeta(BridgeEggMeta);

        GrapplingHook = new ItemStack(Material.FISHING_ROD);
        ItemMeta GrapplingHookMeta = GrapplingHook.getItemMeta();
        GrapplingHookMeta.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + "Grappling Hook");
        ArrayList<String> GrapplingHookLore = new ArrayList<>();
        GrapplingHookLore.add(ChatColor.DARK_AQUA + ChatColor.BOLD.toString() + "Item Ability: " + ChatColor.AQUA + "Grapple n Climb ");
        GrapplingHookLore.add("");
        GrapplingHookLore.add(ChatColor.GREEN + ChatColor.BOLD.toString() + "Right-Click: " + ChatColor.WHITE + "Launch a sticky");
        GrapplingHookLore.add(ChatColor.WHITE + "hook and br " + ChatColor.DARK_RED + "Spider"+ ChatColor.DARK_BLUE +"man");
        GrapplingHookMeta.setLore(GrapplingHookLore);
        GrapplingHook.setItemMeta(GrapplingHookMeta);

        joltItems.setItem(0, Incinerator);
        joltItems.setItem(1, Wand);
        joltItems.setItem(2, Pogo);
        joltItems.setItem(3, Swifts);
        joltItems.setItem(4, Jetpack);
        joltItems.setItem(5, Railgun);
        joltItems.setItem(6, YonduFin);
        joltItems.setItem(7, Bustercall);
        joltItems.setItem(8, BridgeEgg);
        joltItems.setItem(9,GrapplingHook);
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
            if (clicked.hasItemMeta())
            {

                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + ChatColor.BOLD.toString() + "Incinerator")) {
                    player.getInventory().addItem(Incinerator);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.AQUA + ChatColor.BOLD.toString() + "Lightning Wand")) {
                    player.getInventory().addItem(Wand);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GREEN + ChatColor.BOLD.toString() + "Pogo Stick")) {
                    player.getInventory().addItem(Pogo);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + ChatColor.BOLD.toString() + "Swifts")) {
                    player.getInventory().addItem(Swifts);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.BLUE + ChatColor.BOLD.toString() + "Jetpack")) {
                    player.getInventory().addItem(Jetpack);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Railgun")) {
                    player.getInventory().addItem(Railgun);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.RED + ChatColor.BOLD.toString() + "Yondu's Fin")) {
                    player.getInventory().addItem(YonduFin);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + ChatColor.BOLD.toString() + "Buster Call")) {
                    player.getInventory().addItem(Bustercall);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GREEN + ChatColor.BOLD.toString() + "Bridge Egg")) {
                    player.getInventory().addItem(BridgeEgg);
                }
                if (clicked.getItemMeta().getDisplayName().equals(ChatColor.GREEN + ChatColor.BOLD.toString() + "Grappling Hook")) {
                    player.getInventory().addItem(GrapplingHook);
                }
            }
        }
    }
}
