package com.valeriotor.BTV.crafting;

import java.util.HashMap;

import com.valeriotor.BTV.BeyondTheVeil;
import com.valeriotor.BTV.research.ResearchUtil;
import com.valeriotor.BTV.tileEntities.TileGearBench;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GearBenchRecipe {
	
	public static GearBenchRecipe getRecipe(String file) {
		GearBenchRecipeTemp temp = BeyondTheVeil.gson.fromJson(file, GearBenchRecipeTemp.class);
		GearBenchRecipe gbr = new GearBenchRecipe();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				String s = temp.rows[i].substring(j, j+1);
				String stackName = s.equals(" ") ? "nullstack" : temp.map.get(s);
				gbr.grid[4*i+j] = getStackFromString(stackName);
			}
		}
		gbr.output = getStackFromString(temp.output);
		gbr.outputName = temp.output;
		if(temp.req != null) {
			String[] ss = temp.req.split(";");
			gbr.requiredResearch = ss[0];
			if(ss.length > 1)
				gbr.requiredResearchStage = Integer.parseInt(ss[1]);
		}
		return gbr;
	}
	
	private static ItemStack getStackFromString(String stackName) {
		if(stackName.equals("nullstack")) return ItemStack.EMPTY;
		String[] ss = stackName.split(";");
		Item item = Item.REGISTRY.getObject(new ResourceLocation(ss[0]));
		int amount = 1, meta = 0;
		if(ss.length > 1) {
			amount = Integer.parseInt(ss[1]);
			if(ss.length > 2)
				amount = Integer.parseInt(ss[2]);
		}
		return new ItemStack(item, amount, meta);
	}
	
	private ItemStack[] grid = new ItemStack[16];
	private ItemStack output;
	private String outputName;
	private String requiredResearch;
	private int requiredResearchStage = 0;
	
	public ItemStack getStackInRowColumn(int row, int column) {
		return getStackInSlot(row*4+column).copy();
	}
	
	public ItemStack getStackInSlot(int index) {
		return grid[index].copy();
	}
	
	public ItemStack getOutput() {
		return this.output.copy();
	}
	
	public String getOutputName() {
		return this.outputName;
	}
	
	public boolean checksOut(TileGearBench gb) {
		for(int i = 0; i < 16; i++) {
			ItemStack stack = grid[i];
			ItemStack gbstack = gb.getStackInSlot(i);
			if(gbstack == null || stack.getItem() != gbstack.getItem() || stack.getMetadata() != gbstack.getMetadata()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isKnown(EntityPlayer p) {
		if(requiredResearch == null)
			return true;
		if(ResearchUtil.getResearchStage(p, requiredResearch) >= requiredResearchStage)
			return true;
		return false;
	}
	
	private static class GearBenchRecipeTemp {
		private String[] rows;
		private String output;
		private HashMap<String, String> map;
		private String req;
	}
}
