package normaltest;

import java.util.*;

public class NormalTest {
    public static List<Integer> sortAsFrequency(int a,int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int number:nums){
            map.put(number,0);
        }
        for(int number:map.keySet()){
            for(int num:nums){
                if(number==num){
                    map.put(number,map.get(number)+1);
                }
            }
        }
        List<Map.Entry<Integer,Integer>> list = sortformaptest(map);
        for(Map.Entry<Integer,Integer> entry:list){
            for(int i=0;i<entry.getValue();i++){
                result.add(entry.getKey());
            }
        }
        return result;
    }
    public static List<Map.Entry<Integer,Integer>> sortformaptest(Map<Integer,Integer> map){
        /*把hashmap转化为arraylist*/
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
                return list;
    }

    public static void main(String[] args) {
       int[] nums = {100,200,100,100,200,400,500,1500,1500,1500} ;
        System.out.println(sortAsFrequency(nums.length,nums));
       
    }
}
