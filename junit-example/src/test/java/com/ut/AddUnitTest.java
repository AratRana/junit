package com.ut;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cal.Add;

public class AddUnitTest {
	@Test
	public void addJunitTest() {
		Add add = new Add();
		int result = add.add(2, 3);
		assertEquals(5, result);
	}
}
