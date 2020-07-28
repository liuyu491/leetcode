package Swordmeansoffer66;

public class HasPath {
    private boolean[][] marked = null;
    //定义偏移量，分别表示向左、上、右、下移动
    private int[][] devis = {{-1,0},{0,-1},{1,0},{0,1}};


    //回溯
    public boolean hasPath(String matr, int rows, int cols, String stri)
    {
        char[] matrix = matr.toCharArray();
        char[] str = stri.toCharArray();
        //定义标记数组，用来记录已近走过的路径
        marked = new boolean[rows][cols];
        char[][] mat = new char[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                mat[i][j] = matrix[i*cols+j];
            }
        }


        String string = new String(str);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==str[0]){
                    //如果找到了字符串就返回true。
                    if(searchWord(new StringBuilder(),0,mat,string,i,j)){
                        return true;
                    }
                }
            }
        }
        //在matrix[i][j]位置周围没有符合条件的点
        return false;
    }


    //搜索单词
    private  boolean searchWord(StringBuilder sb,int index,char[][] matrix,String str,int i,int j){
        char c = matrix[i][j];
        sb.append(c);
        marked[i][j] = true;
        if(sb.toString().equals(str)){
            return true;
        }


        for(int[] devi:devis){
            int m = i+devi[0];
            int n = j+devi[1];
            if(m<0||n<0||m>=matrix.length||n>=matrix[0].length){
                continue;
            }
            char a = matrix[m][n];

            if(a==str.charAt(index+1)&&!marked[m][n]){
                //如果searchWord函数返回true（找到了单词的路径）那么就直接返回true。
                if(searchWord(sb,index+1,matrix,str,m,n)){
                    return true;
                }

            }
        }
        //没有在上面的代码中返回，说明经过i,j这个点的路径不对，将状态复原后返回false。
        sb.deleteCharAt(sb.length()-1);
        marked[i][j] = false;
        return false;

    }

    public static void main(String[] args) {


        String a = "ab";

        String i = new String("a")+new String("b");

        String g = i.intern();


        System.out.println(g==i);

    }
}
