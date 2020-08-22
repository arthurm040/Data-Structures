public class genericStack<E>
{
    private Node top;
    private int size;
    
   public class Node
   {
       public E e;
       public Node next;
       
       public Node(E e, Node next)  //inner class of each node
       {
        this.e = e;
        this.next = next;
       }
   }
   
       public void push(E e) // make the new item top
       {
           if (top == null) 
               top = new Node(e, null);
           else 
               top = new Node(e, top);
           size++;
       }
       
       public E pop()  //make the next item top and return the old top
       {
           if (top == null) 
               return null;
           
               E temp = top.e;
               top = top.next;
               size--;
           return temp;
       }
       
       public E peek()  // return the top item
       {
           if (top == null) 
               return null;
           return top.e;
       }
       
       public int getSize()
       {
           return size;
       }
       
       public boolean isEmpty()
       {
           if (top == null) 
               return true;
           return false;
       }
       
       public Object [] toArray()
       {
           Object[] array = new Object [size];
    
           if (top == null)
               return array;
           
           Node ptr = top;
           int i = 0;
           
           while(ptr != null) // iterate similarly to a linked list 
           {
               array [i]= ptr.e;
               ptr = ptr.next;
               i++;
           }
           return array;
       }
             
       public String toString()
       {
           if (top == null)
               return "";
           
           String result = "";
           Node ptr = top;
           
           while(ptr != null)
           {
               result += ptr.e + "\n";
               ptr = ptr.next;
           }
           return result;
       }
}