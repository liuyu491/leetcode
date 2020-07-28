package dp;

import backtrack.IntegerBroker_343;

import java.util.ArrayList;

public class Triangle_120 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        for(Integer i:list){
            System.out.println(i);
            list.remove(0);
        }
    }

}
