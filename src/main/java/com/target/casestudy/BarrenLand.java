package com.target.casestudy;

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

public class BarrenLand
{
	public static void main(String[] args)
	{
		process(args);
	}

	public static List<Integer> process(String[] args)
	{
		int[][] barrenCoords = Parser.parse(args);

		if (barrenCoords == null)
		{
			System.out.print(" ");
			return null;
		}

		boolean[][] isBarrenSquare = markBarrenSquares(barrenCoords);

		Graph g = new Graph();
		for (int x = 0; x < MAX_X; x++)
		{
			for (int y = 0; y < MAX_Y; y++)
			{
				if (isBarrenSquare[x][y])
				{
					continue;
				}

				int currentVertice = x + y * MAX_X;
				if (y > -1 && y < LAST_Y && x > -1 && x < LAST_X)
				{
					if (!isBarrenSquare[x][y + 1])
					{
						addNorthEdge(g, currentVertice);
					}

					if (!isBarrenSquare[x + 1][y])
					{
						addEastEdge(g, currentVertice);
					}
				}
				else if (y > -1 && y < LAST_Y && x == LAST_X)
				{
					if (!isBarrenSquare[x][y + 1])
					{
						addNorthEdge(g, currentVertice);
					}
				}
				else if (y == LAST_Y && x > -1 && x < LAST_X)
				{
					if (!isBarrenSquare[x + 1][y])
					{
						addEastEdge(g, currentVertice);
					}
				}
				else if (y == LAST_Y && x == LAST_X)
				{
					// top right square - don't create any edges
				}
			}
		}

		List<Integer> usableLandAreas = bfs(g);

		Collections.sort(usableLandAreas);
		for (Integer usableArea : usableLandAreas)
		{
			System.out.print(usableArea);
			System.out.print(" ");
		}

		return usableLandAreas;
	}

	private static void addNorthEdge(Graph g, int currentVertice)
	{
		Edge edgeN = new Edge(currentVertice, currentVertice + MAX_X);
		g.addEdge(edgeN);
	}

	private static void addEastEdge(Graph g, int currentVertice)
	{
		Edge edgeE = new Edge(currentVertice, currentVertice + 1);
		g.addEdge(edgeE);
	}

	private static boolean[][] markBarrenSquares(int[][] barrenCoords)
	{
		boolean[][] isBarrenSquare = new boolean[MAX_X][MAX_Y];
		for (int i = 0; i < barrenCoords.length; i++)
		{
			for (int x = barrenCoords[i][XSW]; x <= barrenCoords[i][XNE]; x++)
			{
				for (int y = barrenCoords[i][YSW]; y <= barrenCoords[i][YNE]; y++)
				{
					isBarrenSquare[x][y] = true;
				}
			}
		}

		return isBarrenSquare;
	}

	public static List<Integer> bfs(Graph g)
	{
		Set<Edge> unvisitedEdges = new HashSet<Edge>(g.getEdges());
		Set<Integer> visited = new HashSet<Integer>();
		List<Integer> usableLandAreas = new ArrayList<Integer>();

		while (!unvisitedEdges.isEmpty())
		{
			visited.clear();
			Queue<Integer> q = new LinkedList<Integer>();
			int startNode = unvisitedEdges.iterator().next().v1;
			q.add(startNode);
			visited.add(startNode);

			Graph subgraph = new Graph();
			while (!q.isEmpty())
			{
				int currentSquare = q.remove();
				visited.add(currentSquare);
				Collection<Edge> edgesAtCurrentPoint = g.getEdges(currentSquare);
				for (Edge e : edgesAtCurrentPoint)
				{
					int v1 = e.v1;
					int v2 = e.v2;

					if (v1 != currentSquare && !visited.contains(v1))
					{
						q.add(v1);
						visited.add(v1);
					}

					if (v2 != currentSquare && !visited.contains(v2))
					{
						q.add(v2);
						visited.add(v2);
					}

					if (unvisitedEdges.contains(e))
					{
						subgraph.addEdge(e);
					}
					unvisitedEdges.remove(e);
				}
			}

			usableLandAreas.add(subgraph.vertextEdges.keySet().size());
		}

		return usableLandAreas;
	}
}
