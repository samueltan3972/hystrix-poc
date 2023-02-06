package com.example.hystrixenabled.hystrix_enabled.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {
	@RequestMapping(value = "/getHystrixEnabled", method = RequestMethod.GET)
	  public String getHystrixEnabled() {
	    return "Hystrix is Enabled";
	  }
}