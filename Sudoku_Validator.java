import java.util.Scanner;

public class Sudoku { 

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		 int[][] board = new int[9][9];
		for (int i = 0 ; i < 9 ; i++){
			for (int j =0 ; j < 9 ; j++){
				board[i][j] = sc.nextInt();
			}
		}
		for (int i = 0 ; i < 9 ; i++){
			for (int j =0 ; j < 9 ; j++){
				System.out.println(board[i][j]);
			}
		}
		/* int[][] board = {{8,3,5,4,1,6,9,2,7}, 
                		 {2,9,6,8,5,7,4,3,1}, 
                		 {4,1,7,2,9,3,6,5,8}, 
                		 {5,6,9,1,3,4,7,8,2,1}, 
                		 {1,2,3,6,7,8,5,4,9}, 
                		 {7,4,8,5,2,9,1,6,3}, 
                		 {6,5,2,7,8,1,3,9,4}, 
                		 {9,8,1,3,4,5,2,7,6}, 
                		 {3,7,4,9,6,2,8,1,5}}; 
*/
		System.out.println(testBoard(board));
	
	
	}

	
   
  public static boolean testBoard(int[][] board) { 
    if (!testSize(board)) {
    	return false;
    	} 
    if (!testRows(board)) {
    	return false; 
    }
    if (!testCols(board)) {
    	return false; 
    }
    if (!testRegions(board)) {
    	return false; 
    }
    return true; 
  }  
  // check that the board is 9 x 9 
  static boolean testSize(int[][] board) { 
    if (board.length != 9) return false; 
    for (int i = 0; i < board.length; i++) { 
      if (board[i].length != 9) return false; 
    } 
    return true; 
  }   
  // check that the digits 1-9 each appear  
  // exactly once in the given array 
  static boolean checkDigits(int[] array) { 
    if (array.length != 9) return false;  
    int[] counts = new int[10]; 
    for (int i = 0; i < array.length; i++) { 
      // invalid number 
      if (array[i] < 1 || array[i] > 9) return false;  
       
      // we have already seen this number 
      if (counts[array[i]] > 0) return false;  
      counts[array[i]]++; 
    } 
    return true; 
  }  
  // return true if all rows are correct 
  static boolean testRows(int[][] board) { 
    for (int i = 0; i < board.length; i++) { 
      if (!checkDigits(board[i])) { 
        return false; 
      } 
    } 
    return true; 
  }  
  // return true if all columns are correct 
  static boolean testCols(int[][] board) { 
    int[] tmp = new int[board.length]; 
    for (int col = 0; col < board.length; col++) {  
      // fill a temp array with every element of the column 
      for (int row = 0; row < board.length; row++) { 
        tmp[row] = board[row][col]; 
      }  
      // check to make sure it has all the right digits 
      if (!checkDigits(tmp)) { 
        return false;  
      } 
    } 
    return true; 
  }   
//return true if every region is correct 
 static boolean testRegions(int[][] board) {  
  // loop through each region, passing the indices  
  // of the upper-left corner to the next method 
  // note that we increment row and column counters by 3 here 
  for (int row = 0; row < board.length; row += 3) { 
    for (int col = 0; col < board.length; col += 3) { 
      if (!testRegion(board, row, col)) { 
        return false;  
      } 
    } 
  } 
  return true; 
 }  
 // test a specific region, given the upper left corner 
 static boolean testRegion(int[][] board, int startRow, int startCol) { 
   int[] tmp = new int[board.length]; 

   // fill a temporary array with every element of the region 
   int index = 0; 
   for (int row = startRow; row < startRow+3; row++) { 
     for (int col = startCol; col < startCol+3; col++) { 
       tmp[index] = board[row][col]; 
       index++; 
     } 
   }  
   // check if we have all of the right digits in the region 
   return checkDigits(tmp); 
 } 
}  
