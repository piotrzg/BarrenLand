package com.target.casestudy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Graph
{
	public Multimap<Integer, Edge> vertextEdges = ArrayListMultimap.create();
	public Set<Edge> edges = new HashSet<Edge>();

	public void addEdge(Edge e)
	{
		edges.add(e);
		vertextEdges.put(e.v1, e);
		vertextEdges.put(e.v2, e);
	}

	public Collection<Edge> getEdges()
	{
		return edges;
	}

	public Collection<Edge> getEdges(int vertextId)
	{
		Collection<Edge> edges = new ArrayList<Edge>();
		for (Edge edge : vertextEdges.get(vertextId))
		{
			edges.add(edge);
		}
		return edges;
	}
}
