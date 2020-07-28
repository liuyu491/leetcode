package bfs;

import java.util.LinkedList;
import java.util.Queue;
public class NumIslands {
    private int numbers;
    private class Element{
        int i;
        int j;
        Element(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    private boolean[][] marked;
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        marked = new boolean[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if((!marked[i][j])&&grid[i][j]=='1'){
                    bfs(i,j,grid);
                    numbers++;
                }
            }
        }
        return numbers;
    }
    private void bfs(int i,int j,char[][] grid){
        Queue<Element> que = new LinkedList<>();
        que.add(new Element(i,j));
        marked[i][j] = true;
        while(!que.isEmpty()){
            Element cur = que.peek();
            if(cur.i<grid.length-1&&(!marked[cur.i+1][cur.j])&&grid[cur.i+1][cur.j]=='1'){
                que.add(new Element(cur.i+1,cur.j));
                marked[cur.i+1][cur.j] = true;
            }
            if(cur.j<grid[0].length-1&&(!marked[cur.i][cur.j+1])&&grid[cur.i][cur.j+1]=='1'){
                que.add(new Element(cur.i,cur.j+1));
                marked[cur.i][cur.j+1] = true;
            }
            if(cur.i>0&&(!marked[cur.i-1][cur.j])&&grid[cur.i-1][cur.j]=='1'){
                que.add(new Element(cur.i-1,cur.j));
                marked[cur.i-1][cur.j] = true;
            }
            if(cur.j>0&&(!marked[cur.i][cur.j-1])&&grid[cur.i][cur.j-1]=='1'){
                que.add(new Element(cur.i,cur.j-1));
                marked[cur.i][cur.j-1] = true;
            }
            que.poll();
        }
    }
}
