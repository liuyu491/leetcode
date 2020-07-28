package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    List<Integer> list = new ArrayList<>();
    private void inordertraversal(TreeNode node){
        if(node==null){
            return;
        }
        inorderTraversal(node.left);
        list.add(node.val);
        inorderTraversal(node.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inordertraversal(root);
        return list;
    }
    private List<Integer> inordertraversal_itera(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list1 = new ArrayList<>();
        if(root==null){
            return list1;   //如果root是null则直接结束遍历
        }
        stack.push(root);
        while(root!=null||stack.isEmpty()){//这个条件保证了在根节点没有左子树的情况下也可以完成对二叉树的遍历
            while(root!=null){//判断当前节点是否为空，若不为空则把其入栈。
                stack.push(root);
                root = root.left;//把左子节点都入栈，**注意**:在一个会停下的while循环中循环的条件必须在循环中改变，并最终达到停止的状态。
            }
            TreeNode temp = stack.pop();//出栈动作保证了从树的底往上面遍历
            list1.add(temp.val);//在遍历过程中对中的节点进行操作
            root = temp.right;//把根节点置为由子节点
        }
        return list1;
    }
}
