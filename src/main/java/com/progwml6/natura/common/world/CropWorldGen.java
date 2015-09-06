package com.progwml6.natura.common.world;

import java.util.Random;

import com.progwml6.natura.common.blocks.BlocksNatura;
import com.progwml6.natura.common.blocks.natural.plants.BlockNaturaBarleyCrop;
import com.progwml6.natura.common.blocks.natural.plants.BlockNaturaCottonCrop;
import com.progwml6.natura.common.move.PHNatura;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CropWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		final int xChunk = chunkX * 16 + 8, zChunk = chunkZ * 16 + 8;
		int xCh = chunkX * 16 + random.nextInt(16);
		int yCh = random.nextInt(128);
		int zCh = chunkZ * 16 + random.nextInt(16);

		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenerator(new BlockPos(xChunk + 16, 0, zChunk + 16));

		//Barley
		if (PHNatura.generateBarley && random.nextInt(5) == 0 && this.goodClimate(biome, 0.11f, 1.0f, 0.11f, 2f))
		{
			this.generateBarley(world, random, xCh, yCh + PHNatura.seaLevel, zCh);
			this.generateBarley(world, random, xCh, yCh + PHNatura.seaLevel, zCh);
		}

		//Cotton
		if (PHNatura.generateCotton && random.nextInt(12) == 0 && this.goodClimate(biome, 0.11f, 1.0f, 0.11f, 2f))
		{
			this.generateCotton(world, random, xCh, yCh + PHNatura.seaLevel, zCh);
			this.generateCotton(world, random, xCh, yCh + PHNatura.seaLevel, zCh);
		}
	}

	public boolean generateBarley(World world, Random random, int x, int y, int z)
	{
		for (int tries = 0; tries < 64; tries++)
		{
			int i1 = (x + random.nextInt(8)) - random.nextInt(8);
			int j1 = (y + random.nextInt(4)) - random.nextInt(4);
			int k1 = (z + random.nextInt(8)) - random.nextInt(8);
			BlockPos pos = new BlockPos(i1, j1, k1);
			if (world.isAirBlock(pos) && Blocks.yellow_flower.canBlockStay(world, pos, world.getBlockState(pos)))
			{
				world.setBlockState(pos, BlocksNatura.barley_crop.getDefaultState().withProperty(BlockNaturaBarleyCrop.AGE, 3), 2);
			}
		}

		return true;
	}

	public boolean generateCotton(World world, Random random, int x, int y, int z)
	{
		for (int tries = 0; tries < 64; tries++)
		{
			int i1 = (x + random.nextInt(8)) - random.nextInt(8);
			int j1 = (y + random.nextInt(4)) - random.nextInt(4);
			int k1 = (z + random.nextInt(8)) - random.nextInt(8);
			BlockPos pos = new BlockPos(i1, j1, k1);
			if (world.isAirBlock(pos) && Blocks.yellow_flower.canBlockStay(world, pos, world.getBlockState(pos)))
			{
				world.setBlockState(pos, BlocksNatura.cotton_crop.getDefaultState().withProperty(BlockNaturaCottonCrop.AGE, 4), 2);
			}
		}

		return true;
	}

	public boolean goodClimate(BiomeGenBase biome, float minTemp, float maxTemp, float minRain, float maxRain)
	{
		float temp = biome.temperature;
		float rain = biome.rainfall;
		return minTemp <= temp && temp <= maxTemp && minRain <= rain && rain <= maxRain;

	}

}
