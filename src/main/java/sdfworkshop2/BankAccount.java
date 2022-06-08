package main.java.sdfworkshop2;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;
import java.utils.List;

public class sdfworkshop2 {

    //properties
    private String name ="";
    private String accId = UUID.randomUUID().toString().substring(0,8);
    private float balance = 0f;
    //transaction list on bankaccount object
    private List<String> transaction = new LinkedList<>();
    private boolean isClosed = false;
    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    //constructors
    //with bank account name
    public BankAccount(String name){
        this.name = name;
    }
    // with bank account name, initial balance
    public BankAccount(String name, float initialBal){
        this.name = name;
        this.balance = initialBal;
    }

    //get set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public Date getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    protected float withdraw(float awithdrawAmt){
        Float withdrawAmt = null;
        try{
            withdrawAmt = Float.parseFloat(awithdrawAmt);
            
            //invalid amount
            if (withdrawAmt.floatValue() <= 0){
                throw new IllegalArgumentException("Amount cannot be zero or negative");
            }
            
            //account is closed
            if(this.isClosed){
                throw new IllegalArgumentException("Amount is closed");
            }

            this.balance -= withdrawAmt().floatValue();
            //construct the transaction history event log;
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(depositAmt.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld);
            //save event log into the txn linkedList
            transaction.add(txnStrbld.toString);
            //update the withdrawal amount
            

        }catch(NumberFormatException e){
            //invalid ammount
            System.out.println(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        return withdrawAmt;
    }

    protected void deposit(String adepositAmt){
        try{
            Float depositAmt = Float.parseFloat(adepositAmt);
            
            //invalid amount
            if (depositAmt.floatValue() <= 0){
                throw new IllegalArgumentException("Amount cannot be zero or negative");
            }
            
            //account is closed
            if(this.isClosed){
                throw new IllegalArgumentException("Amount is closed");
            }

            this.balance += depositAmt().floatValue();
            //construct the transaction history event log;
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmt.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld);
            //save event log into the txn linkedList
            transaction.add(txnStrbld.toString);
            //update the deposit amount
            

        }catch(NumberFormatException e){
            //invalid ammount
            System.out.println(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
    }
}
