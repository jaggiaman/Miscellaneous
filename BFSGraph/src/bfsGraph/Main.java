package bfsGraph;

import java.util.Scanner;

public class Main {
	
	
	
	
    public static void main(String args[]) 
    {
        int vertices, edge;
        int to = 0, from = 0;
        int source;
        Scanner sc = new Scanner(System.in);
        Graph graph;
        System.out.println("Enter the number of vertices: ");
        vertices = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        edge = sc.nextInt();
 
        graph = new Graph(vertices);
 
        System.out.println("Enter the edges: <to> <from>");
        while (edge>0) 
        {
        	System.out.println("Enter edge no:"+ edge);
            to = sc.nextInt();
            from = sc.nextInt();
            if((to>0&&to<=vertices)&&(from>0&&from<=vertices))
            {
            	graph.makeEdge(to, from);
            	edge--;
            }
            else
            	System.out.println("Enter Valid vertices");
        }
 
        System.out.println("The adjacency matrix for the given graph is: ");
        System.out.print("  ");
        for (int i = 1; i <= vertices; i++)
            System.out.print(i + " ");
        System.out.println();
 
        for (int i = 1; i <= vertices; i++) 
        {
            System.out.print(i + " ");
            for (int j = 1; j <= vertices; j++) 
                System.out.print(graph.getEdge(i, j) + " ");
            System.out.println();
        }
        System.out.println("Please enter the source for traversal ");
        source = sc.nextInt();
        if((source>0&&source<=vertices))
        {
        	BFS bfs = new BFS();
        	int[] visited = new int[graph.vertices+1];// to track node visited
        	boolean connected = bfs.traverse(graph,source, visited);
        	if(connected){
        		if(bfs.isConnected(graph,source))
        			System.out.println("\nGiven graph is strongly connected");
            	else
            		System.out.println("\nGiven graph is not strongly connected");
        	}
        	else
        		System.out.println("\nGiven graph is not strongly connected");
        }
        else
        	System.out.println("Enter Valid vertices");
        sc.close();
    }
}
