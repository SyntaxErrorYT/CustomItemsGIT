package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.CustomItemsGIT;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DamageMultiplierSword implements Listener {

    CustomItemsGIT plugin;

    public DamageMultiplierSword(CustomItemsGIT plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null && event.getCurrentItem().getItemMeta().getLore() != null
                && event.getCurrentItem().getItemMeta().getLore().contains("§6Item Ability: Damage Multiplier")){
            String zombie = plugin.getConfig().getString("undeadsword.zombie");
            String skeleton = plugin.getConfig().getString("undeadsword.skeleton");
            ItemMeta meta = event.getCurrentItem().getItemMeta();
            List<String> lore = new ArrayList<>(meta.getLore());
            lore.set(4, "§7Zombies: §c+" + zombie + "%");
            lore.set(5, "§7Skeletons: §c+" + skeleton + "%");
            meta.setLore(lore);
            event.getCurrentItem().setItemMeta(meta);
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event){
        if(event.getItem().getItemStack().getItemMeta() != null && event.getItem().getItemStack().getItemMeta().getLore() != null
                && event.getItem().getItemStack().getItemMeta().getLore().contains("§6Item Ability: Damage Multiplier")){
            String zombie = plugin.getConfig().getString("undeadsword.zombie");
            String skeleton = plugin.getConfig().getString("undeadsword.skeleton");
            ItemMeta meta = event.getItem().getItemStack().getItemMeta();
            List<String> lore = new ArrayList<>(meta.getLore());
            lore.set(4, "§7Zombies: §c+" + zombie + "%");
            lore.set(5, "§7Skeletons: §c+" + skeleton + "%");
            meta.setLore(lore);
            event.getItem().getItemStack().setItemMeta(meta);
        }
    }

    @EventHandler
    public void onSwap(PlayerItemHeldEvent event){
        if(event.getPlayer().getInventory().getItem(event.getNewSlot()) != null && event.getPlayer().getInventory().getItem(event.getNewSlot()).getItemMeta() != null
                && event.getPlayer().getInventory().getItem(event.getNewSlot()).getItemMeta().getLore() != null
                && event.getPlayer().getInventory().getItem(event.getNewSlot()).getItemMeta().getLore().contains("§6Item Ability: Damage Multiplier")){
            String zombie = plugin.getConfig().getString("undeadsword.zombie");
            String skeleton = plugin.getConfig().getString("undeadsword.skeleton");
            ItemMeta meta = event.getPlayer().getInventory().getItem(event.getNewSlot()).getItemMeta();
            List<String> lore = new ArrayList<>(meta.getLore());
            lore.set(4, "§7Zombies: §c+" + zombie + "%");
            lore.set(5, "§7Skeletons: §c+" + skeleton + "%");
            meta.setLore(lore);
            event.getPlayer().getInventory().getItem(event.getNewSlot()).setItemMeta(meta);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null
                    && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability: Damage Multiplier")) {
                if (event.getEntity() instanceof Zombie) {
                    int zombie = plugin.getConfig().getInt("undeadsword.zombie");
                    event.setDamage(event.getDamage() + (event.getDamage() * zombie / 100));
                } else if (event.getEntity() instanceof Skeleton) {
                    int skeleton = plugin.getConfig().getInt("undeadsword.skeleton");
                    event.setDamage(event.getDamage() + (event.getDamage() * skeleton / 100));
                }
                player.sendMessage(String.valueOf(event.getDamage()));
            }
        }
    }
}
