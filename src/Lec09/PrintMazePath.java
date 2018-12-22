package Lec09;

import Lec08.MazePath;

public class PrintMazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMazePath(3, 3, "");
		System.out.println(MazePath.getMazePath(0, 0, 3, 3));

	}
	
	public static void printMazePath(int er, int ec, String ans)
	{
		
		if(er == 0 && ec == 0)
		{
			System.out.println(ans);
			return;
		}
		
		
		if (er >= 0) {
			printMazePath(er - 1, ec, ans + "V");
		}
		if(ec >= 0)
		{
			printMazePath(er, ec - 1 , ans + "H");
		}
	}
	
}
