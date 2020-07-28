package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumSquares {
    public int numSquares(int n){

        return 0;
    }
    private List<Integer> getneighbor(int a,int b){
        List<Integer> neighbors = new ArrayList<>();
        int neighbor = 0;
        for (int i = 1;  (a+neighbor)<=b ; i++) {
            neighbor = (int)Math.pow(i,2);
            neighbors.add(neighbor);
        }
        return neighbors;
    }
    private int bfs(int n){
        int steps = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int size = 0;
        while(!que.isEmpty()){
            size = que.size();
            for (int i = 0; i <size ; i++) {
                int top = que.peek();
               List<Integer> neightors = getneighbor(top,n);
               for(int neighbor:neightors){

               }
            }
        }
        return steps;
    }
}
