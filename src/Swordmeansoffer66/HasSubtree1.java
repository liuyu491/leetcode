package Swordmeansoffer66;

import utils.TreeNode;
import utils.TreeUtils;

public class HasSubtree1 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {


        if(root1==null||root2==null){
            return false;
        }

        return isSubtree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);

    }

    private boolean isSubtree(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root2==null&&root1!=null){
            return true;
        }
        if(root2!=null&&root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return root1.val==root2.val&&isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
    }

}
