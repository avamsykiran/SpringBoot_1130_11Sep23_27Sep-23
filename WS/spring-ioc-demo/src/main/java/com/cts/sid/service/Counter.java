package com.cts.sid.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class Counter {

	@Value("${sid.counter.count:10}")
	private int count;
	
	public int getCount() {
		return ++count;
	}
}
