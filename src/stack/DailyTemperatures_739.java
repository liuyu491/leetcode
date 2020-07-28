package stack;

import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length-1; i >=0 ; i--) {
            while(!stack.isEmpty()&&T[i]>=T[stack.peek()]){    /* 利用一个栈来存贮已经访问过的最近的最大的值 */
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = 0;
                stack.push(i);
            }else{
                ans[i] = stack.peek()-i;
                stack.push(i);
            }

        }
        return ans;
    }
}
