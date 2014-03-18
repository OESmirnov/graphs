package ru.sgu.csit.csc.graphs.labeled;

import ru.sgu.csit.csc.graphs.BaseGraph;

import java.util.*;

public class AdjacencyListsEdgeLabeledGraph<L> extends BaseGraph implements EdgeLabeledGraph<L> {
    private final List<List<Edge<L>>> adjacencyLists;

    public AdjacencyListsEdgeLabeledGraph(int vertexCount, Type type) {
        super(vertexCount, type);
        adjacencyLists = new ArrayList<List<Edge<L>>>(vertexCount);
        for (int i = 0; i < vertexCount; ++i) {
            adjacencyLists.add(new ArrayList<Edge<L>>());
        }
    }

    @Override
    public boolean addEdge(int from, int to, L label) {
        handleAddEdge(from, to);
        adjacencyLists.get(from).add(new Edge<L>(to, label));
        if (getType() == Type.UNDIRECTED) {
            adjacencyLists.get(to).add(new Edge<L>(to, label));
        }
        return true;
    }

    @Override
    public Iterable<Edge<L>> getNeighborEdges(int vertex) {
        return Collections.unmodifiableList(adjacencyLists.get(vertex));
    }

    @Override
    public boolean addEdge(int from, int to) {
        return addEdge(from, to, null);
    }

    @Override
    public Iterable<Integer> getNeighbors(final int vertex) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new NeighborsIterator(vertex);
            }
        };
    }

    private class NeighborsIterator implements Iterator<Integer> {
        private final int vertex;
        private int cursor = 0;

        private NeighborsIterator(int vertex) {
            this.vertex = vertex;
        }

        @Override
        public boolean hasNext() {
            return cursor < adjacencyLists.get(vertex).size();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return adjacencyLists.get(vertex).get(cursor++).getTo();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported.");
        }
    }
}
