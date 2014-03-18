package ru.sgu.csit.csc.graphs;

import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjacencyMatrixGraph extends BaseGraph {
    private final BitSet adjacencyMatrix[];

    public AdjacencyMatrixGraph(int vertexCount, Type type) {
        super(vertexCount, type);
        adjacencyMatrix = new BitSet[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            adjacencyMatrix[i] = new BitSet(vertexCount);
        }
    }

    @Override
    public boolean addEdge(int from, int to) {
        if (adjacencyMatrix[from].get(to)) {
            return false;
        }

        handleAddEdge(from, to);
        adjacencyMatrix[from].set(to);
        if (this.getType() == Type.UNDIRECTED) {
            adjacencyMatrix[to].set(from);
        }
        return true;
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
        private int cursor = -1;
        private final int vertex;

        private void adjustCursor() {
            ++cursor;
            while (cursor < getVertexCount() && !adjacencyMatrix[this.vertex].get(cursor)) {
                ++cursor;
            }
        }

        private NeighborsIterator(int vertex) {
            this.vertex = vertex;
            adjustCursor();
        }

        @Override
        public boolean hasNext() {
            return cursor != getVertexCount();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = cursor;
            adjustCursor();
            return i;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported.");
        }
    }
}
