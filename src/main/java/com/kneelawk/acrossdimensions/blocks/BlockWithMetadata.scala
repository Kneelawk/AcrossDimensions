package com.kneelawk.acrossdimensions.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.util.IIcon
import com.kneelawk.acrossdimensions.ref.TexRef
import cpw.mods.fml.relauncher.SideOnly
import cpw.mods.fml.relauncher.Side
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import java.util.{ List => JList }
import net.minecraft.item.ItemStack

class BlockWithMetadata(prefix: String, suffixes: Array[String], mat: Material) extends Block(mat) {
	@SideOnly(Side.CLIENT)
	var icns: Array[IIcon] = new Array(suffixes.length)

	@SideOnly(Side.CLIENT)
	override def registerBlockIcons(ir: IIconRegister) {
		for (i <- 0 to (suffixes.length - 1)) {
			icns(i) = ir.registerIcon(TexRef.getTex(prefix + suffixes(i)))
		}
	}

	@SideOnly(Side.CLIENT)
	override def getIcon(side: Int, meta: Int) = icns(meta % icns.length)

	@SideOnly(Side.CLIENT)
	override def getSubBlocks(item: Item, tab: CreativeTabs, $list: JList[_]) {
		val list = $list.asInstanceOf[JList[ItemStack]]

		for (i <- 0 to (icns.length - 1)) {
			list.add(new ItemStack(item, 1, i))
		}
	}

	override def damageDropped(meta: Int) = meta
}