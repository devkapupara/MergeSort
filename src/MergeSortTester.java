import java.util.Arrays;

public class MergeSortTester {
    public static void main(String[] args) {
        int[] nums = new int[50];
        for (int i = 50; i > 0; i--)
            nums[i-1] = 51-i;
        System.out.println(Arrays.toString(nums));
        MergeSorter ms = new MergeSorter(nums);
        nums = ms.sort();
        System.out.println(Arrays.toString(nums));
        System.out.println("Number of inversions = " + ms.getInversions());
    }
}
