import java.util.Scanner;

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

abstract class Fibo implements Command{
    public String name () {return "fibo";}
    public Boolean run(Scanner scanner){
        
        System.out.print("Entree un nombre : ");
		val = scanner.nextInt();
        input = scanner.nextLine();
        System.out.println("Fibo de " + val + " est egale a : " + fibo(val));
        
        /*
        System.out.println("Entrez l'index du nombre que vous chercher dans la séquence de fibo : ");
        int n = Integer.parseInt(scanner.nextLine());
        if(n <= 1) {
            System.out.println("Le résultat est "+n);
            return false;
        }
        int fib = 1;
        int prevFib = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib+= prevFib;
            prevFib = temp;
        }
        System.out.println("Le résultat est "+fib);
        return false;
        */
    }
}
