import java.util.Arrays;
import java.util.Random;

public class HashTableTester
{

    public static void main(String[] args)
    {
        HashTable h = new HashTable();
        
        Random random = new Random();
        
        for (int i = 0; i < 40; i++)
        {
            h.add(random.nextInt(40));
        }
        
        System.out.println(h.treePrint());
        
        for (int i = 0; i < 10; i++)
        {
            int value = random.nextInt(40);
            boolean contains = h.contains(value);
            if (contains)
            {
                System.out.println(value + " is included");
            }
            else {
                System.out.println(value + " is not included");
            }     
        }
        
        System.out.println("the size of the table is " + h.totalSize());
        System.out.println();

        for (int i = 0; i < 10; i++)
        {
            int value = random.nextInt(40);
            System.out.print("to be deleted " + value);
            boolean deleted = h.delete(value);
            if (deleted)
                System.out.print(" deleted");
            else 
                System.out.print(" not deleted");
            
            System.out.println();
        }
        
        System.out.println(h);
        
        System.out.println("the size of the table is " + h.totalSize());
        
        System.out.println(h.treePrint());
        
        System.out.println(Arrays.toString(h.toArray()));
        
    }
}
