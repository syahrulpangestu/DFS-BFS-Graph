package com.strukdat;

import java.util.*;

class Graph{
    int vertex;
    LinkedList<Integer>[] list;

    Graph(int vertex){
        this.vertex=vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i]= new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        list[src].addFirst(dest);
    }

    public void DepthFirstTraver() {
        System.out.println("Depth First Traversal : ");
        boolean[] isVisited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();

        for (int firstNode = 1; firstNode < vertex; firstNode++) {
            if (!isVisited[firstNode]){
                stack.push(firstNode);
                isVisited[firstNode] = true;
                while (!stack.isEmpty()){
                    int nodeIndex = stack.pop();
                    System.out.print(nodeIndex + " ");
                    LinkedList<Integer> nodeList = list[nodeIndex];
                    for (int dest : nodeList) {
                        if (!isVisited[dest]) {
                            stack.push(dest);
                            isVisited[dest] = true;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public void BreadthFirstTraver() {
        System.out.println("Breadth First Traversal : ");
        boolean[] isVisited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        int firstNode = 1;
        isVisited[firstNode] = true;
        queue.add(firstNode);
        while (queue.size()!=0){
            firstNode = queue.poll();
            System.out.print(firstNode+" ");
            LinkedList<Integer> nodeList = list[firstNode];
            for (int dest : nodeList) {
                if (!isVisited[dest]) {
                    queue.add(dest);
                    isVisited[dest] = true;
                }
            }
        }
    }

    public void printGraph(){
        for (int i = 0; i < vertex ; i++) {
            LinkedList<Integer> nodeList = list[i];
            if(!nodeList.isEmpty()) {
                System.out.print("source = " + i + " is connected to nodes: ");
                for (Integer integer : nodeList) {
                    System.out.print(" " + integer);
                }
                System.out.println();
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(12);

//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(2, 3);
//        graph.addEdge(4, 0);
//        graph.addEdge(4, 1);
//        graph.addEdge(4, 5);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 9);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);
        graph.addEdge(7, 11);
        graph.addEdge(8, 9);
        graph.addEdge(8, 11);
        graph.addEdge(9, 5);
        graph.addEdge(9, 8);
        graph.addEdge(11, 7);
        graph.addEdge(11, 10);
        graph.printGraph();
        graph.DepthFirstTraver();
        graph.BreadthFirstTraver();
    }
}
