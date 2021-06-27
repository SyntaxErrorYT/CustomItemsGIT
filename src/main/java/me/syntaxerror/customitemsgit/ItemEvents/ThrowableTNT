package me.syntaxerror.customitemsgit.ItemEvents;

import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class ThrowableTNT implements Listener {

    List<FallingBlock> throwedtnt = new ArrayList<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null
                    && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability: Throwable TNT")){
                FallingBlock tnt = event.getPlayer().getWorld().spawnFallingBlock(event.getPlayer().getEyeLocation(), Material.TNT, (byte) 0);
                tnt.setDropItem(false);
                throwedtnt.add(tnt);
                tnt.setVelocity(event.getPlayer().getLocation().getDirection().multiply(3));
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onFall(EntityChangeBlockEvent event){
        if(event.getEntity() instanceof FallingBlock){
            if(throwedtnt.contains(event.getEntity())){
                event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 50, false, false);
                event.setCancelled(true);
                event.getEntity().remove();
                throwedtnt.remove(event.getEntity());
            }
        }
    }
}
