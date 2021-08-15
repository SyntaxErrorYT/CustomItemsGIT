package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Fireballs implements Listener {

    CustomItemsGIT plugin;

    public Fireballs(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null
                    && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability: Fireball")){

                Fireball fireball = event.getPlayer().getWorld().spawn(event.getPlayer().getEyeLocation(), Fireball.class);
                fireball.setYield(0);
                fireball.setCustomName("Fireball");
                fireball.setVelocity(event.getPlayer().getLocation().getDirection());

                new BukkitRunnable(){
                    public void run(){
                        if(!fireball.isDead()){
                            fireball.getWorld().spawnParticle(Particle.FLAME, fireball.getLocation(), 1);
                        }
                        else{
                            cancel();
                        }
                    }
                }.runTaskTimer(plugin, 0L, 2L);

                event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onLand(ProjectileHitEvent event){
        if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("Fireball")){
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 5, true, true);
            for(Entity entity : event.getEntity().getNearbyEntities(5, 5, 5)){
                if(entity instanceof LivingEntity){
                    LivingEntity livingentity = (LivingEntity) entity;
                    double distance = event.getEntity().getLocation().distanceSquared(livingentity.getLocation());
                    if(distance <= 0.5){
                        livingentity.setVelocity(new Location(livingentity.getWorld(), 0, 1, 0).toVector());
                    }
                    else{
                        livingentity.setVelocity(livingentity.getLocation().subtract(event.getEntity().getLocation()).toVector().multiply(1 / distance));
                    }
                }
            }
        }
    }
}

