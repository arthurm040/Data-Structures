public class GenericQueue<E>
{
    public Node first;
    public Node last;
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
   
       public void add(E e) // make the new item top
       {
           if (first == null) 
           {
               first = new Node(e, null);
               last = first;
           }
           else 
           {
               last.next = new Node(e, null);
               last = last.next;
           } 
           size++;
       }
       
       
       public E remove()  //make the next item top and return the old top
       {
           if (first == null) 
               return null;
           
               E temp = first.e;
               first = first.next;
               size--;
           return temp;
       }
      
       public E peek()  // return the top item
       {
           if (first == null) 
               return null;
           return first.e;
       }
       
       public E getLast()  // return the top item
       {
           if (first == null) 
               return null;
           return last.e;
       }
       
       public int getSize()
       {
           return size;
       }
       
       public boolean isEmpty()
       {
           if (first == null) 
               return true;
           return false;
       }
       
       public Object [] toArray()
       {
           Object[] array = new Object [size];
    
           if (first == null)
               return array;
           
           Node ptr = first;
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
           if (first == null)
               return "";
           
           String result = "";
           Node ptr = first;
           
           while(ptr != null)
           {
               result += ptr.e + "\n";
               ptr = ptr.next;
           }
           return result;
       }
}
