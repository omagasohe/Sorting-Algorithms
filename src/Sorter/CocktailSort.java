package Sorter;

public class CocktailSort extends Sort {

	public CocktailSort() {
		Name = "Cocktail Sort";
		Description = "Fastest of the bubble sorts, transverses the array bottom to top, then top to bottom";
	}

	@Override
	public int[] sort(int[] a) {
		workingArray = a.clone();
		int startIndex=0,endIndex = workingArray.length-1;
		boolean swapped = false;
		
		do
		{
		swapped = false;
		
		for(int index = startIndex+1;index<=endIndex;index++)
		{
			if(workingArray[index] < workingArray[index-1])
			{
				swap(index,index-1);
				swapped = true;
			}
		}
		endIndex--;
		for(int index = endIndex;index>startIndex;index--)  
		{
			if(workingArray[index] < workingArray[index-1])
			{
				swap(index, index-1);
				swapped = true;
			}

			
		}
		startIndex++;
		
		}while(swapped);
		return workingArray.clone();
	}

}
