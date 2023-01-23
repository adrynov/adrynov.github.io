package com.adrynov;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("Sam");
        queue.add("Anna");
        queue.add("Heidi");
        queue.add("Sally");
        queue.add("John");

        System.out.println(queue);

        while (!queue.isEmpty()) {
            String removed = queue.remove();
            System.out.println(queue);
        }

//        Graph graph = new Graph(5);
//
//        graph.addNode(new GraphNode<>('A'));
//        graph.addNode(new GraphNode<>('B'));
//        graph.addNode(new GraphNode<>('C'));
//        graph.addNode(new GraphNode<>('D'));
//        graph.addNode(new GraphNode<>('E'));
//
//        graph.addEdge(0, 0);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 4);
//        graph.addEdge(4, 0);
//        graph.addEdge(4, 2);
//
//        graph.print();

    }
}
