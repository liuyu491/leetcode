package Swordmeansoffer66;

import java.util.Arrays;

public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        Arrays.sort(numbers);
        boolean res = true;
        int numsOf0 = getNumbersOf0(numbers);
        System.out.println(numsOf0);
        int pre = numbers[numsOf0];
        int cur = 0;
        for(int i=numsOf0+1;i<numbers.length;i++){
            cur = numbers[i];
            if(cur-pre==1){
                pre = cur;
            }else{
                int gap = cur-pre-1;
                if(numsOf0>=gap){
                    numsOf0 = numsOf0-gap;
                    pre = cur;

                }else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
    //获取0的数量
    private int getNumbersOf0(int[] numbers){
        int count = 0;
        for(int i=0;i<2;i++){
            if(numbers[i]==0)
                count++;
            else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        IsContinuous isContinuous = new IsContinuous();
        int[] nums = {0,3,1,6,4};
        System.out.println(isContinuous.isContinuous(nums));
    }
}
