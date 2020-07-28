package dfs;

import utils.TreeNode;

public class ConvertSortedArraytoBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return helper(nums,0,nums.length-1,null);//最后一次返回根节点
    }
    private TreeNode helper(int[] nums,int low,int high,TreeNode root){//每次递归调用返回一个节点，同时将该节点指定为父节点的左或者右子节点。
        /*递归结束的条件是low>high*/
        if(low>high){
            return null;
        }
        int   mid = (low+high)/2;
        root = new TreeNode(nums[mid]);//每次递归都会新建一个节点
        root.left = helper(nums,low,mid-1,root.left);//给root的左节点赋值为下次递归的返回值
        root.right = helper(nums,mid+1,high,root.right);
        return root;//一次递归的返回值
    }
}
