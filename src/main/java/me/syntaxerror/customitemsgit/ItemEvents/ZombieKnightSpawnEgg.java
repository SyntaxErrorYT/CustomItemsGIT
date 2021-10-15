package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class ZombieKnightSpawnEgg implements Listener {

    public static void createZombieKnight(Location location){
        Zombie zombie = location.getWorld().spawn(location, Zombie.class);

        zombie.setCustomName(ChatColor.GOLD + "Zombie Knight");
        zombie.setCustomNameVisible(true);

        zombie.getEquipment().setItemInMainHand(new ItemStack(Material.GOLDEN_SWORD));
        zombie.getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET));
        zombie.getEquipment().setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
        zombie.getEquipment().setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
        zombie.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS));
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getHand() != null && event.getHand().equals(EquipmentSlot.HAND)){
                if(event.getItem() != null && event.getItem().getItemMeta() != null && event.getItem().getItemMeta().getLore() != null
                        && event.getItem().getItemMeta().getLore().contains(ItemManager.ZombieKnightSpawnEgg.getItemMeta().getLore().get(0))){
                    Location spawnLocation;
                    if(event.getClickedBlock().isPassable()){
                        spawnLocation = event.getClickedBlock().getLocation().add(0.5, 0, 0.5);
                    }
                    else{
                        spawnLocation = event.getClickedBlock().getRelative(event.getBlockFace()).getLocation().add(0.5, 0, 0.5);
                    }
                    createZombieKnight(spawnLocation);
                    if(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                    }
                    event.setCancelled(true);
                }
            }
        }
    }
}
