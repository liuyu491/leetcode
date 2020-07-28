package Swordmeansoffer66;

import java.util.Arrays;

public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {
        int minIndex = 0;
        for(int i=0;i<numbers.length-1;i++){
            minIndex = i;
            for(int j=i+1;j<numbers.length;j++){
                int compareRes = compareTo(numbers[minIndex],numbers[j]);
                if(compareRes>0){
                    minIndex = j;
                }
            }
            swap(numbers,i,minIndex);
        }
        System.out.println(Arrays.toString(numbers));
        StringBuilder sb = new StringBuilder();
        for(int i:numbers){
            sb.append(i);
        }
        return sb.toString();

    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int compareTo(int i1,int i2){
        String s1 = String.valueOf(i1)+String.valueOf(i2);
        String s2 = String.valueOf(i2)+String.valueOf(i1);
        int conb1 = Integer.parseInt(s1);
        int conb2 = Integer.parseInt(s2);
        return conb1>conb2?1:-1;
    }

    public static void main(String[] args) {
        PrintMinNumber printMinNumber = new PrintMinNumber();
        printMinNumber.PrintMinNumber(new int[]{3,5,1,4,2});
    }
}
