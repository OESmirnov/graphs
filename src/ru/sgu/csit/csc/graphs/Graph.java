package ru.sgu.csit.csc.graphs;

public interface Graph {
    int getVertexCount();

    boolean addEdge(int from, int to);

    Iterable<Integer> getNeighbors(int vertex);

    enum Type {
        DIRECTED,
        UNDIRECTED
    }
}
