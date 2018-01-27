import java.util.Scanner;

public class Trial_Sudoku {
	public static void main(String[] args){
	int[][] sudoku = new int[9][9];
	System.out.println("Enter sudoku elements");
	Scanner sc = new Scanner(System.in);
	
	for( int i = 0 ; i < 9 ; i++ ){
		for( int j = 0 ; j <9 ; j++ ){
			sudoku[i][j] = sc.nextInt();
		}}
	for( int i = 0 ; i < 9 ; i++ ){
		for( int j = 0 ; j <9 ; j++ ){
			System.out.println(sudoku[i][j]);
		}}
	}

}
