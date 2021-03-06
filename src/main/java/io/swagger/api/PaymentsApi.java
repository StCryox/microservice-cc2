/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.List;
import io.swagger.model.Payment;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-02T09:42:13.391Z")

@Validated
@Api(value = "payments", description = "the payments API")
@RequestMapping(value = "/v1")
public interface PaymentsApi {

    @ApiOperation(value = "Make a payment", nickname = "makePayment", notes = "", tags={ "payment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid data in the payment JSON"),
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/payments/",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<String> makePayment(@RequestHeader("idempotency-key") String idempotencyKey, @ApiParam(value = "payment object" ,required=true )  @Valid @RequestBody List<Payment> body);

}
