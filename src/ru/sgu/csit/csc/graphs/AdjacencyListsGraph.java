package ru.sgu.csit.csc.graphs;

import java.util.*;

public class AdjacencyListsGraph extends BaseGraph {
    private final List<List<Integer>> adjacencyLists;

    public AdjacencyListsGraph(int vertexCount, Type type) {
        super(vertexCount, type);
        adjacencyLists = new ArrayList<List<Integer>>(vertexCount);
        for (int i = 0; i < vertexCount; ++i) {
            adjacencyLists.add(new ArrayList<Integer>());
        }
    }

    @Override
    public boolean addEdge(int from, int to) {
        handleAddEdge(from, to);
        adjacencyLists.get(from).add(to);
        if (getType() == Type.UNDIRECTED) {
            adjacencyLists.get(to).add(from);
        }
        return true;
    }

    @Override
    public Iterable<Integer> getNeighbors(int vertex) {
        return Collections.unmodifiableList(adjacencyLists.get(vertex));
    }
}
