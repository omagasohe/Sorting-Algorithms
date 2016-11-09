package Sorter;

public class BubbleSort extends Sort {

	public BubbleSort()
	{
		Name = "Bubble Sort";
		Description = "Most basic sort, terribly ineffient. Only good for understanding bad";
	}
	@Override
	public int[] sort(int[] a) {
		workingArray = a.clone();
		int lenght = workingArray.length;
		
		for(int cycle = 1; cycle < lenght; cycle++)
			for(int index = 1; index < lenght; index++)
				if(workingArray[index] < workingArray[index-1])
					swap(index, index-1);
				
		return workingArray.clone();
	}

}
