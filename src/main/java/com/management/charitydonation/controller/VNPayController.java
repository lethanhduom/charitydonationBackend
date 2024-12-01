package com.management.charitydonation.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.charitydonation.config.VNPayConfig;
import com.management.charitydonation.service.VNPayService;


import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vnpay")
public class VNPayController {
	private VNPayService VNPayService;

   
//	@PostMapping("/create")
//    public Map<String, String> createPayment(@RequestParam("amount") String amount) {
//        Map<String, String> response = new HashMap<>();
//        try {
//            // Cấu hình các tham số của VNPAY
//            String vnp_Version = "2.1.0";
//            String vnp_Command = "pay";
//        
//            String orderId = VNPayService.getRandomNumber(8); // Random order ID
//            String orderInfo = "Thanh toan don hang " + orderId;
//            String transactionRef = VNPayService.getRandomNumber(8); // Mã giao dịch duy nhất
////            String ipAddress = VNPayService.getIpAddress(request);
//            String vnp_IpAddr = "127.0.0.1";
//            // Xây dựng các tham số gửi tới VNPAY
//            Map<String, String> vnp_Params = new HashMap<>();
//            vnp_Params.put("vnp_Version", vnp_Version);
//            vnp_Params.put("vnp_Command", vnp_Command);
//            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
//            vnp_Params.put("vnp_Amount", String.valueOf(Long.parseLong(amount)*100)); // Đơn vị là VND x100
//            vnp_Params.put("vnp_CurrCode", "VND");
//            vnp_Params.put("vnp_TxnRef", transactionRef);
//            vnp_Params.put("vnp_OrderInfo", orderInfo);
//            vnp_Params.put("vnp_OrderType", "other"); // Loại giao dịch
//            vnp_Params.put("vnp_Locale", "vn");
//            vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl);
//            vnp_Params.put("vnp_CreateDate", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
//
//            // Tạo query string từ các tham số
//            String vnp_SecureHash = VNPayService.hashAllFields(vnp_Params); // Tạo mã bảo mật
//            vnp_Params.put("vnp_SecureHash", vnp_SecureHash);
//
//            // Xây dựng URL thanh toán
//            StringBuilder query = new StringBuilder(vnp_Url + "?");
//            for (Map.Entry<String, String> entry : vnp_Params.entrySet()) {
//                query.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
//            }
//            query.deleteCharAt(query.length() - 1);
//
//            // Gửi lại URL thanh toán cho client
//            response.put("paymentUrl", query.toString());
//        } catch (Exception e) {
//            response.put("error", "Có lỗi xảy ra: " + e.getMessage());
//        }
//        return response;
//    }
	
	
	
	/////////////////////////////////////
	
	
	@PostMapping("/create")
	public Map<String, String> create(@RequestBody String amount) throws UnsupportedEncodingException{
		
		String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
//        long amount = 10000*100;
//        String bankCode = "NCB";
        
        String vnp_TxnRef = VNPayService.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";
        
        Map<String, String> response = new HashMap<>();
        
        
  try {
	  Map<String, String> vnp_Params = new HashMap<>();
      vnp_Params.put("vnp_Version", vnp_Version);
      vnp_Params.put("vnp_Command", vnp_Command);
      vnp_Params.put("vnp_TmnCode", VNPayConfig.vnp_TmnCode);
      vnp_Params.put("vnp_Amount", String.valueOf(String.valueOf(Long.parseLong(amount)*100)));
      vnp_Params.put("vnp_CurrCode", "VND");
      
//      vnp_Params.put("vnp_BankCode", bankCode);
      vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
      vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
      vnp_Params.put("vnp_OrderType", orderType);

      vnp_Params.put("vnp_Locale", "vn");
      vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrl);
      vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

      Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
      String vnp_CreateDate = formatter.format(cld.getTime());
      vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
      
      cld.add(Calendar.MINUTE, 15);
      String vnp_ExpireDate = formatter.format(cld.getTime());
      vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
      
      List fieldNames = new ArrayList(vnp_Params.keySet());
      Collections.sort(fieldNames);
      StringBuilder hashData = new StringBuilder();
      StringBuilder query = new StringBuilder();
      Iterator itr = fieldNames.iterator();
      while (itr.hasNext()) {
          String fieldName = (String) itr.next();
          String fieldValue = (String) vnp_Params.get(fieldName);
          if ((fieldValue != null) && (fieldValue.length() > 0)) {
              //Build hash data
              hashData.append(fieldName);
              hashData.append('=');
              hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
              //Build query
              query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
              query.append('=');
              query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
              if (itr.hasNext()) {
                  query.append('&');
                  hashData.append('&');
              }
          }
      }
      String queryUrl = query.toString();
      String vnp_SecureHash = VNPayService.hmacSHA512(VNPayConfig.vnp_HashSecret, hashData.toString());
      queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
      String paymentUrl = VNPayConfig.vnp_Url + "?" + queryUrl;
      response.put("paymentUrl", paymentUrl);
  }catch (Exception e) {
	e.printStackTrace();
}
    
        
        
		
		return response ;
	}
	
	

}
