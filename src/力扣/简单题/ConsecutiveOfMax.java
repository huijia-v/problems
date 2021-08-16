package 力扣.简单题;

import java.util.ArrayList;

public class ConsecutiveOfMax {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                list.add(count);
                count = 0;
            }
            if (i == nums.length - 1) {
                list.add(count);
            }

        }

        for (Integer res : list) {
            max = Math.max(max, res);
//            System.out.println(res);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1,0,1,1,1,1};
//        System.out.println(findMaxConsecutiveOnes(nums));
        int res = findMaxConsecutiveOnes(nums);
        System.out.println(res);
//        System.out.println(nums[nums.length - 1]);
        int res2 = finMaxOne(nums);
        System.out.println(res2);
    }

    public static int finMaxOne(int[] nums) {

        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;

            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        if (nums[nums.length - 1] == 1) {
            max = Math.max(max, count);
        }
        return max;
    }
}
