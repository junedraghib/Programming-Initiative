package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 26-Dec-2018
 */

//3 4
//11 12 13 14
//21 22 23 24
//31 32 33 34
//41 42 43 44
public class SpiralCloclwise {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        
        int[][] arr = new int[m][n];
        for (int i = 0; i < m ;i++ )
        {
            for (int j = 0; j < n ;j++ )
            {
                arr[i][j] = s.nextInt();
            }   
        }
        
        int x = 0, y = 0, z = n, w = m;
        while(w > x && z > y)
        {
            int r = x, c = y;
            while(c < z)
            {
                System.out.print(arr[r][c]+", ");
                c++;
            }
            
            z--;
            c--;
            r++;
            //r++;
            
            while(r < w)
            {
                System.out.print(arr[r][c]+", ");
                r++;
            }
            
            w--;
            r--;
            c--;
            //x++;
            
            while(c >= y)
            {
                System.out.print(arr[r][c]+", ");
                c--;
            }
            
            y++;
            c++;
            r--;
            //--;
            
            while(r > x)
            {
                System.out.print(arr[r][c]+", ");
                r--;
            }
            
            x++;
            r++;
            c--;
        }
        
        System.out.print("END");
        
    }
}
