package ru.sgu.csit.csc.graphs.state.algorithm;

import ru.sgu.csit.csc.graphs.state.Aborter;
import ru.sgu.csit.csc.graphs.state.PathsTree;
import ru.sgu.csit.csc.graphs.state.StateGraph;

public interface Bfs<V> {
    public PathsTree<V> run(StateGraph<V> graph, V sourceVertex);
    public PathsTree<V> run(StateGraph<V> graph, V sourceVertex, Aborter<V> aborter);
}
