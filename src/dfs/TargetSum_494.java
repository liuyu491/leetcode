package dfs;

import java.util.ArrayList;
import java.util.List;

public class TargetSum_494 {
    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        caculatesum(sum, 0, nums, S);
        return count;
    }

    private void caculatesum(int sum, int index, int[] nums, int S) {
        if (index == nums.length) {
            if (sum == S) {
                count++;
            }
            return;
        }
        caculatesum(sum + nums[index], index + 1, nums, S);
        caculatesum(sum - nums[index], index + 1, nums, S);
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        TargetSum_494 test = new TargetSum_494();
        System.out.println(test.findTargetSumWays(nums, 1));
    }
}
