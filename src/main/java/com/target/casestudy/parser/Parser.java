package com.target.casestudy.parser;

import static com.target.casestudy.Constants.XNE;
import static com.target.casestudy.Constants.XSW;
import static com.target.casestudy.Constants.YNE;
import static com.target.casestudy.Constants.YSW;

public class Parser
{
	public static int[][] parse(String[] args)
	{
		if (args == null || args.length == 0)
		{
			return null;
		}

		int[][] barrenCoords = new int[args.length][4];

		for (int i = 0; i < args.length; i++)
		{
			String[] coords = args[i].split(" ");

			barrenCoords[i][XSW] = Integer.parseInt(coords[0]);
			barrenCoords[i][YSW] = Integer.parseInt(coords[1]);
			barrenCoords[i][XNE] = Integer.parseInt(coords[2]);
			barrenCoords[i][YNE] = Integer.parseInt(coords[3]);
		}

		return barrenCoords;
	}
}
