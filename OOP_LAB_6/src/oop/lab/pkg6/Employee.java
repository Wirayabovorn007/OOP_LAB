package oop.lab.pkg6;

public class Employee {
    private int energy;
    private String name;
    private Wallet wallet;
    private static String nationality = "Thai";

    public int getEnergy(){
        return this.energy;
    }
    public String getName(){
        return this.name;
    }
    public static String getNationality(){
        return Employee.nationality;
    }
    public Wallet getWallet(){
        return this.wallet;
    }
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public void setName(String name){
        this.name = name;
    }
    public static void setNationality(String nationality){
        Employee.nationality = nationality;
    }
    public void setWallet(Wallet wallet){
        this.wallet = wallet;
    }
    public boolean buyFood(Seller s){
        if(s.sell(this) != null){
            this.eat(s.sell(this));
            return true;
        }
        return false;
    }
    public void eat(Food f){
        this.energy+=Food.getEnergy();
    }
    public boolean equals(Employee e){
        return this.name.equals(e.name);
    }
    public String toString(){
        return "My name is "+this.name+".\nI have "+this.energy+" energy left.\nI have a balance of "+wallet.getBalance()+" baht.";
    }

}
