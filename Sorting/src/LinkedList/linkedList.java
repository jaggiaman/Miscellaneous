package LinkedList;

import java.util.Scanner;


public class linkedList
{
    public static Node start;
    
    /* Constructor */
    public linkedList()
    {
        start=null;
    }
    
    /*  Function to insert an element  */
    public void insert(int val)
    {
        Node node = null;
        node = new Node(val, null);
        if (start == null)
           start = node;
        else 
        {
            node.setNext(start);
            start = node;
        }
    }
    /*  Function to display linked list  */
    public void display(Node node)
    {
        if (node == null) 
        {
            return;
        }
        else
        {
        	System.out.print(node.getData());
        	if(node.getNext()!=null)
        		System.out.print("->");
        	display(node.getNext());
        	return;
        }
        
    }
    
    /*  Function to sort linked list recursively */
    public Node sort(Node head)
    {
        if (head == null||head.getNext()==null) // no need to sort 
        {
            return head;
        }
        int min_val = head.getData();
        Node prev = head;
        Node min = null;
        Node tmp = head.getNext();

        //find minimum value
        while(tmp != null) {
            if(tmp.getData() < min_val) {
            	min_val = tmp.getData();
                //save previous node to remove link
            	min = prev;
            }
            prev = tmp;
            tmp = tmp.getNext();
        }

        if(min == null) {//no minimum node found, carry on with next link 
            head.setNext(sort(head.getNext()));
            return head;
        }
        // minimum value found,swap the values.
       	prev = min;// having link of min node
       	min = prev.getNext();//min node
       	prev.setNext(min.getNext());
       	min.setNext(sort(head));
       	return min;
    }
        
    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
        linkedList list = new linkedList(); 
        System.out.println("Sorting a Single Linked List\n");
        System.out.println("Please Insert No. of element you want to insert in list\n");
        int size = scan.nextInt();
        if(size>0)
        {
        	for(;size>0;)
        	{
        		System.out.println("\nPlease enter element no."+(size));
        		int val = scan.nextInt();
        		if(val>=0){
        			list.insert( val ); 
        			size--;
        		}
        		else
        		{
        			System.out.println("\nList must have positive numbers only\n");
        		}
        	}
        	System.out.println("Unsorted Linked List\n");
        	list.display(start);//Display Unsorted List
        	start=list.sort(start);//Sort the list
        	System.out.println("\nSorted Linked List\n");//Display Sorted list
        	list.display(start);
        }
        else
        {
        	System.out.println("\nNot valid entry\n");
        }
    }
        
}
