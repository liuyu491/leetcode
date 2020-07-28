package dp;

public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
//        DP分析：可以找到当m!=0&&n!=0时，dp[i][j] = dp[i-1][j]+dp[i][j-1],该式子由“机器人每次只能向下或者向右移动一步”得出，dp[i][j]表示机器人从起点到编号为a,b的网格处有多少种走法，因为机器人只可以向下或右走，所以当a==0||b==0时dp[a][b]=1,即只有一种走法
// 我们从起点开始走遍网格中的每一格，来获取dp[a][b]的结果。
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
