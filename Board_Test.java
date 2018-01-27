
public class TestBoard {
	public static void main(String[] args){
		int[][] board = {{1,2,3},
				{6,4,5}};
		System.out.println(board);
		System.out.print(board[0][0]);
		System.out.print(board[0][1]);
		System.out.print(board[0][2]);
		System.out.print(board[1][0]);
		System.out.print(board[1][1]);
		System.out.print(board[1][2]);
		
		System.out.println(" " +board.length);
		if (board.length != 9 ){
			System.out.println("Board is not of given length");
		}
}}
