package dp.bag01;

import java.util.Arrays;

public class CoinChange_322 {
    public static int coinChangeDP(int[] coins, int amount){
        //dp[i]用来存放凑齐金额所用的最少数量的硬币。
        int[] dp = new int[amount+1];
        //初始化dp
        for(int i=1;i<dp.length;i++){

            dp[i] = -1;

        }

        //求值
        for(int i=1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    if(dp[i-coins[j]]!=-1){
                        dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                    }
                }
            }

            if(dp[i]==Integer.MAX_VALUE)
                dp[i] = -1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        coinChangeDP(coins,11);
    }
}
