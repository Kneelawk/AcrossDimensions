package com.kneelawk.acrossdimensions.items.itemblocks

import net.minecraft.item.ItemBlockWithMetadata
import net.minecraft.block.Block
import net.minecraft.item.ItemStack

class ADItemBlock(block: Block) extends ItemBlockWithMetadata(block, block) {

	override def getUnlocalizedName(stack: ItemStack) = super.getUnlocalizedName(stack) + "." + stack.getItemDamage
}