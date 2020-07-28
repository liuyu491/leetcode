package dfs;

import utils.TreeNode;

public class BalancedBinaryTree_110 {
    boolean isbalanced = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isbalanced;

    }
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int a = helper(root.left)+1;
        int b = helper(root.right)+1;
        if(Math.abs(a-b)>1){
            isbalanced = false;
        }
        return Math.max(a,b);
    }
}
