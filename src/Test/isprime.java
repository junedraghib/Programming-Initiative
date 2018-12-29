import java.util.*;
public class isprime 
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        boolean isprime = true; 
        if (n == 2)
        {
        	isprime = true;
		}
        else
        {
        	for (int i = 2; i <= n/2  ;i++ )
            {
                if (n % i == 0)
                {
                    isprime = false;
                    break;
                }
            }
		}
        
        if (isprime)
        {
            System.out.println("Prime");
        }
        else
        {
            System.out.println("Not Prime");
        }
    }
}