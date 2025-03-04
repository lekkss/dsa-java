import java.util.ArrayList;
import java.util.List;

public class PrefixSums {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 7, 7, 2, 1 };
        PrefixSums ps = new PrefixSums(nums);
        System.out.println(ps.rangeSum(0, 5));

    }

    List<Integer> prefix;

    public PrefixSums(int[] nums) {
        prefix = new ArrayList<>();
        int total = 0;
        for (int n : nums) {
            total += n;
            prefix.add(total);
        }
    }

    public int rangeSum(int left, int right) {
        int preRight = prefix.get(right);
        int preLeft = left > 0 ? prefix.get(left - 1) : 0;
        return (preRight - preLeft);
    }
}
