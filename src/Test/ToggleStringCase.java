package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib created on : 26-Dec-2018
 */
public class ToggleStringCase {

	public static void main(String args[]) {
//		Scanner s = new Scanner(System.in);
//
//		String str = s.next();
//		StringBuilder sb = new StringBuilder(str);
//		int i = 0;
//		while (i < sb.length()) {
//			if (Character.isUpperCase(sb.charAt(i))) {
//				sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
//			} else {
//				sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
//			}
//
//			i++;
//		}
//
//		System.out.println(sb.toString());
		System.out.println(insertASCIIdiff("a"));
	}

	public static StringBuilder insertASCIIdiff(String str)
	{
		StringBuilder sb = new StringBuilder(str);
        
        int i = 1, n = sb.length();
        while(i < sb.length())
        {
            int dif = sb.charAt(i ) - sb.charAt(i - 1);
            //System.out.println(dif);
            sb.insert(i, dif);
            if(dif >= 0)
            {
            	i+=2;
            }
            else
            {
            	i+= 3;
            }
            
        }
        return sb;
	}
}
