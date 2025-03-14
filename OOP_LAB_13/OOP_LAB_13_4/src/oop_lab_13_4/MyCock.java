
package oop_lab_13_4;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class MyCock extends JLabel implements Runnable {

   private int seconds = 0;
   private boolean running = true;
   private Thread t;
   
    
    public MyCock(){
        this.setFont(new Font("Arial", Font.BOLD, 84));
        this.setText("00:00:00");
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(!running){
                    start();
                }
                else{
                    stop();
                }
            }
        });
    }
    
    public void run(){
        running = true;
       while(running){
           
           int hour = seconds /3600;
           int min = (seconds % 3600)/60;
           int sec = seconds %60;
           
            this.setText(String.format("%02d:%02d:%02d", hour, min, sec));
            
            seconds++;
            
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
                running = false;
            }
            
        }
    }
    
    public void start(){
        running = true;
        t = new Thread(this);
        t.start();
    }
    
    public void stop(){
          running = false;
      }
    
}