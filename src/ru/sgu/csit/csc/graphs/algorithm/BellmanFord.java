package ru.sgu.csit.csc.graphs.algorithm;

import ru.sgu.csit.csc.graphs.labeled.EdgeLabeledGraph;
import ru.sgu.csit.csc.graphs.PathsTree;

public interface BellmanFord {
    <L, V> PathsTree<V> run(EdgeLabeledGraph<L> graph, int sourceVertex, LengthGetter<L, V> lengthGetter, Metric<V> metric);

    public interface LengthGetter<L, V> {
        V length(L label);
    }

    public interface Metric<V> {
        V infinity();

        V zero();

        V add(V left, V right);

        int compare(V left, V right);
    }
}
