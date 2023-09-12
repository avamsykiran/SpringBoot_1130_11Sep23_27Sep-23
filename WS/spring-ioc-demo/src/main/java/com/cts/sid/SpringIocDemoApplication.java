package com.cts.sid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.sid.ui.SpringIocDemoUI;

public class SpringIocDemoApplication {

	public static void main(String[] args) {

		ApplicationContext container = new AnnotationConfigApplicationContext(SpringIocDemoConfiguration.class);
		
		SpringIocDemoUI uiBean = (SpringIocDemoUI) container.getBean("ui");
		uiBean.run();
	}

}
