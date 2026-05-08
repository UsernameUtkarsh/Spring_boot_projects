package com.bharath.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharath.core.services.PaymentServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CoreApplicationTests {
	
	@Autowired
	PaymentServiceImpl service;

	@Test
	void testDependencyInjection() {
		assertNotNull(service.getDao());
		
	}

}
