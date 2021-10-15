package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OreCompass implements Listener {

    private BlockFace[] blockFaces = {
            BlockFace.UP, BlockFace.DOWN, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST
    };

    HashMap<Player, Location> blockLocation = new HashMap<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getHand().equals(EquipmentSlot.HAND)){
                if(event.getItem() != null && event.getItem().getItemMeta() != null && event.getItem().getItemMeta().getLore() != null
                        && event.getItem().getItemMeta().getLore().contains(ItemManager.OreCompass.getItemMeta().getLore().get(0))){
                    List<Block> adjacentBlocks = new ArrayList<>();
                    if(event.getPlayer().getLevel() >= 1){
                        adjacentBlocks.add(event.getPlayer().getLocation().getBlock());
                        int counter = 0;
                        for(int i = 0; i < adjacentBlocks.size(); i++){
                            if(counter < 10000){
                                Block block = adjacentBlocks.get(i);
                                if(block.getType().toString().contains("ORE")){
                                    blockLocation.put(event.getPlayer(), block.getLocation());
                                    event.getPlayer().setCompassTarget(block.getLocation());
                                    event.getPlayer().sendMessage(ChatColor.YELLOW + "An ore has been found!");
                                    event.getPlayer().setLevel(event.getPlayer().getLevel() - 1);
                                    break;
                                }
                                else{
                                    for(BlockFace blockFace : blockFaces){
                                        if(!adjacentBlocks.contains(block.getRelative(blockFace))){
                                            adjacentBlocks.add(block.getRelative(blockFace));
                                        }
                                    }
                                }
                                counter++;
                            }
                            else{
                                event.getPlayer().sendMessage(ChatColor.YELLOW + "A total of 10000 blocks were scanned but no ores were found!");
                                break;
                            }
                        }
                    }
                    else{
                        event.getPlayer().sendMessage(ChatColor.RED + "Not enough Levels!");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(blockLocation.containsValue(event.getBlock().getLocation())){
            for(Player player : blockLocation.keySet()){
                if(blockLocation.get(player).equals(event.getBlock().getLocation())){
                    player.sendMessage(ChatColor.RED + "The ore your compass was pointing to was mined!");
                    player.setCompassTarget(event.getPlayer().getWorld().getSpawnLocation());
                    blockLocation.remove(player);
                }
            }
        }
    }

    @EventHandler
    public void onLogOut(PlayerQuitEvent event){
        if(blockLocation.containsKey(event.getPlayer())){
            event.getPlayer().sendMessage(ChatColor.RED + "Your Ore Compass has been reset!");
            event.getPlayer().setCompassTarget(event.getPlayer().getWorld().getSpawnLocation());
            blockLocation.remove(event.getPlayer());
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        if(blockLocation.containsKey(event.getEntity())){
            event.getEntity().sendMessage(ChatColor.RED + "Your Ore Compass has been reset!");
            event.getEntity().setCompassTarget(event.getEntity().getWorld().getSpawnLocation());
            blockLocation.remove(event.getEntity());
        }
    }
}
