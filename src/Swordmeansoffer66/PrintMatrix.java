package Swordmeansoffer66;

import java.util.ArrayList;

public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int up = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        ArrayList<Integer> res = new ArrayList<>();

        while(up<=bottom&&left<=right){
            //up
            for(int j=left;j<=right;j++){
                res.add(matrix[up][j]);
            }
            up++;
            //right
            for(int i=up;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            //bottom
            for(int j=right;j>=left;j--){
                res.add(matrix[bottom][j]);
            }
            bottom--;
            //left
            for(int i=bottom;i>=up;i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8}};
        System.out.println(printMatrix(matrix));
    }
}
