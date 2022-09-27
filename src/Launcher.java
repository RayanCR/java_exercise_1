import java.nio.file.Paths;
import java.util.*;
public class Launcher {
    public static void main(String[] args){
            List<Command> command = new ArrayList<>();
            command.add(new Quit(){});
            command.add(new Fibo(){});
            command.add(new Freq(){});
            command.add(new Predict(){});

            System.out.println("Bienvenue sur le Launcher !");
            Scanner sc = new Scanner(System.in);
            while (true) {
                String inp = sc.nextLine();
                int u = 0;
                for (Command value : command) {
                    if (value.name().equals(inp)) {
                        if (value.run(sc)) {
                            System.out.println("Bonne journée");
                            return;
                        }else {
                            u++;
                        }
                    }
                }
                if (u==0){
                    System.out.println("Unknown command");
                }
            }

    }
}
