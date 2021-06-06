package me.syntaxerror.customitemsgit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command");
            return true;
        } else {
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
            } else {
                sender.sendMessage("You are not allowed to use this command");
            }

            return true;
        }
    }
}
