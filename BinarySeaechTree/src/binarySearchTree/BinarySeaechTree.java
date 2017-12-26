package binarySearchTree;

import java.util.Scanner;

public class BinarySeaechTree {

    public static Node root;
   
    /* Constructor */
    public BinarySeaechTree()
    {
    	root=null;
    }   
    /*  Function to insert an element  */
    public Node insert(Node root,int val)
    {
        Node node = null;
        node = new Node(val, null, null);
        if (root == null)
        	return node;
        else
        	//If val is less than node value go to left else go to left
        	if(root.value>val)
        		root.left=insert(root.left,val);
        	else
        		root.right=insert(root.right,val);
        	return root;
    }
    
    
    /*  Function for inorder traversal for binary search tree */
    public void inorder(Node node)
    {
        if (node == null) 
        {
            return;
        }
        inorder(node.left);
        System.out.print(node.value+" ");
        inorder(node.right);
        
    }
    /* Function to find inorder successor*/
    public Node inorderSuccessor(Node node){
    	if(node==null)
    		return null;
    	if(node.left==null)
    		return node;
    	else
    		return (inorderSuccessor(node.left));
    }
    
    
    /* Function to delete an element from the Tree */
    public Node delete(Node node, int val){
    	if(node==null){
    		System.out.println("\nElement not Found \n");
    		return null;
    	}
    	//If val is less than node value go to left else go to left
    	if(node.value>val){
    		node.left =delete(node.left,val);
    		return node;
    	}
    	else if(node.value<val){
    		node.right=delete(node.right,val);
    		return node;
    	}
    	else{
    		//Case 1: we're deleting leaf node
    		if(node.left==null && node.right==null)
    			return null;
    		//Case 2 : node is having only one child 
    		else if(node.left==null)
    			return node.right;
    		else if(node.right==null)
    			return node.left;
    		//Case 3: node is having both child, find inorder successor, swap the nodes
    		else{
    			// Find inorder successor
    			Node successor = inorderSuccessor(node.right);
    			// Replace value
    			node.value=successor.value;
    			// delete inorder successor node
    			node.right=delete(node.right,successor.value);
    		
    			return node;
    		}
    	
    	}
    }    
    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of Binary search tree */
        BinarySeaechTree bt = new BinarySeaechTree(); 
        System.out.println("Binary Search Tree\n");
        System.out.println("Please Insert No. of element you want to insert in tree\n");
        int size = scan.nextInt();
        if(size>0)
        {
        	for(int i=0;i<size;)
        	{
        		System.out.println("\nPlease enter element no."+(i));
        		int val = scan.nextInt();
        		if(val>=0){
        			root=bt.insert(root, val ); 
        			i++;
        		}
        		else
        		{
        			System.out.println("\nTree must have positive numbers only\n");
        		}
        	}
        	System.out.println("\nInorder traversal for tree\n");
        	bt.inorder(root);
        }
        else
        {
        	System.out.println("\nNot valid entry\n");
        }
        char ch;
        do{
        	System.out.println("\nPlease Insert element you want to delete in tree\n");
            int val = scan.nextInt();
        	root=bt.delete(root,val);
        	System.out.println("\nInorder traversal for tree\n");
        	bt.inorder(root);
        	System.out.println("\nWant to delete another element(y or n)\n");
        	ch=scan.next().charAt(0);
        }while (ch == 'Y'|| ch == 'y');  
    }
 

}
