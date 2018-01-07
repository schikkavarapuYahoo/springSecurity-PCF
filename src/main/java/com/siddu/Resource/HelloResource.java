package com.siddu.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

	@RequestMapping("/")
	public String hello() {
		return "Hello siddu i am from spring boot with spring security";
	}
}
