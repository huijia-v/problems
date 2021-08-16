

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {


        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] num2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int count = longestConsecutive(nums);
        System.out.println(count);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_Set = new HashSet<>();
        for (int num : nums) {
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


    public static int longestConsecutive3(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        // max 最终结果, curr 当前长度, last 上个数字
        int max = 1, curr = 1, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) continue;
            if (nums[i] == last + 1) curr++; // 符合连续，长度 +1
            else {
                max = Math.max(max, curr); // 连不上了，记录长度
                curr = 1; // 重新开始
            }
            last = nums[i];
        }
        max = Math.max(max, curr); // 别忘了最后一段的连续区间
        return max;
    }

}



