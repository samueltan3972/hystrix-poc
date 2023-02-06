package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Delegate.DemoDelegate;

@RestController
public class DemoController {
	@Autowired
	DemoDelegate demoDelegate;
	
	@RequestMapping(value = "/getDemo", method = RequestMethod.GET)
	  public String getDemo() {
		String msg = demoDelegate.callHystrixEnabled();
		System.out.println(msg);
		
	    return msg;
	  }
}
