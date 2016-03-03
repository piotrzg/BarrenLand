package com.target.casestudy.parser;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static com.target.casestudy.Constants.XNE;
import static com.target.casestudy.Constants.XSW;
import static com.target.casestudy.Constants.YNE;
import static com.target.casestudy.Constants.YSW;

public class ParserTest
{
	@Test
	public void testSimpleParse()
	{
		int[][] result = Parser.parse(new String[] {"0 292 399 307"});
		
		assertEquals(result.length, 1);
	}
}
