package com.app.services;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.app.dto.ReCaptchResponseType;

@Service
public class ReCaptchaValidationService {
	private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
    
	private final String RECAPTCHA_SECRET = "6LeR5nkpAAAAAL3tHYRTUNAwyJ_TqEm9_bC3E5t3";

	    public boolean validateCaptcha(String captchaResponse){
	    	System.out.println("IN Captcha Validation");
	        RestTemplate restTemplate = new RestTemplate();

	        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
	        requestMap.add("secret", RECAPTCHA_SECRET);
	        requestMap.add("response", captchaResponse);

	        ReCaptchResponseType apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap, ReCaptchResponseType.class);
	        if(apiResponse == null){
	            return false;
	        }
          System.out.println("Captcha Validation Successfull");
	        return Boolean.TRUE.equals(apiResponse.isSuccess());
}
}
