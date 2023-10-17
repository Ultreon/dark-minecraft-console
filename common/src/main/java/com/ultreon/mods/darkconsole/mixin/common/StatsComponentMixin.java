package com.ultreon.mods.darkconsole.mixin.common;

import com.ultreon.mods.darkconsole.server.DarkConsoleModServer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.StatsComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.swing.*;
import java.awt.*;

@Mixin(StatsComponent.class)
public abstract class StatsComponentMixin extends JComponent {
    @Redirect(method = "paint", at = @At(value = "NEW", target = "(I)Ljava/awt/Color;", ordinal = 0, remap = false), remap = false)
    public Color darkConsole$replaceBackground(int rgb) {
        return new Color(0x00000000, true);
    }

    @Inject(method = "paint", at = @At(value = "INVOKE", target = "Ljava/awt/Graphics;setColor(Ljava/awt/Color;)V"), remap = false)
    public void darkConsole$injectFont(Graphics graphics, CallbackInfo ci) {
        ((Graphics2D)graphics).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        ((Graphics2D)graphics).setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 120);
        graphics.setFont(DarkConsoleModServer.font);
    }

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void darkConsole$replaceBackground1(MinecraftServer pServer, CallbackInfo ci) {
        setBackground(new Color(0x00000000, true));
        setFont(DarkConsoleModServer.font);
    }

    @Redirect(method = "paint", at = @At(value = "NEW", target = "(I)Ljava/awt/Color;", ordinal = 1, remap = false), remap = false)
    public Color darkConsole$replaceBarColor(int rgb) {
        return new Color(rgb).brighter().brighter().brighter();
    }

    @Redirect(method = "paint", at = @At(value = "FIELD", target = "Ljava/awt/Color;BLACK:Ljava/awt/Color;", ordinal = 0, remap = false), remap = false)
    public Color darkConsole$replaceTextColor() {
        return Color.WHITE;
    }
}