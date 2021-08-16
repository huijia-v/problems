package 力扣.中等题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] num2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int count = longestConsecutive(nums);
        System.out.println(count);
    }


    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { //判断前后数据是否重复，若重复就不进入循环内部
                if (nums[i] == nums[i - 1] + 1) {  //满足不重复的条件后判断是否连续
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;  //一旦进入则说明连续重复的条件中断了，当前长度复原为1

                }
            }
        }
        return Math.max(longestStreak, currentStreak);

    }


    /*增加了判断跳过的逻辑之后，时间复杂度是多少呢？外层循环需要 O(n)O(n) 的时间复杂度，
    只有当一个数是连续序列的第一个数的情况下才会进入内层循环，然后在内层循环中匹配连续序列中的数，
    因此数组中的每个数只会进入内层循环一次。根据上述分析可知，总时间复杂度为 O(n)O(n)，符合题目要求。*/
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> num_Set = new HashSet<>();
        for (int num : nums) {  //是为了去重
            num_Set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_Set) {
            if (!num_Set.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;
                while (num_Set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;

    }


    public static int longestConsecutive4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int currentStreak = 1;
        int longesStreak = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == last) continue;

            if (nums[i] == last + 1) {
                currentStreak += 1;
            } else {
                longesStreak = Math.max(longesStreak, currentStreak);
                currentStreak = 1;

            }
            last = nums[i];
        }
        return Math.max(longesStreak, currentStreak);
    }
}
