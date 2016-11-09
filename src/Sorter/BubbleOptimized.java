package Sorter;

public class BubbleOptimized extends Sort {

	public BubbleOptimized()
	{
		Name = "Bubble Optimum";
		Description = "Slightly faster bubble sort for most cases";
	}
	
	@Override
	public int[] sort(int[] a) {
		workingArray = a.clone();
		int end = workingArray.length;
		//boolean swapped = false;
		int swapIndex=0;
		do
		{
			swapIndex=0;
			for(int index = 1; index<end;index++)
			{
				if(workingArray[index] < workingArray[index-1])
				{
					swap(index,index-1);
					swapIndex=index;
				}
			}
			
			end = swapIndex;
		}
		while(swapIndex>1);//swapped);
		return workingArray.clone();
	}

}
