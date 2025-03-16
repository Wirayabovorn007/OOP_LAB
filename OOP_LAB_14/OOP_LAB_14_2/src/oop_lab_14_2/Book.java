
package oop_lab_14_2;

import java.util.*;
import javax.swing.JOptionPane;
import java.io.*;

public class Book implements Serializable{
    
    public static File file = new File("src/oop_lab_14_2/bookData.dat");

    private String name;
    private double price;
    private String type;
    
    private static ArrayList<Book> book = new ArrayList<>();
    
    public Book(){
        this("", 0.0, "");
    }
    
    public Book(String name, double price, String type){
        this.name = name;
        this.price = price;
        this.type = type; 
        
        book.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Book> getBook() {
        return book;
    }
    
    
    public void updateBook(int index, String name, double price, String type){
        Book editingB = book.get(index);
        editingB.setName(name);
        editingB.setPrice(price);
        editingB.setType(type);
        
        JOptionPane.showMessageDialog(null, "Done it.");
    }
    
    public void deleteBook(int index){
        book.remove(index);
        JOptionPane.showMessageDialog(null, "Done it.");
    }
    
    public void saveData(){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))){
            os.writeObject(new ArrayList<>(book));
            System.out.println("Data Save!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadData(){
        
        if(!file.exists() || file.length() ==0){
            return;
        }
        
        if(fileExist()){
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                Object obj = in.readObject();
                if(obj instanceof ArrayList<?>){
                    System.out.println("Reading BOOK obj");
                    book = (ArrayList<Book>) obj;
                }
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
        }
        }
        else{
            createFile();
        }
    }
    
    public void createFile(){
        try{
           file.createNewFile();    
            }catch(IOException e){
                    e.printStackTrace();
           }
        loadData();
        }
    
    
    public static boolean fileExist(){
        return file.exists();
    }
    
}
