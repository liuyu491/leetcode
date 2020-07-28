package dfs;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthofBinaryTree_104 {
    //方法1：层级遍历
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {//不像dfs，bfs的wile循环里不需要加root!=null条件
            int size = que.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node_tmp = que.peek();
                if (node_tmp.left != null) {
                    que.add(node_tmp.left);
                }
                if (node_tmp.right != null) {
                    que.add(node_tmp.right);
                }
                que.poll();
            }
        }
        return depth;
    }
    //方法2：
}
