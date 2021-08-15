package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BomberElytra implements Listener {

    CustomItemsGIT plugin;

    public BomberElytra(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onFly(EntityToggleGlideEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            new BukkitRunnable() {
                public void run() {
                    if (player.isGliding()) {
                        if (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getItemMeta() != null
                                && player.getInventory().getChestplate().getItemMeta().getLore() != null) {
                            if (player.getInventory().getChestplate().getItemMeta().getLore().contains(ItemManager.BomberElytra.getItemMeta().getLore().get(0))) {
                                String loreline = player.getInventory().getChestplate().getItemMeta().getLore().get(4);
                                List<String> loresplit = new ArrayList<>(Arrays.asList(loreline.split(" ")));
                                String mode = loresplit.get(2);
                                if (mode.equals("On")) {
                                    if (player.getInventory().containsAtLeast(new ItemStack(Material.TNT), 1)) {
                                        player.getWorld().spawn(player.getLocation(), TNTPrimed.class);
                                        player.getInventory().removeItem(new ItemStack(Material.TNT, 1));
                                    }
                                }
                            } else {
                                cancel();
                            }
                        } else {
                            cancel();
                        }
                    } else {
                        cancel();
                    }
                }
            }.runTaskTimer(plugin, 0L, 5L);
        }
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        if(!event.getPlayer().isSneaking()){
            if(player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getItemMeta() != null
                    && player.getInventory().getChestplate().getItemMeta().getLore() != null){
                if(player.getInventory().getChestplate().getItemMeta().getLore().contains(ItemManager.BomberElytra.getItemMeta().getLore().get(0))){
                    ItemStack item = player.getInventory().getChestplate();
                    ItemMeta meta = item.getItemMeta();
                    List<String> lore = meta.getLore();
                    String loreline = lore.get(4);
                    List<String> loresplit = new ArrayList<>(Arrays.asList(loreline.split(" ")));
                    String mode = loresplit.get(2);
                    if(mode.equals("On")){
                        lore.set(4, "§eBomber mode: Off");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                    }
                    else{
                        lore.set(4, "§eBomber mode: On");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                    }
                }
            }
            if(player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null){
                if(player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ItemManager.BomberElytra.getItemMeta().getLore().get(0))){
                    ItemStack item = player.getInventory().getItemInMainHand();
                    ItemMeta meta = item.getItemMeta();
                    List<String> lore = meta.getLore();
                    String loreline = lore.get(4);
                    List<String> loresplit = new ArrayList<>(Arrays.asList(loreline.split(" ")));
                    String mode = loresplit.get(2);
                    if(mode.equals("On")){
                        lore.set(4, "§eBomber mode: Off");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                    }
                    else{
                        lore.set(4, "§eBomber mode: On");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                    }
                }
            }
        }
    }
}
