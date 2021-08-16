package 练习题;

/*
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
描述：从上到下选择一条路，使得经过的数字之和最大。路径上的每一步只能往左下或者右下走。*/
public class MaxOfSum {
//递归解法
public int getMax(){
    int MAX = 101;
    int[][] D = new int[MAX][MAX];   //存储数字三角形
    int n = 5;              //n表示层数
    int i = 0; int j = 0;
    return getMaxSum(D,n,i,j);
}

    public int getMaxSum(int[][] D,int n,int i,int j){
        if(i == n){
            return D[i][j];
        }
        int x = getMaxSum(D,n,i+1,j);
        int y = getMaxSum(D,n,i+1,j+1);
        return Math.max(x,y)+D[i][j];
    }
}
