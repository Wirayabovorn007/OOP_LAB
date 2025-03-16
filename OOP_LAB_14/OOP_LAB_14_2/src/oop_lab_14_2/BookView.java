
package oop_lab_14_2;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
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
   
    public BookView(){
        
        b =new Book();
        b.loadData();
        
        selectedList = b.getBook();
        
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
        add.addActionListener(e-> new BookAdd(this));
        JButton update = new JButton("Update");
        
        update.addActionListener(e-> b.updateBook(ind, nametf.getText(), Double.valueOf(pricetf.getText()),String.valueOf( cb.getSelectedItem())));
        
        JButton delete = new JButton("Delete");
        delete.addActionListener(e->b.deleteBook(ind));
        
        bottomP.add(add);
        bottomP.add(update);
        bottomP.add(delete);
        
        
        
        
        
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(midP, BorderLayout.CENTER);
        frame.add(bottomP, BorderLayout.SOUTH);
        
        
        
        
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                b.saveData();
                System.exit(0);
            }
            
        });
        frame.setVisible(true);
        
        
    }
    
    public void updateVal(int index){
        
        //Update display
        indtf.setText(String.valueOf(index));
        nametf.setText(selectedList.get(index).getName());
        pricetf.setText(String.valueOf(selectedList.get(index).getPrice()));
        cb.setSelectedItem(selectedList.get(index).getType());
        
    }
    
    
    
    public void next(){
        ind++;
        if(ind>selectedList.size()-1){
            ind=0;
        }
        updateVal(ind);
    }
    
       public void prev(){
        ind--;
        if(ind<0){
            ind=selectedList.size()-1;
        }
        
        updateVal(ind);
    }
       

    
    
    
    public static void main(String[] args) {
        new BookView();
    }
    
    
}
