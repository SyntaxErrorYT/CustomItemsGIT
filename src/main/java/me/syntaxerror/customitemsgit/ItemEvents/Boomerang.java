package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class Boomerang implements Listener {

    CustomItemsGIT plugin;

    public Boomerang(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Boomerang Powers:")){

            ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            Location destination = player.getLocation().add(player.getLocation().getDirection().multiply(10));

            as.setArms(true);
            as.setGravity(false);
            as.setVisible(false);
            as.setItemInHand(new ItemStack(Material.BONE));
            as.setRightArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(120), Math.toRadians(0)));

            player.getInventory().removeItem(ItemManager.Boomerang);

            Vector vector = destination.subtract(player.getLocation()).toVector();

            new BukkitRunnable(){

                int distance = 40;
                int i = 0;

                public void run(){

                    EulerAngle rot = as.getRightArmPose();
                    EulerAngle rotnew = rot.add(0, 20, 0);
                    as.setRightArmPose(rotnew);

                    if(i >= distance){
                        as.teleport(as.getLocation().subtract(vector.normalize()));
                        if(i >= distance * 2){
                            as.remove();
                            player.getInventory().addItem(ItemManager.Boomerang);
                            cancel();
                        }
                    }
                    else{
                        as.teleport(as.getLocation().add(vector.normalize()));
                    }

                    i++;

                    for(Entity entity : as.getLocation().getChunk().getEntities()){
                        if(as.getLocation().distanceSquared(entity.getLocation()) < 1){
                            if(entity != player){
                                LivingEntity livingentity = (LivingEntity) entity;
                                livingentity.damage(1000, player);
                            }
                        }
                    }
                }
            }.runTaskTimer(plugin, 1L, 1L);

            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntity(PlayerInteractAtEntityEvent event){
        if(event.getRightClicked() instanceof ArmorStand){
            ArmorStand as = (ArmorStand) event.getRightClicked();
            if(as.getItemInHand().getType().equals(Material.BONE)){
                event.setCancelled(true);
            }
        }
    }
}
