package com.ultreon.mods.darkconsole.fabric

import com.ultreon.mods.darkconsole.server.DarkConsoleModServer
import net.fabricmc.api.DedicatedServerModInitializer

@Suppress("unused")
object DarkConsoleFabricServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        DarkConsoleModServer.init()
    }
}