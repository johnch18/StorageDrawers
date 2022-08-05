package com.jaquadro.minecraft.storagedrawers.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public interface IItemUpgrade {

    IIcon getIconFromDamage(int meta);

    String getUnlocalizedName(ItemStack itemStack);

    void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4);

    void getSubItems(Item item, CreativeTabs creativeTabs, List list);

    void registerIcons(IIconRegister register);

    IIcon[] getIcons();

    void setIcons(IIcon[] icons);

    IIcon getIcon(int i, IIconRegister register);

}
