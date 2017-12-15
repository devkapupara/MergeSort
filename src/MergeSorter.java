package mergesort;

import java.util.Arrays;

public class MergeSorter 
{
	private int[] array;
	
	public MergeSorter(int[] a)
	{
		array = a;
	}
	
	public int[] getArray()
	{
		return array;
	}
	
	public int[] recurseSort(int[] a)
	{
		if (a.length <= 1)
			return a;
		
		int half = a.length % 2 == 0 ? a.length / 2 : (a.length + 1) / 2;
		int[] left = Arrays.copyOfRange(a, 0, half);
		int[] right = Arrays.copyOfRange(a, half, a.length);
		//sop("Left: " + Arrays.toString(left) + " Right: " + Arrays.toString(right));
		
		left = recurseSort(left);
		right = recurseSort(right);
		
		return merge(left, right);
	}
	
	public int[] sort()
	{
		return recurseSort(array);
	}
	
	private int[] merge(int[] a, int[] b)
	{
		//sop("Left: " + Arrays.toString(a) + " Right: " + Arrays.toString(b));
		int[] k = new int[a.length + b.length];
		int counterA = 0, counterB = 0, counterK = 0;
		while (counterB < b.length && counterA < a.length)		// Compare and add values to k until one array runs out.
		{
			if (a[counterA] > b[counterB])
			{
				k[counterK++] = a[counterA++];
			}
			else if (b[counterB] > a[counterA])
			{
				k[counterK++] = b[counterB++];
			}
			else
			{
				k[counterK++] = a[counterA++];
				k[counterK++] = b[counterB++];
			}
		}
		
		if (counterA < a.length)									// If elements in first array still left, copy them. 
		{
			while (counterA < a.length)
			{
				k[counterK++] = a[counterA++];
			}
		}
		else														// Else elements in the second array are left, so copy them.
		{
			while (counterB < b.length)
			{
				k[counterK++] = b[counterB++];
			}
		}
		return k;												// return merged k.
	}
	
	private static void sop(Object x)
	{
		System.out.println(x.toString());
	}
}
