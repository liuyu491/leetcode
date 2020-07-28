package dp;

public class LongestPalindromicSubstring_5 {
    /*子串问题要遍历所有字串需要n+n-1+...+1次
    *  for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
            substirng = string.substring(i,j+1)//字串
            }
            }为从后往取得所有字串的代码，*/
    /*dp:dp[i][j]代表以i开头，j结尾的字串是否是回文串，状态方程为：dp[i][j] = s(i)==s(j)&&dp[i+1][j-1]*/
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        int maxlen = -1;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String result = null;
        for(int i=0;i<len;i++){
            for(int j=i;j>=0;j--){

                dp[i][j] = s.charAt(i)==s.charAt(j)&&(i-j<3||dp[i-1][j+1]);

                if(dp[i][j]&&maxlen<i-j){

                    maxlen = i-j;
                    result = s.substring(j,i+1);
                }
            }
        }

        return result;
    }
}
