package Swordmeansoffer66;

import utils.TreeNode;
import utils.TreeUtils;

public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //遍历整颗树，如果有节点与root2相同，就调用判断子结构的程序进行判断。
        if(root1==null){
            return false;
        }
        if(root1.val==root2.val&&isSubTree(root1,root2)){
            return true;
        }

        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    private boolean isSubTree(TreeNode root1,TreeNode root2){
        //递归停止的条件：
        if(root2==null){
            //B树先遍历完成B树是A树的子结构
            return true;
        }
        if(root1==null){
            //A树先遍历完成，B树还没有遍历完成
            return false;
        }
        return root1.val==root2.val&&isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);

    }

    public static void main(String[] args) {
        HasSubtree hasSubtree = new HasSubtree();
        TreeNode root1 = TreeUtils.array2tree("{8,8,7,9,2,null,null,null,null,4,7}");
        TreeNode root2 = TreeUtils.array2tree("{8,9,2}");
        System.out.println(hasSubtree.HasSubtree(root1, root2));
    }
}
