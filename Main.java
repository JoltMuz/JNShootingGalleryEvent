package io.github.JoltMuz.joltitems;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin implements Listener
{
    public static Plugin plugin;


    @Override
    public void onEnable()
    {
        plugin = this;
        getServer().getPluginManager().registerEvents( new UI(), this);
        getServer().getPluginManager().registerEvents( new Incinerator(), this);
        getServer().getPluginManager().registerEvents( new Wand(), this);
        getServer().getPluginManager().registerEvents( new Pogo(), this);
        getServer().getPluginManager().registerEvents( new Swifts(), this);
        getServer().getPluginManager().registerEvents( new Jetpack(), this);
        getServer().getPluginManager().registerEvents( new Railgun(), this);
        getServer().getPluginManager().registerEvents( new YonduFin(), this);
        getServer().getPluginManager().registerEvents( new Bustercall(), this);
        getServer().getPluginManager().registerEvents( new BridgeEgg(), this);
        getServer().getPluginManager().registerEvents( new Grapplinghook (), this);

        this.getCommand("joltitems").setExecutor(new UI());


        };
    @Override
    public void onDisable()
    {
        //Nothing!
    }


}
