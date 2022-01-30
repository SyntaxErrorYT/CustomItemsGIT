package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class DogDart implements Listener {

    CustomItemsGIT plugin;

    public DogDart(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
            if(event.getHand() == EquipmentSlot.HAND){
                if(event.getItem() != null && event.getItem().getItemMeta() != null && event.getItem().getItemMeta().getLore() != null
                        && event.getItem().getItemMeta().getLore().contains(ItemManager.DogDart.getItemMeta().getLore().get(0))){

                    event.getItem().setAmount(event.getItem().getAmount() - 1);

                    Arrow arrow = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation().add(0, 1.75, 0), Arrow.class);

                    new BukkitRunnable(){
                        public void run(){
                            if(!arrow.isDead() && !arrow.isOnGround()){
                                arrow.setVelocity(event.getPlayer().getLocation().getDirection().multiply(0.75));
                            }
                            else{
                                List<Wolf> dartWolves = new ArrayList<>();
                                Wolf alphaWolf = arrow.getWorld().spawn(arrow.getLocation(), Wolf.class);
                                alphaWolf.setCustomName(ChatColor.GOLD + "Alpha");
                                alphaWolf.setCustomNameVisible(true);
                                dartWolves.add(alphaWolf);
                                Wolf wolf1 = arrow.getWorld().spawn(arrow.getLocation().add(-1, 0, 0), Wolf.class);
                                dartWolves.add(wolf1);
                                Wolf wolf2 = arrow.getWorld().spawn(arrow.getLocation().add(1, 0, 0), Wolf.class);
                                dartWolves.add(wolf2);
                                Wolf wolf3 = arrow.getWorld().spawn(arrow.getLocation().add(0, 0, -1), Wolf.class);
                                dartWolves.add(wolf3);
                                Wolf wolf4 = arrow.getWorld().spawn(arrow.getLocation().add(0, 0, 1), Wolf.class);
                                dartWolves.add(wolf4);
                                new BukkitRunnable(){
                                    int i = 0;
                                    public void run(){
                                        if(i < 80){
                                            if(alphaWolf.getTarget() == null || alphaWolf.getTarget().isDead()){
                                                for(Entity entity : alphaWolf.getNearbyEntities(10, 10, 10)){
                                                    if(entity instanceof LivingEntity && entity != event.getPlayer() && !dartWolves.contains(entity)){
                                                        LivingEntity livingEntity = (LivingEntity) entity;
                                                        alphaWolf.setTarget(livingEntity);
                                                        break;
                                                    }
                                                }
                                            }
                                            wolf1.setTarget(alphaWolf.getTarget());
                                            wolf2.setTarget(alphaWolf.getTarget());
                                            wolf3.setTarget(alphaWolf.getTarget());
                                            wolf4.setTarget(alphaWolf.getTarget());
                                        }
                                        else{
                                            alphaWolf.remove();
                                            wolf1.remove();
                                            wolf2.remove();
                                            wolf3.remove();
                                            wolf4.remove();
                                            cancel();
                                        }
                                        i++;
                                    }
                                }.runTaskTimer(plugin, 0L, 5L);
                                cancel();
                            }
                        }
                    }.runTaskTimer(plugin, 0L, 2L);
                    event.setCancelled(true);
                }
            }
        }
    }
}
