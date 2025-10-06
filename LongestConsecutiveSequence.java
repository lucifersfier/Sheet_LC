import java.util.*;

public class LongestConsecutiveSequence {
    public int[] longConsecutiveSeq(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        Arrays.sort(arr);  // Step 1: Sort the array

        int maxLen = 1;     // Length of longest sequence found
        int currLen = 1;    // Length of current sequence
        int maxStart = 0;   // Start index of longest sequence
        int currStart = 0;  // Start index of current sequence

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                // Consecutive element → extend current sequence
                currLen++;
            } else if (arr[i] != arr[i - 1]) {
                // Sequence broken, reset
                currLen = 1;
                currStart = i;
            }

            // Update max sequence
            if (currLen > maxLen) {
                maxLen = currLen;
                maxStart = currStart;
            }
        }

        // Extract longest consecutive subsequence
        return Arrays.copyOfRange(arr, maxStart, maxStart + maxLen);
    }

    // Quick test
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

        int[] arr1 = {100, 4, 200, 1, 3, 2};
        System.out.println(Arrays.toString(lcs.longConsecutiveSeq(arr1))); // [1, 2, 3, 4]

        int[] arr2 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(Arrays.toString(lcs.longConsecutiveSeq(arr2))); // [1, 2, 3, 4]

        int[] arr3 = {1, 2, 2, 3};
        System.out.println(Arrays.toString(lcs.longConsecutiveSeq(arr3))); // [1, 2, 3]
    }
}
