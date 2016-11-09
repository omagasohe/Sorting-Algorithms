package Sorter;

public class BubbleOptimized extends Sort {

	public BubbleOptimized()
	{
		Name = "Bubble Optimum";
		Description = "Slightly faster bubble sort for most cases";
	}
	
	@Override
	public int[] sort(int[] a) {
		wa = a.clone();
		int l = wa.length;
		//boolean swapped = false;
		int s=0;
		do
		{
			//swapped = false;
			s=0;
			for(int i = 1; i<l;i++)
			{
				if(wa[i] < wa[i-1])
				{
					swap(i,i-1);
					//swapped = true;
					s=i;
				}

				
			}
			
			l = s;//l--;
		}
		while(s>1);//swapped);
		return wa.clone();
	}

}
