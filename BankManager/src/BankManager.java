public class BankManager {

    public static void main(String [] args){

        System.out.println("Bank Manager Example");
        CheckingAccounts ca = new CheckingAccounts();
        SavingsAccounts sa = new SavingsAccounts();
        CODAccounts coda = new CODAccounts();
        System.out.println(ca.returnAccount());
        System.out.println(sa.returnAccount());
        System.out.println(coda.returnAccount());
        //inheritance example
    }
}

class BankAccount{

    String account;
    String balance;
    BankAccount(){
        this.account = " ";
        this.balance = " ";
    }
    BankAccount(String inputAcc, String inputBal){
        this.account = inputAcc;
        this.balance = inputBal;

    }
    String returnAccount(){
        return account;
    }

}

class CheckingAccounts extends BankAccount{
    Integer limit;
    String check = "check";
    String cbalance = "1337";
    CheckingAccounts(){
        this.account = check;
        this.balance = cbalance;
    }

}

class SavingsAccounts extends BankAccount{
    Integer limit;

    String check = "savings";
    String cbalance = "1337";
    SavingsAccounts(){
        this.account = check;
        this.balance = cbalance;
    }

}

class CODAccounts extends BankAccount{
    Integer limit;

    String check = "COD";
    String cbalance = "7331";
    CODAccounts(){
        this.account = check;
        this.balance = cbalance;
    }

}