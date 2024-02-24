import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionIntersection {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3, 4, 5, 5, 6};
        int[] b = {3, 3, 5};
        System.out.println(union(a, b));
        System.out.println(intersection(a, b));
    }

    static Set<Integer> union(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr1).forEach(set::add);
        Arrays.stream(arr2).forEach(set::add);
        return set;
    }

    static Set<Integer> intersection(int[] a, int[] b) {
        Set<Integer> set1 = new HashSet<>();
        Arrays.stream(a).forEach(set1::add);
        Set<Integer> set2 = new HashSet<>();
        Arrays.stream(b).forEach(set2::add);
        set1.retainAll(set2);
        return set1;
    }
}
