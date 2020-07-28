package dp;


import Swordmeansoffer66.Match;

/*
* 注意：在这里只用一个meme数组进行记忆化搜索是有问题的：
* 当选择偷取第0时，那么后续只能尝试偷取不能包含nums.length-1,在这种情况下
* 我们算出的f(i,j)存在meme[i]是用来表示选择了第0间后考虑偷[i,nums.length-2]区间房子得到
* 的最大值。
*
* 当不偷取0时，我们算出的f(i,j)存在meme1[i]是用来表示选择了第0间后考虑偷[i,nums.length-1]区间房子得到
   的最大值。
* */
public class RobII {
    int[] meme1;
    int[] meme2;
    public int rob(int[] nums) {
        meme1 = new int[nums.length-1];
        meme2 = new int[nums.length];
        int res1 = nums[0] + tryRob1(nums,2);
        int res2 = tryRob2(nums,1);
        return Math.max(res1,res2);
    }

    //函数定义：尝试偷取[i,j]范围内房子所获得收益的最大值
    //等于max(nums[1]+f(1+2,j)+nums[2]+f(2+2,j)....)
    private int tryRob2(int[] nums,int i){

        if(i>=nums.length){
            return 0;
        }
        if(meme2[i]!=0)
            return meme2[i];
        int res = Integer.MIN_VALUE;
        for(int m=i;m<=nums.length-1;m++){
            res = Math.max(res,nums[m]+tryRob2(nums,m+2));
        }
        meme2[i] = res;
        return res;

    }

    private int tryRob1(int[] nums,int i){
        if(i>=nums.length-1){
            return 0;
        }
        if(meme1[i]!=0)
            return meme1[i];

        int res = Integer.MIN_VALUE;
        for(int m=i;m<=nums.length-2;m++){
            res = Math.max(res,nums[m]+tryRob1(nums,m+2));
        }
        meme1[i] = res;
        return res;
    }

    public static void main(String[] args) {
        RobII robII = new RobII();
        int[] nums = {6,6,4,8,4,3,3,10};
        System.out.println(robII.rob(nums));


    }
}
