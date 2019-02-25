public class Queens {
  public static boolean isLegal(int[][] board, int r, int c){
    for(int i = 0; i < r; i++){
      if(board[i][c] == 1){
      return false;
      }
      int diff = r - i;
      if(c - diff >= 0 && board[i][c - diff] == 1){
        return false;
      }
      if(c + diff < board[i].length && board[i][c + diff] == 1){
        return false;
      }
    }
    return true;
  }
  public static boolean queenPlacement(int[][] board, int r){
    if(r==board.length){
      return true;
    }
    for(int i = 0; i < board[r].length; i++){
      if(isLegal(board, r, i)){
        board[r][i] = 1;
        if(queenPlacement(board, r+1)){
          return true;
        }else{
          board[r][i] = 0;
        }
      }
    }
    return false;
  }
}
