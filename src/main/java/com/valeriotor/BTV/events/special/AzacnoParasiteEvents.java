package com.valeriotor.BTV.events.special;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;

import com.valeriotor.BTV.events.ServerTickEvents;
import com.valeriotor.BTV.potions.PotionRegistry;
import com.valeriotor.BTV.worship.AzacnoParasite;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class AzacnoParasiteEvents {

	public static final HashMap<UUID, AzacnoParasite> parasites = new HashMap<>();
	
	
	public static void updateParasites() {
		Iterator<Entry<UUID, AzacnoParasite>> iter = parasites.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<UUID, AzacnoParasite> entry = iter.next();
			if(entry.getValue().update())
				iter.remove();
		}
	}
	
	public static void damageEntity(LivingHurtEvent e) {
		EntityPlayer attacker = (EntityPlayer) e.getSource().getTrueSource();
		if(ServerTickEvents.getPlayerTimer("azacno", attacker) == null) return;

		if(e.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer damaged = (EntityPlayer) e.getEntityLiving();
			if(!parasites.containsKey(damaged.getPersistentID()))
				parasites.put(damaged.getPersistentID(), new AzacnoParasite(damaged));
		} else {
			e.getEntityLiving().addPotionEffect(new PotionEffect(PotionRegistry.terror, 300, 3));
		}
	}
	
}