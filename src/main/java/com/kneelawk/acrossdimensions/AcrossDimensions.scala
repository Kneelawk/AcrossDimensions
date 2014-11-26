package com.kneelawk.acrossdimensions

import com.kneelawk.acrossdimensions.proxy.CommonProxy
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.SidedProxy
import com.kneelawk.acrossdimensions.log.ADLog

@Mod(modid = com.kneelawk.acrossdimensions.ref.ModRef.MODID, modLanguage = "scala")
object AcrossDimensions {

	@SidedProxy(clientSide = com.kneelawk.acrossdimensions.ref.CPRef.CLIENT_PROXY, serverSide = com.kneelawk.acrossdimensions.ref.CPRef.SERVER_PROXY)
	var proxy: CommonProxy = null

	@Mod.EventHandler
	def preInit(event: FMLPreInitializationEvent) {
		ADLog.init(event.getModLog)
		proxy.preInit(event)
	}

	@Mod.EventHandler
	def init(event: FMLInitializationEvent) {
		proxy.init(event)
	}

	@Mod.EventHandler
	def postInit(event: FMLPostInitializationEvent) {
		proxy.postInit(event)
	}
}