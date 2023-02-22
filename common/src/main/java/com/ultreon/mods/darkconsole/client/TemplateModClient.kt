package com.ultreon.mods.darkconsole.client

import dev.architectury.event.events.client.ClientLifecycleEvent
import net.minecraft.client.Minecraft

object TemplateModClient {
    fun init() {
        ClientLifecycleEvent.CLIENT_SETUP.register(TemplateModClient::setup)
    }

    private fun setup(minecraft: Minecraft?) {
        // Do client setup here.
    }
}
