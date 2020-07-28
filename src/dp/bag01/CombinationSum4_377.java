package dp.bag01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSum4_377 {
    int[] meme;
    public int combinationSum4(int[] nums, int target) {
        meme = new int[target+1];
        int res = combinationSum4Meme(nums,target);
        System.out.println(Arrays.toString(meme));
        return  res;
    }

    private int combinationSum4Meme(int[] nums, int target){
        if(target==0)
            return 1;


        if(meme[target]!=0){
            return meme[target];
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(target>=nums[i]){
                res = res+combinationSum4Meme(nums,target-nums[i]);
            }
        }
        meme[target] = res;
        return res;
    }

    public static void main(String[] args) {
        CombinationSum4_377 combinationSum4 = new CombinationSum4_377();
        int[] nums = {1,2,3};
        combinationSum4.combinationSum4(nums,4);

    }
}
