package array;

public class ArrayUtils {

    public int[] removeEven(int[] arr) {
        int n = arr.length;
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        int[] oddArr = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                oddArr[idx] = arr[i];
                idx++;
            }
        }
        return oddArr;
    }

    public int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public int minElement(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public int secondMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secodMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secodMax = max;
                max = arr[i];
            } else if (arr[i] > secodMax && arr[i] != max) {
                secodMax = arr[i];
            }
        }
        return secodMax;
    }

    public int[] moveZeros(int[] arr) {
        // two pointer, one focus on zero element, other focuses on non-zero element
        // create a variable to hold current 0 element
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            // swap values of current array index with wherever 0 is fouund
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            // if current j isnt 0, move to next element
            if (arr[j] != 0) {
                j++;
            }
        }
        return arr;
    }

    public int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public int missingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : arr) {
            sum = sum - num;
        }

        return sum;
    }

    public boolean isPalindrime(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayUtils array = new ArrayUtils();
        // System.out.println(Arrays.toString(array.removeEven(new int[]
        // {3,2,4,7,10,6,5})));
        // System.out.println(Arrays.toString(array.reverse(new int[]
        // {2,11,5,10,7,8})));
        // System.out.println((array.minElement(new int[] {5,9,3,15,1,2})));
        // System.out.println((array.secondMaxElement(new int[] {12,34,2,34,33,1})));
        // System.out.println(Arrays.toString(array.moveZeros(new int[] { 0, 1, 0, 4, 12
        // })));

        // System.out.println(Arrays.toString(array.resize(new int[] { 0, 1, 0, 4, 12,
        // 10 }, 10)));
        // System.out.println((array.missingNumber(new int[] { 1, 2, 3, 5, 7, 9, 6, 4
        // })));
        System.out.println(array.isPalindrime("nursesrun"));
    }

}
