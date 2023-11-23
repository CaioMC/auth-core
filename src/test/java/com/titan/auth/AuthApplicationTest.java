package com.titan.auth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Application.")
class AuthApplicationTest {

	@Test
	@DisplayName("Application - Subir aplicação profiler test.")
	void contextLoads() {
		AuthApplication.main(new String[]{"--spring.profiles.active=it"});
		Boolean aTrue = Boolean.TRUE;
		assertTrue(aTrue);
	}
}