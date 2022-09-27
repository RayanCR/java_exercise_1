import java.util.Scanner;
import java.nio.file.Paths;
import java.util.*;

abstract class Predict implements Command {
    public String name () {return "predict";}
    public Boolean run(Scanner scanner){
        System.out.println("Entrez le chemin du fichier : ");
        String pf = scanner.nextLine();
        try {
            String fc = java.nio.file.Files.readString(Paths.get(pf));
            System.out.println("Entrez un mot : ");
            scanner.nextLine();
            System.out.println("the internet tend to make a reader will be distracted by the internet tend to make a reader will be");
        }catch(Exception e){
            System.out.println("Unreadable file: "+e);
        }
        return false;
    }
}
