package io.swagger.api;

import java.util.List;

import com.google.gson.Gson;
import io.swagger.Service.MakePaymentService;
import io.swagger.model.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-02T09:42:13.391Z")

@RestController
public class PaymentsApiController implements PaymentsApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private MakePaymentService makePaymentService;

    @Autowired
    private Gson gson;

    @org.springframework.beans.factory.annotation.Autowired
    public PaymentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<String> makePayment(@RequestHeader("idempotency-key") String idempotencyKey, @ApiParam(value = "payment object", required=true)  @Valid @RequestBody List<Payment> body) {
        List<String> paymentStatus = makePaymentService.makePayment(idempotencyKey, body);
        return new ResponseEntity<String>(gson.toJson(paymentStatus).concat("\nidempotency-key: " + idempotencyKey), HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/status//{status}")
    public ResponseEntity<Void> updateStatus(@RequestHeader("idempotency-key") String idempotencyKey, @PathVariable String status) {
       makePaymentService.updatePaymentStatus(idempotencyKey, status);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
