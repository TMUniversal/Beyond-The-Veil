package com.valeriotor.BTV.events;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.valeriotor.BTV.items.ItemRegistry;
import com.valeriotor.BTV.proxy.ClientProxy;

import baubles.api.BaublesApi;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientEvents {
	
	private int sawcleaverCount = 0;
	private KeyBinding binds[] = {
			Minecraft.getMinecraft().gameSettings.keyBindForward,
			Minecraft.getMinecraft().gameSettings.keyBindLeft,
			Minecraft.getMinecraft().gameSettings.keyBindBack,
			Minecraft.getMinecraft().gameSettings.keyBindRight
	};
	
	
	@SubscribeEvent
	public void clientTickEvent(ClientTickEvent event) {
		if(event.phase.equals(Phase.END)) {
			EntityPlayerSP p = Minecraft.getMinecraft().player;
			if(!Minecraft.getMinecraft().isGamePaused() && p != null) {
			if(p.getHeldItemMainhand().getItem() == ItemRegistry.saw_cleaver && !p.isInWater()) {
				if(ClientProxy.handler.dodge.isPressed() && sawcleaverCount > 4) {
					int conto = 0;
					int direction[] = {-1,-1};
					for(int i = 0; i < 4; i++) {
						if(binds[i].isKeyDown()) {
							conto++;
							if(conto > 0) direction[0] = i;
							if(conto == 2) direction[1] = i;
						}
					}
					for(int i = 0; i < conto && i < 3; i++) {
						this.movePlayer(direction[i], 1 / ((float) conto));
					}
					sawcleaverCount = 0;
					
				}
				
				
			}
			if(sawcleaverCount < 5) {
				sawcleaverCount++;
			}
		}
		}
	}
	
	public void movePlayer(int direction, float multiplier) {
		EntityPlayer p = Minecraft.getMinecraft().player;
		float mX = (float) -Math.sin(p.rotationYawHead*2*Math.PI/360);
		float mZ = (float) Math.cos(p.rotationYawHead*2*Math.PI/360);
		float tmp = mX;
		switch(direction) {
		case 0: break;
		case 1:	
			mX = mZ;
			mZ = -tmp;
			break;
		case 2:
			mX = -mX;
			mZ = -mZ;
			break;
		case 3:
			mX = -mZ;
			mZ = tmp;
		}
		p.motionX += mX * 2 * multiplier;// *(p.isAirBorne ? 1 : 3);
		p.motionZ += mZ * 2 * multiplier;// *(p.isAirBorne ? 1 : 3);
	}
	
	/*
	@SubscribeEvent
	public void onDrawBlockHighlightEvent(DrawBlockHighlightEvent evt){
		EntityPlayer player = Minecraft.getMinecraft().player;
		if(BaublesApi.isBaubleEquipped(player, ItemRegistry.wolf_medallion) != 0) return;
		
		AxisAlignedBB bb = new AxisAlignedBB(player.getPosition().add(-25, -10, -25), player.getPosition().add(25, 12, 25));
		List<Entity> entities = player.world.getEntitiesWithinAABBExcludingEntity(player, bb);
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);	
		GL11.glColor4f(1F, 0F, 1F, 0F); 
		double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double)evt.getPartialTicks();
        double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double)evt.getPartialTicks();
        double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)evt.getPartialTicks();
        Vec3d pos = new Vec3d(d0, d1, d2);
        GL11.glTranslated(-pos.x, -pos.y, -pos.z);
		for(Entity e : entities) {
			Vec3d blockA = new Vec3d(e.posX-1, e.posY-1, e.posZ-1);
			Vec3d blockB = new Vec3d(e.posX+1, e.posY+1, e.posZ+1);
			GL11.glBegin(GL11.GL_LINE_STRIP);

			GL11.glVertex3d(blockA.x, blockA.y, blockA.z);
			GL11.glVertex3d(blockB.x, blockB.y, blockB.z);

			GL11.glEnd();
			
			
			
			
		}
		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}
	*/
	
	
}