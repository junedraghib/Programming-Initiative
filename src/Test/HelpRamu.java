package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 30-Dec-2018
 */
public class HelpRamu {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while(t > 0)
        {
            int n = s.nextInt();
            int[] ticket = new int[n];
            
            int i = 0;
            while(i < n)
            {
                ticket[i] = s.nextInt();
                i++;
            }
            
            int nr = s.nextInt();
            int nc = s.nextInt();
            
            int[] rt = new int[nr];
            int[] ct = new int[nc];
            
            i = 0;
            while(i < nr)
            {
                rt[i] = s.nextInt();
                i++;
            }
            
            i = 0;
            while(i < nc)
            {
                ct[i] = s.nextInt();
                i++;
            }
            
            //checking cost with c1 and c2
            i = 0;
            int costr = 0;
            int costc = 0;
            while(i < nr)
            {
                costr += Math.min(rt[i]*ticket[0], ticket[1]);
                i++;
            }
            
            i = 0;
            while(i < nc)
            {
                costc += Math.min(ct[i]*ticket[0], ticket[1]);
                i++;
            }
            
            int costt = Math.min(costr, ticket[2]) + Math.min(costc, ticket[2]);
            System.out.println(Math.min(costt, ticket[3]));
            
            t--;
        }
    }
}