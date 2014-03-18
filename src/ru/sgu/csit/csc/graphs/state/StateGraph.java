package ru.sgu.csit.csc.graphs.state;

public interface StateGraph<V> {
    Iterable<V> getNeighborVertices(V vertex);
}
