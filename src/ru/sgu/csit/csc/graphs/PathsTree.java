package ru.sgu.csit.csc.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathsTree<V> {
    private int[] previousVertex;
    private V[] distance;

    public PathsTree(int[] previousVertex, V[] distance) {
        this.previousVertex = previousVertex;
        this.distance = distance;
    }

    public int getVertexCount() {
        return distance.length;
    }

    public V getDistance(int vertex) {
        return distance[vertex];
    }

    public int getPreviousVertex(int vertex) {
        return previousVertex[vertex];
    }

    public List<Integer> getPath(int to) {
        List<Integer> path = new ArrayList<Integer>();
        while (to != previousVertex[to]) {
            path.add(to);
            to = previousVertex[to];
        }
        path.add(to);
        Collections.reverse(path);
        return path;
    }
}
