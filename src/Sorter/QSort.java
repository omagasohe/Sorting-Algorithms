package Sorter;

public class QSort extends Sort {
	
	public QSort()
	{
		Name = "Quick Sort";
		Description = "Quick Sort is a super fast partition sort. Uses value of the middle index";
	}
	//
	@Override
	public int[] sort(int[] array) {
		workingArray = array.clone();
		qsort(0,array.length-1);
		return workingArray.clone();
	}
	
	protected void qsort(int startOfSubArray, int endOfSubArray)
	{
		int startIndex = startOfSubArray;
		int endIndex = endOfSubArray;
		
		int pivot = workingArray[startIndex + ((endIndex-startIndex+1)/2)];
		while(startIndex <= endIndex)
		{
			while(workingArray[startIndex] < pivot)
			{

				startIndex++;
			
			}
			while(workingArray[endIndex] > pivot)
			{
				endIndex--;	
			}
			
			
            
			if (startIndex <= endIndex) {
                swap(startIndex,endIndex);
                startIndex++;
                endIndex--;
            }
		}
		if(startOfSubArray < endIndex)
		qsort(startOfSubArray,endIndex);
		
		if(startIndex<endOfSubArray)
		qsort(startIndex,endOfSubArray);
			
	}

}
