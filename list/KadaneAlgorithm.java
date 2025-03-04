package list;

import java.util.Arrays;

public class KadaneAlgorithm {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Extend the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update the global maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        // int currSum = 0;
        // for (int num : nums) {
        // currSum = Math.max(currSum + num, 0);
        // // currSum += num;
        // maxSum = Math.max(maxSum, currSum);

        // }

        // for (int i = 0; i < nums.length; i++) {
        // int currSum = 0;
        // for (int j = i; j < nums.length; j++) {
        // currSum += nums[j];
        // maxSum = Math.max(maxSum, currSum);

        // }
        // }
        return maxSum;
    }

    // Return the left and right index of the max subarray sum,
    // assuming there's exactly one result (no ties).
    // Sliding window variation of Kadane's: O(n)
    public static int[] slidingWindow(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        int maxL = 0, maxR = 0;
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (curSum < 0) {
                curSum = 0;
                L = R;
            }
            curSum += nums[R];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxL = L;
                maxR = R;
            }
        }
        return new int[] { maxL, maxR };
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
        System.out.println("Maximum Subarray Sum: " + Arrays.toString(slidingWindow(nums)));
    }
}
