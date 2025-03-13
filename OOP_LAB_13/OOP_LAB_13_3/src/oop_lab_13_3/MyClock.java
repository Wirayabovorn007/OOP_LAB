package oop_lab_13_3;


import javax.swing.*;
import java.util.*;
import java.awt.*;

public class MyClock extends JLabel implements Runnable {

   private int seconds = 0;
   
    
    public MyClock(){
        this.setFont(new Font("Arial", Font.PLAIN, 84));
        this.setText("00:00:00");
    }
    
    public void run(){
       while(true){
           
           int hour = seconds /3600;
           int min = (seconds % 3600)/60;
           int sec = seconds %60;
           
            this.setText(String.format("%02d:%02d:%02d", hour, min, sec));
            
            seconds++;
            
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
                break;
            }
            
        }
    }
}
