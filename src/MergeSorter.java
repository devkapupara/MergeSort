import java.util.Arrays;

class MergeSorter
{
	private int[] array;
	private int inversions;
	
	MergeSorter(int[] a)
	{
		array = a;
		inversions = 0;
	}
	
	int[] getArray()
	{
		return array;
	}

	int getInversions() { return inversions; }
	
	private int[] recurseSort(int[] a)
	{
		if (a.length <= 1)
			return a;
		
		int half = a.length % 2 == 0 ? a.length / 2 : (a.length + 1) / 2;
		int[] left = Arrays.copyOfRange(a, 0, half);
		int[] right = Arrays.copyOfRange(a, half, a.length);
		//sop("Left: " + Arrays.toString(left) + " Right: " + Arrays.toString(right));
		
		left = recurseSort(left);
		right = recurseSort(right);
		
		return left.length >= right.length ? merge(left, right) : merge(right,left);
	}
	
	int[] sort()
	{
		return recurseSort(array);
	}
	
	private int[] merge(int[] a, int[] b)
	{
		int[] k = new int[a.length + b.length];
		int counterA = 0, counterB = 0, counterK = 0;
		while (counterB < b.length && counterA < a.length)		            // Compare and add values from b.
		{
			if (a[counterA] == b[counterB])
			{
				k[counterK++] = a[counterA++];
				k[counterK++] = b[counterB++];
			}
			else
			    k[counterK++] = a[counterA] < b[counterB] ? a[counterA++] : b[counterB++];
		}
		inversions += (a.length - counterA) * b.length;         // Elements left in A all form inverted pairs with elements in b,
                                                                // So the elements not counted yet from A * elements in B
		while (counterA < a.length)				                // Elements in first array are still left, copy them.
            k[counterK++] = a[counterA++];
		while (counterB < b.length)                             // If elements in the second array are left, copy them.
		    k[counterK++] = b[counterB++];

		return k;												// return merged k.
	}
	
	private static void sop(Object x)
	{
		System.out.println(x.toString());
	}
}
