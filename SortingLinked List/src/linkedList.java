public class linkedList
{
    protected Node start;
    public int size;
    public linkedList()
    {
        start=null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to check size of list  */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element  */
    public void insert(int val)
    {
        Node nptr, ptr, tmp = null;
        nptr = new Node(val, null);
        boolean ins = false;
        if (start == null)
           start = nptr;
        else if (val <= start.getData())
        {
            nptr.setLink(start);
            start = nptr;
        }
        else
        {
            tmp = start;
            ptr = start.getLink();
            while(ptr != null)
            {
                if (val >= tmp.getData() && val <= ptr.getData())
                {
                    tmp.setLink(nptr);
                    nptr.setLink(ptr);
                    ins = true;
                    break;
                }
                else
                {
                    tmp = ptr;
                    ptr = ptr.getLink();
                }
            }
            if (ins == false)
            {
                tmp.setLink(nptr);
            }
        }
        size++;
    }
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getLink();
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node ptr = start;
 
            for (int i = 1; i < size - 1; i++)
                ptr = ptr.getLink();
            ptr.setLink(null);            
            size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }    
    /*  Function to display elements  */
    public void display()
    {
        System.out.print("Sorted Singly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
