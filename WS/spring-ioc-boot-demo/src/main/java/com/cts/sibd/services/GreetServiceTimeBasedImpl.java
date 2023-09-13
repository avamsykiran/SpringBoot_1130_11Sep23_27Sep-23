package com.cts.sibd.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("gs2")
public class GreetServiceTimeBasedImpl implements GreetService{

	@Override
	public String greetUser(String userName) {
		String greeting="";
		
		int h = LocalDateTime.now().getHour();
		
		if(h>=3 && h<12) greeting="Good Morning";
		else if(h>12 && h<=17) greeting="Good Noon";
		else greeting="Good Evening";
		
		return greeting +" " + userName;
	}

}
