import java.util.Arrays;
import java.util.Random;

public class queueTester
{

    public static void main(String[] args)
    {
        Random random = new Random();
        GenericQueue<Integer> g = new GenericQueue<Integer>();
        System.out.println(g.isEmpty());
        
        for (int i = 0; i < 7; i++)
        {
            int r = random.nextInt(100);
            System.out.print(r + "/");
            g.add(r);
        }
        System.out.println();
        System.out.println(g);
        
        System.out.println("popped item: " + g.remove());
        System.out.println("popped item: " + g.remove());
        System.out.println();
        
        System.out.println("After pop \n" + g);
        System.out.println("top of stack " + g.peek());
        System.out.println("last of stack " + g.getLast());
        System.out.println("size: " + g.getSize());
        System.out.println(Arrays.toString(g.toArray()));
    }
}