package mergesort;

public class BubbleSorter 
{
	private int[] array;
	
	public BubbleSorter(int[] a)
	{
		array = a;
	}
	
	public int[] getArray()
	{
		return array;
	}
	
	public void swap(int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public void sort()
	{
		for (int i = 0; i < array.length-1; i++)
		{
			for (int j = 0; j < array.length-i-1; j++)
			{
				if (array[j] < array[j+1])
				{
					swap(j+1, j);
				}
			}
		}
	}
	
//	public static void main(String[] args)
//	{
//		BubbleSorter b = new BubbleSorter(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
//		b.sort();
//		System.out.println(Arrays.toString(b.getArray()));
//	}
}
