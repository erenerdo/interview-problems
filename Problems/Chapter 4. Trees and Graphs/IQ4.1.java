import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 4: Tree and Graphs
        // IQ 4.1 Route Between Node

        /*
        Question:

        Given a directed graph, design an algorithm to find out whether there is a
        route between two nodes.

        Graph:

        1 -> 2
        1 -> 5

        2 -> 3
        2 -> 4

        3 -> 5
        3 -> 6

        4 -> 6

        Solution:

        Pseudo Code: Visit all nodes in BFS order and see if it possible to get to the destination


         */

        Graph g = new Graph(7);

        g.addLink(1,0);
        g.addLink(1,2);
        g.addLink(1,5);
        g.addLink(2,3);
        g.addLink(2,4);
        g.addLink(3,5);
        g.addLink(3,6);
        g.addLink(4,6);


        int source = 1;
        int destination = 6;

        System.out.println("Route between " + source + " and " + destination + " is " + g.isPath(source, destination) );



    }




    public static class Graph {

        public static Vertex[] adj_list;

        Graph(int size){

            adj_list = new Vertex[size];

            for ( int i = 0; i < adj_list.length; i++){
                adj_list[i] = null;
            }

        }

        public void addLink(int source, int destination){

            Vertex v = new Vertex(destination);

            // No link before
            if (adj_list[source] == null){
                adj_list[source] = v;
            }
            else {

                v.next = adj_list[source];
                adj_list[source] = v;


            }

            System.out.println("Built connection from " + source + " -> " + destination);

        }

        public boolean isPath (int source, int destination){

            System.out.println("\nChecking for route between " + source + ", " + destination);

            if (source >= adj_list.length || source < 0 || destination >= adj_list.length || destination < 0)
                return false;

            LinkedList<Integer> Queue = new LinkedList<>();

            // Initialize Queue
            Queue.add(source);

            HashSet<Integer> visited = new HashSet<>();

            visited.add(source);

            while (!Queue.isEmpty()) {

                int q = Queue.removeLast();

                System.out.println("Visiting: " + q);

                if (q == destination)
                    return true;

                Vertex ptr = adj_list[q];

                while (ptr != null) {

                    if(!visited.contains(ptr.data)) {
                       // System.out.println("Ptr: " + ptr.data);
                        Queue.addFirst(ptr.data);
                        visited.add(ptr.data);

                    }

                    ptr = ptr.next;

                }
            }

            System.out.println("All possible destinations visited");

            return false;

        }



        public class Vertex {
            int data;
            Vertex next;

            Vertex(int data){
                this.data = data;
                next = null;
            }

        }

    }


}