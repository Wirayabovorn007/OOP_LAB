
package oop_lab_14_2;

import java.util.*;

public class Book {

    private String name;
    private double price;
    private String type;
    
    private static ArrayList<Book> general = new ArrayList<>();
    private static ArrayList<Book> computer = new ArrayList<>();
    private static ArrayList<Book> mathNsci = new ArrayList<>();
    private static ArrayList<Book> photo3 = new ArrayList<>();
    
    public Book(){
        this("", 0.0, "");
    }
    
    public Book(String name, double price, String type){
        this.name = name;
        this.price = price;
        this.type = type; 
        
        switch(this.type){
            case "General" -> general.add(this);
            case "Computer" -> computer.add(this);
            case "Math&Sci" -> mathNsci.add(this);
            case "Photo3" -> photo3.add(this);
        }
        
        System.out.println("Create succes!");
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

    public ArrayList<Book> getGeneral() {
        return general;
    }

    public ArrayList<Book> getComputer() {
        return computer;
    }

    public ArrayList<Book> getMathNsci() {
        return mathNsci;
    }

    public ArrayList<Book> getPhoto3() {
        return photo3;
    }
    


    
}
