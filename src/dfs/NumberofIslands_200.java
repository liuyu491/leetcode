package dfs;

import java.util.ArrayList;
import java.util.List;

public class NumberofIslands_200 {
    private class Neighbor {
        int i;
        int j;

        Neighbor(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int numIslands(char[][] grid) {
        int length = grid.length;
        if(length==0){
            return 0;
        }
        int count = 0;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        for (int i = 0; i <length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if(grid[i][j]=='1'&&marked[i][j]==false){
                    dfs(grid,i,j,marked);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] marked) {
        if (!marked[i][j]) {
            marked[i][j] = true;
           for(Neighbor neighbor:getneighbors(i,j,grid)){
               dfs(grid,neighbor.i,neighbor.j,marked);
           }
        }
    }

    private List<Neighbor> getneighbors(int i, int j,  char[][] grid) {
        ArrayList<Neighbor> neihbors = new ArrayList<>();
        if (j < grid[0].length - 1 && grid[i][j + 1] =='1') {
            neihbors.add(new Neighbor(i, j + 1));
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            neihbors.add(new Neighbor(i + 1, j));
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            neihbors.add(new Neighbor(i, j - 1));
        }
        if (i > 0 && grid[i - 1][j] == '1') {
            neihbors.add(new Neighbor(i - 1, j));
        }
        return neihbors;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        NumberofIslands_200 test = new NumberofIslands_200();
        System.out.println(test.numIslands(grid));
    }
}
