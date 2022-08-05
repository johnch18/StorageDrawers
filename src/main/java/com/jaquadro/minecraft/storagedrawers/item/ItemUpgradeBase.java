package com.jaquadro.minecraft.storagedrawers.item;
import com.jaquadro.minecraft.storagedrawers.core.ModCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public abstract class ItemUpgradeBase extends Item implements IItemUpgrade {

    public static final String[] iconNames = new String[] { null, null, "iron", "gold", "obsidian", "diamond", "emerald" };

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage (int meta) {
        return getIcons()[MathHelper.clamp_int(meta, 0, iconNames.length - 1)];
    }

    @Override
    public String getUnlocalizedName (ItemStack itemStack) {
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, iconNames.length - 1);
        if (iconNames[meta] == null)
            return super.getUnlocalizedName();

        return super.getUnlocalizedName() + "." + iconNames[meta];
    }

    public ItemUpgradeBase (String name) {
        setUnlocalizedName(name);
        setHasSubtypes(true);
        setMaxDamage(0);
        setCreativeTab(ModCreativeTabs.tabStorageDrawers);
    }

    public IIcon[] getIcons() {
        return icons;
    }

    public void setIcons(IIcon[] icons) {
        this.icons = icons;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons (IIconRegister register) {
        setIcons(new IIcon[iconNames.length]);
        for (int i = 0, n = iconNames.length; i < n; i++) {
            if (iconNames[i] == null)
                continue;
            getIcons()[i] = getIcon(i, register);
        }
    }

}
