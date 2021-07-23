package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SmokeBow implements Listener {

    CustomItemsGIT plugin;

    public SmokeBow(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event){
        if(event.getBow() != null && event.getBow().getItemMeta() != null && event.getBow().getItemMeta().getLore() != null &&
                event.getBow().getItemMeta().getLore().contains("§6Item Ability: Wither Smoke")){

            if(event.getEntity() instanceof Player){

                event.getProjectile().setCustomName("Smoke Bow");

                new BukkitRunnable(){
                    public void run(){
                        if(!event.getProjectile().isDead() && !event.getProjectile().isOnGround()){
                            event.getProjectile().getWorld().spawnParticle(Particle.SMOKE_NORMAL, event.getProjectile().getLocation(), 25);
                        }
                        else{
                            cancel();
                        }
                    }
                }.runTaskTimer(plugin, 0L, 2L);
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event){
        if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("Smoke Bow")){

            event.getEntity().getWorld().spawnParticle(Particle.SMOKE_LARGE, event.getEntity().getLocation(), 1000);

            for(Entity entity : event.getEntity().getNearbyEntities(4, 4, 4)){
                if(entity instanceof LivingEntity){
                    LivingEntity livingentity = (LivingEntity) entity;
                    if(livingentity != event.getEntity().getShooter()){
                        livingentity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 0));
                    }
                }
            }
        }
    }
}
