package com.valeriotor.BTV.world.Structures;

import java.util.Random;

import com.valeriotor.BTV.blocks.BlockRegistry;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Idol extends HamletStructure{
	
	
	
	public Idol(World w) {
		this.world = w;
		this.radius = 3;
	}


	@Override
	public void StartStructure(Random r) {
		IBlockState state = BlockRegistry.BricksBlue.getDefaultState();
		if(this.isItOnWater) state = BlockRegistry.DampWood.getDefaultState();
		
		for(int[] n : this.dark_sand) world.setBlockState(new BlockPos(x+n[0], y+n[1], z+n[2]), state);
		for(int[] n : this.bricks_blue) world.setBlockState(new BlockPos(x+n[0], y+n[1], z+n[2]), BlockRegistry.BricksBlue.getStateFromMeta(n[3]));
		for(int[] n : this.air) world.setBlockState(new BlockPos(x+n[0], y+n[1], z+n[2]), Blocks.AIR.getStateFromMeta(n[3]));
		for(int[] n : this.prismarine) world.setBlockState(new BlockPos(x+n[0], y+n[1], z+n[2]), Blocks.PRISMARINE.getStateFromMeta(n[3]));
		for(int[] n : this.idol) world.setBlockState(new BlockPos(x+n[0], y+n[1], z+n[2]), BlockRegistry.BlockIdol.getStateFromMeta(n[3]));
	}

	
	public boolean isIdolOnWater() {
		int counter = 0;
		for(int x = this.center.getX()-this.radius; x < this.center.getX()+this.radius; x++) {
			for(int z = this.center.getZ()-this.radius; z < this.center.getZ()+this.radius; z++) {
				BlockPos pos = new BlockPos(x, this.world.getHeight(x,z)-1, z);
				if(this.world.getBlockState(pos).getBlock() == Blocks.WATER) counter++;
			}
		}
		if(counter < (this.radius+1)*(this.radius+1)) return false;
		this.isItOnWater = true;
		return true;
	}
	
	int[][] dark_sand = { 

			{-4, -1, -4, 0}, {-4, -1, -3, 0}, {-4, -1, -2, 0}, {-4, -1, -1, 0}, {-4, -1, 0, 0}, {-4, -1, 1, 0}, {-4, -1, 2, 0}, {-4, -1, 3, 0}, {-4, -1, 4, 0}, {-3, -1, -4, 0}, 
			{-3, -1, -3, 0}, {-3, -1, -2, 0}, {-3, -1, -1, 0}, {-3, -1, 0, 0}, {-3, -1, 1, 0}, {-3, -1, 2, 0}, {-3, -1, 3, 0}, {-3, -1, 4, 0}, {-2, -1, -4, 0}, {-2, -1, -3, 0}, 
			{-2, -1, -2, 0}, {-2, -1, -1, 0}, {-2, -1, 0, 0}, {-2, -1, 1, 0}, {-2, -1, 2, 0}, {-2, -1, 3, 0}, {-2, -1, 4, 0}, {-1, -1, -4, 0}, {-1, -1, -3, 0}, {-1, -1, -2, 0}, 
			{-1, -1, -1, 0}, {-1, -1, 0, 0}, {-1, -1, 1, 0}, {-1, -1, 2, 0}, {-1, -1, 3, 0}, {-1, -1, 4, 0}, {0, -1, -4, 0}, {0, -1, -3, 0}, {0, -1, -2, 0}, {0, -1, -1, 0}, 
			{0, -1, 0, 0}, {0, -1, 1, 0}, {0, -1, 2, 0}, {0, -1, 3, 0}, {0, -1, 4, 0}, {1, -1, -4, 0}, {1, -1, -3, 0}, {1, -1, -2, 0}, {1, -1, -1, 0}, {1, -1, 0, 0}, 
			{1, -1, 1, 0}, {1, -1, 2, 0}, {1, -1, 3, 0}, {1, -1, 4, 0}, {2, -1, -4, 0}, {2, -1, -3, 0}, {2, -1, -2, 0}, {2, -1, -1, 0}, {2, -1, 0, 0}, {2, -1, 1, 0}, 
			{2, -1, 2, 0}, {2, -1, 3, 0}, {2, -1, 4, 0}, {3, -1, -4, 0}, {3, -1, -3, 0}, {3, -1, -2, 0}, {3, -1, -1, 0}, {3, -1, 0, 0}, {3, -1, 1, 0}, {3, -1, 2, 0}, 
			{3, -1, 3, 0}, {3, -1, 4, 0}, {4, -1, -4, 0}, {4, -1, -3, 0}, {4, -1, -2, 0}, {4, -1, -1, 0}, {4, -1, 0, 0}, {4, -1, 1, 0}, {4, -1, 2, 0}, {4, -1, 3, 0}, 
			{4, -1, 4, 0}, 

			}; 
			 
			int[][] bricks_blue = { 

			{-4, 0, -4, 0}, {-4, 0, 4, 0}, {-1, 0, 0, 0}, {0, 0, -1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {1, 0, 0, 0}, {4, 0, -4, 0}, {4, 0, 4, 0}, 


			}; 
			 
			int[][] air = { 

			{-4, 0, -3, 0}, {-4, 0, -2, 0}, {-4, 0, -1, 0}, {-4, 0, 0, 0}, {-4, 0, 1, 0}, {-4, 0, 2, 0}, {-4, 0, 3, 0}, {-4, 1, -3, 0}, {-4, 1, -2, 0}, {-4, 1, -1, 0}, 
			{-4, 1, 0, 0}, {-4, 1, 1, 0}, {-4, 1, 2, 0}, {-4, 1, 3, 0}, {-4, 2, -4, 0}, {-4, 2, -3, 0}, {-4, 2, -2, 0}, {-4, 2, -1, 0}, {-4, 2, 0, 0}, {-4, 2, 1, 0}, 
			{-4, 2, 2, 0}, {-4, 2, 3, 0}, {-3, 0, -4, 0}, {-3, 0, -3, 0}, {-3, 0, -2, 0}, {-3, 0, -1, 0}, {-3, 0, 0, 0}, {-3, 0, 1, 0}, {-3, 0, 2, 0}, {-3, 0, 3, 0}, 
			{-3, 0, 4, 0}, {-3, 1, -4, 0}, {-3, 1, -3, 0}, {-3, 1, -2, 0}, {-3, 1, -1, 0}, {-3, 1, 0, 0}, {-3, 1, 1, 0}, {-3, 1, 2, 0}, {-3, 1, 3, 0}, {-3, 1, 4, 0}, 
			{-3, 2, -4, 0}, {-3, 2, -3, 0}, {-3, 2, -2, 0}, {-3, 2, -1, 0}, {-3, 2, 0, 0}, {-3, 2, 1, 0}, {-3, 2, 2, 0}, {-3, 2, 3, 0}, {-3, 2, 4, 0}, {-2, 0, -4, 0}, 
			{-2, 0, -3, 0}, {-2, 0, -2, 0}, {-2, 0, -1, 0}, {-2, 0, 0, 0}, {-2, 0, 1, 0}, {-2, 0, 2, 0}, {-2, 0, 3, 0}, {-2, 0, 4, 0}, {-2, 1, -4, 0}, {-2, 1, -3, 0}, 
			{-2, 1, -2, 0}, {-2, 1, -1, 0}, {-2, 1, 0, 0}, {-2, 1, 1, 0}, {-2, 1, 2, 0}, {-2, 1, 3, 0}, {-2, 1, 4, 0}, {-2, 2, -4, 0}, {-2, 2, -3, 0}, {-2, 2, -2, 0}, 
			{-2, 2, -1, 0}, {-2, 2, 0, 0}, {-2, 2, 1, 0}, {-2, 2, 2, 0}, {-2, 2, 3, 0}, {-2, 2, 4, 0}, {-1, 0, -4, 0}, {-1, 0, -3, 0}, {-1, 0, -2, 0}, {-1, 0, -1, 0}, 
			{-1, 0, 1, 0}, {-1, 0, 2, 0}, {-1, 0, 3, 0}, {-1, 0, 4, 0}, {-1, 1, -4, 0}, {-1, 1, -3, 0}, {-1, 1, -2, 0}, {-1, 1, -1, 0}, {-1, 1, 0, 0}, {-1, 1, 1, 0}, 
			{-1, 1, 2, 0}, {-1, 1, 3, 0}, {-1, 1, 4, 0}, {-1, 2, -4, 0}, {-1, 2, -3, 0}, {-1, 2, -2, 0}, {-1, 2, -1, 0}, {-1, 2, 0, 0}, {-1, 2, 1, 0}, {-1, 2, 2, 0}, 
			{-1, 2, 3, 0}, {-1, 2, 4, 0}, {0, 0, -4, 0}, {0, 0, -3, 0}, {0, 0, -2, 0}, {0, 0, 2, 0}, {0, 0, 3, 0}, {0, 0, 4, 0}, {0, 1, -4, 0}, {0, 1, -3, 0}, 
			{0, 1, -2, 0}, {0, 1, -1, 0}, {0, 1, 1, 0}, {0, 1, 2, 0}, {0, 1, 3, 0}, {0, 1, 4, 0}, {0, 2, -4, 0}, {0, 2, -3, 0}, {0, 2, -2, 0}, {0, 2, -1, 0}, 
			{0, 2, 1, 0}, {0, 2, 2, 0}, {0, 2, 3, 0}, {0, 2, 4, 0}, {1, 0, -4, 0}, {1, 0, -3, 0}, {1, 0, -2, 0}, {1, 0, -1, 0}, {1, 0, 1, 0}, {1, 0, 2, 0}, 
			{1, 0, 3, 0}, {1, 0, 4, 0}, {1, 1, -4, 0}, {1, 1, -3, 0}, {1, 1, -2, 0}, {1, 1, -1, 0}, {1, 1, 0, 0}, {1, 1, 1, 0}, {1, 1, 2, 0}, {1, 1, 3, 0}, 
			{1, 1, 4, 0}, {1, 2, -4, 0}, {1, 2, -3, 0}, {1, 2, -2, 0}, {1, 2, -1, 0}, {1, 2, 0, 0}, {1, 2, 1, 0}, {1, 2, 2, 0}, {1, 2, 3, 0}, {1, 2, 4, 0}, 
			{2, 0, -4, 0}, {2, 0, -3, 0}, {2, 0, -2, 0}, {2, 0, -1, 0}, {2, 0, 0, 0}, {2, 0, 1, 0}, {2, 0, 2, 0}, {2, 0, 3, 0}, {2, 0, 4, 0}, {2, 1, -4, 0}, 
			{2, 1, -3, 0}, {2, 1, -2, 0}, {2, 1, -1, 0}, {2, 1, 0, 0}, {2, 1, 1, 0}, {2, 1, 2, 0}, {2, 1, 3, 0}, {2, 1, 4, 0}, {2, 2, -4, 0}, {2, 2, -3, 0}, 
			{2, 2, -2, 0}, {2, 2, -1, 0}, {2, 2, 0, 0}, {2, 2, 1, 0}, {2, 2, 2, 0}, {2, 2, 3, 0}, {2, 2, 4, 0}, {3, 0, -4, 0}, {3, 0, -3, 0}, {3, 0, -2, 0}, 
			{3, 0, -1, 0}, {3, 0, 0, 0}, {3, 0, 1, 0}, {3, 0, 2, 0}, {3, 0, 3, 0}, {3, 0, 4, 0}, {3, 1, -4, 0}, {3, 1, -3, 0}, {3, 1, -2, 0}, {3, 1, -1, 0}, 
			{3, 1, 0, 0}, {3, 1, 1, 0}, {3, 1, 2, 0}, {3, 1, 3, 0}, {3, 1, 4, 0}, {3, 2, -4, 0}, {3, 2, -3, 0}, {3, 2, -2, 0}, {3, 2, -1, 0}, {3, 2, 0, 0}, 
			{3, 2, 1, 0}, {3, 2, 2, 0}, {3, 2, 3, 0}, {3, 2, 4, 0}, {4, 0, -3, 0}, {4, 0, -2, 0}, {4, 0, -1, 0}, {4, 0, 0, 0}, {4, 0, 1, 0}, {4, 0, 2, 0}, 
			{4, 0, 3, 0}, {4, 1, -3, 0}, {4, 1, -2, 0}, {4, 1, -1, 0}, {4, 1, 0, 0}, {4, 1, 1, 0}, {4, 1, 2, 0}, {4, 1, 3, 0}, {4, 2, -4, 0}, {4, 2, -3, 0}, 
			{4, 2, -2, 0}, {4, 2, -1, 0}, {4, 2, 0, 0}, {4, 2, 1, 0}, {4, 2, 2, 0}, {4, 2, 3, 0}, {4, 2, 4, 0}, 

			}; 
			 
			int[][] prismarine = { 

			{-4, 1, -4, 2}, {-4, 1, 4, 2}, {4, 1, -4, 2}, {4, 1, 4, 2}, 

			}; 
			
			 
			int[][] idol = { 

			{0, 2, 0, 3}, 

			}; 
	
}
