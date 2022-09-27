import java.util.Scanner;
import java.util.*;

public interface Command{
    String name();
    Boolean run(Scanner scanner);
}
