package main.skyblock;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Skyblock extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Hello Skyblock!");
        Bukkit.getPluginManager().registerEvents(this, this);
        new Egg_Launcher(this);


    }
}
