package objects.vietjet;

import enums.vietjet.FlyType;

public class BookingInfo {
    FlyType flyType = FlyType.RETURN;
    String from;
    String to;
    int fromDate;
    int toDate;
    Passengers passengers = new Passengers.Builder().setAdults(1).build();
    String promotionCode = "";
    Boolean findLowestFare = false;

    public BookingInfo(String from, String to, int fromDate, int toDate) {
        this.from = from;
        this.to = to;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public BookingInfo(FlyType flyType, String from, String to, int fromDate, int toDate, Passengers passengers, String promotionCode, Boolean findLowestFare) {
        this.flyType = flyType;
        this.from = from;
        this.to = to;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.passengers = passengers;
        this.promotionCode = promotionCode;
        this.findLowestFare = findLowestFare;
    }

    public FlyType getFlyType() {
        return flyType;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getFromDate() {
        return fromDate;
    }

    public int getToDate() {
        return toDate;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public Boolean getFindLowestFare() {
        return findLowestFare;
    }

}
