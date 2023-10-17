package com.ultreon.mods.darkconsole.mixin.common;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

class FuncAction extends AbstractAction {
    private Consumer<ActionEvent> actionPerformed;

    public FuncAction(Consumer<ActionEvent> actionPerformed) {
        this.actionPerformed = actionPerformed;
    }

    public FuncAction(String name, Consumer<ActionEvent> actionPerformed) {
        super(name);
        this.actionPerformed = actionPerformed;
    }

    public FuncAction(String name, Icon icon, Consumer<ActionEvent> actionPerformed) {
        super(name, icon);
        this.actionPerformed = actionPerformed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.actionPerformed.accept(e);
    }
}
