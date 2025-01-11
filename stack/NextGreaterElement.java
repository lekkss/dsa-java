package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int[] temp = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                temp[i] = -1;
            } else {
                temp[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 7, 3, 4, 8, 1 };
        System.out.println(Arrays.toString(nextGreater(nums)));
    }
}
