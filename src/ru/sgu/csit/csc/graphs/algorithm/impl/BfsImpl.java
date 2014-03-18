package ru.sgu.csit.csc.graphs.algorithm.impl;

import ru.sgu.csit.csc.graphs.Graph;
import ru.sgu.csit.csc.graphs.PathsTree;
import ru.sgu.csit.csc.graphs.algorithm.Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BfsImpl implements Bfs {
    @Override
    public PathsTree<Integer> run(Graph graph, int sourceVertex) {
        int[] previousVertex = new int[graph.getVertexCount()];
        Integer[] distance = new Integer[graph.getVertexCount()];

        for (int i = 0; i < graph.getVertexCount(); i++) {
            previousVertex[i] = -1;
            distance[i] = null;
        }
        previousVertex[sourceVertex] = sourceVertex;
        distance[sourceVertex] = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : graph.getNeighbors(from)) {
                if (distance[to] == null) {
                    distance[to] = distance[from] + 1;
                    previousVertex[to] = from;
                    queue.add(to);
                }
            }
        }

        return new PathsTree<Integer>(previousVertex, distance);
    }
}
