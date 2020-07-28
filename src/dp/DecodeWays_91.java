package dp;

import java.util.HashMap;

public class DecodeWays_91 {
    public static int numDecodings(String s) {
//        int numofLetters = 0;
//        String sb = null;
//        int result = 1;
//        /*找出所有可以编码的子字符串*/
//        for(int i=0;i+2<=s.length();i++){
//            sb = s.substring(i,i+2);
//            int code = Integer.parseInt(sb);
//            if(0<code&&code<27){
//                numofLetters++;
//            }
//        }
//        /*如果没有可以编码的子字符串，就返回1*/
//        if(numofLetters==0){
//            return result;
//        }else{  /*如果有可以编码的子字符串，就算出可以编码的方式数*/
//            result = (int)Math.pow(2,numofLetters) - 1;
//        }
//        return result + 1;
       return 0;
    }
    public static void main(String[] args) {
        int a = 5;
        System.out.println(numDecodings("123"));
    }
}
