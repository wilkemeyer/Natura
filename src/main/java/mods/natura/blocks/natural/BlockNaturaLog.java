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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNaturaLog extends BlockLog implements IBlockWithVariants
{
	public enum LogVariant implements IBlockVariant
	{
		EUCALYPTUS(0, "eucalyptus_log"),
		SAKURA(1, "sakura_log"),
		GHOSTWOOD(2, "ghostwood_log"),
		HOPSEED(3, "hopseed_log");

		private static final LogVariant[] metaLookup = new LogVariant[LogVariant.values().length];

		static
		{
			for (LogVariant type : LogVariant.values())
			{
				metaLookup[type.getMetadata()] = type;
			}
		}

		private int metadata;

		private String name;

		LogVariant(int metadata, String name)
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

		public static LogVariant getVariantFromMetadata(int meta)
		{
			return LogVariant.metaLookup[meta];
		}
	}

	public static final PropertyEnum LOG_TYPE = PropertyEnum.create("variant", LogVariant.class);

	public BlockNaturaLog()
	{
		super();
		this.setHardness(1.5F);
		this.setResistance(5F);
		this.setStepSound(Block.soundTypeWood);
		Blocks.fire.setFireInfo(this, 5, 20);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(LOG_TYPE, LogVariant.EUCALYPTUS).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
		this.setCreativeTab(NaturaCreativeTabs.tab);
	}

	@Override
	public float getBlockHardness(World worldIn, BlockPos pos)
	{
		return this.blockHardness;
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
		for (LogVariant type : LogVariant.values())
		{
			list.add(new ItemStack(itemIn, 1, type.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState iblockstate = this.getDefaultState().withProperty(LOG_TYPE, LogVariant.getVariantFromMetadata((meta & 3)));

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
		int i = b0 | ((LogVariant) state.getValue(LOG_TYPE)).getMetadata();

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
		return new BlockState(this, new IProperty[] { LOG_TYPE, LOG_AXIS });
	}

	/**
	 * Get the damage value that this Block should drop
	 */
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((LogVariant) state.getValue(LOG_TYPE)).getMetadata();
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
		return LogVariant.getVariantFromMetadata(stack.getMetadata()).getName();
	}
}
