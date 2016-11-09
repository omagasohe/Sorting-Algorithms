package Sorter;

public class InsertionSort extends Sort {
	public InsertionSort()
	{
		Name = "Insertion Sort";
		Description = "Much faster than bubble sort, but has the same swap counts";
	}
	
	@Override
	public int[] sort(int[] a) {
		workingArray = a.clone();
		int l = workingArray.length;
		
		for(int count = 1; count < l;count++)
		{
			int index = count;
			while ( index > 0 &&(workingArray[index] < workingArray[index-1]))
			{
				swap(index,index-1);
				index--;
			}
		}
		return workingArray.clone();
	}

}
