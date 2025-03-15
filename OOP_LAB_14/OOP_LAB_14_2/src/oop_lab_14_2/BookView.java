
package oop_lab_14_2;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;

public class BookView {
    
    Book b;
    
    JFrame frame = new JFrame();
    String bookType[] = {"General","Computer", "Math&Sci", "Photo3"};
    
    
    ArrayList<Book> selectedList = null;
    
    JComboBox cb = new JComboBox(bookType);
    
    int ind = 0;
    JTextField indtf = new JTextField(String.valueOf(ind));
    JTextField nametf = new JTextField();
   
    JTextField pricetf = new JTextField();
   
    public BookView(boolean show){
        frame.setVisible(show);
    }
    
    public BookView(){
        
        b =new Book();
        
         nametf.setPreferredSize(new Dimension(150, 40));
         pricetf.setPreferredSize(new Dimension(150, 40));
        
        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel space = new JPanel();
        
        
        JPanel LeftP = new JPanel();
        LeftP.setLayout(new BoxLayout(LeftP, BoxLayout.Y_AXIS));
        LeftP.setBorder(new EmptyBorder(0, 0, 0,20));
        JLabel name = new JLabel("Name");
        name.setBorder(new EmptyBorder(10,0,10,0));
        JLabel price = new JLabel("Price");
        price.setBorder(new EmptyBorder(10,0,10,0));
        JLabel type = new JLabel("Type");
        type.setBorder(new EmptyBorder(10,0,10,0));
        LeftP.add(name);
        LeftP.add(price);
        LeftP.add(type);
        
        JPanel rightP = new JPanel();
        rightP.setLayout(new BoxLayout(rightP, BoxLayout.Y_AXIS));
        
        
        cb.setPreferredSize(new Dimension(150, 40));
        rightP.add(nametf);
        rightP.add(pricetf);
        rightP.add(cb);
        
        topPanel.add(LeftP);
        topPanel.add(space);
        topPanel.add(rightP);

        
        JPanel midP = new JPanel(new FlowLayout());
        JButton prev = new JButton("<<<");
        prev.addActionListener(e->prev());
        
        JButton next = new JButton(">>>");
        next.addActionListener(e->next());
        
        midP.add(prev);
        midP.add(indtf);
        midP.add(next);
        
        JPanel bottomP = new JPanel(new FlowLayout());
        JButton add = new JButton("Add");
        add.addActionListener(e-> new BookAdd());
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        
        bottomP.add(add);
        bottomP.add(update);
        bottomP.add(delete);
        
        
        //Set value
        nametf.setText("");
        pricetf.setText("0.00");
        updateSelectedList();
        
        
        
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(midP, BorderLayout.CENTER);
        frame.add(bottomP, BorderLayout.SOUTH);
        
        
        
        
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
    
    public void updateVal(int index){
        
        //Update display
        indtf.setText(String.valueOf(index));
        nametf.setText(selectedList.get(index).getName());
        pricetf.setText(String.valueOf(selectedList.get(index).getPrice()));
        
    }
    
    
    
    public void next(){
        updateSelectedList();
        ind++;
        if(ind>selectedList.size()-1){
            ind=0;
        }
        updateVal(ind);
    }
    
       public void prev(){
        updateSelectedList();
        ind--;
        if(ind<0){
            ind=selectedList.size()-1;
        }
        
        updateVal(ind);
    }
       

    public void updateSelectedList(){
        String selectedType = (String) cb.getSelectedItem();
        switch(selectedType){
            case "General" -> selectedList = b.getGeneral();
            case "Computer" -> selectedList = b.getComputer();
            case "Math&Sci" -> selectedList = b.getMathNsci();
            case "Photo3" -> selectedList = b.getPhoto3();
        }
    }
    
    
    public static void main(String[] args) {
        new BookView();
    }
    
    
}
