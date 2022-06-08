package sdfworkshop2;

import main.java.sdfworkshop2.BankAccount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My ATM Machine - POSSBank");
        BankAccount bkAcc = new BankAccount("Jumbo");
        bkAcc.deposit("1000");
        System.out.println("My new account balance >" + bkAcc.getBalance());
        bkAcc.withdraw("0");
        

    }
}
