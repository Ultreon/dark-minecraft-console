package com.ultreon.mods.darkconsole.fabric

import com.ultreon.mods.darkconsole.DarkConsoleMod
import net.fabricmc.api.ModInitializer

@Suppress("unused")
object DarkConsoleFabric : ModInitializer {
    override fun onInitialize() {
        DarkConsoleMod.init()
    }
}