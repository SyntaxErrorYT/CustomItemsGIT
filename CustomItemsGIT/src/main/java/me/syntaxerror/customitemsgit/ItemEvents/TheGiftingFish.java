package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class TheGiftingFish implements Listener {

    private ItemStack[] giftsack = {
            new ItemStack(Material.DIAMOND, 1),
            new ItemStack(Material.REDSTONE, 1),
            new ItemStack(Material.LAPIS_LAZULI, 1),
            new ItemStack(Material.EMERALD, 1),
            new ItemStack(Material.COAL, 1)
    };

    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) ||event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(name.equals("§cThe Gifting Fish")){
                Random r = new Random();
                event.getPlayer().getInventory().removeItem(ItemManager.TheGiftingFish);
                event.getPlayer().getInventory().addItem(giftsack[r.nextInt(giftsack.length + 0) - 0]);
                player.sendMessage(ChatColor.YELLOW + "Woooo! You were gifted an item!");
            }
        }
    }
}
