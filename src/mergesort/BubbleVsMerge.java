package mergesort;

public class BubbleVsMerge 
{
	
	public static int[] getTestData(int size)
	{
		int[] a = new int[size];
		for (int i = 0; i < size; i++)
		{
			a[i] = i;
		}
		
		return a;
	}
	
	public static void main(String[] args)
	{
		int[] sizes = {1000, 5000, 10000, 50000, 100000};
		
		sop("Size\t\tMerge Sort Time\t\tBubble Sort Time");
		for (int s: sizes)
		{
			int[] data = getTestData(s);
			
			BubbleSorter b = new BubbleSorter(data);
			MergeSorter m = new MergeSorter(data);
			
			// Timing via Bubble Sort
			
			long BubbleStart = System.currentTimeMillis();
			b.sort();
			long BubbleEnd = System.currentTimeMillis() - BubbleStart;
			
			// Timing via Merge Sort
			
			long MergeStart = System.currentTimeMillis();
			m.sort();
			long MergeEnd = System.currentTimeMillis() - MergeStart;
			
			sop(s + " \t\t"  + MergeEnd + "ms\t\t\t" + BubbleEnd + "ms");
		}
	}
	
	public static void sop(Object x)
	{
		System.out.println(x.toString());
	}
}
