package OnWiKi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*一个数组中的数互不相同，求其中和为 0 的 数对 的个数*/
public class EnumerateTest01 {
    public static void main(String[] args) {
        int[] test = {0,0,0};
        int count = test02(test);
        System.out.println(count);
    }

    public static int enuArr(int[] arr) {
        boolean[] index = new boolean[arr.length * 2];

        int count = 0;
        for (int j : arr) {
            if (index[arr.length - j]) {
                ++count;
            }
            index[arr.length + j] = true;
        }
        return count * 2;
    }

    public static int test(int[] arr) {

        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(-j)) {
                count++;
            }
            set.add(j);
        }
        return count;
    }

    public static int test02(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    ++count;
                }
            }
        }
        return count;
    }

    public static int test03(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] + arr[j] == 0) {
                    ++count;
                }
            }
        }
        return count;
    }

}
