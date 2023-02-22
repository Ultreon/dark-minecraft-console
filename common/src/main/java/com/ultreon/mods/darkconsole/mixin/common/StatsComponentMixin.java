
/*
 * Copyright (c) 2022. - Qboi SMP Development Team
 * Do NOT redistribute, or copy in any way, and do NOT modify in any way.
 * It is not allowed to hack into the code, use cheats against the code and/or compiled form.
 * And it is not allowed to decompile, modify or/and patch parts of code or classes or in full form.
 * Sharing this file isn't allowed either, and is hereby strictly forbidden.
 * Sharing decompiled code on social media or an online platform will cause in a report on that account.
 *
 * ONLY the owner can bypass these rules.
 */

package com.ultreon.mods.darkconsole.mixin.common;

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
    @Redirect(method = "paint", at = @At(value = "NEW", target = "java/awt/Color", ordinal = 0, remap = false), remap = false)
    public Color essentials$replaceBackground(int rgb) {
        return new Color(0x00000000, true);
    }

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void essentials$replaceBackground1(MinecraftServer pServer, CallbackInfo ci) {
        setBackground(new Color(0x00000000, true));
    }

    @Redirect(method = "paint", at = @At(value = "NEW", target = "java/awt/Color", ordinal = 1, remap = false), remap = false)
    public Color essentials$replaceBarColor(int rgb) {
        return new Color(rgb).brighter().brighter().brighter();
    }

    @Redirect(method = "paint", at = @At(value = "FIELD", target = "Ljava/awt/Color;BLACK:Ljava/awt/Color;", ordinal = 0, remap = false), remap = false)
    public Color essentials$replaceTextColor() {
        return Color.WHITE;
    }
}