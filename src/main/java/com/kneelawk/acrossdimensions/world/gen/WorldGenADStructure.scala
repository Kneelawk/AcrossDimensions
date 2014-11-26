package com.kneelawk.acrossdimensions.world.gen

import java.util.Random

import com.kneelawk.acrossdimensions.world.gen.structure.MapGenControl

import cpw.mods.fml.common.IWorldGenerator
import net.minecraft.block.Block
import net.minecraft.world.World
import net.minecraft.world.chunk.IChunkProvider

class WorldGenADStructure extends IWorldGenerator {
	@Override
	override def generate(rand: Random, x: Int, z: Int, world: World, chunkProvider: IChunkProvider, chunkProviderServer: IChunkProvider) {
		var structures = MapGenControl.structureList.iterator
		while (structures.hasNext) {
			val struct = structures.next
			struct.func_151539_a(chunkProvider, world, x, z, null.asInstanceOf[Array[Block]])
		}

		structures = MapGenControl.structureList.iterator
		while (structures.hasNext) {
			val struct = structures.next
			struct.generateStructuresInChunk(world, rand, x, z)
		}
	}
}