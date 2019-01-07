package Test;

import java.util.Scanner;

/**
 * created by : Juned Raghib
 * created on : 04-Jan-2019
 */
public class NQueen {

public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        nqueen(n, "", new boolean[n][n]);
    }
    
    public static void nqueen(int n, String ans, boolean[][] placed)
    {
        if(n == 0)
        {
            System.out.print(ans+" ");
        }
        
            for (int j = 0; j < n ;j++ )
            {
                if (isSafe(i, j, placed))
                {
                    placed[i][j] = true;
                    
                    nqueen(n - 1, ans + "{"+i+"-"+j+"}", placed);   
                    
                    placed[i][j] = false;
                }
            }   
    }
    
    
    public static boolean isSafe(int i, int j, boolean[][] placed)
    {
        //vertically up
        while(j >= 0)
        {
            if (placed[i][j])
            {
                return false;
            }
            j--;
        }
        
        //digonally forward
        while(j >= 0 && i < placed.length)
        {
            if (placed[i][j])
            {
                return false;
            }
            j--;
            i++;
        }
        
        //diagonally backward
        while(j >= 0 && i >= 0)
        {
            if (placed[i][j])
            {
                return false;
            }
            j--;
            i--;
        }
        
        return true;
    }
}
