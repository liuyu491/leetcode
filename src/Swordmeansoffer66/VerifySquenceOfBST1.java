package Swordmeansoffer66;

import utils.TreeNode;
import utils.TreeUtils;

public class VerifySquenceOfBST1 {

    public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence==null){
            return false;
        }
        return verifySquenceOfBST(sequence,0,sequence.length-1);
    }
    //判断[i,j]范围的子序列是不是符合二叉搜索树的特点，根节点的值大于左子树所有节点，
    //小于右子树所有节点
    private static boolean verifySquenceOfBST(int [] sequence,int i,int j) {
        if(i>=j){
            return true;
        }
        int mid = sequence[j];
        int index = j;
        for(int n=i;n<j;n++){
            if(sequence[n]>mid){
                index = n;
                break;
            }
        }

        for(int n=index;n<j;n++){
            if(sequence[n]<mid){
                return false;
            }
        }
        return verifySquenceOfBST(sequence,i,index-1)&&verifySquenceOfBST(sequence,index,j-1);
    }


    public static void main(String[] args) {
        int[] arr = {3,8,6,15,10};
        System.out.println(verifySquenceOfBST(arr));
    }
}
