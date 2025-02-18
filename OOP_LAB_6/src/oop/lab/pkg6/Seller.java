package oop.lab.pkg6;

public class Seller extends Employee{
    public Food sell(Employee e){
        if(e.getWallet().getBalance() >= Food.getPrice()){
            double food_price = Food.getPrice();
            double seller_wallet_balance = this.getWallet().getBalance();
            double employee_wallet_balance = e.getWallet().getBalance();
            this.getWallet().setBalance(seller_wallet_balance + food_price - 25);
            e.getWallet().setBalance(employee_wallet_balance - food_price + 25);
            return new Food();
        }
        System.out.println("Your money is not enough.");
        return null;
    }
}
