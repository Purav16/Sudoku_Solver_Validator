import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class three {
	public static void main(String[] args){
		 InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(isr);
         System.out.println("Enter the Sudoku elements");
         try {
			String[] integersInString = br.readLine().split(" ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         int board[][] = new int[9][9];
         for ( int i = 0 ; i < 9 ; i++ ){
        	 for ( int j = 0 ; j < 9 ; j++ ){
        		 try {
					board[i][j] = br.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
         }
         System.out.println("elemetns are");
         for ( int i = 0 ; i < 9 ; i++ ){
        	 for ( int j = 0 ; j < 9 ; j++ ){
        		 System.out.println(board[i][j]);
        	 }}
	}

}
