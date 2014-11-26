package com.kneelawk.acrossdimensions.proxy

import com.kneelawk.acrossdimensions.world.gen.structure.MapGenControl
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import com.kneelawk.acrossdimensions.world.gen.WorldGenADStructure

class CommonProxy {
	def preInit(event: FMLPreInitializationEvent) {
		MapGenControl.init
	}
	
	def init(event: FMLInitializationEvent) {
		GameRegistry.registerWorldGenerator(new WorldGenADStructure(), 100)
	}
	
	def postInit(event: FMLPostInitializationEvent) {
	}
}