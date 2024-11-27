package com.management.charitydonation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.management.charitydonation.service.PayPalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;import com.paypal.base.rest.PayPalRESTException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/paypal")
public class PayPalController {
	private final PayPalService payPalService;
	@PostMapping("/create")
	public String createPayment() {
		try {
			String CancelUrl=      "http://localhost:3000/payment/cancel";
			String SuccessUrl=     "http://localhost:3000/payment/success";
			Payment payment=payPalService.createPayment(10.0, "USD", "paypal", "sale", "Payment Description", CancelUrl, SuccessUrl);

			for(Links links:payment.getLinks()) {
				if(links.getRel().equals("approval_url")) {
					return links.getHref();
				}
			}
		}catch (PayPalRESTException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "error";
	}
@GetMapping("/success")
public String paymentSuccess(@RequestParam("paymentId") String paymentId
		, @RequestParam ("payerId") String payerId) {
	try {
		Payment payment=payPalService.executePayment(paymentId, payerId);
		if(payment.getState().equals("approved")) {
			return payment.toJSON();
		}
	}catch (PayPalRESTException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return "error";
}



}
