package oop.lab.pkg7;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TellerGUI {
    public TellerGUI() {
        JFrame frame = new JFrame("Teller GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        String value = "6000";

        JPanel textFieldPanel = new JPanel();
        JTextField b = new JTextField(value);
        b.setEnabled(false);

        JTextField a = new JTextField();

        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
        b.setPreferredSize(new Dimension(140, 50));
        a.setPreferredSize(new Dimension(140, 50));
        textFieldPanel.add(b);
        textFieldPanel.add(a);

        JPanel labelPanel = new JPanel();
        JLabel balance = new JLabel("Balance");
        JLabel amount = new JLabel("Amount");
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        balance.setAlignmentX(Component.LEFT_ALIGNMENT);
        amount.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPanel.add(balance);
        labelPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        labelPanel.add(amount);

        JPanel spacePanel = new JPanel();
        spacePanel.setPreferredSize(new Dimension(60, 10));

        JPanel labelandfield = new JPanel();
        labelandfield.setLayout(new FlowLayout());
        labelandfield.add(labelPanel);
        labelandfield.add(spacePanel);
        labelandfield.add(textFieldPanel);

        Dimension btnSize = new Dimension(80, 30);
        JButton deposit = new JButton("Deposit");
        JButton withdraw = new JButton("Withdraw");
        JButton exit = new JButton("Exit");

        deposit.setPreferredSize(btnSize);
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                    double currentval = Double.parseDouble(b.getText());
                    double num = Double.parseDouble(a.getText());
                    currentval += num;
                    b.setText(String.valueOf(currentval));
               
            }
        });

        withdraw.setPreferredSize(btnSize);
        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    double currentval = Double.parseDouble(b.getText());
                    double num = Double.parseDouble(a.getText());
                    currentval -= num;
                    b.setText(String.valueOf(currentval));
                    
            }
        });

        exit.setPreferredSize(btnSize);
        exit.addActionListener(e -> System.exit(0));

        JPanel btnPanel = new JPanel();
        btnPanel.add(deposit);
        btnPanel.add(withdraw);
        btnPanel.add(exit);

        JPanel resultJPanel = new JPanel();
        resultJPanel.setLayout(new BoxLayout(resultJPanel, BoxLayout.Y_AXIS));
        resultJPanel.add(labelandfield);
        resultJPanel.add(btnPanel);

        frame.add(resultJPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TellerGUI();
    }
}
