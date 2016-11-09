package Sorter;

public class CocktailSort extends Sort {

	public CocktailSort() {
		Name = "Cocktail Sort";
		Description = "Fastest of the bubble sorts, transverses the array bottom to top, then top to bottom";
	}

	@Override
	public int[] sort(int[] a) {
		wa = a.clone();
		int s=0,e = wa.length-1;
		boolean swapped = false;
		
		do
		{
		swapped = false;
		
		for(int i = s+1;i<=e;i++)
		{
			if(wa[i] < wa[i-1])
			{
				swap(i,i-1);
				swapped = true;
			}
		}
		e--;
		for(int i = e;i>s;i--)  
		{
			if(wa[i] < wa[i-1])
			{
				swap(i, i-1);
				swapped = true;
			}

			
		}
		s++;
		
		}while(swapped);
		return wa.clone();
	}

}
