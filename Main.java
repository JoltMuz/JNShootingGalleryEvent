package io.github.JoltMuz.joltitems;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents( new UI(), this);
        getServer().getPluginManager().registerEvents( new Incinerator(), this);
        getServer().getPluginManager().registerEvents( new Wand(), this);
        getServer().getPluginManager().registerEvents( new Pogo(), this);
        getServer().getPluginManager().registerEvents( new Swifts(), this);
        
        this.getCommand("joltitems").setExecutor(new UI());
    }
    @Override
    public void onDisable()
    {
        //Nothing!
    }


}
