package objects.vietjet;

public class Trade {
    private String buyCcy;
    private String sellCcy;
    private String amount;
    private String date;

    /**
     * These fields are growing and may have around 10 or more....
     * private String tradeType;
     * private String company;
     */

    public Trade() {
    }

    public Trade(String buyCcy, String sellCcy, String amount, String date) {
        this.buyCcy = buyCcy;
        this.sellCcy = sellCcy;
        this.amount = amount;
        this.date = date;
    }

    /**
     * accessors here....
     */
}
