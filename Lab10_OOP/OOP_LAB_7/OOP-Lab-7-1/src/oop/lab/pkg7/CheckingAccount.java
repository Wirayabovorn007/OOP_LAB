package oop.lab.pkg7;

public class CheckingAccount extends Account {
    private double credit;

    public CheckingAccount(){
        super(0, "");
        this.credit = 0;
    }
    public CheckingAccount(double balance, String name, double credit){
        super(balance, name);
        this.credit = credit;
    }
    public void setCredit(double credit){
        if(credit > 0){
            this.credit = credit;
        }
        else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    public double getCredit(){
        return this.credit;
    }
    
    public void withdraw(double a){
        if(a>0){
            if(balance >= a){
                System.out.println(a+" baht is withdrawn from "+name+" and your credit balance is "+this.credit+".");
                balance -= a;
            }
            if(a > balance){
                if (this.credit > 0){
                    if (balance - a >0){
                    this.credit -= (a-balance);
                    balance = 0;
                    System.out.println(a+" baht is withdrawn from "+name+" and your credit balance is "+this.credit+".");
                    }
                }
                else{
                    System.out.println("Not enough money!");
                }
            }
        }
        
    }


    public void withdraw(String a){
        double amount = Double.valueOf(a);
        withdraw(amount);
    }

    public String toString(){
        if (name == ""){
            return "The"+name+" account has "+balance+" baht and "+this.credit+" credits.";
        }
        return "The "+name+" account has "+balance+" baht and "+this.credit+" credits.";
    }
}
