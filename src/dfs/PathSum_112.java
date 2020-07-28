package dfs;

import utils.TreeNode;

import java.util.Stack;

public class PathSum_112 {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        int sum_temp = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack_sum = new Stack<>();
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                sum_temp = sum_temp+root.val;
                stack_sum.push(sum_temp);
                root = root.left;
            }
            root = stack.pop();
            sum_temp = stack_sum.pop();
            if(root.right==null&&root.left==null){
                if(sum_temp==sum){
                    flag = true;
                    return flag;
                }
            }
            root = root.right;

        }
        return flag;
    }
}
