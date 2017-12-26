//Nodes implementation
package binarySearchTree;
class Node
{
    public int value;
    public Node left;
    public Node right;
    
    /*  Constructors */
    public Node()
    {
        left = null;
        right= null;
        value = 0;
    } 

    public Node(int data,Node node1, Node node2)
    {
        value = data;
        left = node1;
        right= node2;
    }  

}