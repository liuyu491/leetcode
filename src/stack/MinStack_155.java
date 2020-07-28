package stack;

import java.util.Stack;

public class MinStack_155 {
    int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = null;
    public MinStack_155() {

    }

    public void push(int x) {
        if(x<=min){     /*当出现新的最小值时把之前的最小值入栈，然后更新最小值，然后把新的数入栈   */
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min){/* 当最小值出栈后，将之前的最小值也出栈，同时跟新最小值*/
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
