package Lec07;

import java.util.Scanner;

public class fibb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(fibbonaci(n));
	}
	
	public static int fibbonaci(int n)
	{
		if (n == 1)
		{
			return 1;
		}
		if (n == 0)
		{
			return 0;
		}
		int fbb = fibbonaci(n-1) + fibbonaci(n - 2);
		return fbb;
	}

}
