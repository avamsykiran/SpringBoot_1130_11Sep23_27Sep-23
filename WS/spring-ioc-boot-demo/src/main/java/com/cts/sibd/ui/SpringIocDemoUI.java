package com.cts.sibd.ui;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sibd.services.Counter;
import com.cts.sibd.services.GreetService;

@Component("ui")
public class SpringIocDemoUI implements CommandLineRunner {

	@Value("${sid.application.name:Spring Boot First Application}")
	private String appTitle;
	
	@Autowired
	private LocalDate date;
	
	@Autowired
	private Scanner scan;
	
	@Autowired
	@Qualifier("gs1")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("gs2")
	private GreetService greetService2;
	
	@Autowired
	private Counter counter1;
	
	@Autowired
	private Counter counter2;
	
	@Autowired
	private Counter counter3;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(appTitle);
		System.out.println("-------------------------------------------------------------------------");
		System.out.println(date);
		System.out.println("-------------------------------------------------------------------------");
		
		System.out.println("User Name? ");
		String userName = scan.nextLine();
		System.out.println(greetService1.greetUser(userName));
		System.out.println(greetService2.greetUser(userName));
	
		System.out.println(counter1.getCount());
		System.out.println(counter1.getCount());
		
		System.out.println(counter2.getCount());
		System.out.println(counter2.getCount());
		
		System.out.println(counter3.getCount());
		System.out.println(counter3.getCount());
	}

}
