package io.swagger.Service;

import io.swagger.model.Payment;
import io.swagger.model.Price;
import io.swagger.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MakePaymentService {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RedisRepository redisRepository;

    private String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(formatter);
    }

    public List<String> makePayment(String idempotencyKey, List<Payment> payments) {
        List<String> res =  new ArrayList();
        if(redisRepository.keyExist(idempotencyKey)) {
            System.out.println("key exist: " + idempotencyKey);
            res.add((String) redisRepository.findByKey(idempotencyKey));
        }
        else {
            for (Payment payment : payments) {
                redisRepository.save(idempotencyKey, "processing since: " + getCurrentDateTime());
                res.add(paymentService.pay(
                        payment.getSellerAccount(),
                        payment.getCreditCardInfo().get(0),
                        new Price(payment.getAmount(), payment.getCurrency())
                ));
           }
        }
        return res;
    }

    public void updatePaymentStatus(String idempotencyKey, String status) {
        /*
             callback function after payment service is done.
             We should expose a route for the payment service to call to update status.
             Status = Paid ? Failed
         */
        redisRepository.save(idempotencyKey, status + " at: " + getCurrentDateTime());
    }
}
