package ru.geekbrains.java.level_1.lesson_8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Calculator extends JFrame implements ActionListener {

    private double operand1;
    private boolean isDotPressed = false;
    private final StringBuilder displayValue;
    private int operandCount = 0;
    private Operator previousOperator = null;
    private Display display;

    private enum Operator { EQUAL, PLUS, MINUS, MULTIPLY, DIVIDE; }

    public Calculator(String title) {
        super(title);
        displayValue = new StringBuilder(32);
        initComponents();
        setSize(230, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        display = new Display();
        panel.add(display);

        panel.add(new Keypad(this));
        this.add(panel);

        this.setVisible(true);
    }

    private void clearDisplay() {
        displayValue.delete(0, displayValue.length());
        display.setValue("0");
    }

    private void pressedNumber(String number) {
        if (this.previousOperator == Operator.EQUAL) {
            previousOperator = null;
            clearDisplay();
            isDotPressed = false;
        }

        displayValue.append(number);
        display.setValue(displayValue.toString());
    }

    private void pressedClear() {
        previousOperator = null;
        operand1 = 0;
        clearDisplay();
        operandCount = 0;
    }

    private void calculate(Operator operator, double b) {
        if (operator == Operator.PLUS)
            operand1 += b;
        else if (operator == Operator.MINUS)
            operand1 -= b;
        else if (operator == Operator.MULTIPLY)
            operand1 *= b;
        else if (operator == Operator.DIVIDE)
            operand1 /= b;
    }

    private void pressedOperator(Operator operator) {

        double operand2 = (displayValue.length() > 0) ? Double.parseDouble(displayValue.toString()) : operand1;

        if (operator == Operator.EQUAL) {
            calculate(previousOperator, operand2);
            operandCount = 0;
        } else {
            operandCount++;
            if (operandCount > 1) {
                calculate(operator, operand2);
            }else{
                operand1 = operand2;
            }
            clearDisplay();
        }
        if (isDotPressed) {
            display.setValue("" + operand1);
        } else {
            display.setValue("" + (long) operand1);
        }
        this.previousOperator = operator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().charAt(0) >= '0' && e.getActionCommand().charAt(0) <= '9')
            pressedNumber(e.getActionCommand());
        else if (e.getActionCommand().charAt(0) == '=')
            pressedOperator(Operator.EQUAL);
        else if (e.getActionCommand().charAt(0) == '+')
            pressedOperator(Operator.PLUS);
        else if (e.getActionCommand().charAt(0) == '-')
            pressedOperator(Operator.MINUS);
        else if (e.getActionCommand().charAt(0) == '*')
            pressedOperator(Operator.MULTIPLY);
        else if (e.getActionCommand().charAt(0) == '/')
            pressedOperator(Operator.DIVIDE);
        else if (e.getActionCommand().charAt(0) == 'C')
            pressedClear();

    }
}