package com.example.demo.Delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DemoDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callHystrixEnabled_fallback", commandKey = "DemoDelegate")
	  public String callHystrixEnabled() {
	 
	    String response = restTemplate
	        .exchange("http://localhost:8082/getHystrixEnabled"
	        , HttpMethod.GET
	        , null
	        , new ParameterizedTypeReference<String>() {
	      }).getBody();
	 
	    System.out.println("Response Received as " + response + " -  " + new Date());
	 
	    return "NORMAL FLOW !!! " + response + " -  " + new Date();
	  }
	
	@SuppressWarnings("unused")
	  private String callHystrixEnabled_fallback() {
	 
	    return "CIRCUIT BREAKER ENABLED!!! No Response From Hystrix Service at this moment. " +
	      " Service will be back shortly - " + new Date();
	  }
	
	@Bean
	  public RestTemplate restTemplate() {
	    return new RestTemplate();
	  }
}
