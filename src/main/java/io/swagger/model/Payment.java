package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.BuyerInfo;
import io.swagger.model.CreditCardInfo;
import io.swagger.model.PaymentOrders;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Payment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-02T09:42:13.391Z")


public class Payment   {
  @JsonProperty("buyer_info")
  @Valid
  private List<BuyerInfo> buyerInfo = null;

  @JsonProperty("checkout_id")
  private String checkoutId = null;

  @JsonProperty("credit_card_info")
  @Valid
  private List<CreditCardInfo> creditCardInfo = null;

  @JsonProperty("payment_orders")
  @Valid
  private List<PaymentOrders> paymentOrders = null;

  @JsonProperty("seller_account")
  private String sellerAccount = null;

  @JsonProperty("amount")
  private String amount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("payment_order_id")
  private String paymentOrderId = null;

  public Payment buyerInfo(List<BuyerInfo> buyerInfo) {
    this.buyerInfo = buyerInfo;
    return this;
  }

  public Payment addBuyerInfoItem(BuyerInfo buyerInfoItem) {
    if (this.buyerInfo == null) {
      this.buyerInfo = new ArrayList<BuyerInfo>();
    }
    this.buyerInfo.add(buyerInfoItem);
    return this;
  }

  /**
   * The information of the buyer
   * @return buyerInfo
  **/
  @ApiModelProperty(value = "The information of the buyer")

  @Valid

  public List<BuyerInfo> getBuyerInfo() {
    return buyerInfo;
  }

  public void setBuyerInfo(List<BuyerInfo> buyerInfo) {
    this.buyerInfo = buyerInfo;
  }

  public Payment checkoutId(String checkoutId) {
    this.checkoutId = checkoutId;
    return this;
  }

  /**
   * A globally unique ID for this checkout
   * @return checkoutId
  **/
  @ApiModelProperty(required = true, value = "A globally unique ID for this checkout")
  @NotNull


  public String getCheckoutId() {
    return checkoutId;
  }

  public void setCheckoutId(String checkoutId) {
    this.checkoutId = checkoutId;
  }

  public Payment creditCardInfo(List<CreditCardInfo> creditCardInfo) {
    this.creditCardInfo = creditCardInfo;
    return this;
  }

  public Payment addCreditCardInfoItem(CreditCardInfo creditCardInfoItem) {
    if (this.creditCardInfo == null) {
      this.creditCardInfo = new ArrayList<CreditCardInfo>();
    }
    this.creditCardInfo.add(creditCardInfoItem);
    return this;
  }

  /**
   * Get creditCardInfo
   * @return creditCardInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CreditCardInfo> getCreditCardInfo() {
    return creditCardInfo;
  }

  public void setCreditCardInfo(List<CreditCardInfo> creditCardInfo) {
    this.creditCardInfo = creditCardInfo;
  }

  public Payment paymentOrders(List<PaymentOrders> paymentOrders) {
    this.paymentOrders = paymentOrders;
    return this;
  }

  public Payment addPaymentOrdersItem(PaymentOrders paymentOrdersItem) {
    if (this.paymentOrders == null) {
      this.paymentOrders = new ArrayList<PaymentOrders>();
    }
    this.paymentOrders.add(paymentOrdersItem);
    return this;
  }

  /**
   * Get paymentOrders
   * @return paymentOrders
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PaymentOrders> getPaymentOrders() {
    return paymentOrders;
  }

  public void setPaymentOrders(List<PaymentOrders> paymentOrders) {
    this.paymentOrders = paymentOrders;
  }

  public Payment sellerAccount(String sellerAccount) {
    this.sellerAccount = sellerAccount;
    return this;
  }

  /**
   * Which seller will receive the money
   * @return sellerAccount
  **/
  @ApiModelProperty(value = "Which seller will receive the money")


  public String getSellerAccount() {
    return sellerAccount;
  }

  public void setSellerAccount(String sellerAccount) {
    this.sellerAccount = sellerAccount;
  }

  public Payment amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The transaction amount of the order
   * @return amount
  **/
  @ApiModelProperty(value = "The transaction amount of the order")


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Payment currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * The currency for the order
   * @return currency
  **/
  @ApiModelProperty(example = "EUR", value = "The currency for the order")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Payment paymentOrderId(String paymentOrderId) {
    this.paymentOrderId = paymentOrderId;
    return this;
  }

  /**
   * A globally unique ID for this payment
   * @return paymentOrderId
  **/
  @ApiModelProperty(value = "A globally unique ID for this payment")


  public String getPaymentOrderId() {
    return paymentOrderId;
  }

  public void setPaymentOrderId(String paymentOrderId) {
    this.paymentOrderId = paymentOrderId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.buyerInfo, payment.buyerInfo) &&
        Objects.equals(this.checkoutId, payment.checkoutId) &&
        Objects.equals(this.creditCardInfo, payment.creditCardInfo) &&
        Objects.equals(this.paymentOrders, payment.paymentOrders) &&
        Objects.equals(this.sellerAccount, payment.sellerAccount) &&
        Objects.equals(this.amount, payment.amount) &&
        Objects.equals(this.currency, payment.currency) &&
        Objects.equals(this.paymentOrderId, payment.paymentOrderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buyerInfo, checkoutId, creditCardInfo, paymentOrders, sellerAccount, amount, currency, paymentOrderId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    buyerInfo: ").append(toIndentedString(buyerInfo)).append("\n");
    sb.append("    checkoutId: ").append(toIndentedString(checkoutId)).append("\n");
    sb.append("    creditCardInfo: ").append(toIndentedString(creditCardInfo)).append("\n");
    sb.append("    paymentOrders: ").append(toIndentedString(paymentOrders)).append("\n");
    sb.append("    sellerAccount: ").append(toIndentedString(sellerAccount)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    paymentOrderId: ").append(toIndentedString(paymentOrderId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

