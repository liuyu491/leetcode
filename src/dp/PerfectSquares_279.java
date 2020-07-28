package dp;

public class PerfectSquares_279 { //动态规划背包问题
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int i = 1;
        int idx = 0;
        for(i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                idx = i-j*j;
                if(dp[i]==0){
                    dp[i] = dp[idx]+1;
                }else{
                    dp[i] = Math.min(dp[idx]+1,dp[i]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares_279 pstest = new PerfectSquares_279();
        System.out.println( pstest.numSquares(12));
    }
}
