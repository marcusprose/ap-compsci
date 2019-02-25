public class QueensProblem {
  
  public static void main(String[] args) {
    int[][] board = new int[8][8];
    queenPlacement(board, 0);
  }
  
  
  public static boolean isLegal(int[][] board, int r, int c) {
    for(int i = 0; i < r; i++) {
      if(board[i][c] == 1){
      return false;
      }
      int diff = r - i;
      if(c - diff >= 0 && board[i][c - diff] == 1){
        return false;
      }
      if(c + diff < board[i].length && board[i][c + diff] == 1) {
        return false;
      }
    }
    return true;
  }
  public static boolean queenPlacement(int[][] board, int r) {
    if(r==board.length) {
      printBoard(board);
      return true;
    }
    for(int i = 0; i < board[r].length; i++) {
      if(isLegal(board, r, i)){
        board[r][i] = 1;
        if(queenPlacement(board, r+1)) {
          return true;
        }else{
          board[r][i] = 0;
        }
      }
    }
    return false;
  }
  
  public static void printBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) {
          System.out.print("_ ");
        } else {
          System.out.print("q ");
        }
      }
      System.out.println();
    }
  }
  
  
  
}
