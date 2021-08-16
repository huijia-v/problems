package 力扣.简单题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch {

        public int[] findErrorNums(int[] nums) {
            int[] errorNums = new int[2];
            int n = nums.length;
            Arrays.sort(nums);
            int prev = 0;
            for (int curr : nums) {
                if (curr == prev) {
                    errorNums[0] = prev;
                } else if (curr - prev > 1) {
                    errorNums[1] = prev + 1;
                }
                prev = curr;
            }
            if (nums[n - 1] != n) {
                errorNums[1] = n;
            }
            return errorNums;
        }


    public int[] findErrorNums2(int[] nums) {

        int[] errorNums = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                errorNums[0] = i;
            } else if (count == 0) {
                errorNums[1] = i;
            }
        }
        return errorNums;
    }

    }


