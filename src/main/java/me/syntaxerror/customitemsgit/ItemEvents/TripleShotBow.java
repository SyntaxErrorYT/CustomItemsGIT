package me.syntaxerror.customitemsgit.ItemEvents;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class TripleShotBow implements Listener {

    @EventHandler
    public void onShoot(EntityShootBowEvent event){
        if(event.getProjectile() instanceof Arrow){
            if(event.getEntity() instanceof Player){
                if(event.getBow() != null && event.getBow().getItemMeta() != null && event.getBow().getItemMeta().getLore() != null
                        && event.getBow().getItemMeta().getLore().contains("§6Item Ability: Three Shot")){

                    Arrow arrow = (Arrow) event.getProjectile();

                    Arrow arrow1 = event.getEntity().getWorld().spawn(event.getEntity().getEyeLocation(), Arrow.class);
                    arrow1.setDamage(arrow.getDamage() / 2);
                    arrow1.setKnockbackStrength(10);
                    arrow1.setShooter(event.getEntity());
                    arrow1.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(30)));

                    Arrow arrow2 = event.getEntity().getWorld().spawn(event.getEntity().getEyeLocation(), Arrow.class);
                    arrow2.setDamage(arrow.getDamage() / 2);
                    arrow2.setKnockbackStrength(10);
                    arrow2.setShooter(event.getEntity());
                    arrow2.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(-30)));
                }
            }
        }
    }
}
