import ru.sgu.csit.csc.graphs.Graph;
import ru.sgu.csit.csc.graphs.PathsTree;
import ru.sgu.csit.csc.graphs.algorithm.BellmanFord;
import ru.sgu.csit.csc.graphs.algorithm.impl.BellmanFordImpl;
import ru.sgu.csit.csc.graphs.labeled.AdjacencyListsEdgeLabeledGraph;
import ru.sgu.csit.csc.graphs.labeled.EdgeLabeledGraph;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        EdgeLabeledGraph<Integer> graph = new AdjacencyListsEdgeLabeledGraph<Integer>(n, Graph.Type.DIRECTED);
        for (int i = 0; i < m; i++) {
            int from, to, weight;
            from = scanner.nextInt();
            to = scanner.nextInt();
            weight = scanner.nextInt();
            graph.addEdge(from - 1, to - 1, weight);
        }

        PathsTree<Integer> pathsTree = new BellmanFordImpl().run(graph, 0, new BellmanFord.LengthGetter<Integer, Integer>() {
                    @Override
                    public Integer length(Integer label) {
                        return label;
                    }
                }, new BellmanFord.Metric<Integer>() {
                    @Override
                    public Integer infinity() {
                        return null;
                    }

                    @Override
                    public Integer zero() {
                        return 0;
                    }

                    @Override
                    public Integer add(Integer left, Integer right) {
                        if (left == null || right == null) {
                            return null;
                        } else {
                            return left + right;
                        }
                    }

                    @Override
                    public int compare(Integer left, Integer right) {
                        if (left == null && right == null) {
                            return 0;
                        }
                        if (left == null) {
                            return 1;
                        }
                        if (right == null) {
                            return -1;
                        }
                        return (left < right) ? -1 : ((left.equals(right)) ? 0 : 1);
                    }
                }
        );
        for (int to = 1; to < graph.getVertexCount(); to++) {
            if (pathsTree.getDistance(to) != null) {
                System.out.println(pathsTree.getDistance(to));
            } else {
                System.out.println("NO");
            }
        }
    }
}