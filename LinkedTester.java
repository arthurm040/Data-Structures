import java.util.Arrays;
import java.util.Random;

public class LinkedTester
{
    public static void main(String[] args)
    {
        Random random = new Random();
        
        Linked<Integer> l = new Linked<Integer>();
        
        for (int i = 0; i < 8; i++)
        {
            l.addBack(random.nextInt(20));
        }
        
        for (int i = 0; i < 8; i++)
        {
            l.addFront(random.nextInt(20));
        }
        
        System.out.println(l);
        System.out.println("Size: " + l.getSize());
        
        int r;
        int result;
        
        l.deleteHead();
        l.deleteTail();
        
        System.out.println(l);
        System.out.println("Size: " + l.getSize());
        
        for (int i = 0; i < 4; i++)
        {
            r = random.nextInt(20);
            result = l.contains(r);
            
            if (result == -1)
                System.out.print(r + " is not included/ ");
            else 
                System.out.print(r + " is included/ ");
        }
        System.out.println();
        System.out.println("at index 5: " + l.findAtIndex(5));
        System.out.println("at index 20: " + l.findAtIndex(20));
        
        l.delete(l.findAtIndex(5));
        
        System.out.println(l);
       
        System.out.println(Arrays.toString(l.toArray()));
        System.out.println(Arrays.toString(l.reverseArray()));
    }
}