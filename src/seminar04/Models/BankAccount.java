package seminar04.Models;

/**
 * Модель банковского аккаунта
 */
public class BankAccount {

    private long card;
    private int balance;

    public BankAccount() {
        balance = 1000;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }
}
