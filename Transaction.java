import java.util.ArrayList;

public class Transaction {
    private String type;
    private int amount;

    public Transaction(String t, int a) {
        type = t;
        amount = a;
    }

    public static String add(Transaction t) {
        // add the transaction to the account history
        // if the account history is full, remove the oldest transaction
        // and add the new transaction to the account history
        if (accountHistory.size() == 10) {
            accountHistory.remove(0);
        }
        accountHistory.add(t);
        return null;
    }
    //create an account history array list
    public static ArrayList<Transaction> accountHistory = new ArrayList<Transaction>();



    public String getType() {
        Debug.trace("Transaction::getType: type = " + this.type);
        return this.type;
    }

    public int getAmount() {
        Debug.trace("Transaction::getAmount: amount = " + this.amount);
        return this.amount;
    }

    public static String getHistory() {
        String history = "";
        for (Transaction t : accountHistory) {
            history += t.getType() + " " + t.getAmount() + "\n";
        }
        return history;
    }
}