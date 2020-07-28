package Swordmeansoffer66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ReOrderArray {

    public static void reOrderArray(int [] array) {
        int i = 0;
        int j= i+1;
        while(i<array.length){
            if((array[i]&1)==1){
                i++;
            }else{
                j = i+1;

                while(j<array.length&&(array[j]&1)==0){
                    j++;
                }

                if(j==array.length){
                    break;
                }
                int tmp = array[j];
                for(int m = j-1;m>=i;m--){
                    array[m+1] = array[m];
                }
                array[i] = tmp;
            }
        }


    }

    public static void main(String[] args) {
//        int[] array = {2};
//        reOrderArray(array);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(list.size());
//        System.out.println(Arrays.toString(array));
    }
}
