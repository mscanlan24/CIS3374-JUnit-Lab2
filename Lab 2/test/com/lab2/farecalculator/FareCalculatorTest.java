package com.lab2.farecalculator;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;

import com.lab2.transit.FareCalculator;

@RunWith(Parameterized.class)
public class FareCalculatorTest {
	private FareCalculator farecalculator;
	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;
	private static final double DELTA = 1e-15;
	
	public FareCalculatorTest(double expected, int age, String time, boolean isHoliday) {
		this.expected = expected;
		this.age = age;
		this.time = time;
		this.isHoliday = isHoliday;
	}
	@Parameters
	public static Collection<Object[]> testParams(){
		return Arrays.asList(new Object[][]{
				{0.0, 65, "6:00", false},
				{2.5, 64, "18:00", false},
				{2.5, 6, "10:30", false},
				{0.0, 5, "16:15", false},
				{0.0, 70, "9:01", false},
				{2.5, 82, "9:00", false},
				{0.0, 2, "6:59", false},
				{2.5, 4, "7:00", false},
				{0.0, 72, "7:15", true},
				{0.0, 3, "8:30", true}
		});
	}
	@Before
	public void setUp(){
		farecalculator = new FareCalculator();
	}
	@Test
	public void calculateFareTest(){
		assertEquals(expected, FareCalculator.calculateFare(age, time, isHoliday), DELTA);
	}
}
