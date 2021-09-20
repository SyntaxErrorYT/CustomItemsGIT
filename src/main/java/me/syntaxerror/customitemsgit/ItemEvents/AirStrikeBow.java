package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Random;

public class AirStrikeBow implements Listener {

    @EventHandler
    public void onShoot(EntityShootBowEvent event){
        if(event.getEntity() instanceof Player){
            if(event.getBow() != null && event.getBow().getItemMeta() != null && event.getBow().getItemMeta().getLore() != null
                    && event.getBow().getItemMeta().getLore().contains(ItemManager.AirStrikeBow.getItemMeta().getLore().get(0))){
                if(event.getProjectile() instanceof Arrow){
                    Arrow arrow = (Arrow) event.getProjectile();
                    arrow.setCustomName("Air Strike Bow");
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event){
        if(event.getEntity() instanceof Arrow){
            Arrow arrow = (Arrow) event.getEntity();
            if(arrow.getCustomName() != null && arrow.getCustomName().equals("Air Strike Bow")){
                Location hitLocation = arrow.getLocation();
                Random r = new Random();
                for(Entity entity : arrow.getNearbyEntities(5, 5, 5)){
                    if(entity instanceof Player){
                        Player player = (Player) entity;
                        player.sendTitle(ChatColor.RED + "Air Strike Incoming!", ChatColor.DARK_RED + "Just stand right there!", 10, 60, 10);
                        player.playSound(player.getLocation(), Sound.ENTITY_TNT_PRIMED, 5, 5);
                    }
                }
                for(int i = 0; i < 10; i++){
                    Arrow airStrikeArrow = arrow.getWorld().spawn(hitLocation.clone().add(r.nextInt(5 + 5) - 5, 100, r.nextInt(5 + 5) - 5), Arrow.class);
                    airStrikeArrow.setCustomName("Air Strike Arrow");
                    airStrikeArrow.setShooter(arrow.getShooter());
                }
            }
            else if(arrow.getCustomName() != null && arrow.getCustomName().equals("Air Strike Arrow")){
                arrow.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, arrow.getLocation(), 10);
                arrow.getWorld().playSound(arrow.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 5, 5);
                for(Entity entity : arrow.getNearbyEntities(3, 3, 3)){
                    if(entity instanceof LivingEntity){
                        if(entity != arrow.getShooter()){
                            LivingEntity livingEntity = (LivingEntity) entity;
                            livingEntity.damage(10, (Entity) arrow.getShooter());
                        }
                    }
                }
                arrow.remove();
            }
        }
    }
}
