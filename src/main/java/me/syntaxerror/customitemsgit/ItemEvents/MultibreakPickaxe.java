package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class MultibreakPickaxe implements Listener {

    List<Block> blocks = new ArrayList<>();

    BlockFace blockface = null;

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            blockface = event.getBlockFace();
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null
                && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ItemManager.MultibreakPickaxe.getItemMeta().getLore().get(1))){
            if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                blocks.add(block.getRelative(BlockFace.EAST));
                blocks.add(block.getRelative(BlockFace.WEST));
                blocks.add(block.getRelative(BlockFace.NORTH));
                blocks.add(block.getRelative(BlockFace.SOUTH));
                blocks.add(block.getRelative(BlockFace.SOUTH_WEST));
                blocks.add(block.getRelative(BlockFace.SOUTH_EAST));
                blocks.add(block.getRelative(BlockFace.NORTH_WEST));
                blocks.add(block.getRelative(BlockFace.NORTH_EAST));
            }
            if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                blocks.add(block.getRelative(BlockFace.UP));
                blocks.add(block.getRelative(BlockFace.DOWN));
                blocks.add(block.getRelative(BlockFace.NORTH));
                blocks.add(block.getRelative(BlockFace.SOUTH));
                blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH));
                blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH));
                blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.NORTH));
                blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.SOUTH));
            }
            if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                blocks.add(block.getRelative(BlockFace.UP));
                blocks.add(block.getRelative(BlockFace.DOWN));
                blocks.add(block.getRelative(BlockFace.EAST));
                blocks.add(block.getRelative(BlockFace.WEST));
                blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
                blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
                blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST));
                blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST));
            }
            for(Block b : blocks){
                b.breakNaturally(event.getPlayer().getInventory().getItemInMainHand());
            }
            blocks.clear();
        }
    }
}
