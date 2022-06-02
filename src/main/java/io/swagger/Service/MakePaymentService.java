package io.swagger.Service;

import io.swagger.model.Payment;
import io.swagger.model.Price;
import org.springframework.beans.factory.annotation.Autowired;

public class MakePaymentService {
    @Autowired
    private PaymentService paymentService;

    public void makePayment(Payment payment) {
        paymentService.pay(payment.getSellerAccount(),
                        payment.getCreditCardInfo().get(0),
                        new Price(payment.getAmount(), payment.getCurrency())
                );
    }
}
