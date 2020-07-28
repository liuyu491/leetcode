package backtrack;
/*
*给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.FutureTask;

public class IntegerBroker_343 {
    //回溯算法拆分整数
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    //函数的语义：找出把整数n拆分成两个数的所有可能。
    public void integerBroker(int n,List<Integer> list){
        if(n==1){
            list.add(1);
            ArrayList<Integer> arrayList = (ArrayList<Integer>)list;
            res.add((ArrayList<Integer>)arrayList.clone());
            list.remove(list.size()-1);
        }else{

            for (int j = 1; j <n/2+1 ; j++) {
                list.add(j);
                list.add(n-j);
                ArrayList<Integer> arrayList = (ArrayList<Integer>)list;
                res.add((ArrayList<Integer>)arrayList.clone());
                list.remove(list.size()-1);
                integerBroker(n-j,list);
                list.remove(list.size()-1);
            }

        }
    }

    public List<List<Integer>> integerBreaker(int n){
        integerBroker(n,list);
        return res;
    }

    public static void main(String[] args) {
        IntegerBroker_343 integerBroker = new IntegerBroker_343();
        System.out.println(integerBroker.integerBreaker(4));
//        System.out.println(Math.floor(1)==1);
    }
}
