package com.cts.sid.service;

import org.springframework.stereotype.Service;

@Service("gs1")
public class GreetServieSimpleImpl implements GreetService {

	@Override
	public String greetUser(String userName) {
		return "Hello "+userName;
	}

}
