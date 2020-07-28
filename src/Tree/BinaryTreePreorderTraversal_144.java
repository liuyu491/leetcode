package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        while (root != null || (!stack.isEmpty())) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return list;
    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal_recur(TreeNode root) {
        dfs(root);
        return list;
    }
    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
