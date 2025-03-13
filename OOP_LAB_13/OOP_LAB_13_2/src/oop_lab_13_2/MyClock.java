package oop_lab_13_2;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class MyClock extends JLabel implements Runnable {

   
    
    public MyClock(){  }
    
    public void run(){
       while(true){
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            this.setText(String.format("%02d:%02d:%02d", hour, min, sec));
            this.setFont(new Font("Arial", Font.PLAIN, 84));
            
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
                break;
            }
            
        }
    }
}
