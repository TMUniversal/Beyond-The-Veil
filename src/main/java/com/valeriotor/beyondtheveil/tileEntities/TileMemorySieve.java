package com.valeriotor.beyondtheveil.tileEntities;

import javax.annotation.Nullable;

import com.valeriotor.beyondtheveil.dreaming.Memory;
import com.valeriotor.beyondtheveil.items.IArtifactItem;
import com.valeriotor.beyondtheveil.items.ItemRegistry;
import com.valeriotor.beyondtheveil.util.ItemHelper;
import com.valeriotor.beyondtheveil.util.SyncUtil;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;

public class TileMemorySieve extends TileEntity implements ITickable{
	
	private ItemStack heldItem = new ItemStack(Items.AIR);
	private EntityItem itemEntity;
	
	public TileMemorySieve() {
	}
	
	public void addItem(ItemStack stack) {
		if(this.heldItem.getItem() == Items.AIR && stack.getItem() != ItemRegistry.memory_phial) {
			this.heldItem = stack.copy();
			stack.shrink(1);
			this.heldItem.setCount(1);
			itemEntity = new EntityItem(this.world, pos.getX(), pos.getY(), pos.getZ(), heldItem);
			if(!this.world.isRemote) {
				markDirty();
				this.sendUpdates(world);
			}
		}
	}
	
	public ItemStack getItem(EntityPlayer p, ItemStack in) {
		if(in.getItem() != ItemRegistry.memory_phial) {
			ItemStack stack = this.heldItem;
			this.heldItem = new ItemStack(Items.AIR);
			itemEntity = null;
			if(!this.world.isRemote) {
				if(stack.getItem() instanceof IArtifactItem) {
					((IArtifactItem)stack.getItem()).unlockData(p);
				}
				markDirty();
				this.sendUpdates(world);
			}
			return stack;
		}
		if(this.heldItem.getItem() != Items.AIR) {
			for(Memory m : Memory.values()) {
				ItemStack memStack = m.getItem();
				if(heldItem.getItem() == memStack.getItem() && m.isUnlocked(p)) {
					if(!memStack.getHasSubtypes() || heldItem.getMetadata() == memStack.getMetadata()) {
						ItemStack newStack = new ItemStack(ItemRegistry.memory_phial);
						ItemHelper.checkTagCompound(newStack).setString("memory", m.getDataName());
						in.shrink(1);
						ItemHandlerHelper.giveItemToPlayer(p, newStack);
						this.heldItem = ItemStack.EMPTY;
						itemEntity = null;
						if(!this.world.isRemote) {
							markDirty();
							this.sendUpdates(world);
							if(m == Memory.LEARNING)
								SyncUtil.addStringDataOnServer(p, false, "firstMemory");
						}
						return ItemStack.EMPTY;
					}
				}
			}
		}			
		return ItemStack.EMPTY;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		if(compound.hasKey("held_item")) {
			this.heldItem = new ItemStack(compound.getCompoundTag("held_item"));
			itemEntity = new EntityItem(this.world, pos.getX(), pos.getY(), pos.getZ(), heldItem);
		} else
			itemEntity = null;
		super.readFromNBT(compound);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		if(this.heldItem.getItem() != Items.AIR){
			NBTTagCompound nbt = new NBTTagCompound();
			this.heldItem.writeToNBT(nbt);
			compound.setTag("held_item", nbt);
		}
		return super.writeToNBT(compound);
	}
	
	@SideOnly(Side.CLIENT)
	public EntityItem getItemEntity() {
		return this.itemEntity;
	}
	
	@Nullable
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		handleUpdateTag(pkt.getNbtCompound());
	}
	
	private void sendUpdates(World worldObj) {
		world.markBlockRangeForRenderUpdate(pos, pos);
		world.notifyBlockUpdate(pos, getState(), getState(), 3);
		world.scheduleBlockUpdate(pos,this.getBlockType(),0,0);
	}
	
	public IBlockState getState() {
		return world.getBlockState(pos);
	}

	@Override
	public void update() {
		if(world.isRemote)
			if(itemEntity != null)
				itemEntity.onUpdate();
	}
	
}
