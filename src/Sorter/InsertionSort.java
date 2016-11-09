package Sorter;

public class InsertionSort extends Sort {
	public InsertionSort()
	{
		Name = "Insertion Sort";
		Description = "Much faster than bubble sort, but has the same swap counts";
	}
	
	@Override
	public int[] sort(int[] a) {
		wa = a.clone();
		int l = wa.length;
		
		for(int i = 1; i < l;i++)
		{
			int j = i;
			while ( j>0 &&(wa[j] < wa[j-1]))
			{
				swap(j,j-1);
				j--;
			}
		}
		return wa;
	}

}
