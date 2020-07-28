package dfs;

import java.util.Stack;

public class ValidateBinarySearchTree_98 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*二叉搜索的中序遍历，相当于对二叉中的元素从小到大排序，在按照中序遍历的次序遍历二叉树时，
    判断当前节点的值是否大于前一个被遍历的节点的值，
    如果大于就是二叉搜索树，否则就不是*/
    public boolean isValidBST(TreeNode root) {
        Integer pre = Integer.MIN_VALUE;
        boolean flag = true;
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return true;
        }
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre!=null&&root.val<=pre){
                flag = false;
                break;
            }
            pre = root.val;
            root = root.right;
        }
        return flag;
    }


}

