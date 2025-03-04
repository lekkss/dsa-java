import java.util.HashSet;
// Given an array, return true if there are two elements within a window
// of size k that are equal

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 3, 3, 3 }; // Array of integers
        int k = 3; // Window size
        System.out.println(closeDuplicates(nums, k)); // Output: true
        System.out.println(longestSubarray(nums));
    }

    public static boolean closeDuplicates(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>(); // Cur window of size <= k
        int L = 0; 

        for (int R = 0; R < nums.length; R++) {
            if (R - L + 1 > k) {
                window.remove(nums[L]);
                L++;
            }
            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
        }
        return false; // If no duplicates are found within the window, return false
    }

    public static int longestSubarray(int[] nums) {
        int length = 0;
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            if (nums[L] != nums[R]) {
                L = R;
            }
            length = Math.max(length, R - L + 1);
        }
        return length;
    }
}