package 尚硅谷;


/*二维数组转稀疏数组的步骤
 * 1.遍历原始的二维数组，得到有效数据的个数sum
 * 2.根据sum创建稀疏数组 Sparse  int[sum + 1][3]       row col val
 * 3.将二维数组的有效数据存储到稀疏数组*/

/*将稀疏数组转换为原始数组
 * 1.先读取稀疏数组的第一行，根据读取到的殊据创建原始数组 srcArray = new int[n][n]
 * 2.再读取稀疏数组的后几行将其赋值给原始数组即可*/
public class ArraySparseTest {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[3][4] = 1;
        arr[4][5] = 2;
        arr[5][5] = 2;
        arr[6][5] = 2;
        for (int[] data : arr) {
            for (int num : data) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
        //创建稀疏师数组

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparse = new int[sum + 1][3];
        sparse[0][0] = arr.length;
        sparse[0][1] = arr.length;
        sparse[0][2] = sum;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparse[count][0] = i;
                    sparse[count][1] = j;
                    sparse[count][2] = arr[i][j];
                }
            }
        }

        for (int i = 0; i < sparse.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparse[i][0], sparse[i][1], sparse[i][2]);
        }
    }
}