package Sorter;

import java.util.Arrays;

public class GnomeSort extends Sort 
{
	public GnomeSort()
	{
		Name = "Gnome Sort";
		Description = "Insterestingly simple sort. Sorts out the arrays bottom to top. like a rolling bubble insertion sort.";
	}
	@Override
	public int[] sort(int[] array) {
		wa = array.clone();
		int i = 1;
		while( i < wa.length)
		{	
			if(i==0 || wa[i] >= wa[i-1])
			{
				i++;
			}
			else
			{
				swap(i,i-1);
				i--;
			}
			//System.out.println(i + Arrays.toString(wa));

		}
		return wa.clone();
	}
}
