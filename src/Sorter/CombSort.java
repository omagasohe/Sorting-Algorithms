package Sorter;

public class CombSort extends Sort {

	public CombSort()
	{
		Name = "Comb Sort";
		Description = "Bubble sort with varing swap intervals. Design to move turtles and rabbits better";
	}
	//
	@Override
	public int[] sort(int[] array) 
	{
		wa = array.clone();
		int gap = wa.length;
		double shrink = 1.3;
		boolean sorted = false;
		
		while (!sorted)
		{
			gap = (int) Math.floor(gap/shrink);
			if(gap > 1)
				sorted = false;
			else
			{
				sorted=true;
				gap = 1;
			}
			for(int i = 0; i+gap<wa.length;i++)
			{
				if(wa[i] > wa[i+gap])
				{
					swap(i,i+gap);
					sorted = false;
				}
				
				
			}
		}
		return wa.clone();
	}
}
