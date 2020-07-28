package dfs;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class SymmetricTree_101 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //方法一：
//    public boolean isSymmetric(TreeNode root) {
//        return bfs(root);
//    }
//    private boolean bfs(TreeNode node){
//        if(node==null){
//            return true;
//        }
//        Queue<TreeNode> que = new LinkedList<>();
//        List<Integer> list = null;
//        que.add(node);
//        while (node!=null||!que.isEmpty()){
//            TreeNode temp = que.peek();
//            int size = que.size();
//            list = new ArrayList<>();
//            for (int i = 0; i <size ; i++) {
//                if(temp.left!=null){
//                    que.add(temp.left);
//                }
//                if(temp.right!=null){
//                    que.add(temp.right);
//                }
//                list.add(que.poll().val);
//            }
//            for (int i = 0; i <=list.size()/2 ; i++) {
//                if(list.get(i)!=list.get(list.size()-1-i)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    //方法二：二叉树对称，则总序遍历结果对称，但相反不行
//    public boolean isSymmetric(TreeNode root) {
//        //1.迭代遍历法：
//        Stack<TreeNode> stack = new Stack<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        if(root==null){
//            return true;
//        }
//        //root不为空时直接进入循环，不要加入stack后才进入循环，这样根节点会被加两次
//        while (!stack.isEmpty()||root!=null){
//            while(root!=null){//左子节点为空停止
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();//弹出空左子节点的父节点作为当前节点
//            list.add(root.val);//对节点做相应操作
//            root = root.right;//下次循环的节点设为当前节点的右子节点
//        }
//        for (int i = 0; i <list.size()/2 ; i++) {
//            if(list.get(i)!=list.get(list.size()-1-i)){
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return true;
        }
        if(root.left!=null){
            if(root.right!=null){/*左子节点不为空，右子节点也不为空则把它们入栈，否则返回false，如果都为空则不做操作*/
                stack.push(root.left);//把左右树对称位置的节点存入栈相邻的位置
                stack.push(root.right);
            }else {
                return false;
            }
        }else{
            if(root.right!=null){
                return false;
            }
        }
        while (!stack.isEmpty()){
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if(right.val!=left.val){//判断左右树对称位置的节点值是否相等
                return false;
            }
            if(left.left!=null){
                if(right.right!=null){
                    stack.push(left.left);
                    stack.push(right.right);
                }else {
                    return false;
                }
            }else {
                if(right.right!=null){
                    return false;
                }
            }
            if(left.right!=null){
                if(right.left!=null){
                    stack.push(left.right);
                    stack.push(right.left);
                }else {
                    return false;
                }
            }else {
                if(right.left!=null){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
