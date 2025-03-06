package oop_lab_12_1;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class chatDemo extends JFrame implements ActionListener {
    private JTextArea textA;
    private JTextField textField;
    private JButton submitBtn, resetBtn;
    private JPanel p, p2;

    ArrayList<String> store_text = new ArrayList<String>();
    
    public chatDemo() {
        textA = new JTextArea(20, 45);
        textField = new JTextField(45);
        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");

        textA.setEditable(false);

        JPanel p = new JPanel();
        p.add(textA);
        p.add(textField);

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(submitBtn);
        p2.add(resetBtn);

        p.add(p2);

        submitBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        this.add(p);
        this.pack();
        this.setSize(480, 450);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        loadFileHistory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = "";
        if(e.getSource()==submitBtn){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            store_text.add(dtf.format(LocalDateTime.now())+" "+textField.getText());
            updateFile();
        }
        else if(e.getSource()==resetBtn){
            store_text.clear();
            textA.setText("");
        }
    }


    public void updateFile() {
        try {
            String projectPath = System.getProperty("user.dir");
            File myFile = new File(projectPath + "/src/oop_lab_12_1/chatDemo.dat");
            
            try (FileWriter writer = new FileWriter(myFile, true)) {
                for (String line : store_text) {
                    writer.write(line + "\n");
                }
            }
        
            //Display
            StringBuilder newContent = new StringBuilder(textA.getText());
            for (String line : store_text) {
                newContent.append(line).append("\n");
            }
            textA.setText(newContent.toString());
            store_text.clear();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadFileHistory() {
        try {
            String projectPath = System.getProperty("user.dir");
            File myFile = new File(projectPath + "/src/oop_lab_12_1/chatDemo.dat");
    
            if (!myFile.exists()) {
                return;
            }
    
            try (Scanner reader = new Scanner(myFile)) {
                StringBuilder history = new StringBuilder();
                while (reader.hasNextLine()) {
                    history.append(reader.nextLine()).append("\n");
                }
                textA.setText(history.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "/src/oop_lab_12_1/chatDemo.dat");
        if (file.exists()) {
            new chatDemo();
        } 
        else{
            try {
                if (!file.exists()) {
                    boolean created = file.createNewFile();
                } 
                new chatDemo();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
    }
}
