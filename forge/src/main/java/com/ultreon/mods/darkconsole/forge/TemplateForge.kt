@file:Suppress("removal")

package com.ultreon.mods.darkconsole.forge

import com.ultreon.mods.darkconsole.DarkConsoleMod
import com.ultreon.mods.darkconsole.server.DarkConsoleModServer
import dev.architectury.platform.forge.EventBuses
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.KotlinModLoadingContext

@Mod(TemplateForge.modId)
class TemplateForge {
    init {
        EventBuses.registerModEventBus(modId, KotlinModLoadingContext.get().getKEventBus())

        DarkConsoleMod.init()

        DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER) { Runnable { DarkConsoleModServer.init() } }
    }

    companion object {
        const val modId = "dark_console"
    }
}