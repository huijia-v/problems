package 模拟题;


/*题目：现有面值为1，3，4，5的硬币，要求求出能够凑够99元的最少硬币方案
*
* f(n) = MinCon(f(n - 1) + 1// f(n - 3) + 1// f(n - 4) + 1// f(n - 5) + 1*/
public class Demo01 {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5};
        int count = 12;
        int i = NumOfCoin(a, 4, count);
        System.out.println(i);
    }

    private static int NumOfCoin(int[] a, int size, int count) {
        int[] MinCoin = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            int minCoin = i;

            for (int j = 0; j < size; j++) {
                if (a[j] <= i) {
                    if ((MinCoin[i - a[j]] + 1) < minCoin) {
                        minCoin = MinCoin[i - a[j]] + 1;
                    }
                }
            }
            MinCoin[i] = minCoin;
//            System.out.printf("凑够%d的最少硬币数量是%d\n", i, MinCoin[i]);
        }
        return MinCoin[MinCoin.length - 1];

    }

}
