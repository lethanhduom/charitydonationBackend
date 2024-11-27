package com.management.charitydonation.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface PayPalService {
public Payment createPayment(Double total, String currency, String method, String intent, String description,String cancalUrl, String sucessUrl) throws PayPalRESTException;
public Payment executePayment(String paymentId,String payerId) throws PayPalRESTException;

}