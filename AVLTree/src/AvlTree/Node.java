//Nodes implementation
package AvlTree;
class Node
{
    public int value, height;
    public Node left;
    public Node right;
    
    /*  Constructors */
    public Node()
    {
        left = null;
        right= null;
        value = 0;
        height=0;
    } 

    public Node(int data,int ht,Node node1, Node node2)
    {
        value = data;
        height = ht;
        left = node1;
        right= node2;
    }  

}