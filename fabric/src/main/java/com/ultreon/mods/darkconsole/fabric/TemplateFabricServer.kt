package com.ultreon.mods.darkconsole.fabric

import com.ultreon.mods.darkconsole.server.TemplateModServer
import net.fabricmc.api.DedicatedServerModInitializer

@Suppress("unused")
object TemplateFabricServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        TemplateModServer.init()
    }
}