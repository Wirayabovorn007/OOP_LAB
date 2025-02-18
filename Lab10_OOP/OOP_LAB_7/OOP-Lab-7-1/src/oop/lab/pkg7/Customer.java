package oop.lab.pkg7;
import java.util.ArrayList;

public class Customer {
    private String firstname;
    private String lastname;
    private ArrayList<Account> acct;
    private int numOfAccount=0;

    public Customer(){
        this("", "");
    }

    public Customer(String firstname, String lastname){
        this.setFirstName(firstname);
        this.setLastName(lastname);
        acct = new ArrayList<Account>();
    }


    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public String getFirstName(){
        return this.firstname;
    }

    public void setLastName(String lastname){
        this.lastname = lastname;
    }

    public String getLastName(){
        return this.lastname;
    }

    public void setAcct(CheckingAccount acct){
        this.acct = acct;
    }

    public CheckingAccount getAcct(){
        return this.acct;
    }


    public String toString(){
            return "The "+this.firstname+" account has "+numOfAccount+" accounts.";
    }

    public boolean equals(Customer c){
        if(c == null){
            return false;
        }
        return this.firstname.equals(c.firstname) && this.lastname.equals(c.lastname);
    }




    //Lab10
    public Account getAccount(int index){
        return acct.get(index);
    }
    public void addAccount(Account acct){
        this.acct.add(acct);
        numOfAccount+=1;
    }
    public int getNumOfAccount(){
        return acct.size();
    }

}
