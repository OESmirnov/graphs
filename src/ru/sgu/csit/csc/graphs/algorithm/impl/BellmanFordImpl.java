package ru.sgu.csit.csc.graphs.algorithm.impl;

import ru.sgu.csit.csc.graphs.labeled.EdgeLabeledGraph;
import ru.sgu.csit.csc.graphs.PathsTree;
import ru.sgu.csit.csc.graphs.algorithm.BellmanFord;

public class BellmanFordImpl implements BellmanFord {
    @Override
    public <L, V> PathsTree<V> run(EdgeLabeledGraph<L> graph, int sourceVertex, LengthGetter<L, V> lengthGetter, Metric<V> metric) {
        int[] previousVertex = new int[graph.getVertexCount()];

        @SuppressWarnings("unchecked")
        V[] distance = (V[]) new Object[graph.getVertexCount()];

        for (int i = 0; i < graph.getVertexCount(); i++) {
            distance[i] = metric.infinity();
            previousVertex[i] = -1;
        }
        previousVertex[sourceVertex] = sourceVertex;
        distance[sourceVertex] = metric.zero();

        for (int i = 0; i < graph.getVertexCount(); i++) {
            for (int from = 0; from < graph.getVertexCount(); from++) {
                for (EdgeLabeledGraph.Edge<L> edge : graph.getNeighborEdges(from)) {
                    if (metric.compare(distance[edge.getTo()],
                            metric.add(distance[from], lengthGetter.length(edge.getLabel()))) > 0) {
                        distance[edge.getTo()] = metric.add(distance[from], lengthGetter.length(edge.getLabel()));
                        previousVertex[edge.getTo()] = from;
                    }
                }
            }
        }

        return new PathsTree<V>(previousVertex, distance);
    }
}
