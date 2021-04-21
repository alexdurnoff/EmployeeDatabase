package entity.payment;

import entity.EntityView;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.function.Predicate;

public enum PaymentView implements Predicate<PaymentView>, EntityView {
    NULLPERCENT("0%"),
    FORTYPERCENT("40%"),
    FIFTYPERCENT("50%"),
    EIGHTYPERCENT("80%"),
    HUNDREDPERCENT("100%"),
    DEFAULTPAYMANET("Оплата")
    ;

    private final String title;
    private final ChoiceBox<PaymentView> choiceBox;

    PaymentView(String title){
        this.title = title;
        this.choiceBox = new PaymentChoiceBox();
    }

    @Override
    public boolean test(PaymentView paymentView) {
        return false;
    }


    @Override
    public String toString() {
        return title;
    }

    public PaymentView paymentViewByTitle(String string){
        PaymentView[] values = values();
        for (PaymentView paymentView : values){
            if (paymentView.title.equals(string)) return paymentView;
        }
        return PaymentView.DEFAULTPAYMANET;
    }

    public static PaymentView paymentByTitle(String title){
        if (title.equals("0%")) return PaymentView.NULLPERCENT;
        if (title.equals("40%")) return PaymentView.FORTYPERCENT;
        if (title.equals("50%")) return PaymentView.FIFTYPERCENT;
        if (title.equals("80%")) return PaymentView.EIGHTYPERCENT;
        if (title.equals("100%")) return PaymentView.HUNDREDPERCENT;
        return PaymentView.DEFAULTPAYMANET;
    }

    public void addToGridPane(GridPane gridPane, int rowNumber){
        Label label = new Label("оплата в процентах");
        gridPane.add(label, 0, rowNumber);
        gridPane.add(choiceBox, 1, rowNumber);
    }

    @Override
    public String requestPart() {
        return "set payment = " +
                "'" +
                userChoice() +
                "'";
    }

    public PaymentView userChoice(){
        return this.choiceBox.getValue();
    }
}
