package mods.natura.blocks.natural;

import java.util.List;

import mantle.blocks.iface.IBlockVariant;
import mantle.blocks.iface.IBlockWithVariants;
import mods.natura.creativetabs.NaturaCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

public class BlockNaturaPlanks extends Block implements IBlockWithVariants
{
	public static String[] textureNames = new String[] { "eucalyptus", "sakura", "ghostwood", "redwood", "bloodwood", "hopseed", "maple", "silverbell", "purpleheart", "tiger", "willow", "darkwood", "fusewood" };

	public enum PlanksVariant implements IBlockVariant
	{
		EUCALYPTUS(0, "eucalyptus"),
		SAKURA(1, "sakura"),
		GHOSTWOOD(2, "ghostwood"),
		REDWOOD(3, "redwood"),
		BLOODWOOD(4, "bloodwood"),
		HOPSEED(5, "hopseed"),
		MAPLE(6, "maple"),
		SILVERBELL(7, "silverbell"),
		PURPLEHEART(8, "purpleheart"),
		TIGER(9, "tiger"),
		WILLOW(10, "willow"),
		DARKWOOD(11, "darkwood"),
		FUSEWOOD(12, "fusewood");

		private static final PlanksVariant[] metaLookup = new PlanksVariant[PlanksVariant.values().length];

		static
		{
			for (PlanksVariant type : PlanksVariant.values())
			{
				metaLookup[type.getMetadata()] = type;
			}
		}

		private int metadata;

		private String name;

		PlanksVariant(int metadata, String name)
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

		public static PlanksVariant getVariantFromMetadata(int meta)
		{
			return PlanksVariant.metaLookup[meta];
		}
	}

	public static final PropertyEnum PLANK_TYPE = PropertyEnum.create("variant", PlanksVariant.class);

	public BlockNaturaPlanks()
	{
		super(Material.wood);
		Blocks.fire.setFireInfo(this, 5, 20);
		this.setHardness(2.0f);
		this.setStepSound(Block.soundTypeWood);

		this.setDefaultState(this.getBlockState().getBaseState().withProperty(PLANK_TYPE, PlanksVariant.EUCALYPTUS));
		this.setCreativeTab(NaturaCreativeTabs.tab);
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		if (this.getMetaFromState(world.getBlockState(pos)) == 2 || this.getMetaFromState(world.getBlockState(pos)) == 4 || this.getMetaFromState(world.getBlockState(pos)) > 10)
			return 0;
		return this.getFlammability(world, pos, face);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		if (this.getMetaFromState(world.getBlockState(pos)) == 2 || this.getMetaFromState(world.getBlockState(pos)) == 4 || this.getMetaFromState(world.getBlockState(pos)) > 10)
			return 0;
		return this.getFireSpreadSpeed(world, pos, face);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		for (PlanksVariant type : PlanksVariant.values())
		{
			list.add(new ItemStack(itemIn, 1, type.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(PLANK_TYPE, PlanksVariant.getVariantFromMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((PlanksVariant) state.getValue(PLANK_TYPE)).getMetadata();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { PLANK_TYPE });
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((PlanksVariant) state.getValue(PLANK_TYPE)).getMetadata();
	}

	@Override
	public String getVariantNameFromStack(ItemStack stack)
	{
		return PlanksVariant.getVariantFromMetadata(stack.getMetadata()).getName();
	}
}
