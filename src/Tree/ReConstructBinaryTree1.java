package Tree;

import utils.TreeNode;
import utils.TreeUtils;

import java.util.Arrays;

public class ReConstructBinaryTree1 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConstructBinaryTree(pre,in,0,in.length-1,0);
    }
    private TreeNode reConstructBinaryTree(int[] pre,int[] in,int in_start,int in_end,int pre_start){
        if(in_start==in_end){
            return new TreeNode(in[in_start]);
        }
        if(in_start>in_end){
            return null;
        }
        int in_root = 0;
        for(int i=in_start;i<=in_end;i++){
            if(in[i]==pre[pre_start]){
                in_root = i;
            }
        }
        int leftLength = in_root-in_start;
        int rightLength = in_end-in_root;
        TreeNode root = new TreeNode(in[in_root]);
        root.left = reConstructBinaryTree(pre,in,in_start,in_root-1,pre_start+1);
        root.right = reConstructBinaryTree(pre,in,in_root+1,in_end,pre_start+1+leftLength);
        return root;
    }

    public static void main(String[] args) {
        ReConstructBinaryTree1 reConstructBinaryTree1 = new ReConstructBinaryTree1();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        TreeNode root = reConstructBinaryTree1.reConstructBinaryTree(pre,in);
        System.out.println(TreeUtils.serialize(root));
    }
}
