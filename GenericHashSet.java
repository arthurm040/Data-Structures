public class GenericHashSet <E>
{
    private Object [] array;
    private int size = 0;

    public GenericHashSet()
    {
        this.array = new Object[10];
    }
    
    public void add(E item)
    {
        if (contains(item))
            return;
        
        if (size > (array.length * 8)/10)  //80% percent full
                resize();
        
        int location = Math.abs((item.hashCode() % array.length));
        
        if (array[location] == null) //best case scenario // spot is empty
        {
            array[location] = item;
            size++;
            return;
        }
        else 
        {
            for (int i = location; i < array.length; i++)  // find the next open spot
            {
                if (array[i] == null)
                {
                    array[i] = item;
                    size++;
                    return;
                } 
            }
        }
        
        location = Math.abs((item.hashCode() % array.length)); 
        
        for (int i = 0; i < location; i++) //check from the beginning to the normal location
        {
            if (array[i] == null)
            {
                array[i] = item;
                size++;
                return;
            } 
        }
        
    }
    
    private void resize()
    {
        Object [] temp = new Object[array.length * 2]  ;
        boolean filled;
        
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null)
                continue;
             else 
             {
                 filled = false;
                 int location = Math.abs((array[i].hashCode() % temp.length));
                
                 if (temp[location] == null) 
                     temp[location] = array[i];
                 else 
                 {
                     for (int j = location; j < temp.length; j++) 
                     {
                         if (temp[j] == null)
                         {
                             temp[j] = array[i];
                             filled = true;
                             break;
                         } 
                     }
                     
                     if (filled == false)
                     {
                         location = Math.abs((array[i].hashCode() % array.length));
                         
                         for (int q = 0; q < location; q++) 
                         {
                             if (temp[q] == null)
                             {
                                 temp[q] = array[i];
                                 break;
                             } 
                         }
                     }
                 }
             }
             
        }   
            
        array = temp;
    }
    
    public boolean contains(E item)
    {
        int location = Math.abs((item.hashCode() % array.length));
        
        if (array[location] == item)
            return true;
        
        for (int i = location; i < array.length; i++)
        {
            if (array[i] == item)
                return true;
            
            if (array[i] == null)
                return false;
        }
        
        location = Math.abs((item.hashCode() % array.length));
        
        for (int i = 0; i < location; i++)
        {
            if (array[i] == item)
                return true;
            
            if (array[i] == null)
                return false;
        }
        
        return false;   
    }
    
    public E get(E item)
    {
        int location = Math.abs((item.hashCode() % array.length));
        
        if (array[location] == item)
            return item;
        
        for (int i = location; i < array.length; i++)
        {
            if (array[i] == item)
                return item;
            
            if (array[i] == null)
                return null;
        }
        
        location = Math.abs((item.hashCode() % array.length));
        
        for (int i = 0; i < location; i++)
        {
            if (array[i] == item)
                return item;
            
            if (array[i] == null)
                return null;
        }
        
        return null;   
        
    }
    
    public boolean delete(E item)
    {
        int location = Math.abs((item.hashCode() % array.length));
        
        if (array[location] == item)
        {
            array[location] = null;
            size--;
            return true;
        }
        
        for (int i = location; i < array.length; i++)
        {
            if (array[i] == item)
            {
                array[i] = null;
                size--;
                return true;
            }
            
            if (array[i] == null)
                return false;
        }
        
        location = Math.abs((item.hashCode() % array.length));
        
        for (int i = 0; i < location; i++)
        {
            if (array[i] == item)
            {
                array[i] = null;
                size--;
                return true;
            }
            
            if (array[i] == null)
                return false;
        }
        
        return false;   
    }
    
    public int getSize()
    {
        return size++;
    }
    
    public int length() 
    {
        return array.length;
    }
    
    public Object [] keySet()
    {
        return array;
    }
    
    public String toString()
    {
        String result = "";
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null)
                continue;
            
            result += array[i] + "\n";
        }
        
        return result.substring(0, result.length() - 1);
    }
}