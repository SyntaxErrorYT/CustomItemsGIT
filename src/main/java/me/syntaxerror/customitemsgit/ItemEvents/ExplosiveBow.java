package me.syntaxerror.customitemsgit.ItemEvents;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExplosiveBow implements Listener {

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        Arrow arrow = (Arrow) event.getEntity();
        Player player = (Player) arrow.getShooter();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();
        Location arrowloc = arrow.getLocation();
        World world = player.getWorld();
        if(name.equals("§5Explosive Bow")){
            world.createExplosion(arrowloc, 5, false, false);
        }
    }
}
