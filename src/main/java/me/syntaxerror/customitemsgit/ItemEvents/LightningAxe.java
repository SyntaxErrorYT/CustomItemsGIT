package me.syntaxerror.customitemsgit.ItemEvents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LightningAxe implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity){

            Player player = (Player) event.getDamager();
            LivingEntity livingentity = (LivingEntity) event.getEntity();

            if(player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null
                    && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability: Stormbreaker")){

                player.getWorld().strikeLightningEffect(event.getEntity().getLocation());

                String lore = player.getInventory().getItemInMainHand().getItemMeta().getLore().get(2);
                List<String> loresplit = new ArrayList<>(Arrays.asList(lore.split(" ")));
                String damage = loresplit.get(1);
                damage = damage.replaceAll("§c", "");

                livingentity.damage(Integer.parseInt(damage));
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null
                    && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability: Stormbreaker")){

                for(Entity entity : event.getPlayer().getNearbyEntities(12, 12, 12)){
                    if(entity instanceof LivingEntity){

                        LivingEntity livingentity = (LivingEntity) entity;

                        livingentity.getWorld().strikeLightningEffect(livingentity.getLocation());

                        String lore = event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().get(7);
                        List<String> loresplit = new ArrayList<>(Arrays.asList(lore.split(" ")));
                        String damage = loresplit.get(1);
                        damage = damage.replaceAll("§c", "");

                        livingentity.damage(Integer.parseInt(damage));
                    }
                }
            }
        }
    }
}
