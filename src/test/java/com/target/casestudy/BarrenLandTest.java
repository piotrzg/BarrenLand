package com.target.casestudy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

public class BarrenLandTest
{
	@Test
	public void testSampleSimple()
	{
		List<Integer> result = BarrenLand.process(new String[] { "0 292 399 307" });

		assertEquals(116800, (int) result.get(0));
		assertEquals(116800, (int) result.get(1));
	}

	@Test
	public void testSampleComplex()
	{
		List<Integer> result = BarrenLand.process(new String[] { "48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547" });

		assertEquals(22816, (int) result.get(0));
		assertEquals(192608, (int) result.get(1));
	}

	@Test
	public void testNullInput()
	{
		List<Integer> result = BarrenLand.process(null);
		assertNull(result);
	}
	
	@Test
	public void testEmptyInput()
	{
		List<Integer> result = BarrenLand.process(new String[] {});
		assertNull(result);
	}	
}
