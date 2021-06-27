package me.syntaxerror.customitemsgit.ItemEvents;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Set;

public class TeleportSword implements Listener {

    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null
            && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability (Right Click):")){
                Block block = player.getTargetBlock((Set<Material>)null, 8);
                Location location = block.getLocation();
                float pitch = player.getEyeLocation().getPitch();
                float yaw = player.getEyeLocation().getYaw();
                location.add(0, 1, 0);
                location.setYaw(yaw);
                location.setPitch(pitch);
                player.teleport(location);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 5, 5);
            }
        }
    }
}
