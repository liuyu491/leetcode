package bfs;

import java.util.*;

public class OpenLock {
    HashMap<String,Integer> hashmap = new HashMap<>();
    boolean[] marked = new boolean[10000];
    OpenLock(){
        for (int i = 0; i <=9999 ; i++) {
            if(i<10){
                hashmap.put("000"+i,i);
            }else if(i>=10&&i<100){
                hashmap.put("00"+i,i);
            }else if(i>=100&&i<1000){
                hashmap.put("0"+i,i);
            }else if(i>=1000){
                hashmap.put(""+i,i);
            }
        }
    }
    public int openlock(String[] deadends, String target) {
      int result = bfs("0000",deadends,target);
        System.out.println(result);
        return result;
    }

    private List<String> getNeighbors(String s){
        List<String> neighbors = new ArrayList<>();
        char[] num_c = s.toCharArray();
        for (int i = 0; i <num_c.length ; i++) {
            char[] num_temp = s.toCharArray();
                if(num_c[i]=='0'){
                    num_temp[i] = 1+'0';
                    neighbors.add(new String(num_temp));
                    num_temp[i] = 9+'0';
                    neighbors.add(new String(num_temp));
                }else if(num_c[i]=='9'){
                    num_temp[i] = 0+'0';
                    neighbors.add(new String(num_temp));
                    num_temp[i] = 8+'0';
                    neighbors.add(new String(num_temp));
                }else{
                    int a = num_c[i]-'0';
                    num_temp[i] = (char)((a+1)+'0');
                    neighbors.add(new String(num_temp));
                    num_temp[i] = (char)((a-1)+'0');
                    neighbors.add(new String(num_temp));
                }

        }
        return neighbors;
    }
    private int bfs(String source,String[] deadends, String target){
        Queue<String> que = new LinkedList<>();
        que.add(source);
        int steps = 1;
        List<String> neighbors = null;
        int size = 0;
        while (!que.isEmpty()){
            size = que.size();
            for (int i = 0; i <size ; i++) {
                String s = que.peek();
                neighbors = getNeighbors(s);
//                System.out.println(neighbors);
                for (String neighbor:neighbors) {
                    if(neighbor.equals(target)){
                        return steps;
                    }
                    if(!marked[hashmap.get(neighbor)]&&isNotDeadnum(neighbor,deadends)){
                        que.add(neighbor);
                        marked[hashmap.get(neighbor)] = true;
                    }
                }
                que.poll();
            }
            steps++;
        }
        return steps;
    }
    private boolean isNotDeadnum(String num ,String[]deadends){
        for (String deadnum:deadends ){
            if(num.equals(deadnum)){
                return false;
            }
        }
        return true;
    }
    private boolean canopen(String[] deadends, String target){

        List<String> neighbors = getNeighbors(target);
        int num_indeadends = 0;
        for (String neighbor:neighbors) {
            for(String deadend:deadends){
                if(deadend.equals("0000")){
                    return false;
                }
                if(neighbor.equals(deadend)){
                    num_indeadends++;
                }
            }
        }
        return num_indeadends!=8;
    }
    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        openLock.openlock(deadends,target);
    }
}
