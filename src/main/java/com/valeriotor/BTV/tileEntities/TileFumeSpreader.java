package com.valeriotor.BTV.tileEntities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;

public class TileFumeSpreader extends TileEntity{
	private Aspect chosenAspect;
	public TileFumeSpreader() {
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		if(chosenAspect != null) compound.setString("containing", this.chosenAspect.getName());
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.chosenAspect = thaumcraft.api.aspects.Aspect.getAspect(compound.getString("containing").toLowerCase());
		super.readFromNBT(compound); 
	}
	
	public Aspect setAspect(Aspect aspect) {
		this.chosenAspect = aspect;
		markDirty();
		return this.chosenAspect;
	}
	
	
	
	
}
