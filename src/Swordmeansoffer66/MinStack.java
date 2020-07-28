package Swordmeansoffer66;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack_min = new Stack<>();


    public void push(int node) {
        if(stack_min.isEmpty()){
            stack_min.push(node);
        }else{
            int min = stack_min.peek();
            if(node<=min){
                min = node;
                stack_min.push(min);
            }
        }

        stack.push(node);
    }

    public void pop() {
        int num = stack.pop();
        if(!stack_min.isEmpty()&&num==stack_min.peek()){
            stack_min.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack_min.pop();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.pop();
        minStack.push(0);
        System.out.println(minStack.min());

        minStack.pop();
        System.out.println(minStack.min());
    }
}
