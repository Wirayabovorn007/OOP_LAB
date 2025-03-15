
package oop_lab_14_1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;


public class TextEditor {
    JFrame frame = new JFrame("Notepad");
    JTextArea ta = new JTextArea();
    
    public TextEditor(){
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        ta.setFont(new Font("Arial",Font.BOLD, 18));
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem New = new JMenuItem("New");
        JMenuItem Open = new JMenuItem("Open");
        JMenuItem Save = new JMenuItem("Save");
        JMenuItem Close = new JMenuItem("Close");
        
        menu.add(New);
        menu.add(Open);
        menu.add(Save);
        menu.add(Close);
        
        Close.addActionListener(e-> System.exit(0));
        New.addActionListener(e-> ta.setText(""));
        Open.addActionListener(e-> ChooseFile());
        Save.addActionListener(e->SaveFile());
        
        
        menuBar.add(menu);
        
        frame.setJMenuBar(menuBar);
        frame.add(ta);
        
        frame.setVisible(true);
        
        
        
        
    }
    
    
    public void SaveFile(){
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(frame);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
                ta.write(bw);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void ChooseFile(){
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(frame);
        int returnVal = fc.showOpenDialog(frame);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            try(BufferedReader reader = new BufferedReader(new FileReader(f))){
                ta.read(reader, null);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        
        
        
        
    }
    
    
    public static void main(String[] args) {
        new TextEditor();
    }
    
}
