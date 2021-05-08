package me.syntaxerror.customitemsgit;

import me.syntaxerror.customitemsgit.ItemEvents.*;
import me.syntaxerror.customitemsgit.ItemEvents.GrapplingHookFiles.GrapplingHook;
import me.syntaxerror.customitemsgit.ItemEvents.GrapplingHookFiles.GrapplingHookCooldown;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItemsGIT extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        ItemManager.init();

        this.getCommand("givegrapplinghook").setExecutor(new Commands());
        this.getCommand("giveteleportsword").setExecutor(new Commands());
        this.getCommand("givethegiftingfish").setExecutor(new Commands());
        this.getCommand("giveexplosivebow").setExecutor(new Commands());
        this.getCommand("giveinfinitewaterbucket").setExecutor((new Commands()));
        this.getCommand("giveinfinitelavabucket").setExecutor((new Commands()));
        this.getCommand("givemachinegunbow").setExecutor(new Commands());
        this.getCommand("givemultibreakpickaxe").setExecutor(new Commands());
        this.getCommand("givemidaspickaxe").setExecutor(new Commands());
        this.getCommand("giveboomerang").setExecutor(new Commands());
        this.getCommand("givehomingbow").setExecutor(new Commands());

        this.getServer().getPluginManager().registerEvents(new TeleportSword(), this);
        this.getServer().getPluginManager().registerEvents(new GrapplingHook(), this);
        this.getServer().getPluginManager().registerEvents(new TheGiftingFish(), this);
        this.getServer().getPluginManager().registerEvents(new ExplosiveBow(), this);
        this.getServer().getPluginManager().registerEvents(new InfiniteBuckets(), this);
        this.getServer().getPluginManager().registerEvents(new MachineGunBow(this), this);
        this.getServer().getPluginManager().registerEvents(new MultibreakPickaxe(), this);
        this.getServer().getPluginManager().registerEvents(new MidasPickaxe(), this);
        this.getServer().getPluginManager().registerEvents(new Boomerang(this), this);
        this.getServer().getPluginManager().registerEvents(new HomingBow(this), this);

        GrapplingHookCooldown.setupCooldown();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
