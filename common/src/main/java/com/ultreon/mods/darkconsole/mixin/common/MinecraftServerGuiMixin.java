package com.ultreon.mods.darkconsole.mixin.common;

import com.ultreon.mods.darkconsole.ConstantsKt;
import com.ultreon.mods.darkconsole.DarkConsoleMod;
import com.ultreon.mods.darkconsole.Hooks;
import com.ultreon.mods.darkconsole.server.DarkConsoleModServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.gui.MinecraftServerGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.Objects;

@Mixin(MinecraftServerGui.class)
public class MinecraftServerGuiMixin {
    @Unique
    private static final Border dark_minecraft_console$BORDER = new LineBorder(new Color(255, 255, 255, ConstantsKt.GUI_BORDER_OPACITY), ConstantsKt.GUI_BORDER_THICKNESS, ConstantsKt.GUI_ROUNDED_BORDERS);

    @Redirect(method = "showFrameFor", at = @At(value = "INVOKE", target = "Ljavax/swing/UIManager;setLookAndFeel(Ljava/lang/String;)V"))
    private static void darkConsole$injectTheme(String lnfClass) {
        Font font;
        System.out.println("font = ");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(DarkConsoleMod.class.getResourceAsStream("/fira_code.ttf"), "Required resource 'fira_code' wasn't found"));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        DarkConsoleModServer.font = new Font(font.getName(), Font.PLAIN, 11);
        Hooks.INSTANCE.setupTheme();
    }

    @Redirect(method = "buildInfoPanel", at = @At(value = "NEW", target = "(Ljavax/swing/border/Border;Ljava/lang/String;)Ljavax/swing/border/TitledBorder;"))
    private TitledBorder darkConsole$redirectInfoPanelBorder(Border border, String title) {
        return new TitledBorder(dark_minecraft_console$BORDER, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, DarkConsoleModServer.font);
    }

    @Redirect(method = "buildPlayerPanel", at = @At(value = "NEW", target = "(Ljavax/swing/border/Border;Ljava/lang/String;)Ljavax/swing/border/TitledBorder;"))
    private TitledBorder darkConsole$redirectPlayerPanelBorder(Border border, String title) {
        return new TitledBorder(dark_minecraft_console$BORDER, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, DarkConsoleModServer.font);
    }

    @Redirect(method = "buildChatPanel", at = @At(value = "NEW", target = "(Ljavax/swing/border/Border;Ljava/lang/String;)Ljavax/swing/border/TitledBorder;"))
    private TitledBorder darkConsole$redirectChatPanelBorder(Border border, String title) {
        return new TitledBorder(dark_minecraft_console$BORDER, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, DarkConsoleModServer.font);
    }

    @Redirect(method = "buildChatPanel", at = @At(value = "INVOKE", target = "Ljavax/swing/JTextArea;addFocusListener(Ljava/awt/event/FocusListener;)V"))
    private void darkConsole$redirectChatPanelFont(JTextArea instance, FocusListener focusListener) {
        instance.setFont(DarkConsoleModServer.font);
        instance.addFocusListener(focusListener);
    }

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Inject(method = "showFrameFor", at = @At(value = "INVOKE", target = "Ljavax/swing/JFrame;setVisible(Z)V"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private static void darkConsole$injectMenuBar(DedicatedServer dedicatedServer, CallbackInfoReturnable<MinecraftServerGui> cir, JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        Hooks.INSTANCE.populateMenuBar(dedicatedServer, frame, menuBar);
        frame.setJMenuBar(menuBar);
    }
}
