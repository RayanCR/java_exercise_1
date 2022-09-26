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

		}
		catch (Exception e)
		{
			System.out.println("Unreadable file: " + e);
		}
		return content;
	}
	

	public static void main(String[] args)
	{
		
		System.out.println("Bienvenue");	
		
		var scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		int val;

		Path filePath;


		while (!"quit".equals(input))
		{
			if ("fibo".equals(input))
			{
				System.out.print("Entree un nombre : ");
				val = scanner.nextInt();
				input = scanner.nextLine();
				System.out.println("Fibo de " + val + " est egale a : " + fibo(val));
			}
			else if ("freq".equals(input))
			{
				System.out.print("Entree le file path : ");

				filePath = Paths.get(scanner.nextLine());

				System.out.println(freq(filePath));
				
			}
			else
			{
				System.out.println("unknown command");
			}

			input = scanner.nextLine();
		}
		
	}
}
