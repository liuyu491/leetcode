

/*
* 跟谁学笔试第一题。
*
* */
package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionsCaculater {

    public static String setCaculater(String infixExp) {
        ArrayList<Object> postfixExp = InfixExp2PostfixExp(infixExp);
        Stack<HashSet<Integer>> stack = new Stack<>();
        for (Object obj:postfixExp
             ) {
            if(obj instanceof HashSet){
                HashSet<Integer> set = (HashSet<Integer>)obj;
                stack.push(set);
            }else {
                Character opera = (Character)obj;
                HashSet<Integer> set1 = stack.pop();
                HashSet<Integer> set2 = stack.pop();
                HashSet<Integer> res = new HashSet<>();
                if(opera=='+'){
                    for (int i:set1
                        ) {
                          res.add(i)  ;
                    }
                    for ( int j:set2
                    ) {
                         res.add(j);
                    }
                    stack.push(res);
                }else if(opera=='*'){
                    for (int i:set2
                    ) {
                        for ( int j:set1
                        ) {
                            String num = i+""+j;
                            res.add(Integer.parseInt(num));
                        }
                    }
                    stack.push(res);
                }
            }
        }
        return stack.pop().toString();
    }


    private static String repla(String exp){

        exp = exp.replaceAll("(?<=\\d)(?=\\[)","*");
        exp = exp.replaceAll("(?<=\\])(?=\\d)","*");
//        newExp = newExp.replaceAll("(?<=\\))(?=\\d)","*");
//        newExp = newExp.replaceAll("(?<=\\d)(?=\\()","*");
        exp= exp.replaceAll("(?<=\\])(?=\\[)","*");
        exp = exp.replaceAll("(?<=\\]),(?=\\[)","+");
        char[] exp_c = exp.toCharArray();
        Stack<Integer> stack1 = new Stack<>();
        /*第一遍遍历，把外层的"["替换成"("*/
        for(int i=0;i<exp_c.length;i++){
            char c = exp_c[i];
            if(c=='['){
                if(!stack1.isEmpty()) {
                    int index = stack1.peek();
                    exp_c[index] = '(';
                }
                stack1.push(i);
            }else if(c==']'){
                if(exp_c[stack1.peek()] == '(')
                    exp_c[i] = ')';

                stack1.pop();
            }
        }

        String newExp =  new String(exp_c);

//        newExp = newExp.replaceAll("(?<=\\])(?=\\()","*");
//        newExp = newExp.replaceAll("(?<=\\))(?=\\[)","*");
//        newExp = newExp.replaceAll("(?<=\\))(?=\\()","*");

        return newExp;
    }


    public static void main(String[] args) {
        System.out.println(setCaculater("[[1,2],[2,3]]4[5,6]"));
        System.out.println(setCaculater("[1,2,3],[2,4]"));
        System.out.println(setCaculater("[1,2][3[4,5]]"));
        StringBuilder sb = new StringBuilder();

    }

    private static ArrayList<Object> InfixExp2PostfixExp(String exp){
         ArrayList<Object> res = new ArrayList<>();
        Stack<Character> oper = new Stack<>();
        String infixexp = repla(exp);

        for(int i=0;i<infixexp.length();i++){
           Character c = infixexp.charAt(i);
           if(c=='['){
                HashSet<Integer> set = string2Set(infixexp,i);
                res.add(set);
                while(infixexp.charAt(i)!=']'){
                    i++;
                }

                continue;
           }else if(isNumber(c)){
                HashSet num = getNumber(infixexp,i);
                res.add(num);
               while(isNumber(infixexp.charAt(i))){
                   i++;
               }
               i--;
               continue;
           }else if(isOpera(c)){
               if (c=='('||oper.isEmpty()){
                   oper.push(c);
               }else if(c=='+'){
                   while (!oper.isEmpty()&&(oper.peek()=='*'||oper.peek()=='+')){
                       res.add(oper.pop());
                   }
                  oper.push(c);
               }else if(c==')'){
                   while (!oper.isEmpty()&&oper.peek()!='('){
                       res.add(oper.pop());
                   }
                   oper.pop();
               }else{
                   while (!oper.isEmpty()&&oper.peek()=='*'){
                       res.add(oper.pop());
                   }
                   oper.push(c);
               }
           }
        }
        while (!oper.isEmpty()){
            res.add(oper.pop());
        }
        return res;
    }

    private static HashSet<Integer> string2Set(String str,int index){
        HashSet<Integer> set = new HashSet<>();
        Pattern pattern = Pattern.compile("\\[(?<set>.*?)\\]");
        Matcher matcher = pattern.matcher(str);

        if(matcher.find(index)){
            String sub = matcher.group("set");
            String[] strs = sub.split(",");
            for (String s:strs
            ) {
                set.add(Integer.parseInt(s));
            }
        }

        return set;
    }

    private static HashSet<Integer> getNumber(String str,int index){
        int num = 21_0000_0001;
        HashSet<Integer> set = new HashSet<>();
        Pattern pattern = Pattern.compile("(?<num>\\d+)");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find(index)){
            String sub = matcher.group("num");
            num = Integer.parseInt(sub);
        }
        set.add(num);
        return set;
    }

    private static  boolean isNumber(char c){
        if(c-'0'>=0&&c-'0'<=9){
            return true;
        }
        return false;
    }

    private static boolean isOpera(char c){
        if(c=='+'||c=='*'||c=='('||c==')'){
            return true;
        }
        return false;
    }


}
