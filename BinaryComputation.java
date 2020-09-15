import java.util.Stack;
public class BinaryComputation
{
    
    public static void main(String[] args)
    {
        System.out.println(binaryToDecimalUnsigned(1111));
        System.out.println(decimalToBinaryUnsigned(9));
        System.out.println(signedDecimalToBinary(-8));
        
        //if there is a leading zero then add true
        System.out.println(signedBinaryToDecimal(101, false));
        
        System.out.println(maxValueOfBitUnsigned(4));
        System.out.println(maxValueOfBitsigned(3));
        System.out.println(minValueOfBitUnsigned(3));
        
        System.out.println(binaryAddition(1101,1010)); // remove leading zero
    }
    
    public static Integer binaryToDecimalUnsigned(int n)
    {
        int powerof2 = 1;
        int result = 0;
        String s = Integer.toString(n);
        
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == '1')
            {
                result += powerof2;
                powerof2 *= 2;
            }
            else {
                if (s.charAt(i) == '0')
                    powerof2 *= 2;
                else 
                    return null;
            }
        }
        
        return result;
    }

    public static Integer decimalToBinaryUnsigned(int n)
    {
        if (n == 0)
            return 0;
        
        String result = "";
        int  powerOf2 = 1;
        
        Stack<Integer> stack = new Stack<Integer>(); 
        
        while(powerOf2 <= n)
        {
            stack.push(powerOf2);
            powerOf2 *= 2;
        }
        
        int temp = 0;
        int stackSize = stack.size();
        
        for (int i = 0; i < stackSize; i++)
        {
            temp = stack.pop();
            
            if (n / temp == 1)
            {
                n -= temp;
                result += "1";
            }
            else 
                result += "0";
        }
        return Integer.valueOf(result);
    }
    
    public static int signedDecimalToBinary(int n)
    {
        if (n > 0)
        {
            return decimalToBinaryUnsigned(n);
        }
        else 
        {
            String result;
            
            if (n % 2 == 0)
                result = "";
            else
                result = "1";
            int  powerOf2 = 1;
            
            Stack<Integer> stack = new Stack<Integer>(); 
            
            while(powerOf2 <= Math.abs(n))
            {
                stack.push(powerOf2);
                powerOf2 *= 2;
            }
            
            int temp = 0;
            int stackSize = stack.size();
            n = powerOf2 - Math.abs(n);
            
            for (int i = 0; i < stackSize; i++)
            {
                temp = stack.pop();
                
                if (n / temp == 1)
                {
                    n -= temp;
                    result += "1";
                }
                else 
                    result += "0";
            }
            return Integer.valueOf(result);
        }
    }
    
    public static Integer signedBinaryToDecimal(int n, boolean b)
    {
        int powerof2 = 1;
        int result = 0;
        
        String s = "";
        if (b == true)
            s = "0"+Integer.toString(n);
        else
            s = Integer.toString(n);
        
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (i != 0)
            {
                if (s.charAt(i) == '1')
                {
                    result += powerof2;
                    powerof2 *= 2;
                }
                else {
                    if (s.charAt(i) == '0')
                        powerof2 *= 2;
                    else   
                        return null;
                }
            }
            else 
            {
                if (s.charAt(i)== '1')
                    result+= -powerof2;
                else {
                    if (s.charAt(i) != '0')
                        return null;
                }
            }
        }
        return result;
    }
    
    public static int maxValueOfBitUnsigned(int n)
    {
        return (int) (Math.pow(2, n) - 1);
    }
    
    public static int maxValueOfBitsigned(int n)
    {
        return (int) (Math.pow(2, n -1) - 1);
    }
    
    public static int minValueOfBitUnsigned(int n)
    {
        return (int) -(Math.pow(2, n -1));
    }
    
    public static String binaryAddition(int n, int m)
    {
        String s1 = Integer.toString(n);
        String s2 = Integer.toString(m);
        System.out.println(s1);
        System.out.println(s2);
        
        int s1Length = s1.length() - 1;
        int s2Length = s2.length() - 1;
        
        int limit = Math.max(s1Length, s2Length) + 1;
        int rounds = 0;
        char carry = '0';
        String result = "";
        Carrier temp;
        
        while(rounds < limit)  
        {
            if (s1Length >= 0 && s2Length >= 0) //both have digits remaining
            {
                temp =  binaryCompute(s1.charAt(s1Length), s2.charAt(s2Length), carry);
                if (temp == null)
                    return null;
                result = temp.result + "" + result;
                carry = temp.carry;
                s1Length--;
                s2Length--;
            }
            else {
                if (s1Length >= 0 && s2Length < 0) // s1 has digits remaining and s2 is done
                {
                    temp =  binaryCompute(s1.charAt(s1Length), '0', carry);
                    if (temp == null)
                        return null;
                    result = temp.result + "" + result;
                    carry = temp.carry;
                    s1Length--;
                    s2Length--;
                }
                else {                              // opposite of previous
                    temp =  binaryCompute('0', s2.charAt(s2Length), carry);
                    if (temp == null)
                        return null;
                    result = temp.result + "" + result;
                    carry = temp.carry;
                    s1Length--;
                    s2Length--;
                }
            }
            rounds++;
        }
        
        if (carry != '0')
            result = carry + "" + result;
        
        return result;
    }
    
    private static Carrier binaryCompute(char c, char d, char carry)
    {
        if (c != '0' && c != '1')
            return null;
        if (d != '0' && d != '1')
            return null;
        
        if (c == '1' && d == '1')
        {
            if (carry == '1')
                return new Carrier('1', '1');
            else 
                return new Carrier('0', '1');
        }
        else 
        {
            if (c == '0' && d == '0')
            {
                if (carry == '1')
                    return new Carrier('1', '0');
                else 
                    return new Carrier('0', '0');
            }
            else 
            {
                if (carry == '1')
                    return new Carrier('0', '1');
                else 
                    return new Carrier('1', '0');
            }   
        }
    }   
}

class Carrier
{
    char result;
    char carry;
    
    public Carrier(char result, char carry)
    {
        this.result = result;
        this.carry = carry;
    }
}
