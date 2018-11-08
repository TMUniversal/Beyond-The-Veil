package com.valeriotor.BTV.events;

import java.awt.List;
import java.util.ArrayList;

import com.valeriotor.BTV.capabilities.DGProvider;
import com.valeriotor.BTV.dreams.DreamHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.capabilities.IPlayerKnowledge;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.api.internal.IInternalMethodHandler;

@Mod.EventBusSubscriber
public class PlayerEvents {
	
	@SubscribeEvent
	public static void wakeUpEvent(PlayerWakeUpEvent event) {
		
		event.getEntityPlayer().addItemStackToInventory(new ItemStack(Items.APPLE,1));
		IPlayerKnowledge k = ThaumcraftCapabilities.getKnowledge(event.getEntityPlayer());
		if(event.getEntityPlayer()!=null && !k.isResearchKnown("FIRSTDREAMS") && k.isResearchKnown("FIRSTSTEPS") && event.getEntityPlayer().world.getWorldTime()>23900) {
			k.addResearch("!didDream");
			k.sync((EntityPlayerMP)event.getEntityPlayer());
		}else if(event.getEntityPlayer() != null && k.isResearchKnown("FIRSTDREAMS") && event.getEntityPlayer().world.getWorldTime()>23900) {
			DreamHandler.chooseDream(event.getEntityPlayer(), k);
		}
		
		
		
		//IInternalMethodHandler.progressResearch(event.getEntityPlayer(), "FIRSTDREAMS");
		
	}
	
	@SubscribeEvent
	public static void event2(PlayerLoggedInEvent event) {
		event.player.getCapability(DGProvider.LEVEL_CAP, null).addLevel();

		event.player.sendMessage(new TextComponentString(Integer.toString((event.player.getCapability(DGProvider.LEVEL_CAP, null).getLevel()))));
		System.out.println(Boolean.toString(event.player.hasCapability(DGProvider.LEVEL_CAP, null)) + "\n\n\n\n");
		//event.player.getCapability(DGProvider.LEVEL_CAP, null).setLevel(3);
	}
	
	/*@SubscribeEvent
	public static void event3(PlayerWakeUpEvent event) {
		ArrayList<Entity> es = (ArrayList<Entity>) event.getEntityPlayer().world.getLoadedEntityList();
		for(Entity e : es) {
			if(e instanceof EntityZombie) {
				System.out.println(e.hasCapability(DGProvider.LEVEL_CAP, null));
			}
		}
	}*/
	
	
}
