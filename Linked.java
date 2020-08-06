public class Linked<E>
{
    public Node head;
    public Node tail;
    private int size;
    
    public class Node
    {
        E item;
        Node next;
        Node previous;
        
        public Node(E item, Node next, Node previous)
        {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }
        
        public void addBack(E n)
        {
            if (head == null)
            {
                head = new Node(n, null, null);
                tail = head;
                this.size = 1;
            }
            else {
                tail.next = new Node(n, null, tail);
                tail = tail.next;
                size++;
            }
        }
        
        public void addFront(E n)
        {
            if (head == null)
                addBack(n);
            else 
            {
                Node temp = new Node(n, head, null);
                head.previous = temp;
                head = temp;
                size++;
            }
        }
        
        public int contains(int E)
        {
            Node ptr = head;
            int index = 0;
            
            while (ptr != null)
            {
                if (ptr.item.equals(E))
                    return index;
                
                ptr = ptr.next;
                index++;
            }
            return -1;
        }
        
        public E findAtIndex(int n) //returns null one if index is invalid
        {
            if (n < 0 || n > size -1)
                return null;
          
            Node ptr = head;
            int index = 0;
            
            while (ptr != null)
            {
                if (index == n)
                    return ptr.item;
                
                ptr = ptr.next;
                index++;
            }
            return null;
        }
        
        public void deleteHead()
        {
            head = head.next;
            head.previous = null;
            size--;
        }
        
        public void deleteTail()
        {
            tail = tail.previous;
            tail.next = null;
            size--;
        }
        
        public boolean delete(E n)
        {
            if (head.item == n)
            {
                deleteHead();
                return true;
            }
            
            if (tail.item == n)
            {
                deleteTail();
                return true;
            }
            
            Node ptr = head;
            
            while (ptr != null)
            {
                if (ptr.item == n)
                {
                  ptr.previous.next = ptr.next;
                  ptr.next.previous = ptr.previous;
                  size--;
                  return true;
                }
                ptr = ptr.next;
            }
            return false;
        }
        
        public Object[] toArray()
        {
            Object[] result = new Object[size];
            
            Node ptr = head;
            int index = 0;
            
            while (ptr != null)
            {
                result[index] = ptr.item;
                ptr = ptr.next;
                index++;
            }
            return result;
        }
        
        public Object[] reverseArray()
        {
            Object [] result = new Object[size];
            
            Node ptr = tail;
            int index = 0;
            
            while (ptr != null)
            {
                result[index] = ptr.item;
                ptr = ptr.previous;
                index++;
            }
            return result;
        }
        
        public int getSize()
        {
            return size;
        }
        
        public String toString()
        {
            String result = "[";
            Node ptr = head;
            
            while (ptr != null)
            {
                result += "" + ptr.item + "-> ";
                ptr = ptr.next;
            }
            return result.substring(0, result.length() - 3) + "]";
        }
    }