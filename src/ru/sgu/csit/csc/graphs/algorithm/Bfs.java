package ru.sgu.csit.csc.graphs.algorithm;

import ru.sgu.csit.csc.graphs.Graph;
import ru.sgu.csit.csc.graphs.PathsTree;

public interface Bfs {
    PathsTree<Integer> run(Graph graph, int sourceVertex);
}
