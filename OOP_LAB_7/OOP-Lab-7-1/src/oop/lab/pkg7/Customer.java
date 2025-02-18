package oop.lab.pkg7;

public class Customer {
    private String firstname;
    private String lastname;
    private CheckingAccount acct;

    public Customer(){
        this("", "", null);
    }

    public Customer(String firstname, String lastname){
        this(firstname, lastname, null);
    }

    public Customer(String firstname, String lastname, CheckingAccount acct){
        this.firstname = firstname;
        this.lastname = lastname;
        this.acct = acct;
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
        if (this.acct == null){
            return this.firstname+" "+this.lastname+" doesn't have account.";
        }
        else{
            return "The "+this.firstname+" account has "+this.acct.getBalance()+" baht and "+this.acct.getCredit()+" credits.";
        }
    }

    public boolean equals(Customer c){
        if(c == null){
            return false;
        }
        return this.firstname.equals(c.firstname) && this.lastname.equals(c.lastname);
    }

}
