package com.ut;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cal.Subtract;

public class SubtractTest {
	@Test
	public void subTest() {
		Subtract sub = new Subtract();
		int z = sub.subtract(3, 2);
		assertEquals(1, z);
	}
}
