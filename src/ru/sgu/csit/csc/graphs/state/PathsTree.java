package ru.sgu.csit.csc.graphs.state;

import java.util.*;

public class PathsTree<V> {
    private final Map<V, V> previousVertex;
    private final Map<V, Integer> distance;

    public PathsTree(Map<V, V> previousVertex, Map<V, Integer> distance) {
        this.previousVertex = new HashMap<V, V>(previousVertex);
        this.distance = new HashMap<V, Integer>(distance);
    }

    public int getDistance(V vertex) {
        return distance.get(vertex);
    }

    public V getPreviousVertex(V vertex) {
        return previousVertex.get(vertex);
    }

    public boolean isReachable(V vertex) {
        return distance.containsKey(vertex);
    }

    public List<V> getPath(V to) {
        if (!isReachable(to)) {
            throw new IllegalArgumentException("Vertex to is not reachable.");
        }
        List<V> path = new ArrayList<V>();
        while (to != previousVertex.get(to)) {
            path.add(to);
            to = previousVertex.get(to);
        }
        path.add(to);
        Collections.reverse(path);
        return path;
    }
}
