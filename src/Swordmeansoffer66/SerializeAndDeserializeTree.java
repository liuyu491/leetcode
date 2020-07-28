package Swordmeansoffer66;

import utils.TreeNode;
import utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeTree {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null){
            sb.append("null");
            return sb.toString();
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node!=null){
                if(node.left!=null){
                    que.offer(node.left);
                }else{
                    que.offer(null);
                }

                if(node.right!=null){
                    que.offer(node.right);
                }else{
                    que.offer(null);
                }
            }


            if(node!=null){
                sb.append(node.val);
            }else{
                sb.append("null");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {

        String treeStr = str.trim();

        String[] strs = str.split(" ");
        if(strs.length==1&&strs[0].equals("null")){
            return null;
        }
        Queue<TreeNode> que = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strs[i]));
        que.offer(root);

        while(i<strs.length-1||!que.isEmpty()){
            TreeNode node  =  que.poll();

            String leftString = strs[++i];
            String rightString = strs[++i];
            if(!leftString.equals("null")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(leftString));
                node.left=leftNode;
                que.offer(leftNode);
            }

            if(!rightString.equals("null")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(rightString));
                node.right=rightNode;
                que.offer(rightNode);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.array2tree("[1,2,3,null,null,4,5]");
        SerializeAndDeserializeTree serializeAndDeserializeTree = new SerializeAndDeserializeTree();
        String s = serializeAndDeserializeTree.Serialize(root);
        TreeNode root1 = serializeAndDeserializeTree.Deserialize(s);
        System.out.println(TreeUtils.serialize(root1));

    }
}
