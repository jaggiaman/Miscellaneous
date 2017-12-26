package mst;

public class MST 
{ 
	 

	    int minKey(int key[], Boolean mstSet[], int V)
	    {

	        int min = Integer.MAX_VALUE, min_index=-1;
	 
	        for (int v = 1; v <= V; v++)
	            if (mstSet[v] == false && key[v] < min)
	            {
	                min = key[v];
	                min_index = v;
	            }
	 
	        return min_index;
	    }
	 

	    void printMST(int parent[], Graph graph)
	    {
	        System.out.println("Edge   Weight");
	        for (int i = 1; i <= graph.vertices; i++)
	        	if(i!=parent[i])
	            System.out.println(parent[i]+" - "+ i+"    "+
	                               graph.getEdge(parent[i],i));
	    }
	 

	    void findMst(Graph graph,int source)
	    {

	    	int vertices=graph.vertices;
	        int parent[] = new int[vertices+1];
	 
	        
	        int key[] = new int [vertices+1];
	 
	        
	        Boolean mstSet[] = new Boolean[vertices+1];
	 

	        for (int i = 1; i <= vertices; i++)
	        {
	            key[i] = Integer.MAX_VALUE;
	            mstSet[i] = false;
	        }
	 
	        // Always include first 1st vertex in MST.
	        key[source] = 0;     // Make key 0 so that this vertex is
	                        // picked as first vertex
	        parent[source] = source; // First node is always root of MST
	 
	       
	        for (int count = 1; count <= vertices-1; count++)
	        {

	            int min = minKey(key, mstSet, vertices);
	 

	            mstSet[min] = true;
	 

	            for (int v = 1; v <= vertices; v++)
	 

	                if (graph.getEdge(min, v)!=0 && mstSet[v] == false &&
	                		graph.getEdge(min, v) <  key[v])
	                {
	                    parent[v]  = min;
	                    key[v] = graph.getEdge(min, v);
	                }
	        }
	 

	        printMST(parent, graph);
	    }
}