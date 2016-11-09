package Sorter;

public class GnomeSort extends Sort 
{
	public GnomeSort()
	{
		Name = "Gnome Sort";
		Description = "Insterestingly simple sort. Sorts out the arrays bottom to top. like a rolling bubble insertion sort.";
	}
	@Override
	public int[] sort(int[] array) {
		workingArray = array.clone();
		int index = 1;
		while( index < workingArray.length)
		{	
			if(index==0 || workingArray[index] >= workingArray[index-1])
			{
				index++;
			}
			else
			{
				swap(index, index-1);
				index--;
			}
		}
		return workingArray.clone();
	}
}
