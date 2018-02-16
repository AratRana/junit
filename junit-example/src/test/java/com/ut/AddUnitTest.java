package com.ut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.cal.Add;

public class AddUnitTest {
	@Test
	public void addJunitTest() {
		Add add = new Add();
		int result = add.add(2, 3);
		assertEquals(5, result);
		try{
			int x = 10/0;
			fail("hello thrown");
		}catch(Exception e){
			System.out.println("divided by zero");
		}
	}
}
