package ru.geekbrains.java.level_1.lesson_8;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private JTextField display;

    public Display() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridLayout(1, 1));

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        this.add(display);
    }

    public void setValue(String value) {
        this.display.setText(value);
    }
}
