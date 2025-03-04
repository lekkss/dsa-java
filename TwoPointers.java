
import java.util.Arrays;

public class TwoPointers {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 7, 7, 2, 1, };
        int[] nums2 = { -2, 2, 3, 5, 6, 8, 9 };
        System.out.println(isPalindrome(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(targetSum(nums2, 4)));

    }

    public static boolean isPalindrome(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] != nums[right]) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    // Given a sorted array of integers, return the indices
    // of two elements (in different positions) that sum up to
    // the target value. Assume there is exactly one solution.
    // O(n)

    public static int[] targetSum(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            if (nums[L] + nums[R] > target) {
                R--;
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                return new int[] { L, R };
            }
        }
        return null;
    }
}
