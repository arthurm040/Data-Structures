import java.util.Arrays;

public class TreeTester
{

    public static void main(String[] args)
    {
      BinaryTree tree = new BinaryTree();
      
        tree.add(20);
        tree.add(10);
        tree.add(30);
        tree.add(5);
        tree.add(13);
        tree.add(23);
        tree.add(35);
        tree.add(4);
        tree.add(6);
        tree.add(12);
        tree.add(15);
        tree.add(21);
        tree.add(28);
        tree.add(32);
        tree.add(40);
        tree.add(45);
        
        System.out.println("size " + tree.size());
        System.out.println("height " + tree.height());
        System.out.println("tree print \n" + tree.treePrint());
        System.out.println();
        System.out.println(Arrays.toString(tree.toArray(tree.root)));
        System.out.println("Basic toString " + tree);
        System.out.println();
        
        System.out.println(Arrays.toString(tree.toArray()));
        System.out.println();
        
        
        System.out.println(tree);
        
        //delete operation
        
        //no child
        System.out.println(tree);
        tree.delete(45);
        System.out.println(tree);
        System.out.println(tree.treePrint());
        System.out.println();
        
        //one child 
        tree.add(45);
        System.out.println(tree);
        tree.delete(40);
        System.out.println(tree);
        System.out.println(tree.treePrint());
        System.out.println();
        
       //two children
        System.out.println(tree);
        tree.delete(30);
        System.out.println(tree);
        System.out.println(tree.treePrint());
    }
}