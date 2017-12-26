package bfsGraph;

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
    public void makeEdge(int to, int from) 
    {
        try 
        {
            adjacency_matrix[to][from] = 1;
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
    }
    // Return Edge value
    public int getEdge(int to, int from) 
    {
        try 
        {
            return adjacency_matrix[to][from];
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }
}
