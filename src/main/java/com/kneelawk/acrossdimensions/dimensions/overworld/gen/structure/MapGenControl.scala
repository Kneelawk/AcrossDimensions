package com.kneelawk.acrossdimensions.dimensions.overworld.gen.structure

import java.util.ArrayList
import com.kneelawk.acrossdimensions.log.ADLog
import com.kneelawk.acrossdimensions.dimensions.overworld.gen.structure.ironmine.StructureIronMinePieces
import com.kneelawk.acrossdimensions.dimensions.overworld.gen.structure.ironmine.StructureStartIronMine
import net.minecraft.world.gen.structure.MapGenStructureIO
import net.minecraft.world.gen.structure.MapGenStructure
import com.kneelawk.acrossdimensions.dimensions.overworld.gen.structure.ironmine.MapGenIronMine
import java.util.HashMap

object MapGenControl {
	
	final val structureList = new ArrayList[MapGenStructure]()
	final val isStructureMap = new HashMap[MapGenStructure, Boolean]()
	
	def init {
		ADLog.info("Registering Structures")

		// register structure starts
		MapGenStructureIO.registerStructure(classOf[StructureStartIronMine], "IronMine")

		// register pieces
		StructureIronMinePieces.registerStructurePieces
		
		// register structures
		registerStructure(new MapGenIronMine(), true)
	}
	
	/**
	 * Register a structure.
	 *
	 * @param structure Structure to generate in the world.
	 * @param shouldGenerateAsStrucure Generate only when the world settings "Generate Structures" is enabled.
	 */
	def registerStructure(structure: MapGenStructure, shouldGenerateAsStructure: Boolean) {
		structureList.add(structure)
	}
}