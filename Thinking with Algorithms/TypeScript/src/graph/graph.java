import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Graph implementation.
 * 
 * Graph Traversal Algorithms lay foundation for Artificial Intelligence.
 * 
 * @author Andrei Drynov
 */
public class Graph {

    private ArrayList<GraphNode> nodes;

    /**
     * Graph edges can be represented with a 2D-array using "Adjacency Table"
     * A B C D E
     * A 1 0 0 0 0
     * B 0 0 1 0 0
     * C 0 0 0 1 1
     * D 0 0 0 0 0
     * E 1 0 1 0 0
     * <p>
     * Time complexity: O(1)
     * Space complexity: O(N^2)
     * <p>
     */
    private int[][] matrix;

    /**
     * Graph edges can be represented using Adjacency List
     * <p>
     * A -> B
     * B -> C -> E
     * E -> A -> C
     */
    private ArrayList<LinkedList<GraphNode>> nodes2;

    /**
     * Constructor
     *
     * @param size Number of graph nodes
     */
    public Graph(int size) {
        this.matrix = new int[size][size];
        this.nodes = new ArrayList<>(size);
    }

    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    /**
     * Adds a relation (the) edge between two nodes.
     *
     * @param src  Origin node
     * @param dest Destination node
     */
    public void addEdge(int src, int dest) {
        matrix[src][dest] = 1;
    }

    /**
     * Checks whether the two nodes are connected
     *
     * @param src  Origin node
     * @param dest Destination node
     * @return True if the nodes are connected
     */
    public boolean connected(int src, int dest) {
        return matrix[src][dest] == 1;
    }

    public void print() {
        // print columns
        System.out.print("  ");
        for (var node : nodes) {
            System.out.print(node.value() + " ");
        }

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {

            System.out.print(nodes.get(i).value() + " ");

            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
