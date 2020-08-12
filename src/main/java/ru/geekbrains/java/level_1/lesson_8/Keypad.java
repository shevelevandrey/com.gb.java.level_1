package ru.geekbrains.java.level_1.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Keypad extends JPanel {

    private final ActionListener actionListener;
    private final String keys = "789/456*123-C0=+";

    public Keypad(ActionListener actionListener){
        this.actionListener = actionListener;
        initComponents();
    }

    private void initComponents(){
        this.setLayout(new GridLayout(4,4));

        for (int i = 0; i < keys.length(); i++) {
            JButton button = new JButton(keys.substring(i, i + 1));
            button.addActionListener(actionListener);
            this.add(button);
        }
    }
}