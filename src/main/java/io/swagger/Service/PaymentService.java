package io.swagger.Service;

import io.swagger.model.CreditCardInfo;
import io.swagger.model.Price;

public interface PaymentService {
    String pay(String seller, CreditCardInfo creditCardInfo, Price price);
}
