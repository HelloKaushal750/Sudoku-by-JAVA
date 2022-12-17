import java.util.*;
class Main{
    public static boolean solve(int[][] board, int row, int col){
        if(row==9){
            return true;
        }
        if(col==9){
            return solve(board,row+1,0);
        }
        if(board[row][col]!=0){
            return solve(board,row,col+1);
        }
        for(int i=1; i<=9; i++){
            if(!valid(board,row,col,i)){
                board[row][col] = 0;
                continue;
            }
            board[row][col] = i;
            if(solve(board,row,col+1)){
                return true;
            }
            board[row][col] = 0;
        }
        return false;
    }

    public static boolean valid(int[][] board, int row, int col, int val){
        int startRow = row - (row % 3);
        int startCol = col - (col % 3);
        for (int i = startRow; i < startRow+3; i++){
            for (int j = startCol; j < startCol+3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        for(int i=0; i<9; i++){
            if(board[row][i]==val){
                return false;
            }
        }
        for(int i=0; i<9; i++){
            if(board[i][col]==val){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                board[i][j]=sc.nextInt();
            }
        }

        if(solve(board,0,0)){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println("-1");
        }
    }
}
