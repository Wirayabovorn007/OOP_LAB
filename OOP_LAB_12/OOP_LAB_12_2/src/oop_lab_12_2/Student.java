package oop_lab_12_2;

import java.io.Serializable;

public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int ID;
    private int money;

    public Student(){
        this("", 0,0);
    }

    public Student(String name, int ID, int  money){
        this.name = name;
        this.ID = ID;
        this.money = money;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public String getName(){
        return this.name;
    }
    public int getID(){
        return this.ID;
    }
    public int getMoney(){
        return this.money;
    }

    
}
