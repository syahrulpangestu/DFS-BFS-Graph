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
        boolean[] isVisited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();

        for (int firstNode = 0; firstNode < vertex; firstNode++) {
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

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            LinkedList<Integer> nodeList = list[i];
            if(!nodeList.isEmpty()) {
                System.out.print("source = " + i + " is connected to nodes: ");
                for (Integer integer : nodeList) {
                    System.out.print(" " + integer);
                }
            }
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.printGraph();
        graph.DepthFirstTraver();
    }
}
