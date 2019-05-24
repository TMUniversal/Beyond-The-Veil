package com.valeriotor.BTV.entities;

import com.valeriotor.BTV.items.ItemRegistry;
import com.valeriotor.BTV.util.ItemHelper;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCrawlingVillager extends EntityCreature{
	
	private boolean unconscious = false; // "unconscious" is synonym of "blackjack" and opposite of "spineless"
	private int ticksToFall = 0;
	private int ticksToRecovery = 200;
	public static final int DEFAULTTICKS = 12;
	private static final DataParameter<Integer> TICKSTOFALL = EntityDataManager.<Integer>createKey(EntityCrawlingVillager.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> PROFESSION = EntityDataManager.<Integer>createKey(EntityVillager.class, DataSerializers.VARINT);
    
	public EntityCrawlingVillager(World w) {
		this(w, false);
	}
	
	
	public EntityCrawlingVillager(World worldIn, boolean blackjack) {
		super(worldIn);
		this.unconscious = blackjack;
		this.ticksToFall = blackjack ? DEFAULTTICKS : 0;
		this.dataManager.set(TICKSTOFALL, this.ticksToFall);
	}
	
	@Override
	public void onAddedToWorld() {
		if(this.world.isRemote) this.ticksToFall = this.dataManager.get(TICKSTOFALL);
		super.onAddedToWorld();
	}
	
	@Override
	protected void entityInit() {
		this.dataManager.register(TICKSTOFALL, Integer.valueOf(0));
		this.dataManager.register(PROFESSION, Integer.valueOf(0));
		super.entityInit();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);		
	}
	
	@Override
	protected void initEntityAI() {
		if(!this.unconscious) {
			this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));		
			this.tasks.addTask(8, new EntityAILookIdle(this));
			this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		}
		super.initEntityAI();
	}
	
	@Override
	public boolean isAIDisabled() {
		return super.isAIDisabled() || this.unconscious;
	}
	
	@Override
	public void onEntityUpdate() {
		if(this.world.isRemote && this.ticksToFall > 0) {
			this.ticksToFall--;
		}
		if(!this.world.isRemote && this.unconscious) {
			if(this.ticksToRecovery > 0) this.ticksToRecovery--;
			else {
				EntityVillager vil = new EntityVillager(this.world, this.getProfessionID());
				BlockPos p = this.getPosition();
				vil.setPosition(p.getX(), p.getY(), p.getZ());
				this.world.spawnEntity(vil);
				this.world.removeEntity(this);
			}
		}
		super.onEntityUpdate();
	}
	
	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, EnumHand hand) {
		if(player.isSneaking() && player.getHeldItem(hand).getItem() == Items.AIR) {
			if(!this.world.isRemote) {
				ItemStack item = new ItemStack(ItemRegistry.held_villager);
				ItemHelper.checkTagCompound(item).setBoolean("spineless", !this.unconscious);
				player.addItemStackToInventory(item);
				this.world.removeEntity(this);
			}
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
	}
	
	@SideOnly(Side.CLIENT)
	public int getTicksToFall() {
		return this.ticksToFall;
	}
	
	public void setTicksToFall(int ticks) {
		this.ticksToFall = ticks;
		this.dataManager.set(TICKSTOFALL, this.ticksToFall);
	}
	
	public void setProfession(int id) {
		this.dataManager.set(PROFESSION, Integer.valueOf(id));
	}
	
	public net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession getProfession(){
		return net.minecraftforge.fml.common.registry.VillagerRegistry.getById(this.dataManager.get(PROFESSION));
	}
	
	public int getProfessionID() {
		return this.dataManager.get(PROFESSION);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("profession", this.dataManager.get(PROFESSION));
		compound.setInteger("ticksToRecovery", this.ticksToRecovery);
		compound.setBoolean("unconscious", this.unconscious);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.setProfession(compound.getInteger("profession"));
		this.ticksToRecovery = compound.getInteger("ticksToRecovery");
		this.unconscious = compound.getBoolean("unconscious");
		super.readFromNBT(compound);
	}
	
	
	

}