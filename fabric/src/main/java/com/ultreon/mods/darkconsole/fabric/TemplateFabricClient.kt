package com.ultreon.mods.darkconsole.fabric

import com.ultreon.mods.darkconsole.client.TemplateModClient
import net.fabricmc.api.ClientModInitializer

@Suppress("unused")
object TemplateFabricClient : ClientModInitializer {
    override fun onInitializeClient() {
        TemplateModClient.init()
    }
}