package com.valeriotor.BTV.shoggoth.buildings;

import java.util.HashMap;

import com.valeriotor.BTV.blocks.BlockRegistry;
import com.valeriotor.BTV.gui.GuiCityMapper;
import com.valeriotor.BTV.shoggoth.BlockBuffer;
import com.valeriotor.BTV.shoggoth.BuildingTemplate;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class BuildingTallTower extends BuildingTemplate{

	public BuildingTallTower(String name, int index) {
		super(10, 10, false, name, index);
		HashMap<Block, byte[][]> map = new HashMap<>();
		map.put(Blocks.AIR, this.air);
		map.put(BlockRegistry.BlockElderBrick, this.elder_bricks);
		map.put(BlockRegistry.BlockStoneElderBrickChiseled, this.elder_bricks_chiseled);
		map.put(BlockRegistry.BlockStoneElderBrickStairs, this.elder_stone_brick_stairs);
		map.put(BlockRegistry.BlockStoneElderBrick, elder_stone_bricks);
		this.buffer = new BlockBuffer(map, 10, 26, 10);
	}

	@Override
	public void drawScaledTexture(GuiCityMapper gui, int xTopLeft, int yTopLeft, float scale, int width, int height) {
		this.drawHelper(gui, xTopLeft, yTopLeft, 96, 0, scale);
	}

	@Override
	public boolean isDefault() {
		return true;
	}
	
	byte[][] air = { 

	{-5, 0, -4, 0}, {-5, 0, 3, 0}, {-5, 0, 4, 0}, {-5, 1, -5, 0}, {-5, 1, -4, 0}, {-5, 1, 3, 0}, {-5, 1, 4, 0}, {-5, 2, -5, 0}, {-5, 2, -4, 0}, {-5, 2, 3, 0}, 
	{-5, 2, 4, 0}, {-5, 3, -5, 0}, {-5, 3, -4, 0}, {-5, 3, 3, 0}, {-5, 3, 4, 0}, {-4, 0, -5, 0}, {-4, 0, 4, 0}, {-4, 1, -5, 0}, {-4, 1, -3, 0}, {-4, 1, -2, 0}, 
	{-4, 1, -1, 0}, {-4, 1, 0, 0}, {-4, 1, 1, 0}, {-4, 1, 2, 0}, {-4, 1, 4, 0}, {-4, 2, -5, 0}, {-4, 2, -3, 0}, {-4, 2, -2, 0}, {-4, 2, -1, 0}, {-4, 2, 0, 0}, 
	{-4, 2, 1, 0}, {-4, 2, 2, 0}, {-4, 2, 4, 0}, {-4, 3, -5, 0}, {-4, 3, -3, 0}, {-4, 3, -2, 0}, {-4, 3, -1, 0}, {-4, 3, 0, 0}, {-4, 3, 1, 0}, {-4, 3, 2, 0}, 
	{-4, 3, 4, 0}, {-3, 1, -4, 0}, {-3, 1, -3, 0}, {-3, 1, -2, 0}, {-3, 1, -1, 0}, {-3, 1, 0, 0}, {-3, 1, 1, 0}, {-3, 1, 2, 0}, {-3, 1, 3, 0}, {-3, 2, -4, 0}, 
	{-3, 2, -3, 0}, {-3, 2, -2, 0}, {-3, 2, -1, 0}, {-3, 2, 0, 0}, {-3, 2, 1, 0}, {-3, 2, 2, 0}, {-3, 2, 3, 0}, {-3, 3, -4, 0}, {-3, 3, -3, 0}, {-3, 3, -2, 0}, 
	{-3, 3, -1, 0}, {-3, 3, 0, 0}, {-3, 3, 1, 0}, {-3, 3, 2, 0}, {-3, 3, 3, 0}, {-2, 1, -4, 0}, {-2, 1, -3, 0}, {-2, 1, -2, 0}, {-2, 1, -1, 0}, {-2, 1, 0, 0}, 
	{-2, 1, 1, 0}, {-2, 2, -4, 0}, {-2, 2, -3, 0}, {-2, 2, -2, 0}, {-2, 2, -1, 0}, {-2, 2, 0, 0}, {-2, 2, 1, 0}, {-2, 2, 2, 0}, {-2, 2, 3, 0}, {-2, 3, -4, 0}, 
	{-2, 3, -3, 0}, {-2, 3, -2, 0}, {-2, 3, -1, 0}, {-2, 3, 0, 0}, {-2, 3, 1, 0}, {-2, 3, 2, 0}, {-2, 3, 3, 0}, {-1, 1, -5, 0}, {-1, 1, -4, 0}, {-1, 1, -3, 0}, 
	{-1, 1, -2, 0}, {-1, 1, -1, 0}, {-1, 1, 0, 0}, {-1, 1, 1, 0}, {-1, 1, 2, 0}, {-1, 1, 3, 0}, {-1, 2, -5, 0}, {-1, 2, -4, 0}, {-1, 2, -3, 0}, {-1, 2, -2, 0}, 
	{-1, 2, -1, 0}, {-1, 2, 0, 0}, {-1, 2, 1, 0}, {-1, 2, 2, 0}, {-1, 3, -4, 0}, {-1, 3, -3, 0}, {-1, 3, -2, 0}, {-1, 3, -1, 0}, {-1, 3, 0, 0}, {-1, 3, 1, 0}, 
	{-1, 3, 2, 0}, {-1, 3, 3, 0}, {0, 1, -5, 0}, {0, 1, -4, 0}, {0, 1, -3, 0}, {0, 1, -2, 0}, {0, 1, -1, 0}, {0, 1, 0, 0}, {0, 1, 1, 0}, {0, 1, 2, 0}, 
	{0, 1, 3, 0}, {0, 2, -5, 0}, {0, 2, -4, 0}, {0, 2, -3, 0}, {0, 2, -2, 0}, {0, 2, -1, 0}, {0, 2, 0, 0}, {0, 2, 1, 0}, {0, 2, 2, 0}, {0, 2, 3, 0}, 
	{0, 3, -4, 0}, {0, 3, -3, 0}, {0, 3, -2, 0}, {0, 3, -1, 0}, {0, 3, 0, 0}, {0, 3, 1, 0}, {0, 3, 2, 0}, {1, 1, -4, 0}, {1, 1, -3, 0}, {1, 1, -2, 0}, 
	{1, 1, -1, 0}, {1, 1, 0, 0}, {1, 1, 1, 0}, {1, 1, 2, 0}, {1, 1, 3, 0}, {1, 2, -4, 0}, {1, 2, -3, 0}, {1, 2, -2, 0}, {1, 2, -1, 0}, {1, 2, 0, 0}, 
	{1, 2, 1, 0}, {1, 2, 2, 0}, {1, 2, 3, 0}, {1, 3, -4, 0}, {1, 3, -3, 0}, {1, 3, -2, 0}, {1, 3, -1, 0}, {1, 3, 0, 0}, {1, 3, 1, 0}, {1, 3, 2, 0}, 
	{2, 1, -4, 0}, {2, 1, -3, 0}, {2, 1, -2, 0}, {2, 1, -1, 0}, {2, 1, 0, 0}, {2, 1, 1, 0}, {2, 1, 2, 0}, {2, 1, 3, 0}, {2, 2, -4, 0}, {2, 2, -3, 0}, 
	{2, 2, -2, 0}, {2, 2, -1, 0}, {2, 2, 0, 0}, {2, 2, 1, 0}, {2, 2, 2, 0}, {2, 2, 3, 0}, {2, 3, -4, 0}, {2, 3, -3, 0}, {2, 3, -2, 0}, {2, 3, -1, 0}, 
	{2, 3, 0, 0}, {2, 3, 1, 0}, {2, 3, 2, 0}, {2, 3, 3, 0}, {3, 0, -5, 0}, {3, 0, 4, 0}, {3, 1, -5, 0}, {3, 1, -3, 0}, {3, 1, -2, 0}, {3, 1, -1, 0}, 
	{3, 1, 0, 0}, {3, 1, 1, 0}, {3, 1, 2, 0}, {3, 1, 4, 0}, {3, 2, -5, 0}, {3, 2, -3, 0}, {3, 2, -2, 0}, {3, 2, -1, 0}, {3, 2, 0, 0}, {3, 2, 1, 0}, 
	{3, 2, 2, 0}, {3, 2, 4, 0}, {3, 3, -5, 0}, {3, 3, -3, 0}, {3, 3, -2, 0}, {3, 3, -1, 0}, {3, 3, 0, 0}, {3, 3, 1, 0}, {3, 3, 2, 0}, {3, 3, 4, 0}, 
	{4, 0, -5, 0}, {4, 0, -4, 0}, {4, 0, 3, 0}, {4, 0, 4, 0}, {4, 1, -5, 0}, {4, 1, -4, 0}, {4, 1, 3, 0}, {4, 1, 4, 0}, {4, 2, -5, 0}, {4, 2, -4, 0}, 
	{4, 2, 3, 0}, {4, 2, 4, 0}, {4, 3, -5, 0}, {4, 3, -4, 0}, {4, 3, 3, 0}, {4, 3, 4, 0}, 

	}; 
	 
	byte[][] elder_bricks = { 

	{-5, 0, -3, 0}, {-5, 0, -2, 0}, {-5, 0, -1, 0}, {-5, 0, 0, 0}, {-5, 0, 1, 0}, {-5, 0, 2, 0}, {-5, 1, -3, 0}, {-5, 1, -2, 0}, {-5, 1, -1, 0}, {-5, 1, 0, 0}, 
	{-5, 1, 1, 0}, {-5, 1, 2, 0}, {-5, 2, -3, 0}, {-5, 2, -2, 0}, {-5, 2, -1, 0}, {-5, 2, 0, 0}, {-5, 2, 1, 0}, {-5, 2, 2, 0}, {-5, 6, -3, 0}, {-5, 6, -2, 0}, 
	{-5, 6, -1, 0}, {-5, 6, 0, 0}, {-5, 6, 1, 0}, {-5, 6, 2, 0}, {-5, 10, -3, 0}, {-5, 10, -2, 0}, {-5, 10, -1, 0}, {-5, 10, 0, 0}, {-5, 10, 1, 0}, {-5, 10, 2, 0}, 
	{-5, 14, -3, 0}, {-5, 14, -2, 0}, {-5, 14, -1, 0}, {-5, 14, 0, 0}, {-5, 14, 1, 0}, {-5, 14, 2, 0}, {-5, 18, -3, 0}, {-5, 18, -2, 0}, {-5, 18, -1, 0}, {-5, 18, 0, 0}, 
	{-5, 18, 1, 0}, {-5, 18, 2, 0}, {-5, 22, -3, 0}, {-5, 22, -2, 0}, {-5, 22, -1, 0}, {-5, 22, 0, 0}, {-5, 22, 1, 0}, {-5, 22, 2, 0}, {-4, 0, -4, 0}, {-4, 0, -3, 0}, 
	{-4, 0, -2, 0}, {-4, 0, -1, 0}, {-4, 0, 0, 0}, {-4, 0, 1, 0}, {-4, 0, 2, 0}, {-4, 0, 3, 0}, {-4, 1, -4, 0}, {-4, 1, 3, 0}, {-4, 2, -4, 0}, {-4, 2, 3, 0}, 
	{-4, 6, -4, 0}, {-4, 6, -3, 0}, {-4, 6, 2, 0}, {-4, 6, 3, 0}, {-4, 10, -4, 0}, {-4, 10, -3, 0}, {-4, 10, 2, 0}, {-4, 10, 3, 0}, {-4, 14, -4, 0}, {-4, 14, -3, 0}, 
	{-4, 14, 2, 0}, {-4, 14, 3, 0}, {-4, 18, -4, 0}, {-4, 18, -3, 0}, {-4, 18, 2, 0}, {-4, 18, 3, 0}, {-4, 22, -4, 0}, {-4, 22, -3, 0}, {-4, 22, 2, 0}, {-4, 22, 3, 0}, 
	{-3, 0, -5, 0}, {-3, 0, -4, 0}, {-3, 0, -3, 0}, {-3, 0, -2, 0}, {-3, 0, -1, 0}, {-3, 0, 0, 0}, {-3, 0, 1, 0}, {-3, 0, 2, 0}, {-3, 0, 3, 0}, {-3, 0, 4, 0}, 
	{-3, 1, -5, 0}, {-3, 1, 4, 0}, {-3, 2, -5, 0}, {-3, 2, 4, 0}, {-3, 6, -5, 0}, {-3, 6, -4, 0}, {-3, 6, 3, 0}, {-3, 6, 4, 0}, {-3, 10, -5, 0}, {-3, 10, -4, 0}, 
	{-3, 10, 3, 0}, {-3, 10, 4, 0}, {-3, 14, -5, 0}, {-3, 14, -4, 0}, {-3, 14, 3, 0}, {-3, 14, 4, 0}, {-3, 18, -5, 0}, {-3, 18, -4, 0}, {-3, 18, 3, 0}, {-3, 18, 4, 0}, 
	{-3, 22, -5, 0}, {-3, 22, -4, 0}, {-3, 22, 3, 0}, {-3, 22, 4, 0}, {-2, 0, -5, 0}, {-2, 0, -4, 0}, {-2, 0, -3, 0}, {-2, 0, -2, 0}, {-2, 0, -1, 0}, {-2, 0, 0, 0}, 
	{-2, 0, 1, 0}, {-2, 0, 2, 0}, {-2, 0, 3, 0}, {-2, 0, 4, 0}, {-2, 1, -5, 0}, {-2, 1, 4, 0}, {-2, 2, -5, 0}, {-2, 2, 4, 0}, {-2, 6, -5, 0}, {-2, 6, 4, 0}, 
	{-2, 10, -5, 0}, {-2, 10, 4, 0}, {-2, 14, -5, 0}, {-2, 14, 4, 0}, {-2, 18, -5, 0}, {-2, 18, 4, 0}, {-2, 22, -5, 0}, {-2, 22, 4, 0}, {-1, 0, -4, 0}, {-1, 0, -3, 0}, 
	{-1, 0, -2, 0}, {-1, 0, -1, 0}, {-1, 0, 0, 0}, {-1, 0, 1, 0}, {-1, 0, 2, 0}, {-1, 0, 3, 0}, {-1, 0, 4, 0}, {-1, 1, 4, 0}, {-1, 2, 4, 0}, {-1, 6, -5, 0}, 
	{-1, 6, 4, 0}, {-1, 10, -5, 0}, {-1, 10, 4, 0}, {-1, 14, -5, 0}, {-1, 14, 4, 0}, {-1, 18, -5, 0}, {-1, 18, 4, 0}, {-1, 22, -5, 0}, {-1, 22, 4, 0}, {0, 0, -4, 0}, 
	{0, 0, -3, 0}, {0, 0, -2, 0}, {0, 0, -1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 2, 0}, {0, 0, 3, 0}, {0, 0, 4, 0}, {0, 1, 4, 0}, {0, 2, 4, 0}, 
	{0, 6, -5, 0}, {0, 6, 4, 0}, {0, 10, -5, 0}, {0, 10, 4, 0}, {0, 14, -5, 0}, {0, 14, 4, 0}, {0, 18, -5, 0}, {0, 18, 4, 0}, {0, 22, -5, 0}, {0, 22, 4, 0}, 
	{1, 0, -5, 0}, {1, 0, -4, 0}, {1, 0, -3, 0}, {1, 0, -2, 0}, {1, 0, -1, 0}, {1, 0, 0, 0}, {1, 0, 1, 0}, {1, 0, 2, 0}, {1, 0, 3, 0}, {1, 0, 4, 0}, 
	{1, 1, -5, 0}, {1, 1, 4, 0}, {1, 2, -5, 0}, {1, 2, 4, 0}, {1, 6, -5, 0}, {1, 6, 4, 0}, {1, 10, -5, 0}, {1, 10, 4, 0}, {1, 14, -5, 0}, {1, 14, 4, 0}, 
	{1, 18, -5, 0}, {1, 18, 4, 0}, {1, 22, -5, 0}, {1, 22, 4, 0}, {2, 0, -5, 0}, {2, 0, -4, 0}, {2, 0, -3, 0}, {2, 0, -2, 0}, {2, 0, -1, 0}, {2, 0, 0, 0}, 
	{2, 0, 1, 0}, {2, 0, 2, 0}, {2, 0, 3, 0}, {2, 0, 4, 0}, {2, 1, -5, 0}, {2, 1, 4, 0}, {2, 2, -5, 0}, {2, 2, 4, 0}, {2, 6, -5, 0}, {2, 6, -4, 0}, 
	{2, 6, 3, 0}, {2, 6, 4, 0}, {2, 10, -5, 0}, {2, 10, -4, 0}, {2, 10, 3, 0}, {2, 10, 4, 0}, {2, 14, -5, 0}, {2, 14, -4, 0}, {2, 14, 3, 0}, {2, 14, 4, 0}, 
	{2, 18, -5, 0}, {2, 18, -4, 0}, {2, 18, 3, 0}, {2, 18, 4, 0}, {2, 22, -5, 0}, {2, 22, -4, 0}, {2, 22, 3, 0}, {2, 22, 4, 0}, {3, 0, -4, 0}, {3, 0, -3, 0}, 
	{3, 0, -2, 0}, {3, 0, -1, 0}, {3, 0, 0, 0}, {3, 0, 1, 0}, {3, 0, 2, 0}, {3, 0, 3, 0}, {3, 1, -4, 0}, {3, 1, 3, 0}, {3, 2, -4, 0}, {3, 2, 3, 0}, 
	{3, 6, -4, 0}, {3, 6, -3, 0}, {3, 6, 2, 0}, {3, 6, 3, 0}, {3, 10, -4, 0}, {3, 10, -3, 0}, {3, 10, 2, 0}, {3, 10, 3, 0}, {3, 14, -4, 0}, {3, 14, -3, 0}, 
	{3, 14, 2, 0}, {3, 14, 3, 0}, {3, 18, -4, 0}, {3, 18, -3, 0}, {3, 18, 2, 0}, {3, 18, 3, 0}, {3, 22, -4, 0}, {3, 22, -3, 0}, {3, 22, 2, 0}, {3, 22, 3, 0}, 
	{4, 0, -3, 0}, {4, 0, -2, 0}, {4, 0, -1, 0}, {4, 0, 0, 0}, {4, 0, 1, 0}, {4, 0, 2, 0}, {4, 1, -3, 0}, {4, 1, -2, 0}, {4, 1, -1, 0}, {4, 1, 0, 0}, 
	{4, 1, 1, 0}, {4, 1, 2, 0}, {4, 2, -3, 0}, {4, 2, -2, 0}, {4, 2, -1, 0}, {4, 2, 0, 0}, {4, 2, 1, 0}, {4, 2, 2, 0}, {4, 6, -3, 0}, {4, 6, -2, 0}, 
	{4, 6, -1, 0}, {4, 6, 0, 0}, {4, 6, 1, 0}, {4, 6, 2, 0}, {4, 10, -3, 0}, {4, 10, -2, 0}, {4, 10, -1, 0}, {4, 10, 0, 0}, {4, 10, 1, 0}, {4, 10, 2, 0}, 
	{4, 14, -3, 0}, {4, 14, -2, 0}, {4, 14, -1, 0}, {4, 14, 0, 0}, {4, 14, 1, 0}, {4, 14, 2, 0}, {4, 18, -3, 0}, {4, 18, -2, 0}, {4, 18, -1, 0}, {4, 18, 0, 0}, 
	{4, 18, 1, 0}, {4, 18, 2, 0}, {4, 22, -3, 0}, {4, 22, -2, 0}, {4, 22, -1, 0}, {4, 22, 0, 0}, {4, 22, 1, 0}, {4, 22, 2, 0}, 

	}; 
	 
	byte[][] elder_stone_bricks = { 

	{-5, 3, -3, 0}, {-5, 3, -2, 0}, {-5, 3, -1, 0}, {-5, 3, 0, 0}, {-5, 3, 1, 0}, {-5, 3, 2, 0}, {-5, 7, -3, 0}, {-5, 7, -2, 0}, {-5, 7, 1, 0}, {-5, 7, 2, 0}, 
	{-5, 11, -3, 0}, {-5, 11, -2, 0}, {-5, 11, 1, 0}, {-5, 11, 2, 0}, {-5, 15, -3, 0}, {-5, 15, -2, 0}, {-5, 15, 1, 0}, {-5, 15, 2, 0}, {-5, 19, -3, 0}, {-5, 19, -2, 0}, 
	{-5, 19, 1, 0}, {-5, 19, 2, 0}, {-5, 23, -3, 0}, {-5, 23, -2, 0}, {-5, 23, 1, 0}, {-5, 23, 2, 0}, {-4, 3, -4, 0}, {-4, 3, 3, 0}, {-4, 4, -2, 0}, {-4, 4, -1, 0}, 
	{-4, 4, 0, 0}, {-4, 4, 1, 0}, {-4, 7, -4, 0}, {-4, 7, -3, 0}, {-4, 7, 2, 0}, {-4, 7, 3, 0}, {-4, 8, -2, 0}, {-4, 8, -1, 0}, {-4, 8, 0, 0}, {-4, 8, 1, 0}, 
	{-4, 11, -4, 0}, {-4, 11, -3, 0}, {-4, 11, 2, 0}, {-4, 11, 3, 0}, {-4, 12, -2, 0}, {-4, 12, -1, 0}, {-4, 12, 0, 0}, {-4, 12, 1, 0}, {-4, 15, -4, 0}, {-4, 15, -3, 0}, 
	{-4, 15, 2, 0}, {-4, 15, 3, 0}, {-4, 16, -2, 0}, {-4, 16, -1, 0}, {-4, 16, 0, 0}, {-4, 16, 1, 0}, {-4, 19, -4, 0}, {-4, 19, -3, 0}, {-4, 19, 2, 0}, {-4, 19, 3, 0}, 
	{-4, 20, -2, 0}, {-4, 20, -1, 0}, {-4, 20, 0, 0}, {-4, 20, 1, 0}, {-4, 23, -4, 0}, {-4, 23, -3, 0}, {-4, 23, 2, 0}, {-4, 23, 3, 0}, {-4, 24, -2, 0}, {-4, 24, -1, 0}, 
	{-4, 24, 0, 0}, {-4, 24, 1, 0}, {-3, 3, -5, 0}, {-3, 3, 4, 0}, {-3, 4, -3, 0}, {-3, 4, -2, 0}, {-3, 4, -1, 0}, {-3, 4, 0, 0}, {-3, 4, 1, 0}, {-3, 4, 2, 0}, 
	{-3, 7, -5, 0}, {-3, 7, -4, 0}, {-3, 7, 3, 0}, {-3, 7, 4, 0}, {-3, 8, -3, 0}, {-3, 8, -2, 0}, {-3, 8, -1, 0}, {-3, 8, 0, 0}, {-3, 8, 1, 0}, {-3, 8, 2, 0}, 
	{-3, 11, -5, 0}, {-3, 11, -4, 0}, {-3, 11, 3, 0}, {-3, 11, 4, 0}, {-3, 12, -3, 0}, {-3, 12, -2, 0}, {-3, 12, -1, 0}, {-3, 12, 0, 0}, {-3, 12, 1, 0}, {-3, 12, 2, 0}, 
	{-3, 15, -5, 0}, {-3, 15, -4, 0}, {-3, 15, 3, 0}, {-3, 15, 4, 0}, {-3, 16, -3, 0}, {-3, 16, -2, 0}, {-3, 16, -1, 0}, {-3, 16, 0, 0}, {-3, 16, 1, 0}, {-3, 16, 2, 0}, 
	{-3, 19, -5, 0}, {-3, 19, -4, 0}, {-3, 19, 3, 0}, {-3, 19, 4, 0}, {-3, 20, -3, 0}, {-3, 20, -2, 0}, {-3, 20, -1, 0}, {-3, 20, 0, 0}, {-3, 20, 1, 0}, {-3, 20, 2, 0}, 
	{-3, 23, -5, 0}, {-3, 23, -4, 0}, {-3, 23, 3, 0}, {-3, 23, 4, 0}, {-3, 24, -3, 0}, {-3, 24, -2, 0}, {-3, 24, -1, 0}, {-3, 24, 0, 0}, {-3, 24, 1, 0}, {-3, 24, 2, 0}, 
	{-2, 1, 3, 0}, {-2, 3, -5, 0}, {-2, 3, 4, 0}, {-2, 4, -4, 0}, {-2, 4, -3, 0}, {-2, 4, -2, 0}, {-2, 4, -1, 0}, {-2, 4, 0, 0}, {-2, 4, 1, 0}, {-2, 4, 2, 0}, 
	{-2, 5, 3, 0}, {-2, 7, 4, 0}, {-2, 8, -4, 0}, {-2, 8, -3, 0}, {-2, 8, -2, 0}, {-2, 8, -1, 0}, {-2, 8, 0, 0}, {-2, 8, 1, 0}, {-2, 8, 2, 0}, {-2, 9, 3, 0}, 
	{-2, 11, 4, 0}, {-2, 12, -4, 0}, {-2, 12, -3, 0}, {-2, 12, -2, 0}, {-2, 12, -1, 0}, {-2, 12, 0, 0}, {-2, 12, 1, 0}, {-2, 12, 2, 0}, {-2, 13, 3, 0}, {-2, 15, 4, 0}, 
	{-2, 16, -4, 0}, {-2, 16, -3, 0}, {-2, 16, -2, 0}, {-2, 16, -1, 0}, {-2, 16, 0, 0}, {-2, 16, 1, 0}, {-2, 16, 2, 0}, {-2, 17, 3, 0}, {-2, 19, 4, 0}, {-2, 20, -4, 0}, 
	{-2, 20, -3, 0}, {-2, 20, -2, 0}, {-2, 20, -1, 0}, {-2, 20, 0, 0}, {-2, 20, 1, 0}, {-2, 20, 2, 0}, {-2, 21, 3, 0}, {-2, 23, 4, 0}, {-2, 24, -4, 0}, {-2, 24, -3, 0}, 
	{-2, 24, -2, 0}, {-2, 24, -1, 0}, {-2, 24, 0, 0}, {-2, 24, 1, 0}, {-2, 24, 2, 0}, {-1, 3, -5, 0}, {-1, 3, 4, 0}, {-1, 4, -4, 0}, {-1, 4, -3, 0}, {-1, 4, -2, 0}, 
	{-1, 4, -1, 0}, {-1, 4, 0, 0}, {-1, 4, 1, 0}, {-1, 4, 2, 0}, {-1, 8, -4, 0}, {-1, 8, -3, 0}, {-1, 8, -2, 0}, {-1, 8, -1, 0}, {-1, 8, 0, 0}, {-1, 8, 1, 0}, 
	{-1, 8, 2, 0}, {-1, 12, -4, 0}, {-1, 12, -3, 0}, {-1, 12, -2, 0}, {-1, 12, -1, 0}, {-1, 12, 0, 0}, {-1, 12, 1, 0}, {-1, 12, 2, 0}, {-1, 16, -4, 0}, {-1, 16, -3, 0}, 
	{-1, 16, -2, 0}, {-1, 16, -1, 0}, {-1, 16, 0, 0}, {-1, 16, 1, 0}, {-1, 16, 2, 0}, {-1, 20, -4, 0}, {-1, 20, -3, 0}, {-1, 20, -2, 0}, {-1, 20, -1, 0}, {-1, 20, 0, 0}, 
	{-1, 20, 1, 0}, {-1, 20, 2, 0}, {-1, 24, -4, 0}, {-1, 24, -3, 0}, {-1, 24, -2, 0}, {-1, 24, -1, 0}, {-1, 24, 0, 0}, {-1, 24, 1, 0}, {-1, 24, 2, 0}, {0, 3, -5, 0}, 
	{0, 3, 4, 0}, {0, 4, -4, 0}, {0, 4, -3, 0}, {0, 4, -2, 0}, {0, 4, -1, 0}, {0, 4, 0, 0}, {0, 4, 1, 0}, {0, 4, 2, 0}, {0, 8, -4, 0}, {0, 8, -3, 0}, 
	{0, 8, -2, 0}, {0, 8, -1, 0}, {0, 8, 0, 0}, {0, 8, 1, 0}, {0, 8, 2, 0}, {0, 12, -4, 0}, {0, 12, -3, 0}, {0, 12, -2, 0}, {0, 12, -1, 0}, {0, 12, 0, 0}, 
	{0, 12, 1, 0}, {0, 12, 2, 0}, {0, 16, -4, 0}, {0, 16, -3, 0}, {0, 16, -2, 0}, {0, 16, -1, 0}, {0, 16, 0, 0}, {0, 16, 1, 0}, {0, 16, 2, 0}, {0, 20, -4, 0}, 
	{0, 20, -3, 0}, {0, 20, -2, 0}, {0, 20, -1, 0}, {0, 20, 0, 0}, {0, 20, 1, 0}, {0, 20, 2, 0}, {0, 24, -4, 0}, {0, 24, -3, 0}, {0, 24, -2, 0}, {0, 24, -1, 0}, 
	{0, 24, 0, 0}, {0, 24, 1, 0}, {0, 24, 2, 0}, {1, 3, -5, 0}, {1, 3, 3, 0}, {1, 3, 4, 0}, {1, 4, -4, 0}, {1, 4, -3, 0}, {1, 4, -2, 0}, {1, 4, -1, 0}, 
	{1, 4, 0, 0}, {1, 4, 1, 0}, {1, 7, 3, 0}, {1, 7, 4, 0}, {1, 8, -4, 0}, {1, 8, -3, 0}, {1, 8, -2, 0}, {1, 8, -1, 0}, {1, 8, 0, 0}, {1, 8, 1, 0}, 
	{1, 11, 3, 0}, {1, 11, 4, 0}, {1, 12, -4, 0}, {1, 12, -3, 0}, {1, 12, -2, 0}, {1, 12, -1, 0}, {1, 12, 0, 0}, {1, 12, 1, 0}, {1, 15, 3, 0}, {1, 15, 4, 0}, 
	{1, 16, -4, 0}, {1, 16, -3, 0}, {1, 16, -2, 0}, {1, 16, -1, 0}, {1, 16, 0, 0}, {1, 16, 1, 0}, {1, 19, 3, 0}, {1, 19, 4, 0}, {1, 20, -4, 0}, {1, 20, -3, 0}, 
	{1, 20, -2, 0}, {1, 20, -1, 0}, {1, 20, 0, 0}, {1, 20, 1, 0}, {1, 23, 3, 0}, {1, 23, 4, 0}, {1, 24, -4, 0}, {1, 24, -3, 0}, {1, 24, -2, 0}, {1, 24, -1, 0}, 
	{1, 24, 0, 0}, {1, 24, 1, 0}, {2, 3, -5, 0}, {2, 3, 4, 0}, {2, 4, -3, 0}, {2, 4, -2, 0}, {2, 4, -1, 0}, {2, 4, 0, 0}, {2, 4, 1, 0}, {2, 4, 2, 0}, 
	{2, 7, -5, 0}, {2, 7, -4, 0}, {2, 7, 3, 0}, {2, 7, 4, 0}, {2, 8, -3, 0}, {2, 8, -2, 0}, {2, 8, -1, 0}, {2, 8, 0, 0}, {2, 8, 1, 0}, {2, 8, 2, 0}, 
	{2, 11, -5, 0}, {2, 11, -4, 0}, {2, 11, 3, 0}, {2, 11, 4, 0}, {2, 12, -3, 0}, {2, 12, -2, 0}, {2, 12, -1, 0}, {2, 12, 0, 0}, {2, 12, 1, 0}, {2, 12, 2, 0}, 
	{2, 15, -5, 0}, {2, 15, -4, 0}, {2, 15, 3, 0}, {2, 15, 4, 0}, {2, 16, -3, 0}, {2, 16, -2, 0}, {2, 16, -1, 0}, {2, 16, 0, 0}, {2, 16, 1, 0}, {2, 16, 2, 0}, 
	{2, 19, -5, 0}, {2, 19, -4, 0}, {2, 19, 3, 0}, {2, 19, 4, 0}, {2, 20, -3, 0}, {2, 20, -2, 0}, {2, 20, -1, 0}, {2, 20, 0, 0}, {2, 20, 1, 0}, {2, 20, 2, 0}, 
	{2, 23, -5, 0}, {2, 23, -4, 0}, {2, 23, 3, 0}, {2, 23, 4, 0}, {2, 24, -3, 0}, {2, 24, -2, 0}, {2, 24, -1, 0}, {2, 24, 0, 0}, {2, 24, 1, 0}, {2, 24, 2, 0}, 
	{3, 3, -4, 0}, {3, 3, 3, 0}, {3, 4, -2, 0}, {3, 4, -1, 0}, {3, 4, 0, 0}, {3, 4, 1, 0}, {3, 7, -4, 0}, {3, 7, -3, 0}, {3, 7, 2, 0}, {3, 7, 3, 0}, 
	{3, 8, -2, 0}, {3, 8, -1, 0}, {3, 8, 0, 0}, {3, 8, 1, 0}, {3, 11, -4, 0}, {3, 11, -3, 0}, {3, 11, 2, 0}, {3, 11, 3, 0}, {3, 12, -2, 0}, {3, 12, -1, 0}, 
	{3, 12, 0, 0}, {3, 12, 1, 0}, {3, 15, -4, 0}, {3, 15, -3, 0}, {3, 15, 2, 0}, {3, 15, 3, 0}, {3, 16, -2, 0}, {3, 16, -1, 0}, {3, 16, 0, 0}, {3, 16, 1, 0}, 
	{3, 19, -4, 0}, {3, 19, -3, 0}, {3, 19, 2, 0}, {3, 19, 3, 0}, {3, 20, -2, 0}, {3, 20, -1, 0}, {3, 20, 0, 0}, {3, 20, 1, 0}, {3, 23, -4, 0}, {3, 23, -3, 0}, 
	{3, 23, 2, 0}, {3, 23, 3, 0}, {3, 24, -2, 0}, {3, 24, -1, 0}, {3, 24, 0, 0}, {3, 24, 1, 0}, {4, 3, -3, 0}, {4, 3, -2, 0}, {4, 3, -1, 0}, {4, 3, 0, 0}, 
	{4, 3, 1, 0}, {4, 3, 2, 0}, {4, 7, -3, 0}, {4, 7, -2, 0}, {4, 7, 1, 0}, {4, 7, 2, 0}, {4, 11, -3, 0}, {4, 11, -2, 0}, {4, 11, 1, 0}, {4, 11, 2, 0}, 
	{4, 15, -3, 0}, {4, 15, -2, 0}, {4, 15, 1, 0}, {4, 15, 2, 0}, {4, 19, -3, 0}, {4, 19, -2, 0}, {4, 19, 1, 0}, {4, 19, 2, 0}, {4, 23, -3, 0}, {4, 23, -2, 0}, 
	{4, 23, 1, 0}, {4, 23, 2, 0}, 

	}; 
	 
	byte[][] elder_stone_brick_stairs = { 

	{-5, 4, -3, 0}, {-5, 4, -2, 0}, {-5, 4, -1, 0}, {-5, 4, 0, 0}, {-5, 4, 1, 0}, {-5, 4, 2, 3}, {-5, 5, -3, 6}, {-5, 5, -2, 4}, {-5, 5, -1, 4}, {-5, 5, 0, 4}, 
	{-5, 5, 1, 4}, {-5, 5, 2, 4}, {-5, 8, -3, 0}, {-5, 8, -2, 0}, {-5, 8, -1, 0}, {-5, 8, 0, 0}, {-5, 8, 1, 0}, {-5, 8, 2, 3}, {-5, 9, -3, 4}, {-5, 9, -2, 4}, 
	{-5, 9, -1, 4}, {-5, 9, 0, 4}, {-5, 9, 1, 4}, {-5, 9, 2, 7}, {-5, 12, -3, 0}, {-5, 12, -2, 0}, {-5, 12, -1, 0}, {-5, 12, 0, 0}, {-5, 12, 1, 0}, {-5, 12, 2, 3}, 
	{-5, 13, -3, 4}, {-5, 13, -2, 4}, {-5, 13, -1, 4}, {-5, 13, 0, 4}, {-5, 13, 1, 4}, {-5, 13, 2, 7}, {-5, 16, -3, 2}, {-5, 16, -2, 0}, {-5, 16, -1, 0}, {-5, 16, 0, 0}, 
	{-5, 16, 1, 0}, {-5, 16, 2, 3}, {-5, 17, -3, 4}, {-5, 17, -2, 4}, {-5, 17, -1, 4}, {-5, 17, 0, 4}, {-5, 17, 1, 4}, {-5, 17, 2, 7}, {-5, 20, -3, 0}, {-5, 20, -2, 0}, 
	{-5, 20, -1, 0}, {-5, 20, 0, 0}, {-5, 20, 1, 0}, {-5, 20, 2, 3}, {-5, 21, -3, 4}, {-5, 21, -2, 4}, {-5, 21, -1, 4}, {-5, 21, 0, 4}, {-5, 21, 1, 4}, {-5, 21, 2, 7}, 
	{-5, 24, -3, 0}, {-5, 24, -2, 0}, {-5, 24, -1, 0}, {-5, 24, 0, 0}, {-5, 24, 1, 0}, {-5, 24, 2, 3}, {-5, 25, -3, 4}, {-5, 25, -2, 4}, {-5, 25, -1, 4}, {-5, 25, 0, 4}, 
	{-5, 25, 1, 4}, {-5, 25, 2, 7}, {-4, 4, -4, 0}, {-4, 4, -3, 2}, {-4, 4, 2, 0}, {-4, 4, 3, 3}, {-4, 5, -4, 6}, {-4, 5, -3, 4}, {-4, 5, 2, 7}, {-4, 5, 3, 4}, 
	{-4, 8, -4, 0}, {-4, 8, -3, 2}, {-4, 8, 2, 0}, {-4, 8, 3, 3}, {-4, 9, -4, 4}, {-4, 9, -3, 6}, {-4, 9, 2, 4}, {-4, 9, 3, 7}, {-4, 12, -4, 0}, {-4, 12, -3, 2}, 
	{-4, 12, 2, 0}, {-4, 12, 3, 3}, {-4, 13, -4, 4}, {-4, 13, -3, 6}, {-4, 13, 2, 4}, {-4, 13, 3, 7}, {-4, 16, -4, 2}, {-4, 16, -3, 0}, {-4, 16, 2, 0}, {-4, 16, 3, 3}, 
	{-4, 17, -4, 4}, {-4, 17, -3, 6}, {-4, 17, 2, 4}, {-4, 17, 3, 7}, {-4, 20, -4, 0}, {-4, 20, -3, 2}, {-4, 20, 2, 0}, {-4, 20, 3, 3}, {-4, 21, -4, 4}, {-4, 21, -3, 6}, 
	{-4, 21, 2, 4}, {-4, 21, 3, 7}, {-4, 24, -4, 0}, {-4, 24, -3, 2}, {-4, 24, 2, 0}, {-4, 24, 3, 3}, {-4, 25, -4, 4}, {-4, 25, -3, 6}, {-4, 25, 2, 4}, {-4, 25, 3, 7}, 
	{-3, 4, -5, 0}, {-3, 4, -4, 2}, {-3, 4, 3, 0}, {-3, 4, 4, 3}, {-3, 5, -5, 6}, {-3, 5, -4, 4}, {-3, 5, 3, 7}, {-3, 5, 4, 4}, {-3, 8, -5, 0}, {-3, 8, -4, 2}, 
	{-3, 8, 3, 0}, {-3, 8, 4, 3}, {-3, 9, -5, 4}, {-3, 9, -4, 6}, {-3, 9, 3, 4}, {-3, 9, 4, 7}, {-3, 12, -5, 0}, {-3, 12, -4, 2}, {-3, 12, 3, 0}, {-3, 12, 4, 3}, 
	{-3, 13, -5, 4}, {-3, 13, -4, 6}, {-3, 13, 3, 4}, {-3, 13, 4, 7}, {-3, 16, -5, 2}, {-3, 16, -4, 0}, {-3, 16, 3, 0}, {-3, 16, 4, 3}, {-3, 17, -5, 4}, {-3, 17, -4, 6}, 
	{-3, 17, 3, 4}, {-3, 17, 4, 7}, {-3, 20, -5, 0}, {-3, 20, -4, 2}, {-3, 20, 3, 0}, {-3, 20, 4, 3}, {-3, 21, -5, 4}, {-3, 21, -4, 6}, {-3, 21, 3, 4}, {-3, 21, 4, 7}, 
	{-3, 24, -5, 0}, {-3, 24, -4, 2}, {-3, 24, 3, 0}, {-3, 24, 4, 3}, {-3, 25, -5, 4}, {-3, 25, -4, 6}, {-3, 25, 3, 4}, {-3, 25, 4, 7}, {-2, 1, 2, 2}, {-2, 4, -5, 2}, 
	{-2, 4, 4, 3}, {-2, 5, -5, 6}, {-2, 5, 2, 2}, {-2, 5, 4, 7}, {-2, 8, -5, 2}, {-2, 8, 4, 3}, {-2, 9, -5, 6}, {-2, 9, 2, 2}, {-2, 9, 4, 7}, {-2, 12, -5, 2}, 
	{-2, 12, 4, 3}, {-2, 13, -5, 6}, {-2, 13, 2, 2}, {-2, 13, 4, 7}, {-2, 16, -5, 2}, {-2, 16, 4, 3}, {-2, 17, -5, 6}, {-2, 17, 2, 2}, {-2, 17, 4, 7}, {-2, 20, -5, 2}, 
	{-2, 20, 4, 3}, {-2, 21, -5, 6}, {-2, 21, 2, 2}, {-2, 21, 4, 7}, {-2, 24, -5, 2}, {-2, 24, 4, 3}, {-2, 25, -5, 6}, {-2, 25, 4, 7}, {-1, 0, -5, 2}, {-1, 2, 3, 0}, 
	{-1, 4, -5, 2}, {-1, 4, 4, 3}, {-1, 5, -5, 6}, {-1, 5, 4, 7}, {-1, 6, 3, 0}, {-1, 8, -5, 2}, {-1, 8, 4, 3}, {-1, 9, -5, 6}, {-1, 9, 4, 7}, {-1, 10, 3, 0}, 
	{-1, 12, -5, 2}, {-1, 12, 4, 3}, {-1, 13, -5, 6}, {-1, 13, 4, 7}, {-1, 14, 3, 0}, {-1, 16, -5, 2}, {-1, 16, 4, 3}, {-1, 17, -5, 6}, {-1, 17, 4, 7}, {-1, 18, 3, 0}, 
	{-1, 20, -5, 2}, {-1, 20, 4, 3}, {-1, 21, -5, 6}, {-1, 21, 4, 7}, {-1, 22, 3, 0}, {-1, 24, -5, 2}, {-1, 24, 4, 3}, {-1, 25, -5, 6}, {-1, 25, 4, 7}, {0, 0, -5, 2}, 
	{0, 3, 3, 0}, {0, 4, -5, 2}, {0, 4, 4, 3}, {0, 5, -5, 6}, {0, 5, 4, 7}, {0, 7, 3, 0}, {0, 8, -5, 2}, {0, 8, 4, 3}, {0, 9, -5, 6}, {0, 9, 4, 7}, 
	{0, 11, 3, 0}, {0, 12, -5, 2}, {0, 12, 4, 3}, {0, 13, -5, 6}, {0, 13, 4, 7}, {0, 15, 3, 0}, {0, 16, -5, 2}, {0, 16, 4, 3}, {0, 17, -5, 6}, {0, 17, 4, 7}, 
	{0, 19, 3, 0}, {0, 20, -5, 2}, {0, 20, 4, 3}, {0, 21, -5, 6}, {0, 21, 4, 7}, {0, 23, 3, 0}, {0, 24, -5, 2}, {0, 24, 4, 3}, {0, 25, -5, 6}, {0, 25, 4, 7}, 
	{1, 4, -5, 2}, {1, 4, 2, 3}, {1, 4, 4, 3}, {1, 5, -5, 6}, {1, 5, 4, 7}, {1, 8, -5, 2}, {1, 8, 2, 3}, {1, 8, 4, 3}, {1, 9, -5, 6}, {1, 9, 4, 7}, 
	{1, 12, -5, 2}, {1, 12, 2, 3}, {1, 12, 4, 3}, {1, 13, -5, 6}, {1, 13, 4, 7}, {1, 16, -5, 2}, {1, 16, 2, 3}, {1, 16, 4, 3}, {1, 17, -5, 6}, {1, 17, 4, 7}, 
	{1, 20, -5, 2}, {1, 20, 2, 3}, {1, 20, 4, 3}, {1, 21, -5, 6}, {1, 21, 4, 7}, {1, 24, -5, 2}, {1, 24, 2, 3}, {1, 24, 4, 3}, {1, 25, -5, 6}, {1, 25, 4, 7}, 
	{2, 4, -5, 2}, {2, 4, -4, 1}, {2, 4, 3, 3}, {2, 4, 4, 1}, {2, 5, -5, 6}, {2, 5, -4, 5}, {2, 5, 3, 5}, {2, 5, 4, 7}, {2, 8, -5, 2}, {2, 8, -4, 1}, 
	{2, 8, 3, 3}, {2, 8, 4, 1}, {2, 9, -5, 5}, {2, 9, -4, 5}, {2, 9, 3, 7}, {2, 9, 4, 5}, {2, 12, -5, 2}, {2, 12, -4, 1}, {2, 12, 3, 3}, {2, 12, 4, 1}, 
	{2, 13, -5, 6}, {2, 13, -4, 5}, {2, 13, 3, 7}, {2, 13, 4, 5}, {2, 16, -5, 2}, {2, 16, -4, 1}, {2, 16, 3, 3}, {2, 16, 4, 1}, {2, 17, -5, 6}, {2, 17, -4, 5}, 
	{2, 17, 3, 7}, {2, 17, 4, 5}, {2, 20, -5, 2}, {2, 20, -4, 1}, {2, 20, 3, 3}, {2, 20, 4, 1}, {2, 21, -5, 6}, {2, 21, -4, 5}, {2, 21, 3, 7}, {2, 21, 4, 5}, 
	{2, 24, -5, 2}, {2, 24, -4, 1}, {2, 24, 3, 3}, {2, 24, 4, 1}, {2, 25, -5, 6}, {2, 25, -4, 5}, {2, 25, 3, 7}, {2, 25, 4, 5}, {3, 4, -4, 2}, {3, 4, -3, 1}, 
	{3, 4, 2, 3}, {3, 4, 3, 1}, {3, 5, -4, 6}, {3, 5, -3, 5}, {3, 5, 2, 5}, {3, 5, 3, 7}, {3, 8, -4, 2}, {3, 8, -3, 1}, {3, 8, 2, 3}, {3, 8, 3, 1}, 
	{3, 9, -4, 6}, {3, 9, -3, 5}, {3, 9, 2, 7}, {3, 9, 3, 5}, {3, 12, -4, 2}, {3, 12, -3, 1}, {3, 12, 2, 3}, {3, 12, 3, 1}, {3, 13, -4, 6}, {3, 13, -3, 5}, 
	{3, 13, 2, 7}, {3, 13, 3, 5}, {3, 16, -4, 2}, {3, 16, -3, 1}, {3, 16, 2, 3}, {3, 16, 3, 1}, {3, 17, -4, 6}, {3, 17, -3, 5}, {3, 17, 2, 7}, {3, 17, 3, 5}, 
	{3, 20, -4, 2}, {3, 20, -3, 1}, {3, 20, 2, 3}, {3, 20, 3, 1}, {3, 21, -4, 6}, {3, 21, -3, 5}, {3, 21, 2, 7}, {3, 21, 3, 5}, {3, 24, -4, 2}, {3, 24, -3, 1}, 
	{3, 24, 2, 3}, {3, 24, 3, 1}, {3, 25, -4, 6}, {3, 25, -3, 5}, {3, 25, 2, 7}, {3, 25, 3, 5}, {4, 4, -3, 2}, {4, 4, -2, 1}, {4, 4, -1, 1}, {4, 4, 0, 1}, 
	{4, 4, 1, 1}, {4, 4, 2, 1}, {4, 5, -3, 6}, {4, 5, -2, 5}, {4, 5, -1, 5}, {4, 5, 0, 5}, {4, 5, 1, 5}, {4, 5, 2, 7}, {4, 8, -3, 2}, {4, 8, -2, 1}, 
	{4, 8, -1, 1}, {4, 8, 0, 1}, {4, 8, 1, 1}, {4, 8, 2, 1}, {4, 9, -3, 6}, {4, 9, -2, 5}, {4, 9, -1, 5}, {4, 9, 0, 5}, {4, 9, 1, 5}, {4, 9, 2, 5}, 
	{4, 12, -3, 2}, {4, 12, -2, 1}, {4, 12, -1, 1}, {4, 12, 0, 1}, {4, 12, 1, 1}, {4, 12, 2, 1}, {4, 13, -3, 6}, {4, 13, -2, 5}, {4, 13, -1, 5}, {4, 13, 0, 5}, 
	{4, 13, 1, 5}, {4, 13, 2, 5}, {4, 16, -3, 2}, {4, 16, -2, 1}, {4, 16, -1, 1}, {4, 16, 0, 1}, {4, 16, 1, 1}, {4, 16, 2, 1}, {4, 17, -3, 6}, {4, 17, -2, 5}, 
	{4, 17, -1, 5}, {4, 17, 0, 5}, {4, 17, 1, 5}, {4, 17, 2, 5}, {4, 20, -3, 2}, {4, 20, -2, 1}, {4, 20, -1, 1}, {4, 20, 0, 1}, {4, 20, 1, 1}, {4, 20, 2, 1}, 
	{4, 21, -3, 6}, {4, 21, -2, 5}, {4, 21, -1, 5}, {4, 21, 0, 5}, {4, 21, 1, 5}, {4, 21, 2, 5}, {4, 24, -3, 2}, {4, 24, -2, 1}, {4, 24, -1, 1}, {4, 24, 0, 1}, 
	{4, 24, 1, 1}, {4, 24, 2, 1}, {4, 25, -3, 6}, {4, 25, -2, 5}, {4, 25, -1, 5}, {4, 25, 0, 5}, {4, 25, 1, 5}, {4, 25, 2, 5}, 

	}; 
	 
	byte[][] elder_bricks_chiseled = { 

	{-5, 7, -1, 0}, {-5, 7, 0, 0}, {-5, 11, -1, 0}, {-5, 11, 0, 0}, {-5, 15, -1, 0}, {-5, 15, 0, 0}, {-5, 19, -1, 0}, {-5, 19, 0, 0}, {-5, 23, -1, 0}, {-5, 23, 0, 0}, 
	{-2, 7, -5, 0}, {-2, 11, -5, 0}, {-2, 15, -5, 0}, {-2, 19, -5, 0}, {-2, 23, -5, 0}, {-1, 7, 4, 0}, {-1, 11, 4, 0}, {-1, 15, 4, 0}, {-1, 19, 4, 0}, {-1, 23, 4, 0}, 
	{0, 7, 4, 0}, {0, 11, 4, 0}, {0, 15, 4, 0}, {0, 19, 4, 0}, {0, 23, 4, 0}, {1, 7, -5, 0}, {1, 11, -5, 0}, {1, 15, -5, 0}, {1, 19, -5, 0}, {1, 23, -5, 0}, 
	{4, 7, -1, 0}, {4, 7, 0, 0}, {4, 11, -1, 0}, {4, 11, 0, 0}, {4, 15, -1, 0}, {4, 15, 0, 0}, {4, 19, -1, 0}, {4, 19, 0, 0}, {4, 23, -1, 0}, {4, 23, 0, 0}, 


	}; 

}
