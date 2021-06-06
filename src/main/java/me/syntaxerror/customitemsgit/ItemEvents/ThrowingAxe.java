package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThrowingAxe implements Listener {

    CustomItemsGIT plugin;

    public ThrowingAxe(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            Player player = event.getPlayer();
            if(player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null
                    && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability: Throw §eRIGHT CLICK")){

                String lore = player.getInventory().getItemInMainHand().getItemMeta().getLore().get(4);
                List<String> loresplit = new ArrayList(Arrays.asList(lore.split(" ")));
                String damage = loresplit.get(0);
                damage = damage.replaceAll("§c", "");
                damage = damage.replaceAll(",", "");

                String finaldamage = damage;

                ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 0.5, 0), EntityType.ARMOR_STAND);

                as.setArms(true);
                as.setGravity(false);
                as.setVisible(false);
                as.setSmall(true);
                as.setMarker(true);
                as.setItemInHand(new ItemStack(Material.NETHERITE_AXE));
                as.setRightArmPose(new EulerAngle(Math.toRadians(90), Math.toRadians(0), Math.toRadians(0)));

                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);

                Location dest = player.getLocation().add(player.getLocation().getDirection().multiply(10));
                Vector vector = dest.subtract(player.getLocation()).toVector();

                new BukkitRunnable(){
                    int distance = 30;
                    int i = 0;

                    public void run(){

                        EulerAngle rot = as.getRightArmPose();
                        EulerAngle rotnew = rot.add(20, 0, 0);
                        as.setRightArmPose(rotnew);

                        as.teleport(as.getLocation().add(vector.normalize()));

                        if(as.getTargetBlockExact(1) != null && !as.getTargetBlockExact(1).isPassable()){
                            if(!as.isDead()){
                                as.remove();
                                if(player.getInventory().firstEmpty() != -1){
                                    player.getInventory().addItem(ItemManager.ThrowingAxe);
                                }
                                else{
                                    player.getWorld().dropItemNaturally(player.getLocation(), ItemManager.ThrowingAxe);
                                }
                                cancel();
                            }
                        }

                        for(Entity entity : as.getLocation().getChunk().getEntities()){
                            if(!as.isDead()){
                                if(as.getLocation().distanceSquared(entity.getLocation()) <= 1){
                                    if(entity != player && entity != as){
                                        if(entity instanceof LivingEntity){
                                            LivingEntity livingentity = (LivingEntity) entity;
                                            livingentity.damage(Integer.parseInt(finaldamage), player);
                                            as.remove();
                                            if(player.getInventory().firstEmpty() != -1){
                                                player.getInventory().addItem(ItemManager.ThrowingAxe);
                                            }
                                            else{
                                                player.getWorld().dropItemNaturally(player.getLocation(), ItemManager.ThrowingAxe);
                                            }
                                            cancel();
                                        }
                                    }
                                }
                            }
                        }

                        if(i > distance){
                            if(!as.isDead()){
                                as.remove();
                                if(player.getInventory().firstEmpty() != -1){
                                    player.getInventory().addItem(ItemManager.ThrowingAxe);
                                }
                                else{
                                    player.getWorld().dropItemNaturally(player.getLocation(), ItemManager.ThrowingAxe);
                                }
                                cancel();
                            }
                        }

                        i++;
                    }
                }.runTaskTimer(plugin, 0L, 1L);

                event.setCancelled(true);
            }
        }
    }
}
