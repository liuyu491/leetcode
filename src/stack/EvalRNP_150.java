package stack;

import java.util.Stack;
import java.util.regex.Pattern;

public class EvalRNP_150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String pattern = "\\d*";
        for (int i = 0; i <tokens.length ; i++) {
            if(Pattern.matches(pattern,tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int a = stack.pop();
                int b = stack.pop();
                switch (tokens[i]){
                    case "+":{
                        stack.push(b+a);
                        break;
                    }case "-":{
                        stack.push(b-a);
                        break;
                    }case "*":{
                        stack.push(b*a);
                        break;
                    }case "/":{
                        stack.push(b/a);
                        break;
                    }
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
