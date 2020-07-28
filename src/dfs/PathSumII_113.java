package dfs;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII_113 {
    List<List<Integer>> list1 = new ArrayList<>();
    List<Integer> path1 = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        int sum_temp = 0;
        TreeNode pre = null;//定义节点pre用于记录上次出栈的节点
        List<Integer> path = new ArrayList<>();
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                sum_temp = sum_temp+root.val;
                path.add(root.val);
                root = root.left;
            }
            root = stack.peek();

            /*因为要记录路径，所以访问了父节点的左子节点后不能直接把父节点出栈
            * 这样路径会少记录父节点那一环，要把父节点出栈，必须要等到已经访问过来父节点
            * 的右子节点，或则父节点右子节点为null才行，这样才能完整记录下路径*/
            if(root.right!=null&&pre!=root.right){//判断父节点的右子节是否为null，或已被访问
                root = root.right;
                continue;//访问右子节点
            }
            /*到叶子节点，判断和是否符合要求*/
            if(root.left==null&&root.right==null&&sum_temp==sum){
                list.add(new ArrayList<>(path));
            }
            stack.pop();//把当前节点出栈
            pre = root;//pre指向出栈的节点
            path.remove(path.size()-1);//从路径中移除出栈的节点
            sum_temp = sum_temp-root.val;//和减去已经出栈的节点的值
            root = null;//root设为null，则下次循环直接访问栈顶的节点
        }
        return list;
    }
    /*方法二：递归调用方法*/
    public List<List<Integer>> pathSum_recursive(TreeNode root, int sum) {
        /*如果root为null则返回一个空数组*/
        if(root==null){
            return list1;
        }
        /*调用dfs对数组进行遍历，找出符合要求的路径*/
        dfs(sum,root);
        return list1;
    }
    private void dfs(int target,TreeNode root){
        if(root==null){
            return;
        }
        /*前序遍历符合本题的要求*/
        /*先将根节点放入path1中*/
        path1.add(root.val);
        /*判断叶子节点的值是否等于当前target*/
        if(root.left==null&&root.right==null&&root.val==target){
            list1.add(new ArrayList<>(path1));
        }
        /*每次遍历一个节点就把target的值减去父节点的值，一直递归下去，如果到叶子节点时，target的值等于叶子节点的值说明路径中的点的和等于sum*/
        dfs(target-root.val,root.left);
        dfs(target-root.val,root.right);
        /*一条路径已经查找结束了，方法返回前把路径中的点依此移除*/
        path1.remove(path1.size()-1);
    }
}
