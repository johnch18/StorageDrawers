package com.jaquadro.minecraft.storagedrawers.item;

import com.jaquadro.minecraft.storagedrawers.StorageDrawers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemUpgradeCreative extends ItemUpgradeBase
{
    public static final String[] iconNames = new String[] { "store", "vend" };

    public ItemUpgradeCreative (String name) {
        super(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        String name = getUnlocalizedName(itemStack);
        list.add(StatCollector.translateToLocalFormatted(name + ".description"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems (Item item, CreativeTabs creativeTabs, List list) {
        for (int i = 0, n = iconNames.length; i < n; i++) {
            if (iconNames[i] != null)
                list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public IIcon getIcon(int i, IIconRegister register) {
        return register.registerIcon(StorageDrawers.MOD_ID + ":upgrade_creative_" + iconNames[i]);
    }

}
