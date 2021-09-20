package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChunkMinerPickaxe implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if(item.getItemMeta() != null && item.getItemMeta().getLore() != null && item.getItemMeta().getLore().contains(ItemManager.ChunkMinerPickaxe.getItemMeta().getLore().get(0))){
            event.getPlayer().sendMessage(ChatColor.RED + "Prepare for full inventory spam!!!!!!!!!!!!!!!!!!!!");
            for(int x = 0; x < 16; x++){
                for(int y = 0; y < 256; y++){
                    for(int z = 0; z < 16; z++){
                        Block chunkBlock = block.getChunk().getBlock(x, y, z);
                        String loreLine = item.getItemMeta().getLore().get(4);
                        List<String> loreSplit = new ArrayList<>(Arrays.asList(loreLine.split(" ")));
                        String mode = loreSplit.get(3);
                        if(mode.equals("Off")){
                            if(!chunkBlock.isLiquid() && !chunkBlock.getType().isAir() && !chunkBlock.getType().equals(Material.BEDROCK)){
                                /*for(ItemStack drop : chunkBlock.getDrops(item)){
                                    if(event.getPlayer().getInventory().firstEmpty() != -1){
                                        event.getPlayer().getInventory().addItem(drop);
                                    }else{
                                        event.getPlayer().getWorld().dropItemNaturally(event.getPlayer().getLocation(), drop);
                                    }
                                }*/
                                chunkBlock.setType(Material.AIR);
                            }
                        }
                        else{
                            if(!chunkBlock.isLiquid() && !chunkBlock.getType().isAir() && !chunkBlock.getType().equals(Material.BEDROCK)){
                                if(chunkBlock.getType().toString().contains("DIAMOND")) {
                                    for (ItemStack drop : chunkBlock.getDrops(item)) {
                                        if (event.getPlayer().getInventory().firstEmpty() != -1) {
                                            event.getPlayer().getInventory().addItem(drop);
                                        } else {
                                            event.getPlayer().getWorld().dropItemNaturally(event.getPlayer().getLocation(), drop);
                                        }
                                    }
                                    chunkBlock.setType(Material.AIR);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(event.getHand().equals(EquipmentSlot.HAND)){
                ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
                if(item.getItemMeta() != null && item.getItemMeta().getLore() != null && item.getItemMeta().getLore().contains(ItemManager.ChunkMinerPickaxe.getItemMeta().getLore().get(0))) {
                    ItemMeta meta = item.getItemMeta();
                    List<String> lore = meta.getLore();
                    String loreLine = lore.get(4);
                    List<String> loreSplit = new ArrayList<>(Arrays.asList(loreLine.split(" ")));
                    String mode = loreSplit.get(3);
                    if(mode.equals("On")){
                        lore.set(4, "§eDiamonds only mode: Off");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                    }
                    else{
                        lore.set(4, "§eDiamonds only mode: On");
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                    }
                }
            }
        }
    }
}
