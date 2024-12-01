package com.management.charitydonation.service;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public interface VNPayService {
public String md5(String message) ;
public  String Sha256(String message);
public String hashAllFields(Map fields);
public String hmacSHA512(final String key, final String data);
public String getIpAddress(HttpServletRequest request) ;
public  String getRandomNumber(int len) ;
}
