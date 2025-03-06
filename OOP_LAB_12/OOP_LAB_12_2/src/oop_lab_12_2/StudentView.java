package oop_lab_12_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;


public class StudentView extends JFrame implements ActionListener{
    public String user_name = "";
    public int user_id = 0;
    public int user_money = 0;
    
    JButton deposit = new JButton("Deposit");
    JButton withdraw = new JButton("Withdraw");
    JTextField id_textfield = new JTextField(10);  
    JTextField name_textfield = new JTextField(10);
    JTextField money_textfield = new JTextField(10);

    String projectPath = System.getProperty("user.dir");
    File myFile = new File(projectPath + "/src/oop_lab_12_2/StudentM.dat");

    public StudentView(){
        
        loadFileHistory();

        JPanel mainPanel = new JPanel();

        JLabel id = new JLabel("ID:");
        JLabel name = new JLabel("Name:");
        JLabel money = new JLabel("Money:");

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.add(id);
        labelPanel.add(name);
        labelPanel.add(money);

        money_textfield.setEditable(false);
        money_textfield.setText(String.valueOf(user_money));

        JPanel tfPanel = new  JPanel();
        tfPanel.setLayout(new BoxLayout(tfPanel, BoxLayout.Y_AXIS));
        tfPanel.add(id_textfield);
        tfPanel.add(name_textfield);
        tfPanel.add(money_textfield);

        JPanel buttoPanel = new JPanel();
        buttoPanel.add(deposit);
        buttoPanel.add(withdraw);

        mainPanel.add(labelPanel);
        mainPanel.add(tfPanel);
        mainPanel.add(buttoPanel);



        deposit.addActionListener(this);
        withdraw.addActionListener(this);

        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(250,150);
        this.setVisible(true);


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                user_name = name_textfield.getText();
                String idText = id_textfield.getText().trim();
                user_id = idText.isEmpty() ? 0 : Integer.parseInt(idText);
                Student newStd = new Student(user_name, user_id, user_money);
        
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(myFile))) {
                    out.writeObject(newStd);
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }));

    }
        



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            user_money+=100;
        }
        if(e.getSource() == withdraw){
            if(user_money - 100 < 0){
                user_money = 0;
            }
            else{
                user_money -= 100;
            }
        }
        money_textfield.setText(String.valueOf(user_money));
    }

    public void loadFileHistory() {
        if (!myFile.exists() || myFile.length() == 0) {
            return;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(myFile))) {
            Student savedStudent = (Student) in.readObject();
            user_name = savedStudent.getName();
            user_id = savedStudent.getID();
            user_money = savedStudent.getMoney();
    
            name_textfield.setText(user_name);
            id_textfield.setText(String.valueOf(user_id));
            money_textfield.setText(String.valueOf(user_money));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "/src/oop_lab_12_2/StudentM.dat");
        if (file.exists()) {
            new StudentView();
        } 
        else{
            try {
                if (!file.exists()) {
                    boolean created = file.createNewFile();
                } 
                new StudentView();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
    }
    
}
