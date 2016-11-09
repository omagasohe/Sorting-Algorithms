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
		workingArray = array.clone();
		int gap = workingArray.length;
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
			for(int index = 0; index+gap<workingArray.length;index++)
			{
				if(workingArray[index] > workingArray[index+gap])
				{
					swap(index,index+gap);
					sorted = false;
				}
				
				
			}
		}
		return workingArray.clone();
	}
}
