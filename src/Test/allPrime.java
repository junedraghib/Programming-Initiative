import java.util.Scanner;

public class allPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 2;
        while(i <= n)
        {
            if (isprime(i))
            {
                System.out.println(i);
            }
            
            i++;
        }
    }
    
    public static boolean isprime(int n)
    {
        boolean isprime = true; 
        if (n == 1)
        {
        	isprime = false;
		}
        else
        {
        	for (int i = 2; i <= Math.sqrt(n)  ;i++ )
            {
                if (n % i == 0)
                {
                    isprime = false;
                    break;
                }
            }
		}
		
		return isprime;

	}

}
