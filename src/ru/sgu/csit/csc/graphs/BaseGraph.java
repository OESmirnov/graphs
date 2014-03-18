package ru.sgu.csit.csc.graphs;

public abstract class BaseGraph implements Graph {
    private final int vertexCount;
    private final Type type;

    protected BaseGraph(int vertexCount, Type type) {
        this.vertexCount = vertexCount;
        this.type = type;
    }

    protected Type getType() {
        return type;
    }

    @Override
    public int getVertexCount() {
        return vertexCount;
    }

    protected void handleAddEdge(int from, int to) {
        if (from == to && type == Type.UNDIRECTED) {
            throw new IllegalArgumentException("Undirected graphs do not allow loops.");
        }
    }
}
