package Tree;

import utils.TreeNode;
import utils.TreeUtils;

public class LowestCommonAncestorofaBinaryTree_236 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode leftRes = null;
        TreeNode rightRes = null;
        res = null;
        leftRes = find(root.left, p, q);
        rightRes = find(root.right,p,q);


        if(leftRes!=null&&rightRes!=null)
            return root;

        if(leftRes!=null)
            return lowestCommonAncestor(root.left,p,q);
        else
            return lowestCommonAncestor(root.right,p,q);

    }
    private TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            res = null;
            return res;
        }
        if(root.val==p.val||root.val==q.val){
            res = root;
            return res;
        }
        if(res==null)
            find(root.left,p,q);


        if(res==null)
            find(root.right,p,q);

        return res;
    }

    public static void main(String[] args) {
        String input_s = "[-1,0,3,-2,4,null,null,8]";
        TreeNode tree = TreeUtils.array2tree(input_s);
        LowestCommonAncestorofaBinaryTree_236 lowest = new LowestCommonAncestorofaBinaryTree_236();
        lowest.lowestCommonAncestor(tree,new TreeNode(3),new TreeNode(8));

    }
}
