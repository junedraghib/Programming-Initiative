package Lec06;

import java.util.Scanner;

public class allSubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		allSubStrings(s);
		System.out.println();
		System.out.println("Palindromic : "+isPalindrome(s));
		System.out.println("Palindromic SubStrings count : "+countPalindromicSubString(s));
	}
	
	public static void allSubStrings(String s)
	{	
		System.out.println("All Palindromic Substrings : ");
		for(int i = 0; i < s.length(); i++)
		{
			for(int j = i + 1; j <= s.length(); j++)
			{
				System.out.print(s.substring(i,j)+" ");
			}
		}
	}
	
	
	public static boolean isPalindrome(String s)
	{
		int i = 0;
		int j = s.length() - 1;
		
		for(; i < s.length() -1 && j >= 0; i++, j--)
		{
			if (s.charAt(i) != s.charAt(j))
			{
				return(false);
			}
		}
		
		return(true);
	}

	public static int countPalindromicSubString(String s)
	{
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			for(int j = i + 1; j <= s.length(); j++)
			{
				if (isPalindrome(s.substring(i,j))) {
					count++;
					System.out.println(s.substring(i,j));
				}
			}
		}
		
		return count;
	}
}
