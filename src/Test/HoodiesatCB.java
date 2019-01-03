package Test;

import java.util.Scanner;

import Lec13.Queue;
import Lec14.QueueReverse;

/**
 * created by : Juned Raghib
 * created on : 02-Jan-2019
 */
public class HoodiesatCB {

	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void hoodies(int q) throws Exception{ 
		
		while(q >= 0)
		{
		    char op = scn.next().charAt(0);
		    if(op == 'E')
		    {
		        int x = scn.nextInt();
		        int y = scn.nextInt();
		        
		    }
		    else
		    {
		        
		    }
		    
		    q--;
		}


		
	} 

	    public static void oppE(Queue course, Queue rollno, int c, int r, boolean flag) throws Exception
	    {
	        QueueReverse.queueActualReverese(course);
	        QueueReverse.queueActualReverese(rollno);
	        
	        if(course.isEmpty() && rollno.isEmpty())
	        {
	            return;
	        }
	        
	        int curcou = course.dequeue();
	        int currol = rollno.dequeue();
	        // boolean flag = false;
	        
	        if(c == curcou && !flag)
	        {
	            flag = true;
	        }
	        else
	        {
	            flag = false;
	        }
	        
	        oppE(course, rollno, c, r, flag);
	        
	        if(c == curcou && flag)
	        {
	            course.enqueue(c);
	            rollno.enqueue(r);
	        }
	        
	        course.enqueue(curcou);
	        rollno.enqueue(currol);
	        
	    }
	    
	    

}
