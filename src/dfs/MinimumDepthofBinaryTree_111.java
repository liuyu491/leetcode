package dfs;

import utils.TreeNode;

public class MinimumDepthofBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return helper(root);
    }
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int a = helper(root.left)+1;
        int b = helper(root.right)+1;
        return Math.min(a,b);
    }
}
