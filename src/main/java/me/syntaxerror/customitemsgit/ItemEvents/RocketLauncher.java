package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RocketLauncher implements Listener {

    CustomItemsGIT plugin;

    public RocketLauncher(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null
                    && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability: Ricochet Rocket §eRIGHT CLICK")) {

                Player player = event.getPlayer();

                String lore = player.getInventory().getItemInMainHand().getItemMeta().getLore().get(4);
                List<String> loresplit = new ArrayList(Arrays.asList(lore.split(" ")));
                String damage = loresplit.get(0);
                damage = damage.replaceAll("§c", "");
                damage = damage.replaceAll(",", "");

                Location eye = player.getEyeLocation();
                Firework firework = (Firework) eye.getWorld().spawnEntity(eye, EntityType.FIREWORK);
                FireworkMeta meta = firework.getFireworkMeta();
                meta.setPower(2);
                firework.setFireworkMeta(meta);
                firework.setShotAtAngle(true);
                firework.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                firework.setVelocity(eye.getDirection().normalize().multiply(2));
                firework.setBounce(true);
                firework.setCustomName(damage);
                firework.setShooter(player);
                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 5, 5);

                new BukkitRunnable() {

                    public void run() {
                        if (firework.isDead()) {
                            cancel();
                        }
                        else{
                            firework.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, firework.getLocation(), 10);
                            firework.getWorld().playSound(firework.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 5, 5);
                            for (Entity entity : firework.getNearbyEntities(5, 5, 5)) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity livingentity = (LivingEntity) entity;
                                    if (!livingentity.equals(player) && !livingentity.equals(firework)) {
                                        livingentity.damage(Integer.parseInt(firework.getCustomName()));
                                    }
                                }
                            }
                            cancel();
                        }
                    }
                }.runTaskTimer(plugin, firework.getFireworkMeta().getPower() * 10 + 10, 0L);

                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event){
        if(event.getEntity() instanceof Firework && event.getEntity().getCustomName() != null){
            Firework firework = (Firework) event.getEntity();
            firework.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, firework.getLocation(), 10);
            firework.getWorld().playSound(firework.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 5, 5);
            firework.setVelocity(new Vector(firework.getFacing().getModX(), firework.getFacing().getModY(), firework.getFacing().getModZ()));
            for(Entity entity : firework.getNearbyEntities(5, 5, 5)){
                if(entity instanceof LivingEntity) {
                    LivingEntity livingentity = (LivingEntity) entity;
                    if(!livingentity.equals(event.getEntity().getShooter()) && !livingentity.equals(firework)) {
                        livingentity.damage(Integer.parseInt(firework.getCustomName()) / 2);
                    }
                }
            }
            if(event.getHitEntity() != null){
                Firework newfirework = (Firework) firework.getWorld().spawnEntity(firework.getLocation(), EntityType.FIREWORK);
                FireworkMeta meta = newfirework.getFireworkMeta();
                meta.setPower(firework.getFireworkMeta().getPower() - (firework.getTicksLived() / 10) - 1);
                newfirework.setFireworkMeta(meta);
                newfirework.setShotAtAngle(true);
                newfirework.setRotation(firework.getLocation().getYaw(), firework.getLocation().getPitch());
                newfirework.setVelocity(new Vector(firework.getFacing().getModX(), firework.getFacing().getModY(), firework.getFacing().getModZ()));
                newfirework.setBounce(true);
                newfirework.setCustomName(firework.getCustomName());
                newfirework.setShooter(firework.getShooter());
                new BukkitRunnable() {

                    public void run() {
                        if (newfirework.isDead()) {
                            cancel();
                        }
                        else{
                            newfirework.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, newfirework.getLocation(), 10);
                            newfirework.getWorld().playSound(newfirework.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 5, 5);
                            for (Entity entity : newfirework.getNearbyEntities(5, 5, 5)) {
                                if (entity instanceof LivingEntity) {
                                    LivingEntity livingentity = (LivingEntity) entity;
                                    if (!livingentity.equals(newfirework.getShooter()) && !livingentity.equals(newfirework)) {
                                        livingentity.damage(Integer.parseInt(newfirework.getCustomName()));
                                    }
                                }
                            }
                            cancel();
                        }
                    }
                }.runTaskTimer(plugin, newfirework.getFireworkMeta().getPower() * 10 + 10, 0L);
            }
        }
    }
}
