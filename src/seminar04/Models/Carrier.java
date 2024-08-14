package seminar04.Models;

/**
 * Модель перевозчика
 */
public class Carrier {

    private int id;
    private long cardNumber;

    public Carrier(int id, long cardNumber) {
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getId() {
        return id;
    }


}
