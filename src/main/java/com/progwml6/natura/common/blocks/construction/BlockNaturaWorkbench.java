package com.progwml6.natura.common.blocks.construction;

import java.util.List;

import com.progwml6.natura.common.Natura;
import com.progwml6.natura.common.blocks.util.variants.IBlockWithVariants;
import com.progwml6.natura.common.blocks.util.variants.blockstates.BlockVariant;
import com.progwml6.natura.common.blocks.util.variants.blockstates.PropertyVariant;
import com.progwml6.natura.common.network.NaturaGuiHandler;
import com.progwml6.natura.common.util.NaturaCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNaturaWorkbench extends Block implements IBlockWithVariants
{
	public static final BlockVariant EUCALYPTUS = new BlockVariant(0, "table_eucalyptus"),
			SAKURA = new BlockVariant(1, "table_sakura"),
			GHOSTWOOD = new BlockVariant(2, "table_ghostwood"),
			REDWOOD = new BlockVariant(3, "table_redwood"),
			BLOODWOOD = new BlockVariant(4, "table_bloodwood"),
			HOPSEED = new BlockVariant(5, "table_hopseed"),
			MAPLE = new BlockVariant(6, "table_maple"),
			SILVERBELL = new BlockVariant(7, "table_silverbell"),
			PURPLEHEART = new BlockVariant(8, "table_purpleheart"),
			TIGER = new BlockVariant(9, "table_tiger"),
			WILLOW = new BlockVariant(10, "table_willow"),
			DARKWOOD = new BlockVariant(11, "table_darkwood"),
			FUSEWOOD = new BlockVariant(12, "table_fusewood");

	public static final PropertyVariant WOOD_TYPE = PropertyVariant.create("variant", EUCALYPTUS, SAKURA, GHOSTWOOD, REDWOOD, BLOODWOOD, HOPSEED, MAPLE, SILVERBELL, PURPLEHEART, TIGER, WILLOW, DARKWOOD, FUSEWOOD);

	public BlockNaturaWorkbench()
	{
		super(Material.wood);

		this.setHardness(2.5f);
		this.setStepSound(Block.soundTypeWood);

		this.setDefaultState(this.getBlockState().getBaseState().withProperty(WOOD_TYPE, EUCALYPTUS));
		this.setCreativeTab(NaturaCreativeTabs.tabMisc);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			player.openGui(Natura.INSTANCE, NaturaGuiHandler.WORKBENCH_ID, world, pos.getX(), pos.getY(), pos.getZ());
		}

		return true;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		for (BlockVariant variant : WOOD_TYPE.getAllowedValues())
		{
			list.add(new ItemStack(itemIn, 1, variant.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(WOOD_TYPE, WOOD_TYPE.fromMeta(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockVariant) state.getValue(WOOD_TYPE)).getMeta();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { WOOD_TYPE });
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((BlockVariant) state.getValue(WOOD_TYPE)).getMeta();
	}

	@Override
	public String getVariantUnlocalizedName(ItemStack stack)
	{
		return WOOD_TYPE.fromMeta(stack.getMetadata()).getName();
	}
}
