package com.ultreon.mods.darkconsole.server

import dev.architectury.event.events.common.LifecycleEvent

object TemplateModServer {
    fun init() {
        LifecycleEvent.SETUP.register(TemplateModServer::setup)
    }

    private fun setup() {
        // Do server setup here.
    }
}
