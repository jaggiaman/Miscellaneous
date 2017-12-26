//Nodes implementation
package LinkedList;
class Node
{
    int value;
    Node next;
    
    /*  Constructors */
    public Node()
    {
        next = null;
        value = 0;
    } 

    public Node(int data,Node node)
    {
        value = data;
        next = node;
    }  
    
    /*  To get data value of node */
    public int getData()
    {
        return value;
    } 
    /*  To set data value*/
    public void setData(int data)
    {
        value = data;
    }   
    /*  To set link to next Node  */
    public void setNext(Node node)
    {
        next = node;
    }     
    /*  To get link*/
    public Node getNext()
    {
        return next;
    }    

}