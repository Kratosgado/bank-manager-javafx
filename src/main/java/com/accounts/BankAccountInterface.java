package bank;

import java.util.HashMap;

public abstract class BankAccountInterface {
    private int numOfCustomerAccounts;
    private double moneyInAccount;
    private double moneyOutAccount;
    private HashMap clients;

    public  void saveData(){};
    public void loadData(){};
    public void makeDeposit(int accountNumber, double amt){};
    public void makeWithdrawal(int accountNumber, double amt){};
    public void addAccount(){};

}
