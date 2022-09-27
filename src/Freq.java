import java.nio.file.Paths;
import java.util.*;
abstract class Freq implements Command {
    public String name () {return "freq";}
    public Boolean run(Scanner scanner){
        System.out.println("Entrez le path du fichier que vous voulez traiter (connaitre les 3 mots les plus courants) : ");
        Scanner sc = new Scanner(System.in);
        String inpf = (sc.nextLine());
        try {
            String fc = java.nio.file.Files.readString(Paths.get(inpf));
            fc = fc.replaceAll("\\p{Punct}", " ");
            fc = fc.toLowerCase();
            String[] fct = fc.split(" ");
            ArrayList<String> fct2 = new ArrayList<>();
            for (String word : fct){
                if(!word.isBlank()){
                    fct2.add(word);
                }
            }
            Map<String,Integer> map_res = new HashMap<>();
            int i;
            for (String word : fct2){
                i=0;
                for (String wordc : fct2){
                    if(word.equals(wordc)){
                        i++;
                    }
                }
                map_res.put(word,i);
            }
            for(int c=0; c<3; c++) {
                int maxValueInMap = (Collections.max(map_res.values()));
                for (Map.Entry<String, Integer> map : map_res.entrySet()) {
                    if (map.getValue() == maxValueInMap) {
                        System.out.print(map.getKey()+" ");
                        map_res.remove(map.getKey());
                        break;
                    }
                }
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("Unreadable file: "+e);
        }
        return false;
    }
}
