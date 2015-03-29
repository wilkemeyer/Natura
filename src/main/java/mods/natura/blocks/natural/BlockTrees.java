package mods.natura.blocks.natural;

import java.util.List;
import java.util.Random;

import mantle.blocks.iface.IBlockVariant;
import mantle.blocks.iface.IBlockWithVariants;
import mods.natura.creativetabs.NaturaCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTrees extends BlockLog implements IBlockWithVariants
{
	public enum TreeVariant implements IBlockVariant
	{
		EUCALYPTUS(0, "eucalyptus_log"),
		SAKURA(1, "sakura_log"),
		GHOSTWOOD(2, "ghostwood_log"),
		HOPSEED(3, "hopseed_log");

		private static final TreeVariant[] metaLookup = new TreeVariant[TreeVariant.values().length];

		static
		{
			for (TreeVariant type : TreeVariant.values())
			{
				metaLookup[type.getMetadata()] = type;
			}
		}

		private int metadata;

		private String name;

		TreeVariant(int metadata, String name)
		{
			this.metadata = metadata;
			this.name = name;
		}

		@Override
		public String getName()
		{
			return this.name;
		}

		@Override
		public int getMetadata()
		{
			return this.metadata;
		}

		public static TreeVariant getVariantFromMetadata(int meta)
		{
			return TreeVariant.metaLookup[meta];
		}
	}

	public static final PropertyEnum TREE_TYPE = PropertyEnum.create("variant", TreeVariant.class);

	public BlockTrees()
	{
		super();
		this.setHardness(1.5F);
		this.setResistance(5F);
		this.setStepSound(Block.soundTypeWood);
		Blocks.fire.setFireInfo(this, 5, 20);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(TREE_TYPE, TreeVariant.EUCALYPTUS).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
		this.setCreativeTab(NaturaCreativeTabs.tab);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.getMetaFromState(world.getBlockState(pos)) % 4 != 2 ? this.getFlammability(world, pos, face) : 0;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.getMetaFromState(world.getBlockState(pos)) % 4 != 2 ? this.getFireSpreadSpeed(world, pos, face) : 0;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		for (TreeVariant type : TreeVariant.values())
		{
			list.add(new ItemStack(itemIn, 1, type.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState iblockstate = this.getDefaultState().withProperty(TREE_TYPE, TreeVariant.getVariantFromMetadata((meta & 3)));

		switch (meta & 12)
		{
		case 0:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
			break;
		case 4:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
			break;
		case 8:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
			break;
		default:
			iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
		}

		return iblockstate;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		byte b0 = 0;
		int i = b0 | ((TreeVariant) state.getValue(TREE_TYPE)).getMetadata();

		switch (SwitchEnumAxis.AXIS_LOOKUP[((BlockLog.EnumAxis) state.getValue(LOG_AXIS)).ordinal()])
		{
		case 1:
			i |= 4;
			break;
		case 2:
			i |= 8;
			break;
		case 3:
			i |= 12;
		}

		return i;
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { TREE_TYPE, LOG_AXIS });
	}

	/**
	 * Get the damage value that this Block should drop
	 */
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((TreeVariant) state.getValue(TREE_TYPE)).getMetadata();
	}

	static final class SwitchEnumAxis
	{
		static final int[] AXIS_LOOKUP = new int[BlockLog.EnumAxis.values().length];

		static
		{
			try
			{
				AXIS_LOOKUP[BlockLog.EnumAxis.X.ordinal()] = 1;
			}
			catch (NoSuchFieldError var3)
			{
			}

			try
			{
				AXIS_LOOKUP[BlockLog.EnumAxis.Z.ordinal()] = 2;
			}
			catch (NoSuchFieldError var2)
			{
			}

			try
			{
				AXIS_LOOKUP[BlockLog.EnumAxis.NONE.ordinal()] = 3;
			}
			catch (NoSuchFieldError var1)
			{
			}
		}
	}

	@Override
	public String getVariantNameFromStack(ItemStack stack)
	{
		return TreeVariant.getVariantFromMetadata(stack.getMetadata()).getName();
	}
}
