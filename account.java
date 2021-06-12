package tahir_Lab11;


import java.io.*;
import java.util.ArrayList;

public class account implements Serializable {
    private String Account_Number;
    private int bal;

    public account(String Account_Number, int bal){
        this.Account_Number=Account_Number;
        this.bal=bal;
    }

    public void setAccount_Number(String accNo) {
        Account_Number = accNo;
    }

    public void balSet(int bal) {
        this.bal = bal;
    }

    public int balget() {
        return bal;
    }

    public String getAccount_Number() {
        return Account_Number;
    }

    public void WD(int money){
        bal -=money;
        System.out.println("Money Withdrawn: "+money+"\nCurrent Balance: "+bal+"\n***************");
        



    }
    public void deposit(int money){
        bal +=money;
        System.out.println("Money Deposited: "+money);
        System.out.println("Current Balance:" + money+"\n***************");

    }

    public void transfer(account to, account from, int money){
        to.balSet(money+bal);
        from.balSet(money-bal);
        System.out.println(money+" transferred successfully.");

    }
    public void BalanceInquiry(){
        System.out.println("Current Balance: "+balget()+"\n***************");
    
    }

   
    public String toString() {
        return "Account Number: "+Account_Number+"\nBalance: "+bal;
    }
    public static void writeFile(ArrayList<account> record) {
        FileOutputStream bookStream;
        try {



            bookStream = new FileOutputStream("Account.txt");
            ObjectOutputStream objectStream = new ObjectOutputStream(bookStream);
            objectStream.writeObject(record.toString());
            objectStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(ArrayList<account> record) {

        try {



            FileInputStream inputStream = new FileInputStream("Account.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            System.out.println(objectInputStream.readObject());

            objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
