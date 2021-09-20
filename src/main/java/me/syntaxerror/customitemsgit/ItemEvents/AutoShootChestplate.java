package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoShootChestplate extends BukkitRunnable {

    CustomItemsGIT plugin;

    public AutoShootChestplate(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    List<LivingEntity> shotAt = new ArrayList<>();

    @Override
    public void run(){
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getItemMeta() != null && player.getInventory().getChestplate().getItemMeta().getLore() != null &&
                    player.getInventory().getChestplate().getItemMeta().getLore().contains(ItemManager.AutoShootChestplate.getItemMeta().getLore().get(0))){
                for(Entity entity : player.getNearbyEntities(10, 10, 10)){
                    if(entity != player && entity instanceof LivingEntity){
                        LivingEntity livingEntity = (LivingEntity) entity;
                        Random r = new Random();
                        if(!shotAt.contains(livingEntity)){
                            shotAt.add(livingEntity);
                            if(r.nextInt(100) < 90){
                                Arrow arrow = player.getWorld().spawn(player.getLocation().add(0, 0.8, 0), Arrow.class);
                                arrow.setShooter(player);
                                new BukkitRunnable(){
                                    public void run(){
                                        if(!arrow.isOnGround() && !arrow.isDead() && !livingEntity.isDead()){
                                            arrow.setVelocity(livingEntity.getEyeLocation().subtract(arrow.getLocation()).toVector().multiply(0.7));
                                        }
                                        else{
                                            if(!arrow.isDead()){
                                                arrow.remove();
                                            }
                                            shotAt.remove(livingEntity);
                                            cancel();
                                        }
                                    }
                                }.runTaskTimer(plugin, 0, 5);
                            }
                            else{
                                TNTPrimed tnt = player.getWorld().spawn(player.getLocation().add(0, 0.8, 0), TNTPrimed.class);
                                new BukkitRunnable(){
                                    public void run(){
                                        if(!tnt.isDead() && !livingEntity.isDead()){
                                            tnt.setVelocity(livingEntity.getEyeLocation().subtract(tnt.getLocation()).toVector().multiply(0.25));
                                        }
                                        else{
                                            if(!tnt.isDead()){
                                                tnt.remove();
                                            }
                                            shotAt.remove(livingEntity);
                                            cancel();
                                        }
                                    }
                                }.runTaskTimer(plugin, 0, 5);
                            }
                        }
                    }
                }
            }
        }
    }
}
