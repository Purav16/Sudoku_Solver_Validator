import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class c {

		int[][] puzzle;
		private int steps;
		
		//Constructor
		public c(String path) throws IOException{
			//Read a file into a buffered reader
			FileReader fr = new FileReader(path);
			BufferedReader textReader = new BufferedReader(fr);
			
			
			puzzle  = new int[9][9];//2D int array for puzzle data
			String[] lines = new String[9];
			
			for (int r = 0; r < puzzle.length; r++)
			{
				//Input the lines of the BufferedReade into the lines array.
				lines[r] = textReader.readLine();
				
				while (lines[r] != null && (lines[r].contains("1") == false) && 
						(lines[r].contains("2") == false) &&
						(lines[r].contains("3") == false) &&
						(lines[r].contains("4") == false) &&
						(lines[r].contains("5") == false) &&
						(lines[r].contains("6") == false) &&
						(lines[r].contains("7") == false) &&
						(lines[r].contains("8") == false) &&
						(lines[r].contains("9") == false) &&
						(lines[r].contains(".") == false) 
						)
				{
					lines[r] = textReader.readLine(); //Reads a new line if there is no important information
				}
				
				//format the lines array into the puzzle array.
				for ( int c = 0; c < puzzle[r].length; c++)
				{
					
					puzzle[r][c] = toInt(lines[r].substring(0, 1));
					lines[r] = lines[r].substring(1,lines[r].length());
					
					while (puzzle[r][c] == -1)
					{
						puzzle[r][c] = toInt(lines[r].substring(0, 1));
						lines[r] = lines[r].substring(1,lines[r].length());
					}
					
				}
				
			}
			textReader.close();
			
			//Output the unsolved Sudoku
			System.out.println("Unsolved: ");
			outputSudoku(puzzle);
			
		}
		
		public void outputSudoku(int[][] puzzle)
		{
			for (int r = 0; r < puzzle.length; r++)
			{
				System.out.println( puzzle[r][0] + " " + puzzle[r][1] + " " 
									+ puzzle[r][2] + "      " + puzzle[r][3] + " " 
									+ puzzle[r][4] + " " + puzzle[r][5] + "      " 
									+ puzzle[r][6] + " " + puzzle[r][7] + " " + puzzle[r][8] );
				if ( r == 2 || r == 5 )
				{
					System.out.println();
				}
			}
		}
		
		public Boolean solve(int r, int c)
		{
			if(c >= 9) 
			{
				c = 0;
				r++;
			}
			
			if (r == 9 && c == 9 && puzzle[r][c] != 0)
			{
				return true;
			}
			
			
			
			if (puzzle[r][c] != 0) return solve(r,c+1);
			//else
			for (int i=0;i<=9; i++)
			{
				puzzle[r][c] = i;
				if (valid(r,c) && solve(r,c+1)) return true;
				
			}
			
			puzzle[r][c] = 0;
			return false;
		}
		
		//Checks to see if the entry at this location is valid. 
		//True = valid, False = invalid
		public Boolean valid(int r , int c)
		{
			
			//Check row
			for (int i = 0; i < puzzle.length; i ++)
			{
				//!=i excludes the space we are checking.
				if ( puzzle[r][c] == puzzle[r][i] && c != i)
					return false;
			}
			
			//Check column
			for (int i = 0; i < puzzle[r].length; i++)
			{
				if ( puzzle[r][c] == puzzle[i][c] && r != i)
				{
					return false;
				}
			}
			
			//Create a 3x3 Matrix and assign the appropriate values
			int[][]three = threebythree(puzzle,r,c);
			
			//Check the matrix for a repeating value.
			for (int i = 0; i < three.length; i ++)
			{
				for (int j = 0; j < three[i].length; j++)
				{
					if (puzzle[r][c] == three[i][j] && (i != r) && (j != c))
					{
						return false;
					}
				}	
			}
			
			//Check for invalid values in r,c
			if (puzzle[r][c] > 9 || puzzle[r][c] < 1)
			{
				return false;
			}

			//If we have made it this far without exiting the function via returning
			//false, it is valid.
			return true;
		}
	
		//We use this to help find the contents of the 3x3 matrix of a point
	public int[][] threebythree(int[][] puzzle, int r, int c)
	{
		int[][] three = new int[3][3];
		/*We have to find where the point will lay in it's Matrix.
		Because we don't really care about the location of all of the numbers,
		Except the incorrect one,
		We can just add them to a string and check it's contents.*/ 
		int offsetR = 0;
		int offsetC = 0;
		
		if ( (r) % 3 == 2)
		{
			offsetR = -2;
		}
		else if ( (r) % 3 == 1)
		{			
			offsetR = -1;
		}
		else if ( (r) % 3 == 0)
		{	
			offsetR = 0;
		}
		
		if ( (c) % 3 == 2)
		{
			offsetC = -2;
			
		}
		else if ( (c) % 3 == 1)
		{
			offsetC = -1;
			
		}
		else if ( (c) % 3 == 0)
		{
			offsetC = 0;
		}
		
		for ( int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				three[i][j] = puzzle[r + offsetR + i][c + offsetC + j];
			}
		}
		
		return three;
	}
	
	//Turns the string into ints. The blank values will be expressed as 0's,
	//invalid values will be expressed as -1.
	private static int toInt(String a)
	{
		//We only care what the string starts with, as the rest of it is the rest of the line
		if (a.startsWith("."))
		{
			return 0;
		}
		else if( a.startsWith("1"))
		{
			return 1;
		} else if (a.startsWith("2"))
		{
			return 2;
		} else if (a.startsWith("3"))
		{
			return 3;
		} else if (a.startsWith("4"))
		{
			return 4;
		} else if (a.startsWith("5"))
		{
			return 5;
		} else if (a.startsWith("6"))
		{
			return 6;
		} else if (a.startsWith("7"))
		{
			return 7;
		}
		else if (a.startsWith("8"))
		{
			return 8;
		}
		else if (a.startsWith("9"))
		{
			return 9;
		} else
		{
			return -1;
		}
		
	}
	
	//This is my main method
	public static void main (String[] args) throws IOException
	{
		Scanner getInput = new Scanner(System.in);//Create a new input Scanner
		String input =  getInput.nextLine(); //Create a string to hold input
		getInput.close();
		
		c sudoku = new c(input); //Retrieve the given file as a new Sudoku
		sudoku.solve(0, 0);
		
		sudoku.outputSudoku(sudoku.puzzle);
		
	}
	
}