package io.swagger.Service;

import io.swagger.model.CreditCardInfo;
import io.swagger.model.Price;

public class FakePaymentService implements PaymentService {

    public String pay(String seller, CreditCardInfo creditCardInfo, Price price) {
        System.out.println("payment in process");
        return "Payment in process to: " + seller + "of " + price.getAmount() + price.getCurrency() + ".";
    }
}
