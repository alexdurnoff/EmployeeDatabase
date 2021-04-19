package entity;

import java.util.function.Predicate;

public enum Payment implements Predicate<Payment> {
    NULLPERCENT("0%"),
    FORTYPERCENT("40%"),
    FIFTYPERCENT("50%"),
    EIGHTYPERCENT("80%"),
    HUNDREDPERCENT("100%"),
    DEFAULTPAYMANET("Оплата")
    ;

    private final String title;

    Payment(String title){
        this.title = title;
    }

    @Override
    public boolean test(Payment payment) {
        return false;
    }


    @Override
    public String toString() {
        return title;
    }

    public static Payment paymentByTitle(String title){
        if (title.equals("0%")) return Payment.NULLPERCENT;
        if (title.equals("40%")) return Payment.FORTYPERCENT;
        if (title.equals("50%")) return Payment.FIFTYPERCENT;
        if (title.equals("80%")) return Payment.EIGHTYPERCENT;
        if (title.equals("100%")) return Payment.HUNDREDPERCENT;
        return Payment.DEFAULTPAYMANET;
    }
}
