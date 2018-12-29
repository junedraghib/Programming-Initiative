package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 27-Dec-2018
 */
public class CompressString {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        
        StringBuilder sb = new StringBuilder(str);
        
        int i = 0;
        while(i < sb.length() - 1)
        {
            int j = i + 1, count = 1;
            
            while(sb.charAt(i) == sb.charAt(j) && j <= sb.length() - 1)
            {
                j++;
                count++;
                if(j >= sb.length())
                {
                    break;
                }
            }
            
            if(count > 1)
            {
                sb.delete(i + 1, j);
                sb.insert(i, count);
                
                i+= Integer.toString(count).length();
            }
            else
            {
                i++;
            }
            
        }
        System.out.println(sb);
    }
}