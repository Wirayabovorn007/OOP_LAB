package oop.lab.pkg7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorSample extends JFrame implements ActionListener {
    private JTextField tf;
    private String n1 = "", n2 = "", op = "";

    public CalculatorSample() {
        setTitle("My Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tf = new JTextField();
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setEditable(true);
        add(tf, BorderLayout.NORTH);

        String[] buttons = {
            "7", "8", "9", "+", 
            "4", "5", "6", "-",
            "1", "2", "3", "x",
            "C", "0", "=", "/"
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        for (String t : buttons) {
            JButton btn = new JButton(t);
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("C")) {
            tf.setText("");
            n1 = n2 = op = "";
        } else if (cmd.equals("=")) {
            if (!n1.isEmpty() && !op.isEmpty() && !n2.isEmpty()) {
                double ans = calculate(Double.parseDouble(n1), Double.parseDouble(n2), op);
                tf.setText(String.valueOf(ans));
                n1 = String.valueOf(ans);
                n2 = op = "";
            }
        } else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("x") || cmd.equals("/")) {
            if (!n1.isEmpty()) {
                op = cmd;
                tf.setText("");
            }
        } else {
            if (op.isEmpty()) {
                n1 += cmd;
                tf.setText(n1);
            } else {
                n2 += cmd;
                tf.setText(n2);
            }
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "x": return num1 * num2;
            case "/": return num1 / num2;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        new CalculatorSample();
    }
}




