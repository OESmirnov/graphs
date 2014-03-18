package ru.sgu.csit.csc.graphs.state.algorithm.impl;

import ru.sgu.csit.csc.graphs.state.Aborter;
import ru.sgu.csit.csc.graphs.state.PathsTree;
import ru.sgu.csit.csc.graphs.state.StateGraph;
import ru.sgu.csit.csc.graphs.state.algorithm.Bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BfsImpl<V> implements Bfs<V> {
    @Override
    public PathsTree<V> run(StateGraph<V> graph, V sourceVertex) {
        return run(graph, sourceVertex, null);
    }

    @Override
    public PathsTree<V> run(StateGraph<V> graph, V sourceVertex, Aborter<V> aborter) {
        Map<V, V> previousVertex = new HashMap<V, V>();
        Map<V, Integer> distance = new HashMap<V, Integer>();

        previousVertex.put(sourceVertex, sourceVertex);
        distance.put(sourceVertex, 0);

        Queue<V> queue = new LinkedList<V>();
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            V from = queue.poll();
            if (aborter != null && aborter.isAbortedState(from)) {
                break;
            }
            for (V to : graph.getNeighborVertices(from)) {
                if (!previousVertex.containsKey(to)) {
                    distance.put(to, distance.get(from) + 1);
                    previousVertex.put(to, from);
                    queue.add(to);
                }
            }
        }

        return new PathsTree<V>(previousVertex, distance);
    }
}
