package Lec07;

import java.util.Scanner;

public class xpown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		float x = scn.nextFloat();
		int n = scn.nextInt();
		System.out.println(xpowern(x, n));
	}
	
	
	public static float xpowern(float x, int n)
	{
		if (n == 0) 
		{
			return 1;
		}
		float xpn = x*xpowern(x, n -1);
		return xpn;
	}

}
