package com.bank;

import javafx.scene.control.Button;

public class BButton extends Button {

    public BButton(
            String text,
            String style) {
        super(text);
        this.setStyle(style);
    }

    public BButton(String text) {
        this(text, Styles.BUTTON_STYLE);
    }
}