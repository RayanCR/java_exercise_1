import java.util.*;
import java.nio.file.*;

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

	public static String freq(Path filePath)
	{
		String content = "";
		String tab[];

		int compt,c1,c2,c3, i, j;
		String mot="";

		Map <Integer,String> dic = new Hashtable <Integer,String>();


		try
		{
			content = Files.readString(filePath);

			content = content.toLowerCase().replaceAll("\n"," ");

			tab = content.split(" ");

			for(i=0; i<tab.length; i++)
			{
				compt = 0;

				if (dic.get(tab[i]) == null)
				{
					for(j=0; j<tab.length; j++)
					{
						if (tab[i].equals(tab[j]))
						{
							compt++;
							mot = tab[i];
						}
					}
					dic.put(compt,tab[i]);
				}

			}

			Map <Integer,String> dic_tree = new TreeMap <Integer,String>(dic);

			i= 0; content = "";
			for (Map.Entry tmp : dic_tree.entrySet())
			{
				if (i >= dic.size()-3)
					content += tmp.getValue() + " ";
				i++;
			}

			System.out.println(dic_tree);

		}
		catch (Exception e)
		{
			System.out.println("Unreadable file: " + e);
		}
		return "the lorem of";
	}
	
	public interface Commande
	{
		String name();
		boolean run(Scanner scanne);
	}



	public static class Quit implements Commande
	{
		String name {

			return "QUIT".toLowerCase();
		}

		boolean run(Scanner arg){
			return true;
		}
	}


	public static class Fibo implements Commande
	{
		String name {

			return "FIBO".toLowerCase();
		}

		boolean run(Scanner arg){
			fibo(arg);
			return false;
		}
	}

	public static class Freq implements Commande
	{
		String name {

			return "FREQ".toLowerCase();
		}

		boolean run(Scanner arg){
			freq(arg);
			return false;
		}
	}

	public static void main(String[] args)
	{
		System.out.println("Bienvenue");

		List<Commande> tab = new arrayList <Commande>();

		tab.add(new Quit());
		tab.add(new Fibo());
		tab.add(new Freq());


		
		var scanner = new Scanner (System.in);

		var input = "";

		int i;

		boolean stop = false, uc = false;

		// Path filePath;

		while (stop == false)
		{
			input = scanner.nextLine();

			uc = false;

			for (i=0; i<tab.size(); i++)
			{
				if (Objects.equals(input,tab.get(i).name().toLowerCase()))
				{
					stop = tab.get(i).run(scanner);
					uc = true;
				}
			}

			if (uc == false)
			{
				System.out.println("unknown command");
			}

		}
		
	}
}
