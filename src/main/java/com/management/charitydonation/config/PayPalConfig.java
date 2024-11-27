package com.management.charitydonation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.paypal.base.rest.APIContext;

@Configuration
public class PayPalConfig {
//	@Value("${paypal.client_id}")
	private String clientId="AeO-MN906-Iie38cfjvA9krnX3SmOd4GgIaTqh-_Bj1ZjhuiPcENhOJJqoMYXk9YZlrAf1Gywpy-4W0t";
//	@Value("${paypal.client_secret}")
	private String clientSecret="EAVudH5iI2qG6h4rRT260VpIgolQ9RbRc_aiJrl1P3trL0RcQSVde0QA9NkFUP41s687E56-KrWAM8FM";
//	@Value("${paypal.mode}")
	private String mode="sandbox";
	@Bean
   public APIContext apiContext() {
	   return new APIContext(clientId,clientSecret,mode);
   }
}
