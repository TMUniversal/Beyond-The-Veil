package com.valeriotor.BTV;

import org.apache.logging.log4j.Logger;

import com.valeriotor.BTV.capabilities.IPlayerData;
import com.valeriotor.BTV.capabilities.IWorship;
import com.valeriotor.BTV.capabilities.PlayerDataHandler;
import com.valeriotor.BTV.capabilities.WorshipCapHandler;
import com.valeriotor.BTV.events.ResearchEvents;
import com.valeriotor.BTV.lib.References;
import com.valeriotor.BTV.lib.commands.ReloadResources;
import com.valeriotor.BTV.lib.commands.SetWorshipLevel;
import com.valeriotor.BTV.network.BTVPacketHandler;
import com.valeriotor.BTV.proxy.CommonProxy;
import com.valeriotor.BTV.research.TCRegistries;
import com.valeriotor.BTV.util.RegistryHelper;
import com.valeriotor.BTV.world.BiomeRegistry;
import com.valeriotor.BTV.world.WorldGenBTV;
import com.valeriotor.BTV.world.Structures.HamletStructuresRegistry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, dependencies = References.DEPENDENCIES)
public class BeyondTheVeil
{
	@SidedProxy(clientSide = "com.valeriotor.BTV.proxy.ClientProxy", serverSide = "com.valeriotor.BTV.proxy.ServerProxy")
    public static CommonProxy proxy;
	
	@Mod.Instance
	public static BeyondTheVeil instance;
    

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
        RegistryHelper.registerEntities();
        BTVPacketHandler.registerPackets();
        //ClientProxy.registerEntity();
        

    	CapabilityManager.INSTANCE.register(IWorship.class, new WorshipCapHandler.DGStorage(), new WorshipCapHandler.Factory());
    	CapabilityManager.INSTANCE.register(IPlayerData.class, new PlayerDataHandler.DataStorage(), new PlayerDataHandler.Factory());

    	MinecraftForge.EVENT_BUS.register(WorshipCapHandler.class);
    	MinecraftForge.EVENT_BUS.register(new ResearchEvents());
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {	
    	
    	//CapabilityHandler.registerCapabilities();
    	new BiomeRegistry();
    	proxy.init(event);
    	proxy.registerEntities();
    	
    	
    	
    	RegistryHelper.registerTileEntities();
    	
    	ResearchCategories.registerCategory("BEYOND_THE_VEIL", (String)null, new AspectList(), new ResourceLocation("beyondtheveil","textures/research/tab_icon.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_1.jpg"),new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png") );
    	TCRegistries.register();
    	ThaumcraftApi.registerResearchLocation(new ResourceLocation(References.MODID, "research/btvresearch"));
    	GameRegistry.registerWorldGenerator(new WorldGenBTV(), 10000);
    	HamletStructuresRegistry.registerStructures();
    	
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new SetWorshipLevel());
        event.registerServerCommand(new ReloadResources());
    }
}
