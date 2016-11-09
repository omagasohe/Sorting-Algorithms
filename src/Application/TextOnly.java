package Application;
import java.util.*;
import Sorter.*;
public class TextOnly {

	static List<Sort> sortList = new ArrayList<Sort>();
	static List<double[][]> results = new ArrayList<double[][]>();

	// One big bag of crazy. Everything in java is an object, even multi-dimensional arrays.
	static Object[][] inputs = {
		{10,Sort.tenArray},
		{50,Sort.fiftyArray},
		{100,Sort.hundArray},
		{500,Sort.fiveHArray},
		{1000,Sort.thouArray},
	};
	
	public static void main(String[] args) 
	{
	
		
		sortList.add(new BubbleSort());
		sortList.add(new BubbleOptimized());
		sortList.add(new CocktailSort());
		sortList.add(new InsertionSort());
		sortList.add(new GnomeSort());		
		sortList.add(new CombSort());

		sortList.add(new QSort());
		
		for(@SuppressWarnings("unused") Sort s : sortList)
			results.add(new double[5][4]);
		
		int testCount = 100;
	
		for(int s = 0; s < sortList.size();s++)
		{
			for(int i = 0; i < 5; i++)
				for(int j = 0; j < 4; j++)
					//This one makes my head hurt. Mixing arrays with methods and implicitly casting multi dimensional arrays. 
					//it'll 
					results.get(s)[i][j] = sortList.get(s).TestSort(((int[][])inputs[i][1])[j], testCount);
			
		}

		//Individual Tests.
		for(int i = 0; i < sortList.size(); i++)
		{
			System.out.printf("%-15s %-12s %-12s %-12s %-12s\n", sortList.get(i).getName(),"Sorted","Partial","Random","Reverse");
			for(int j = 0; j < 5;j++)
				System.out.printf("%-15d %-12.5f %-12.5f %-12.5f %-12.5f\n", inputs[j][0],results.get(i)[j][0],results.get(i)[j][1],results.get(i)[j][2],results.get(i)[j][3]);
			System.out.printf("\n");
		}
	
		//Side by Side.
		for(int i =0; i < 5;i++)
		{
			System.out.printf("%-4d %-10s %-12s %-12s %-12s %-12s\n",inputs[i][0] ,"items","Sorted","Partial","Random","reverse");
			for(int j = 0; j < sortList.size();j++)
				System.out.printf("%-15s %-12.5f %-12.5f %-12.5f %-12.5f\n", sortList.get(j).getName(),results.get(j)[i][0],results.get(j)[i][1],results.get(j)[i][2],results.get(j)[i][3]);
			System.out.printf("\n");
		}
	}
}
