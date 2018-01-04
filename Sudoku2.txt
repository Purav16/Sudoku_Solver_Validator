public class Sudoku_8 {
 
 /** 0 means box is blank, otherwise only numbers 1..9 are allowed */
 private int[][] board = new int[9][9];
 
 public Sudoku_8(){
  board[0][0] = 1;
//  board[0][1] = 1;
  
 }

 private boolean isLegalBox(int[][] theBoard, int rowOffset, int colOffset){
  boolean[] check = new boolean[10];
  for (int row = rowOffset; row < rowOffset + 3; row++){
   for (int col =colOffset; col < colOffset + 3; col++){
    if (board[row][col] == 0)
     continue;
    if (check[ board[row][col] ])
     return false;
    else
     check[ board[row][col] ] = true;
   }
  }
  return true;
 }
 
 public boolean isLegalBoard(int [][] theBoard){
  
  //check all rows
  for (int row = 0; row < 9; row++){
   boolean[] check = new boolean[10];
   for (int i =0; i < 10; i++)
    check[i] = false;
   for (int col =0; col < 9; col++){
    if (board[row][col] == 0)
     continue;
    if (check[ board[row][col] ])
     return false;
    else
     check[ board[row][col] ] = true;
   }
  }
  
  //check all columns
  for (int col = 0; col < 9; col++){
   boolean[] check = new boolean[10];
   for (int i =0; i < 10; i++)
    check[i] = false;
   for (int row =0; row < 9; row++){
    if (board[row][col] == 0)
     continue;
    if (check[ board[row][col] ])
     return false;
    else
     check[ board[row][col] ] = true;
   }
  }

  //check all 9 boxes
  for (int row = 0; row < 9; row+=3){
   for (int col =0; col < 9; col+=3){
    if (! isLegalBox(theBoard, row, col))
     return false;
   }
  }
  
  return true;
 }
 
 public boolean isLegal(){
  return isLegalBoard(board);
 }
 
 public String toString(){
  String result = "";
  for (int row = 0; row < 9; row++){
   for (int col =0; col < 9; col++){
    result += Integer.toString(board[row][col]) + " ";
   }
   result += "\n";
  }
  return result;
 }
}