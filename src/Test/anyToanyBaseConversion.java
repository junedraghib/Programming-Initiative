package Test;

import java.util.Scanner;

public class anyToanyBaseConversion {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Source Base : ");
        int sb = s.nextInt();
        System.out.print("Destination Base : ");
        int db = s.nextInt();
        System.out.print("Source Number : ");
        int sn = s.nextInt();
        
        System.out.println("Destination Number : "+fromDecimal(toDecimal(sn, sb), db));

    }
    
    
    public static int toDecimal(int sn, int sb)
    {
        int dec = 0, i = 0;
        
        while(sn > 0)
        {
            int rem = sn % 10;
            dec += rem * Math.pow(sb, i);
            i++;
            
            sn /= 10;
        }
        
        return dec;
    }
    
    public static int fromDecimal(int dec, int db)
    {
        int pval = 0, ans = 0;
        while(dec >= db)
        {
            int lsb = dec % db; 
            ans += lsb * Math.pow(10, pval);
            pval++;
            dec = dec / db;
        }
        ans += dec * Math.pow(10, pval);
        
        return ans;
    }
}