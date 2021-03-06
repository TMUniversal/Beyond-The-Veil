package com.valeriotor.beyondtheveil.entities.AI;

import com.valeriotor.beyondtheveil.entities.EntityShoggoth;
import com.valeriotor.beyondtheveil.shoggoth.ShoggothBuilding;
import com.valeriotor.beyondtheveil.shoggoth.ShoggothLongBuilding;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class AIShoggothBuild extends EntityAIBase{
	
	private EntityShoggoth shoggoth;
	private int timer = 0;
	
	public AIShoggothBuild(EntityShoggoth shoggoth) {
		this.shoggoth = shoggoth;
		this.setMutexBits(1);
	}
	
	@Override
	public boolean shouldExecute() {
		return shoggoth.map != null;
	}

	@Override
	public boolean shouldContinueExecuting() {
		if(shoggoth.building == null || shoggoth.map == null) return false;
		return shoggoth.progress < shoggoth.map.getInteger("num") && !(shoggoth.building.isDone() && shoggoth.map.hasKey(String.format("b%d", shoggoth.progress)));
	}
	
	@Override
	public void updateTask() {
		int progress = shoggoth.progress;
		if(progress < shoggoth.map.getInteger("num")) {
			if(shoggoth.building == null) {
				shoggoth.progress = 0;
				progress = 0;
				shoggoth.building = ShoggothBuilding.getBuilding(shoggoth.world, shoggoth.map.getCompoundTag(String.format("b%d", progress)));
			}
			int rotation = shoggoth.building.rotation + (shoggoth.building instanceof ShoggothLongBuilding ? 3 : 2);
			BlockPos pos = new BlockPos(shoggoth.building.centerX, shoggoth.building.centerY, shoggoth.building.centerZ).offset(EnumFacing.getHorizontal(rotation), 5 + shoggoth.building.building.height/2);
			int y = shoggoth.world.getHeight(pos.getX(), pos.getZ());
			pos = new BlockPos(pos.getX(),y, pos.getZ());
			if(timer > -1) timer--;
			
			if(Math.abs(shoggoth.posX - pos.getX()) < 5 && Math.abs(shoggoth.posZ - pos.getZ()) < 5) {
				shoggoth.building.placeBlock(shoggoth.world);
			} else if(timer < 0) {
				timer = 10;
				shoggoth.getNavigator().setPath(shoggoth.getNavigator().getPathToPos(pos), 1.5);
			}
			if(shoggoth.building.isDone()) {
				shoggoth.progress++;
				if(shoggoth.map.hasKey(String.format("b%d", shoggoth.progress))) {
					shoggoth.building = ShoggothBuilding.getBuilding(shoggoth.world, shoggoth.map.getCompoundTag(String.format("b%d", shoggoth.progress)));
				} else {
					shoggoth.map = null;
					shoggoth.progress = -1;
				}
			}
		}
	}

}
