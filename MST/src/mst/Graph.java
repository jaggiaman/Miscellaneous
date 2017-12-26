package mst;

public class Graph 
{
    public int vertices;
    public int[][] adjacency_matrix;
    // Constructor to initialize Graph
    public Graph(int v) 
    {
        vertices = v;
        adjacency_matrix = new int[vertices + 1][vertices + 1];
    }
    // Create edge from one vertex to another
    public void makeEdge(int to, int from, int weight) 
    {
        try 
        {
            adjacency_matrix[to][from] = weight;
            adjacency_matrix[from][to] = weight;
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
    }
    // Return Edge value
    public int getEdge(int from, int to) 
    {
        try 
        {
            return adjacency_matrix[from][to];
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }
}
