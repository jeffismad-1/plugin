package main.skyblock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class Egg_Launcher implements Listener {
    public Egg_Launcher (Skyblock plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void OnPLayerInteract(PlayerInteractEvent e){
        if (e.hasItem()){
            Player Player = e.getPlayer();
            if (Objects.requireNonNull(e.getItem()).getType().equals(Material.DIAMOND_HOE)) {
                Player.launchProjectile(Snowball.class);
                Player.sendMessage(ChatColor.GREEN + "You sent a BALL");

            } else if (e.getItem().getType().equals(Material.IRON_HOE)) {
                Player.launchProjectile(Trident.class);
                Player.sendMessage(ChatColor.GREEN + "You sent a Trident");

            }
        }
    }
}
