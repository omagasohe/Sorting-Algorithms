package Sorter;

public class QSort extends Sort {
	
	public QSort()
	{
		Name = "Quick Sort";
		Description = "Quick Sort is a super fast partition sort.";
	}
	//
	@Override
	public int[] sort(int[] array) {
		wa = array.clone();
		qsort(0,array.length-1);
		return wa.clone();
	}
	
	protected void qsort(int start, int end)
	{
		int s = start;
		int e = end;
		
		int p = wa[s + ((e-s+1)/2)];
		while(s <= e)
		{
			while(wa[s] < p)
			{

				s++;
			
			}
			while(wa[e] > p)
			{
				e--;	
			}
			
			
            
			if (s <= e) {
                swap(s,e);
                s++;
                e--;
            }
		}
		if(start < e)
		qsort(start,e);
		if(s<end)
		qsort(s,end);
			
	}

}
