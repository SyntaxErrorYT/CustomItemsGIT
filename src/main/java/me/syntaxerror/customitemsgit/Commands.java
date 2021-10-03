package me.syntaxerror.customitemsgit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
//TakoTheDev is cool
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("op")) {
                if (cmd.getName().equalsIgnoreCase("givegrapplinghook")) {
                    player.getInventory().addItem(ItemManager.GrapplingHook);
                }
                if (cmd.getName().equalsIgnoreCase("giveteleportsword")){
                    player.getInventory().addItem(ItemManager.TeleportSword);
                }
                if (cmd.getName().equalsIgnoreCase("givethegiftingfish")){
                    player.getInventory().addItem(ItemManager.TheGiftingFish);
                }
                if(cmd.getName().equalsIgnoreCase("giveexplosivebow")){
                    player.getInventory().addItem(ItemManager.ExplosiveBow);
                }
                if(cmd.getName().equalsIgnoreCase("giveinfinitewaterbucket")){
                    player.getInventory().addItem(ItemManager.InfiniteWaterBucket);
                }
                if(cmd.getName().equalsIgnoreCase("giveinfinitelavabucket")){
                    player.getInventory().addItem(ItemManager.InfiniteLavaBucket);
                }
                if(cmd.getName().equalsIgnoreCase("givemachinegunbow")){
                    player.getInventory().addItem(ItemManager.MachineGunBow);
                }
                if(cmd.getName().equalsIgnoreCase("givemultibreakpickaxe")){
                    player.getInventory().addItem(ItemManager.MultibreakPickaxe);
                }
                if(cmd.getName().equalsIgnoreCase("givemidaspickaxe")){
                    player.getInventory().addItem(ItemManager.MidasPickaxe);
                }
                if(cmd.getName().equalsIgnoreCase("giveboomerang")){
                    player.getInventory().addItem(ItemManager.Boomerang);
                }
                if(cmd.getName().equalsIgnoreCase("givehomingbow")){
                    player.getInventory().addItem(ItemManager.HomingBow);
                }
                if(cmd.getName().equalsIgnoreCase("giverocketlauncher")){
                    player.getInventory().addItem(ItemManager.RocketLauncher);
                }
                if(cmd.getName().equalsIgnoreCase("givethrowingaxe")){
                    player.getInventory().addItem(ItemManager.ThrowingAxe);
                }
                if(cmd.getName().equalsIgnoreCase("giveundeadsword")){
                    player.getInventory().addItem(ItemManager.UndeadSword);
                }
                if(cmd.getName().equalsIgnoreCase("givethrowabletnt")){
                    player.getInventory().addItem(ItemManager.ThrowableTNT);
                }
                if(cmd.getName().equalsIgnoreCase("givelightningaxe")){
                    player.getInventory().addItem(ItemManager.LightningAxe);
                }
                if(cmd.getName().equalsIgnoreCase("giveautosmeltpickaxe")){
                    player.getInventory().addItem(ItemManager.AutoSmeltPickaxe);
                }
                if(cmd.getName().equalsIgnoreCase("givesmokebow")){
                    player.getInventory().addItem(ItemManager.SmokeBow);
                }
                if(cmd.getName().equalsIgnoreCase("givefireball")){
                    player.getInventory().addItem(ItemManager.Fireball);
                }
                if(cmd.getName().equalsIgnoreCase("givetripleshotbow")){
                    player.getInventory().addItem(ItemManager.TripleShotBow);
                }
                if(cmd.getName().equalsIgnoreCase("givebomberelytra")){
                    player.getInventory().addItem(ItemManager.BomberElytra);
                }
                if(cmd.getName().equalsIgnoreCase("giveautoshootchestplate")){
                    player.getInventory().addItem(ItemManager.AutoShootChestplate);
                }
                if(cmd.getName().equalsIgnoreCase("giveairstrikebow")){
                    player.getInventory().addItem(ItemManager.AirStrikeBow);
                }
                if(cmd.getName().equalsIgnoreCase("givechunkminerpickaxe")){
                    player.getInventory().addItem(ItemManager.ChunkMinerPickaxe);
                }
            }
            else {
                sender.sendMessage("You are not allowed to use this command");
            }
            return true;
        }
        else {
            sender.sendMessage("Only players can use that command");
            return true;
        }
    }
}
