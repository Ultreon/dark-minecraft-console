package com.ultreon.mods.darkconsole.mixin.common;

import com.formdev.flatlaf.FlatDarkLaf;
import com.ultreon.mods.darkconsole.server.gui.ServerGuiHooks;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.gui.MinecraftServerGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import javax.swing.*;

@Mixin(MinecraftServerGui.class)
public class MinecraftServerGuiMixin {
    private static JMenuBar menuBar;

    @Inject(method = "showFrameFor", at = @At(value = "NEW", target = "javax/swing/JFrame"))
    private static void essentials$injectTheme(DedicatedServer pServer, CallbackInfoReturnable<MinecraftServerGui> cir) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Inject(method = "showFrameFor", at = @At(value = "NEW", target = "net/minecraft/server/gui/MinecraftServerGui"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private static void essentials$injectMenuBar(DedicatedServer dedicatedServer, CallbackInfoReturnable<MinecraftServerGui> cir, JFrame jFrame) {
        menuBar = new JMenuBar();
        ServerGuiHooks.INSTANCE.populateMenuBar(dedicatedServer, jFrame, menuBar);
        jFrame.setJMenuBar(menuBar);
    }
}
