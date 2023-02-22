package com.ultreon.mods.darkconsole.fabric

import com.ultreon.mods.darkconsole.TemplateMod
import net.fabricmc.api.ModInitializer

@Suppress("unused")
object TemplateFabric : ModInitializer {
    override fun onInitialize() {
        TemplateMod.init()
    }
}