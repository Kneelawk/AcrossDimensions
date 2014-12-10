package com.kneelawk.acrossdimensions.blocks

import java.util.HashMap
import java.util.Map.Entry
import java.util.function.Consumer
import com.kneelawk.acrossdimensions.items.itemblocks.ADItemBlock
import com.kneelawk.acrossdimensions.ref.LangRef
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import com.kneelawk.acrossdimensions.ref.TexRef
import net.minecraft.block.material.Material

object ADBlocks {
	val tab = new CreativeTabs(LangRef.ACROSS_DIMENSIONS_TAB_NAME) {
		def getTabIconItem = Item.getItemFromBlock(getBlock(LangRef.BLOCK_ALRKITE_NAME))
	}

	val blockMap = new HashMap[String, Block];
	val itemBlockMap = new HashMap[String, Class[_ <: ItemBlock]];

	def init {
		addBlock(TexRef.BLOCK_ALRKITE, Array("Bricks", "Stones", "CrackedStones", "MossyStones"), Material.rock, LangRef.BLOCK_ALRKITE_NAME, tab)
	}

	def registerBlocks {
		val eset = blockMap.entrySet();
		eset.forEach(new Consumer[Entry[String, Block]] {
			def accept(entry: Entry[String, Block]) {
				register(entry.getValue, entry.getKey)
			}
		})
	}

	def getBlock(name: String) = blockMap.get(name)

	def addBlock(block: Block, name: String, tab: CreativeTabs): Block = {
		block.setBlockName(name)
		block.setCreativeTab(tab)
		blockMap.put(name, block)
		block
	}

	def addBlock(block: Block, name: String, itemClass: Class[_ <: ItemBlock], tab: CreativeTabs): Block = {
		addBlock(block, name, tab)
		itemBlockMap.put(name, itemClass)
		block
	}

	def addBlock(prefix: String, suffixes: Array[String], mat: Material, name: String, tab: CreativeTabs): Block = {
		val block = new BlockWithMetadata(prefix, suffixes, mat)
		addBlock(block, name, classOf[ADItemBlock], tab)
	}

	def register(block: Block, name: String) {
		if (itemBlockMap.containsKey(name)) GameRegistry.registerBlock(block, itemBlockMap.get(name), name)
		else GameRegistry.registerBlock(block, name)
	}
}