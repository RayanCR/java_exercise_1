import java.util.Scanner;

abstract class Quit implements Command {
    public String name () {return "quit";}
    public Boolean run(Scanner scanner){
        return true;
    }
}
