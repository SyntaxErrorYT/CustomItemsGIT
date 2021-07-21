package me.syntaxerror.customitemsgit.ItemEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ExplosiveBow implements Listener {

    @EventHandler
    public void onProjectileLaunch(EntityShootBowEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null
            && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§7Creates an explosive...")){
                event.getProjectile().setCustomName("Explosive Bow");
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        if(event.getEntity().getCustomName() != null) {
            if (event.getEntity().getCustomName().equals("Explosive Bow")) {
                event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 5, false, false);
            }
        }
    }
}
