package com.target.casestudy.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ParserTest
{
	@Test
	public void testSimpleParse()
	{
		int[][] result = Parser.parse(new String[] { "0 292 399 307" });

		assertEquals(result.length, 1);
		assertEquals(result[0].length, 4);

		result = Parser.parse(new String[] { "0 292 399 307", "0 292 399 307" });

		assertEquals(result.length, 2);
		assertEquals(result[0].length, 4);
	}

	@Test
	public void testNullParse()
	{
		int[][] result = Parser.parse(null);

		assertNull(result);
	}

	@Test
	public void testEmptyParse()
	{
		int[][] result = Parser.parse(new String[] {});

		assertNull(result);
	}
}
