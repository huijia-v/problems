import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("xh", 21);
        map.put("lt", 21);
        map.put("sy", 21);
        map.forEach((k, v) -> {  //使用lamda表达式遍历
            System.out.println("key:" + k + ", value:" + v);
        });

        int sum = IntStream.rangeClosed(1, 100).filter(a -> a % 2 != 0).sum();
        System.out.println(sum);
    }


    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
