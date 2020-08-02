import java.util.ArrayList;

public class BinaryTree
{
    public Node root;
    private int size = 0;
    private ArrayList<Integer> temp = new ArrayList<Integer>();
    
    public class Node
    {
        int item;
        Node left;
        Node right;
        
        public Node(int item, Node left, Node right)
        {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
        
        public void add(int item)
        {
            temp.clear();
            if(root == null)   // if this is the first item create the root 
            {
                root = new Node(item, null, null);
                size++;
                root.left = null;
                root.right = null;
            }
            else {
                Node ptr = root;  // start looking at the root
                boolean notDone  = true;
                
                while (notDone)
                {
                    if (item > ptr.item) //if the value is greater look to the right 
                    {
                        if (ptr.right == null) //if its empty create new node and end loop
                        {
                            ptr.right = new Node(item, null, null);
                            size++;
                            notDone = false;
                        }
                        else                    // if empty new right node is the starting loop
                            ptr = ptr.right;
                    }
                    else {
                            if (ptr.left == null)
                            {
                                ptr.left = new Node(item, null, null);
                                notDone = false;
                                size++;
                            }
                            else 
                                ptr = ptr.left;
                    }
                }
            }
        }
        
        public boolean isEmpty()
        {
            return root == null ? true: false;
        }
        
        public boolean contains(int item)
        {
            if (root == null) // if the tree is empty then it does not contain the item
                return false;
            else 
            {
                Node ptr = root;
                
                while (ptr != null)  // compares the item to the nodes and decide whether to go left or right
                {
                    if (item == ptr.item)
                        return true;
                    else 
                    {
                        if (item > ptr.item)
                            ptr = ptr.right;
                        else 
                            ptr = ptr.left;
                    }
                }
                return false;
            }
        }
        
        public boolean delete(int value)
        {
            if (root == null) //checks for an empty tree
                return false;
            else {
                Node ptr = root;
                Node previous = null; //keeps track of the parent of the found value
                
                while (ptr != null)
                {
                    if (value == ptr.item)  // value is found and can get deleted
                    {
                        int children = numOfChildren(ptr);  //gets the number of children of the current node
                        if (children == 0) // this is only for a node with no children
                        {
                            if (size == 1)  //if there is only one item then the root is null
                                root = null;
                            else {
                                if (previous.right != null) // determine if it is the left or right child and turns the the child null
                                    {
                                        previous.right = null;
                                        ptr = null;
                                    }
                                else 
                                {
                                    if (previous.left != null)
                                    {
                                        previous.left = null;
                                        ptr = null;
                                    }
                                }
                            }
                        }
                        else {
                            if (children == 1) // one child
                            {
                                
                                if (ptr.left == null)
                                {
                                    ptr.item = ptr.right.item;  //replaces the value in the value and makes the pointer null
                                    ptr.right = null;
                                }
                                else {
                                    ptr.item = ptr.left.item;
                                    ptr.left = null;
                                }
                            }
                            else {   //2 children
                                Node replace = ptr; 
                                Node before = null;
                                
                                if (previous == null) // this only happens when the root is the value searched
                                {
                                    while (ptr != null)
                                    {
                                        before = replace;
                                        replace = ptr;
                                        ptr = ptr.right;
                                    }
                                    root.item = replace.item; 
                                    before.right = null;
                                }
                                else {
                                    if (previous.left.item == value) //determines if the value is the right or left child of its parent
                                    {
                                        if (value > root.item) //determines whether we are on the right or left side
                                        {
                                            while (ptr != null) //finds the highest child if we are on the left and lowest if we are the left
                                            {   //also keeps track of the value before the replacement value
                                                before = replace;
                                                replace = ptr; 
                                                ptr = ptr.left;
                                            }
                                        }
                                        else {
                                            while (ptr != null)
                                            {
                                                before = replace;
                                                replace = ptr;
                                                ptr = ptr.right;
                                            }
                                        }
                                        previous.left.item = replace.item; // replaces the pointer with the replacement value
                                        before.right = null; // and makes the replacement value null
                                    }
                                    else {
                                   
                                        if (value > root.item)
                                        {
                                            while (ptr != null)
                                            {
                                                before = replace;
                                                replace = ptr;
                                                ptr = ptr.left;
                                            }
                                        }
                                        else {
                                            while (ptr != null)
                                            {
                                                before = replace;
                                                replace = ptr;
                                                ptr = ptr.right;
                                            }
                                        }
                                        previous.right.item = replace.item;
                                        before.left = null;
                                    }
                                }
                            }
                        }
                        size--;
                        return true; 
                    }
                    else {                      // keeps comparing to the searched value 
                        if (value > ptr.item)
                        {
                            previous = ptr;
                            ptr = ptr.right;
                        }
                        else 
                        {
                            previous = ptr;
                            ptr = ptr.left;
                        }
                    }
                }
            }
            return false;
        }
        
        private int numOfChildren(Node ptr) //private helper functions that determines the number of children a node has
        {
            if (ptr.left == null && ptr.right == null)
                return 0;
            else {
                if (ptr.left != null && ptr.right != null)
                    return 2;
                else 
                    return 1;
            }
        }

        public int height() // goes to the farthest items to the left or right and compares how far or right it went 
        {
            if (root == null)
                return 0;
                
            Node ptr = root;
            int left = 0;
            int right = 0;
            
            while (ptr != null)
            {
                ptr = ptr.left;
                left++;
            }
            
            ptr = root;
            
            while (ptr != null)
            {
                ptr = ptr.right;
                right++;
            }
            
            return left > right ? left: right;
        }
        
        public int size()
        {
            return size;
        }
        
        public Integer[] toArray(Node ptr)
        {
            Integer [] result = new Integer[size];
            if (root == null)
                return null;
            
            if (ptr != null)
            {
                toArray(ptr.left);
                toArray(ptr.right);
                temp.add(ptr.item);
            }
            
            result = temp.toArray(result);
            
            return result;
        }
        

        public int [] toArray()
        {
            int [] result = new int [size];
            String [] temp = toString().split("\\s+");
            
            for (int i = 0; i < temp.length; i++)
                result[i] = Integer.valueOf(temp[i]);
                
            return result;
        }
        
        public String treePrint()
        {
            if (root == null)
                return "";
                
            int depth = height(); //gets the depth of the tree
            Node [][] tree = new Node[depth][(int) Math.pow(2, depth)];
            //created 2d array with the depth of the tree and columns equals the max number of item in the bottom row
            
            tree[0][0] = root; // assigns the root as the head of the array
            
            for (int level = 1; level < depth; level++) //iterates through every level
            {
                for (int i = 0; i < Math.pow(2, level- 1); i++) //iterates through the number of itms expected in a row
                {
                    if (tree[level -1][i] == null) 
                    {
                        tree[level][i * 2] = null; 
                        tree[level] [i * 2 + 1] = null; 
                    }
                    else 
                    {
                        tree[level][i * 2] = tree[level- 1] [i].left; //assigns the node if the parent is  not null
                        tree[level] [i * 2 + 1] = tree[level -1][i].right;                     
                    }
                }  
            }
            
            //print2D(tree);
            String result = "";
            for (int level = 0; level < tree.length; level++)
            {
                for (int j = 0; j < tree[level].length; j++)
                {
                   if (tree[level][j] != null)
                    result += tree [level][j].item +" ";
                }
                if (level != tree.length - 1)
                    result += "\n";
            }
           
            return result;
        }

        public String toString(Node ptr)
        {
            if (ptr == null)
            {
                return "";
            }
            
            return toString(ptr.left) + ptr.item + " " + toString(ptr.right) + "";
        }

        @Override
        public String toString()
        {
            return toString(root);
        }
    }