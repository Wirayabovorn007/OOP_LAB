
package oop_lab_13_4;


import javax.swing.*;
import java.awt.*;


public class MyFrame {
    MyCock cock;
   
    
    public MyFrame(){
        
        JFrame fr = new JFrame("My Timer");
        
        
        cock = new MyCock();
        
        fr.add(cock, BorderLayout.CENTER);
       
        fr.setSize(350, 300);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Thread t = new Thread(cock);
        t.start();
         
    }
    
    public static void main(String[] args) {
        new MyFrame();
        
    }
}


