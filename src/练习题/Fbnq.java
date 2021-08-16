package 练习题;

public class Fbnq {
    public static void main(String[] args) {
//        System.out.println(fb(5));
//        System.out.println(fb2(5));
        System.out.println("=====================");
        System.out.println(fb(5));
        System.out.println(fb2(5));
//        System.out.println();
//        for (int i = 0; i <= 5; i++) {
//            System.out.print(fb2(i) + " ");
//        }
    }

    //自底向上
    public static int fb(int n) {
        int temp = 0;
        if (n == 0) {
            temp += 2;

        } else if (n == 1) {

            temp += 2;
        } else {
            temp = n;
        }
        int[] dp = new int[temp + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for (int i = 2; i <= temp; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    //递归采用的是自顶向下
    public static int fb2(int n) {
        if (n < 2) {
            return n;
        }
        return fb2(n - 1) + fb2(n - 2);
    }
}
