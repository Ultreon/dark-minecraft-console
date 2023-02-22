package com.ultreon.mods.darkconsole.mixin.common;

import com.formdev.flatlaf.FlatDarkLaf;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.gui.MinecraftServerGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.swing.*;

@Mixin(MinecraftServerGui.class)
public class MinecraftServerGuiMixin {
    @Inject(method = "showFrameFor", at = @At(value = "NEW", target = "javax/swing/JFrame"))
    private static void essentials$showFrameFor(DedicatedServer pServer, CallbackInfoReturnable<MinecraftServerGui> cir) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
}
