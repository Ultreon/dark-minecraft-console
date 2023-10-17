@file:Suppress("removal")

package com.ultreon.mods.darkconsole.forge

import com.ultreon.mods.darkconsole.DarkConsoleMod
import com.ultreon.mods.darkconsole.server.DarkConsoleModServer
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.fml.DistExecutor
import net.minecraftforge.fml.common.Mod

@Mod(DarkConsoleMod.MOD_ID)
class DarkConsoleForge {
    init {
        DarkConsoleMod.init()

        DistExecutor.unsafeRunWhenOn(Dist.DEDICATED_SERVER) { Runnable { DarkConsoleModServer.init() } }
    }
}