package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.calculator.Calculator;

public class CalculatorTest {
	
	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		assertEquals(30, cal.sum(20, 10));
		System.out.println("test1");
	}
	
	@Test
	public void testSum1() {
		Calculator cal = new Calculator();
		assertEquals(60, cal.sum(50, 10));
		System.out.println("test2");
	}
	
	@BeforeClass	// 단위테스트 하기전.
	public static void beforeTest() {
		System.out.println("BeforeClass");
	}
	
	@Before			// 구체적 단위테스트 하기 전
	public void setUp() {
		System.out.println("before setUp");
	}
	
	@After			// 구체적인 단위테스트 종료 후.
	public void tearDown() {
		System.out.println("after tearDown");
	}
	
	@AfterClass		// 모든 단위테스트 종료 후
	public static void afterTest() {
		System.out.println("AfterClass");
	}
}
