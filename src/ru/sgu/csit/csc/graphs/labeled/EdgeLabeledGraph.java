package ru.sgu.csit.csc.graphs.labeled;

import ru.sgu.csit.csc.graphs.Graph;

public interface EdgeLabeledGraph<L> extends Graph {
    boolean addEdge(int from, int to, L label);

    Iterable<Edge<L>> getNeighborEdges(int vertex);

    public static class Edge<L> {
        private final int to;
        private final L label;

        public int getTo() {
            return to;
        }

        public L getLabel() {
            return label;
        }

        public Edge(int to, L label) {

            this.to = to;
            this.label = label;
        }
    }
}
