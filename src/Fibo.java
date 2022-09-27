import java.util.Scanner;

abstract class Fibo implements Command{
    public String name () {return "fibo";}
    public Boolean run(Scanner scanner){
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
    }
}