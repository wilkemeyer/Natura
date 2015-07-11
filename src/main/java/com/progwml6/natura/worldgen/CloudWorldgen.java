package com.progwml6.natura.worldgen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.progwml6.natura.Natura;
import com.progwml6.natura.blocks.BlocksNatura;
import com.progwml6.natura.blocks.natural.BlockClouds;
import com.progwml6.natura.common.PHNatura;

public class CloudWorldgen implements IWorldGenerator
{

    CloudGen smallcloud, mediumcloud, largecloud, hugecloud, smalldarkcloud, mediumdarkcloud, largedarkcloud, hugedarkcloud, tinyashcloud, smallashcloud, mediumashcloud, largeashcloud, hugeashcloud, tinysulfurcloud, smallsulfurcloud, mediumsulfurcloud, largesulfurcloud, hugesulfurcloud;

    public CloudWorldgen()
    {
        smallcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.WHITE), 10, false);
        mediumcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.WHITE), 20, false);
        largecloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.WHITE), 30, false);
        hugecloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.WHITE), 40, false);
        smalldarkcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.GREY), 10, false);
        mediumdarkcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.GREY), 20, false);
        largedarkcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.GREY), 30, false);
        hugedarkcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.GREY), 40, false);
        tinyashcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.DARK), 3, false);
        smallashcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.DARK), 10, false);
        mediumashcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.DARK), 18, false);
        largeashcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.DARK), 27, false);
        hugeashcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.DARK), 37, false);
        tinysulfurcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.SULFER), 3, false);
        smallsulfurcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.SULFER), 10, false);
        mediumsulfurcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.SULFER), 18, false);
        largesulfurcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.SULFER), 27, false);
        hugesulfurcloud = new CloudGen(BlocksNatura.clouds.getDefaultState().withProperty(BlockClouds.CLOUD_TYPE, BlockClouds.SULFER), 37, false);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        //Overworld
        int xCh, yCh, zCh;
        int xChunk = chunkX * 16 + 8, zChunk = chunkZ * 16 + 8;
        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenerator(new BlockPos(xChunk + 16, 0, zChunk + 16));

        if (PHNatura.generateOverworldClouds && biome.rainfall > 0.15f && random.nextInt(PHNatura.cloudSpawnRarity) == 0 && world.provider.getDimensionId() != 1)
        {
            xCh = xChunk + random.nextInt(16);
            zCh = zChunk + random.nextInt(16);
            yCh = random.nextInt(PHNatura.cloudSpawnRange) + PHNatura.cloudSpawnHeight;
            int size = random.nextInt(12);
            if (size < 5)
            {
                smallcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
            }
            else if (size < 9)
            {
                mediumcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
            }
            else if (size < 11)
            {
                largecloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
            }
            else
            {
                hugecloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
            }
        }

        //End Generation
        if (PHNatura.generateDarkClouds && biome == BiomeGenBase.sky && world.provider.getDimensionId() == 1 && random.nextInt(4) == 0)
        {
            xCh = xChunk + random.nextInt(16);
            zCh = zChunk + random.nextInt(16);
            for (int iter = 0; iter < PHNatura.darkCloudSpawnRarity; iter++)
            {
                int height = random.nextInt(PHNatura.darkCloudSpawnRange);
                if (random.nextInt(5) == 0)
                {
                    smalldarkcloud.generate(world, random, new BlockPos(xCh, height + PHNatura.darkCloudSpawnHeight, zCh));
                }
                else if (random.nextInt(7) == 0)
                {
                    mediumcloud.generate(world, random, new BlockPos(xCh, height + PHNatura.darkCloudSpawnHeight, zCh));
                }
                else if (random.nextInt(9) == 0)
                {
                    largedarkcloud.generate(world, random, new BlockPos(xCh, height + PHNatura.darkCloudSpawnHeight, zCh));
                }
                if (random.nextInt(12) == 0)
                {
                    hugedarkcloud.generate(world, random, new BlockPos(xCh, height + PHNatura.darkCloudSpawnHeight, zCh));
                }
            }
        }

        //Nether
        if (!world.provider.isSurfaceWorld())
        {
            if (PHNatura.generateAshClouds && random.nextInt(PHNatura.ashSpawnRarity) == 0)
            {
                xCh = xChunk + random.nextInt(16);
                yCh = random.nextInt(PHNatura.ashSpawnRange) + PHNatura.ashSpawnHeight;
                zCh = zChunk + random.nextInt(16);
                int size = random.nextInt(12);
                if (size < 5)
                {
                    tinyashcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
                }
                else if (size < 9)
                {
                    smallashcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
                }
                else if (size < 11)
                {
                    largeashcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
                }
                else
                {
                    hugeashcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
                }
            }

            if (PHNatura.generateSulfurClouds && random.nextInt(PHNatura.sulfurSpawnRarity) == 0)
            {
                xCh = xChunk + random.nextInt(16);
                yCh = random.nextInt(PHNatura.sulfurSpawnRange) + PHNatura.sulfurSpawnHeight;
                zCh = zChunk + random.nextInt(16);
                int size = random.nextInt(12);
                if (size < 5)
                {
                    tinysulfurcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
                }
                else if (size < 9)
                {
                    smallsulfurcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
                }
                else if (size < 11)
                {
                    largesulfurcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
                }
                else
                {
                    hugesulfurcloud.generate(world, random, new BlockPos(xCh, yCh, zCh));
                }
            }
        }
    }

    class CloudGen extends WorldGenerator
    {
        private IBlockState blockState;

        private int numberOfBlocks;

        private boolean flatCloud;

        public CloudGen(IBlockState cloud, int size, boolean flag)
        {
            blockState = cloud;
            numberOfBlocks = size;
            flatCloud = flag;
        }

        @Override
        public boolean generate(World worldIn, Random rand, BlockPos position)
        {
            int l = rand.nextInt(3) - 1;
            int i1 = rand.nextInt(3) - 1;
            int x = position.getX();
            int y = position.getY();
            int z = position.getZ();
            for (int j1 = 0; j1 < numberOfBlocks; j1++)
            {
                x += (rand.nextInt(3) - 1) + l;
                z += (rand.nextInt(3) - 1) + i1;
                if (rand.nextBoolean() && !flatCloud || flatCloud && rand.nextInt(10) == 0)
                {
                    y += rand.nextInt(3) - 1;
                }
                for (int xIter = x; xIter < x + rand.nextInt(4) + 3 * (flatCloud ? 3 : 1); xIter++)
                {
                    for (int yIter = y; yIter < y + rand.nextInt(1) + 2; yIter++)
                    {
                        for (int zIter = z; zIter < z + rand.nextInt(4) + 3 * (flatCloud ? 3 : 1); zIter++)
                        {
                            if (worldIn.getBlockState(new BlockPos(xIter, yIter, zIter)).getBlock() == Blocks.air && Math.abs(xIter - x) + Math.abs(yIter - y) + Math.abs(zIter - z) < 4 * (flatCloud ? 3 : 1) + rand.nextInt(2))
                            {
                                setBlockAndNotifyAdequately(worldIn, new BlockPos(xIter, yIter, zIter), blockState);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }

}
