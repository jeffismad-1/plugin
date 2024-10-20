package main.skyblock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Egg_Launcher implements Listener {
    private final Skyblock plugin;

    public Egg_Launcher(Skyblock plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();

        // Ensure action is a right-click
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (item != null) {
                // Check if the item is a Snowball Launcher (Diamond Hoe)
                if (isSnowballLauncher(item)) {
                    player.launchProjectile(Snowball.class);
                    player.sendMessage(ChatColor.GREEN + "You sent a Snowball!");

                    // Check if the item is an Iron Hoe
                } else if (item.getType() == Material.IRON_HOE) {
                    player.launchProjectile(Trident.class);
                    player.sendMessage(ChatColor.GREEN + "You sent a Trident!");

                    // Check if the item is a Trident and enchant with Loyalty if not enchanted
                } else if (item.getType() == Material.TRIDENT && !item.containsEnchantment(Enchantment.LOYALTY)) {
                    item.addEnchantment(Enchantment.LOYALTY, 1);
                    player.sendMessage(ChatColor.GREEN + "Trident enchanted with Loyalty!");
                }
            }
        }
    }

    private boolean isSnowballLauncher(ItemStack item) {
        if (item.getType() != Material.DIAMOND_HOE) return false;
        ItemMeta meta = item.getItemMeta();
        return meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.GOLD + "Snowball Launcher");
    }
}
