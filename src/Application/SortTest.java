package Application;
import java.util.Arrays;

import Sorter.*;
public class SortTest {

	public static void main(String[] args) 
	{
	
		System.out.println(Arrays.toString(Sort.tenArray[2]));
		System.out.println(Arrays.toString(new GnomeSort().sort(Sort.fiftyArray[2])));
		System.out.println(new GnomeSort().TestSort(Sort.fiftyArray[2],200));
	}
	
}
