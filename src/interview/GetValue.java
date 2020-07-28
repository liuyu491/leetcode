package interview;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GetValue {

    public static int getValue(String exp){
        /*
        * 根据后续表达式求算式的值
        * */
        ArrayList<Object> postorderExp = inOrderExp2postOrderExp(exp);
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < postorderExp.size(); i++) {
            Object obj = postorderExp.get(i);
            if(obj instanceof Integer){
                numStack.push((Integer) obj);
            }else{

                Integer num1 = numStack.pop();
                Integer num2 = numStack.pop();
                Integer res = null;
                switch ((Character)obj){
                    //后从栈中出来的数字在运算符号的左边。
                    case '+':{
                        res = num1+num2;
                        break;
                    }
                    case '-':{
                        res = num2-num1;
                        break;
                    }
                    case '*':{
                        res = num1 * num2;
                        break;
                    }
                    case '/':{
                        res = num2/num1;
                        break;
                    }

                }
                numStack.push(res);
            }
        }

        return numStack.pop();
    }


    /*
    * 中序表达式转为前序表达式
    * */
    public static ArrayList<Object> inOrderExp2postOrderExp(String inOrderExp){
        Stack<Character> opeStack = new Stack<>();
        ArrayList<Object> postOrderExp = new ArrayList<>();
        //使用hashmap存储运算符对应的有优先级关系
        Map<Character,Integer> priority = new HashMap<>();

        //初始化优先级关系表
        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);
        priority.put('/',2);
        priority.put('(',0);


        //中序表达式转后序表达式
        /*定义两个变量：一个用来存后序遍历结果（list），一个用来存操作中序表达式中遇到的操作符（stack）
        * 遍历中序表达式：
        * 1.如果遇到数字就直接加入表达式中
        * 2.如果遇到操作符：
        * 1.栈为空直接入栈
        * 2.'('直接入栈操作
        * 3.当前操作符优先级高于栈顶优先级直接入栈
        *否则将栈顶元素出栈并加入后序表达，直到满足当前操作符入栈的条件
        * 4.遇到')'将栈中元素出栈并加入后序表达式，直到遇到'(','('出栈后不加入后序表达式
        *
        * 中序表达式遍历结束后，将栈中所有操作符出栈并接入后序表达式
        *
        *注意：用hashmap存取操作符与优先级的对应关系的时候，要把'('的优先级设为0。即栈顶式'('的时候都可以入栈。
        * */


        int index = 0;
        while(index<inOrderExp.length()){
            Character c = inOrderExp.charAt(index);
            //遇到数子，直接加入后序表达式
            if(isNumber(c)){
                int j = index+1;
                while(j<inOrderExp.length()&&isNumber(inOrderExp.charAt(j))){
                    j++;
                }
                int num = getNumber(inOrderExp,index,j);
                postOrderExp.add(num);
                index = j;
            }else{

                if(opeStack.isEmpty()||c=='('){
                    opeStack.push(c);
                    index++;
                }else if(c==')'){
                    //遇到')'将栈中的操作符出栈并加入后序表达式，直到遇到'(','('出栈后不加入后序表达式
                    Character ope = opeStack.pop();
                    if(ope!='(')
                        postOrderExp.add(ope);
                    else
                        index++;
                }else{
                    Character ope = opeStack.peek();
                    if(priority.get(c)>priority.get(ope)){
                         opeStack.push(c);
                         index++;
                    }else{
                        postOrderExp.add(opeStack.pop());
                    }


                }
            }
        }

        while (!opeStack.isEmpty()){
            postOrderExp.add(opeStack.pop());
        }

        return postOrderExp;

    }

    private static int getNumber(String inOrderExp,int i,int j){
        return Integer.valueOf(inOrderExp.substring(i,j));
    }

    private static boolean isNumber(Character c){
        return (c-'0')>=0&&(c-'0')<=9;
    }

    public static void main(String[] args) {
//        System.out.println(inOrderExp2postOrderExp("2*3/(2-1)+3*(4-1)"));
        System.out.println(getValue("2*3/(2-1)+3*(4-1)"));

    }

}
