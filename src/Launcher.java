import java.util.Scanner;

public class Launcher
{
	public static int fibo(int n)
	{
		int i;

		int f0 = 0;
		int f1 = 1;
		int fn = 0;

		for (i = 2; i<n+1; i++)
		{
			fn = f0 + f1;
			f0 = f1;
			f1 = fn;
		}

		return fn;
	}

	public static void main(String[] args) 
	{
		
		System.out.println("Bienvenue");	
		
		var scanner = new Scanner(System.in);

		String input = scanner.nextLine();;

		int val;

		while (!"quit".equals(input))
		{
			if ("fibo".equals(input))
			{
				System.out.println("Entree un nombre : ");
				val = scanner.nextInt();
				input = scanner.nextLine();
				System.out.println("Fibo de " + val + " est egale a : " + fibo(val));
			}
			else
			{
				System.out.println("unknown command");
			}

			input = scanner.nextLine();
		}
		
	}
}
