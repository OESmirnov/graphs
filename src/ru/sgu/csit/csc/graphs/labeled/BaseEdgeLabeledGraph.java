package ru.sgu.csit.csc.graphs.labeled;

import ru.sgu.csit.csc.graphs.BaseGraph;

public abstract class BaseEdgeLabeledGraph<L> extends BaseGraph implements EdgeLabeledGraph<L> {
    protected BaseEdgeLabeledGraph(int vertexCount, Type type) {
        super(vertexCount, type);
    }
}
