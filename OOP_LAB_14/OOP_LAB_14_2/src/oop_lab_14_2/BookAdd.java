
package oop_lab_14_2;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BookAdd{
    JFrame fr = new JFrame();
    BookView bv;
    String name;
    Double price;
    JTextField namet = new JTextField(15);
    JTextField pricet = new  JTextField(15);
    
    
    public BookAdd(BookView bv){
        this.bv = bv;
        JComboBox typet = new  JComboBox(bv.bookType);
        JPanel space = new JPanel();
        
        JPanel lp = new JPanel();
        lp.setLayout(new BoxLayout(lp, BoxLayout.Y_AXIS));
        JLabel namel = new JLabel("Name");
        JLabel pricel = new JLabel("Price");
        JLabel typel = new JLabel("Type");
        
        lp.add(namel);
        lp.add(pricel);
        lp.add(typel);
        
        JPanel rp = new JPanel();
        rp.setLayout(new BoxLayout(rp, BoxLayout.Y_AXIS));
        
       
        
        rp.add(namet);
        rp.add(pricet);
        rp.add(typet);
        
        JPanel btn = new JPanel();
        JButton insert = new JButton("Insert");
        btn.add(insert);
        
        JPanel tp = new JPanel(new FlowLayout());
        tp.add(lp);
        tp.add(space);
        tp.add(rp);
        
        
        insert.addActionListener(e-> insertBook(typet));
        
        fr.add(tp, BorderLayout.NORTH);
        fr.add(btn, BorderLayout.CENTER);
        fr.pack();
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
        
        
    }
    
    
    public void insertBook(JComboBox typet){
        name = namet.getText();
        price = Double.parseDouble(pricet.getText());
        String selectedType = (String) typet.getSelectedItem();
        new Book(name, price, selectedType);
        bv.updateVal(0);
        JOptionPane.showMessageDialog(null, "Done it.", "Information", JOptionPane.INFORMATION_MESSAGE);
        fr.dispose();
        
        
    }
    
    
    
}
