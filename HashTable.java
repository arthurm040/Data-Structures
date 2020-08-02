public class HashTable
{
    private BinaryTree[] table; 
    
    public HashTable() //array with 10 spots
    {
        table = new BinaryTree[10];
        for (int i = 0; i < table.length; i++)
        {
            table[i] = new BinaryTree();
        }
    }
    
    public HashTable(int capacity) // specific size array
    {
        table = new BinaryTree[capacity];
        
        for (int i = 0; i < capacity; i++)
        {
            table[i] = new BinaryTree();
        }
    }
    
    public void add(int item)
    {
        int location = item % table.length;
        table[location].add(item);
    }
    
    public boolean contains(int item)
    {
        int location = item % table.length;
        return table[location].contains(item);
    }
    
    public boolean delete(int item)
    {
        int location = item % table.length;
        return table[location].delete(item);
    }
    
    
    public int [] toArray()
    {
        int [] result = new int[totalSize()];
        int j = 0;
        
        for (int i = 0; i < table.length; i++)
        {
            if (!table[i].isEmpty())
            {
                int [] temp = new int [table[i].size()];
                temp = table[i].toArray();
                
                for (int k = 0; k < temp.length; k++)
                {
                    result[j] = temp[k];
                    j++;
                }
            }
        }
        return result;
    }
    
    public int totalSize()
    {
        int result = 0;
        for (int i = 0; i < table.length; i++)
        {
            if (!table[i].isEmpty())
            {
                result += table[i].size();
            }
        }
        return result;
    }
    
    public String treePrint()
    {
        String result =  "";
        
        for (int i = 0; i < table.length; i++)
        {
            if (table[i].isEmpty())
            {
                result += "[]\n";
            }
            else {
                result +=  table[i].treePrint() + "\n";
            }
            result += "\n";
        }
        return result + "";
    }
    
    @Override
    public String toString()
    {
        String result =  "";
        
        for (int i = 0; i < table.length; i++)
        {
            if (table[i].isEmpty())
            {
                result += "[]\n";
            }
            else {
                result += "[" + table[i].toString() + "]\n";
            }
        }
        return result + "";
    } 
}