package com.kneelawk.acrossdimensions.world.gen.structure

import java.util.ArrayList
import com.kneelawk.acrossdimensions.log.ADLog
import com.kneelawk.acrossdimensions.world.gen.structure.ironstronghold.StructureIronMinePieces
import com.kneelawk.acrossdimensions.world.gen.structure.ironstronghold.StructureStartIronMine
import net.minecraft.world.gen.structure.MapGenStructureIO
import net.minecraft.world.gen.structure.MapGenStructure
import com.kneelawk.acrossdimensions.world.gen.structure.ironstronghold.MapGenIronMine

object MapGenControl {
	
	final val structureList = new ArrayList[MapGenStructure]()
	
	def init {
		ADLog.info("Registering Structures")

		// register structure starts
		MapGenStructureIO.registerStructure(classOf[StructureStartIronMine], "IronMine")

		// register pieces
		StructureIronMinePieces.registerStructurePieces
		
		// register structures
		registerStructure(new MapGenIronMine())
	}
	
	def registerStructure(structure: MapGenStructure) {
		structureList.add(structure)
	}
}