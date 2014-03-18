package ru.sgu.csit.csc.graphs.state;

public abstract class Aborter<V> {
    private V abortedState;

    public Aborter() {
        this.abortedState = null;
    }

    protected void setAbortedState(V abortedState) {
        this.abortedState = abortedState;
    }

    public abstract boolean isAbortedState(V vertex);

    public V getAbortedState() {
        return abortedState;
    }

    public boolean isAborted() {
        return abortedState != null;
    }
}
