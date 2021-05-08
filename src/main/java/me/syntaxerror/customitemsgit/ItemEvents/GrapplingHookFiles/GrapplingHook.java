package me.syntaxerror.customitemsgit.ItemEvents.GrapplingHookFiles;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GrapplingHook implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent event){

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();

        if (name.equals("§9Grappling Hook")) {
            if (event.getState().equals(PlayerFishEvent.State.REEL_IN)) {
                if (GrapplingHookCooldown.checkCooldown(player)) {
                    Location playerLocation = player.getLocation();
                    Location hookLocation = event.getHook().getLocation();
                    Location change = hookLocation.subtract(playerLocation);
                    player.setVelocity(change.toVector().multiply(0.3));
                    GrapplingHookCooldown.setCooldown(player, 5);
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "Item Ability is not ready yet");
                }
            }
        }
    }
}
