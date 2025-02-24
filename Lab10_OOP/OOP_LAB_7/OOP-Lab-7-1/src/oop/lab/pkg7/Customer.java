package oop.lab.pkg7;
import java.util.ArrayList;

public class Customer {
    private String firstname;
    private String lastname;
    private ArrayList<Account> acct;

    public Customer() {
        this("", "");
    }

    public Customer(String firstname, String lastname) {
        this.setFirstName(firstname);
        this.setLastName(lastname);
        acct = new ArrayList<>();
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getLastName() {
        return this.lastname;
    }

    public Account getAccount(int index) {
        return acct.get(index);
    }

    public void addAccount(Account acct) {
        this.acct.add(acct);
    }

    public int getNumOfAccount() {
        return acct.size();
    }

    @Override
    public String toString() {
        return "The customer " + this.firstname + " " + this.lastname + " has " + getNumOfAccount() + " accounts.";
    }

    public boolean equals(Customer c) {
        if (c == null) {
            return false;
        }
        return this.firstname.equals(c.firstname) && this.lastname.equals(c.lastname);
    }
}
