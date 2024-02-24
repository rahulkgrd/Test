import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoElementSunInArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int x = 16;
        System.out.println(isSumExit(arr, x));
        System.out.println(isSumExit1(arr, x));
    }

    //nlogn
    static boolean isSumExit(int[] arr, int sum) {
        if (arr.length < 2)
            return false;
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int tmpSum = arr[i] + arr[j];
            if (tmpSum == sum) {
                return true;
            } else if (tmpSum > sum)
                j--;
            else i++;
        }
        return false;
    }

    static boolean isSumExit1(int[] arr, int sum) {
        if (arr.length < 2)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int val : arr) {
            if (set.contains(val))
                return true;
            else {
                set.add(sum - val);
            }
        }
        return false;
    }
}
