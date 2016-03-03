package com.target.casestudy;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static com.target.casestudy.Constants.LAST_X;
import static com.target.casestudy.Constants.LAST_Y;
import static com.target.casestudy.Constants.MAX_X;
import static com.target.casestudy.Constants.MAX_Y;
import static com.target.casestudy.Constants.XNE;
import static com.target.casestudy.Constants.XSW;
import static com.target.casestudy.Constants.YNE;
import static com.target.casestudy.Constants.YSW;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.target.casestudy.parser.Parser;

public class BarrenLandTest
{
	@Test
	public void testSampleSimple()
	{
		List<Integer> result = BarrenLand.process(new String[] {"0 292 399 307"});
		
		assertEquals(116800, (int)result.get(0));
		assertEquals(116800, (int)result.get(1));
	}
	
	@Test
	public void testSampleComplex()
	{
		List<Integer> result = BarrenLand.process(new String[] {"48 192 351 207","48 392 351 407","120 52 135 547","260 52 275 547"});
		
		assertEquals(22816, (int)result.get(0));
		assertEquals(192608, (int)result.get(1));
	}	
}
