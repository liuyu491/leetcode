package Swordmeansoffer66;

import java.util.Stack;

public class IsPopOrder {
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        if(pushA==null||popA==null||pushA.length!=popA.length){
            return false;
        }

        int i=0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();

        while(true){

            while(!stack.isEmpty()&&stack.peek()==popA[i]){
                i++;
                stack.pop();
            }
            if(j<pushA.length)
                stack.push(pushA[j++]);
            else{
                break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(isPopOrder(pushA, popA));
    }

}
