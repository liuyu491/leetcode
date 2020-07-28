package backtrack;



public class SudokuSolver_37 {
    private boolean[][] rows = null;
    private boolean[][] columns = null;
    private boolean[][] lattices = null;
    public void solveSudoku(char[][] board) {
        rows = new boolean[9][9];
        columns = new boolean[9][9];
        lattices = new boolean[9][9];
        init(board);
        OUT:for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    solveSudokuHelper(board,i,j);
                    break OUT;
                }

            }
        }

    }

    private boolean solveSudokuHelper(char[][] board,int x,int y){
        if(x==9){
            return true;
        }


        int newY = y;
        int newX = x;

        while(true){

            newY++;
            if(newY>8){
                newX = newX+1;
                newY = newY/9-1;
//                if(x==8&&y>=5)
//                    System.out.println("newX,newY:"+newX+","+newY);
                //System.out.println("newX,newY:"+newX+","+newY);
            }


            if(newX>8||board[newX][newY]=='.'){
//                if(x==8&&y>=6)
//                    System.out.println("newX,newY:"+newX+","+newY);
                break;
            }

        }




        boolean flag = false;
        for(int i=1;i<=9;i++){
            if(!rows[x][i-1]&&!columns[y][i-1]&&!lattices[getLoc(x,y)][i-1]){
                board[x][y] = (char)('0'+i);
                rows[x][i-1] = true;
                columns[y][i-1] = true;
                lattices[getLoc(x,y)][i-1] = true;
                flag = solveSudokuHelper(board,newX,newY);
                rows[x][i-1] = false;
                columns[y][i-1] = false;
                lattices[getLoc(x,y)][i-1] = false;
                if(flag){
                    break;
                }
            }
        }
        if(!flag){
            board[x][y] = '.';
        }
        return flag;
    }

    private void init(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c!='.'){
                    rows[i][c-'1'] = true;
                    columns[j][c-'1'] = true;
                    lattices[getLoc(i,j)][c-'1'] = true;
                }
            }
        }
    }
    /*把数独坐标映射为9个格子的编号，从0开始*/
    private int getLoc(int i,int j){
        int x = i/3;
        int y = j/3;
        return x*3+y;
    }

    public static void main(String[] args) {

        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver_37 sudokuSolver = new SudokuSolver_37();
        sudokuSolver.solveSudoku(board);
        for (char[] row: board
        ) {
            for (char c: row
            ) {
                System.out.print(c+" ");
            }
            System.out.println("\n");
        }

    }
}
