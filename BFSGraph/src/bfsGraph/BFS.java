package bfsGraph;
import java.util.LinkedList;
import java.util.Queue;
public class BFS 
{ 
	public Queue<Integer> queue;
	//Constructor
	public BFS(){
		//Initialize the queue
		queue = new LinkedList<Integer>();
	}
	
	//Function for bfs traversal
	// Return true if all vertex traversed
	public boolean traverse(Graph graph, int source, int visited[]){
		int i, element;
		visited[source] = 1;
		queue.add(source);
		System.out.println("BFS traversal for the graph is ");
		while (!queue.isEmpty())
		{
		    element = queue.remove();
		    i = 0;
		    System.out.print(element + "\t");
		    while (i <= graph.vertices)
		    {
		        if ( graph.getEdge(element,i) == 1 && visited[i] == 0)
		        {
		            queue.add(i);
		            visited[i] = 1;
		        }
		        i++;
		    }
		}
		int count=0;
		for(i=1; i<=graph.vertices; i++){
			if(visited[i] == 1)
				count++;
			else
				source=i;
				boolean check=traverse(graph,source,visited);
		}
		if(count==graph.vertices)
			return true;
		else
			return false;
	}
	
	// To check graph is strongly connected or not
	// Return True if Stronly connected
	public boolean isConnected(Graph graph, int source){
		System.out.println("\nThe transporse of adjacency matrix for the given graph is: ");
        System.out.print("  ");
        for (int i = 1; i <= graph.vertices; i++)
            System.out.print(i + " ");
        System.out.println();
        
		Graph transGraph=new Graph(graph.vertices);
		
		for(int i = 1; i <= graph.vertices; i++)
    	{
			System.out.print(i + " ");
      	    for(int j = 1; j <= graph.vertices; j++)
            {
      	    	transGraph.adjacency_matrix[j][i]=graph.getEdge(i, j);
      	    	System.out.print(graph.getEdge(j, i) + " ");
            }
            System.out.println(" ");
        }
		int[] visited = new int[graph.vertices+1];// to track node visited
		boolean connected = traverse(transGraph,source,visited);
		return connected;
		
	}
}