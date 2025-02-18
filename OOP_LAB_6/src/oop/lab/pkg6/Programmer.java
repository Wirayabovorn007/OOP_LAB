package oop.lab.pkg6;

public class Programmer extends Employee{
    private int happiness;

    public int getHappiness(){
        return this.happiness;
    }
    public void setHappiness(int happiness){
        this.happiness = happiness;
    }


    public void coding(String str){
        if(getEnergy() >= 30){
            System.out.println("Your code is "+str);
            setEnergy(getEnergy() - 30);
            setHappiness(getHappiness() - 30);
        }
        else{
            System.out.println("Error Error Error");
            setEnergy(getEnergy() - 30);
            setHappiness(getHappiness() - 30);
        }
    }

    
    public void coding(char str){
        String tostr = Character.toString(str);
        coding(tostr);
    }
}
