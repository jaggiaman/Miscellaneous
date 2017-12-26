package hashing;
import java.math.BigInteger;
import java.util.Scanner;

public class LinearProbe {
	public static String[]input = {"tommy", "jacky", "billa", "willy", "batman", "superman", "wonderwoman", "aquaman", "green", "spiderman", "ironman", "captain", "guruu", "antman", "zoravar", "khalesi", "Drago"};
    public int currentSize;
    public String[] keys;
    public String[] value;
    public int Max;

    /** Constructor **/
    public LinearProbe(int max)
    {
        currentSize = 0;
        Max = max;
        keys = new String[Max];
        value = new String[Max];
    }

    public void printHash()
    {
        for (int i = 0; i < Max; i++)
            if (keys[i] != null&&keys[i] != "*")
                System.out.println(keys[i] +" "+ value[i]);
        System.out.println();
    }
    
    /** Functiont to get hash code of a given key **/
    private int hash(String val)
    {
        char key = val.charAt(0);
        int ascii =  (int) key;
        return  ascii % Max;
    }
    
    /** Function to insert key-value pair **/
    public void insert( String[] val)
    {
        for (int n = 0; n<val.length;n++)
        {
            int collision=0;
            String key = val[n];
            int tmp = hash(key);
            int i = tmp;
                if(value[i] != null)
                {
                     while(value[i] != null){
                         i++;
                         System.out.println("collision occuring at " + i+ " for "+val[n]);
                         i %= Max;
                         collision++;
                     }
                }
            System.out.println("No. of collision for  " + key + " is = " + collision);
           value[i] = key;
            keys[i] = String.valueOf(i);
           currentSize++;
           if(currentSize> (Max/2))
           {
        	  System.out.println("Load facor is greater than 0.5");
        	  System.out.println("------------------------------->");
        	  System.out.println("Increase the table size and restart");
              BigInteger Size = new BigInteger(String.valueOf(Max));

               Max = Size.nextProbablePrime().intValue();
               clear();
               value = new String[Max];
               insert(input);
               break;
           }
        }
    }

    /** Function to clear hash table **/
    public void clear()
    {
        currentSize = 0;
        keys = new String[Max];
        value = new String[Max];
    }
   
    public String get(String val)
    {
        int i = hash(val);
        while (keys[i] != null)
        {
            //if (Integer.parseInt(keys[i])== i)
            if(value[i].equals(val))
            	return keys[i];
            i = (i + 1) % Max;
        }
        return null;
    }

    /** Function to remove key and its value **/
    public void delete(String key)
    {
        if (get(key)!=null)
        
        {
        	int i = Integer.parseInt(get(key));
        	keys[i] = "*";
        }
        else
        	return;
       
    }

    public static void main(String[] args)
    {
    	char ch;
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Implementation\n\n");
        System.out.println("Enter maximum size");
	int size = scan.nextInt();
        LinearProbe lp = new LinearProbe(size);

        
        do
        {
            System.out.println("\nPlease select Operations\n");
            System.out.println("1 for Insert ");
            System.out.println("2 for Delete");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                
                    lp.insert(input);
                    break;
                case 2 :
                    System.out.println("Enter value u want to delete");
                    lp.delete( scan.next() );
                    break;
                default :
                    System.out.println("Wrong Input \n ");
                    break;
            }
	    System.out.println("Hash Table--------->\n");
            lp.printHash();

            System.out.println("\nWant to continue (y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}

