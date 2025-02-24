package oop_lab11_2;

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
    
public void withdraw(double a) throws WithdrawException {
        if(this.balance - a < 0){
            throw new WithdrawException("Account "+this.name+" has not enough money.");
        }
        if (a>0 & this.balance-a >0){
            this.balance -= a;
            System.out.println(a+" baht is withdrawn from "+this.name+".");
        }
        else if(a<0){
            System.out.println("Input number must be a positive integer.");
        }
    }


    public void withdraw(String a) throws WithdrawException{
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
