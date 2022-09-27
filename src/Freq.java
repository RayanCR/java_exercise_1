import java.nio.file.Paths;
import java.util.*;
abstract class Freq implements Command {
    public String name () {return "freq";}
    public Boolean run(Scanner scanner){
        System.out.print("Entrez le path d'un fichier : ");
        Scanner sc = new Scanner(System.in);
        String path = (sc.nextLine());
       try 
       {
          Path file = Paths.get(path);
          String content = Files.readString(file);
          String words[] = content.replaceAll("\\W", " ").toLowerCase().split(" ");
          Map<String, Long> countsByWords = Arrays.stream(words).map(w -> w.trim()).filter(w -> w.length() > 0).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
          System.out.println(countsByWords.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).map(e -> e.getKey()).limit(3).collect(Collectors.joining(" ")));
        } 
        catch(Exception exception) {
          System.out.println("Unreadable file: " + exception);
        }
        return false;
    }
}
