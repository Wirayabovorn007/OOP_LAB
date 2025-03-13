
package oop_lab_13_3;


import javax.swing.*;
import java.awt.*;


public class MyFrame {
    MyClock clock;
   
    
    public MyFrame(){
        
        JFrame fr = new JFrame("My Timer");
        
        
        clock = new MyClock();
        
        fr.add(clock, BorderLayout.CENTER);
       
        fr.setSize(350, 300);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Thread t = new Thread(clock);
        t.start();
         
    }
    
    public static void main(String[] args) {
        new MyFrame();
        
    }
}

