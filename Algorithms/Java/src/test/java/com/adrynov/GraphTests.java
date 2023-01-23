package com.adrynov;

import com.adrynov.graph.Graph;
import com.adrynov.graph.GraphNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Graphs are useful for social networks or route directions.
 */
public class GraphTests {

    private static Graph graph = new Graph(5);

    @BeforeAll
    static void setup() {
        /**
         * A B C D E
         * A 0 1 0 0 0
         * B 0 0 1 0 0
         * C 0 0 0 1 1
         * D 0 0 0 0 0
         * E 1 0 1 0 0
         */
        graph.addNode(new GraphNode('A'));
        graph.addNode(new GraphNode('B'));
        graph.addNode(new GraphNode('C'));
        graph.addNode(new GraphNode('D'));
        graph.addNode(new GraphNode('E'));
    }


    @Test
    void createGraphUsingAdjacencyTable() {
        graph.addEdge(0, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        assertTrue(graph.connected(2, 4));

//        graph.print();
    }

}
