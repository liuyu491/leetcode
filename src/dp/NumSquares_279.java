package dp;

import bfs.NumSquares;

public class NumSquares_279 {
    //numSquares函数表示将数字n分割成至少1个完全平方数相加，完全平方数最少的情况的完全平方数的个数。
    int[] meme;
    public int numSquares(int n) {
        meme = new int[n+1];
        return numSquaresMeme(n);
    }

    public int numSquaresMeme(int n) {
        double num = Math.sqrt(n);

        //判断num是不是整数
        if(Math.ceil(num)==num){
            return 1;
        }

        if(n==0){
            return 0;
        }

        if(meme[n]!=0){
            return meme[n];
        }

        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min = Math.min(min,numSquaresMeme(n-i*i)+1);
        }
        meme[n] = min;
        return min;
    }


    public static void main(String[] args) {
        NumSquares_279 numSquares_279 = new NumSquares_279();
        System.out.println(numSquares_279.numSquares(10));
    }

}
