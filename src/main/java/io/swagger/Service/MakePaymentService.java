package io.swagger.Service;

import io.swagger.model.Payment;
import io.swagger.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class MakePaymentService {
    @Autowired
    private PaymentService paymentService;

    public List<String> makePayment(@Valid List<Payment> payments) {
        List<String> res =  new ArrayList();
        payments.forEach(payment ->
            res.add(paymentService.pay(payment.getSellerAccount(),
                            payment.getCreditCardInfo().get(0),
                            new Price(payment.getAmount(), payment.getCurrency())
                    ))
        );
        return res;
    }

    public void updatePaymentStatus(boolean status) {
        /*
            TODO: 02/06/2022
             callback function after payment service is done.
             We should expose a route for the payment service to call to update status.
             True = paid
             False = failed
         */
    }
}
