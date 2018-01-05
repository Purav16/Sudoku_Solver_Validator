public class Sudoku_1 
{
    int a[][]=new int[9][9];
    public void initialize1()
    {
        for(int i=0;i<9;i++)
        {
         for(int j=0;j<9;j++)
        {
             a[i][j]=0;
        }

     }
    }
    protected boolean detectRow( int row, int num )
       {
          for( int col = 0; col < 9; col++ )
             if( a[row][col] == num )
                return false;

          return true ;
       }

    protected boolean detectCol( int col, int num )
       {
          for( int row = 0; row < 9; row++ )
             if( a[row][col] == num )
                return false ;

          return true ;
       }

    protected boolean detectBox( int row, int col, int num )
       {
          row = (row / 3) * 3 ;
          col = (col / 3) * 3 ;

          for( int r = 0; r < 3; r++ )
             for( int c = 0; c < 3; c++ )
             if( a[row+r][col+c] == num )
                return false ;

          return true ;
       }

    public void solve( int row, int col ) throws Exception
    {
        if( row > 8 )
             throw new Exception( "Solution found" ) ;

        if( a[row][col] != 0 )
             next( row, col ) ;
          else
          {
    for( int num = 1; num < 10; num++ )
    {
       if(detectRow(row,num) && detectCol(col,num) && detectBox(row,col,num) )
       {
          a[row][col] = num ;
          next(row, col) ;
       }
    }
          }
    }
    public void display()
    { 
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void next( int row, int col ) throws Exception
       {
          if( col < 8 )
             solve( row, col + 1 ) ;
          else
             solve( row + 1, 0 ) ;
       }  
    public static void main(String[] args) throws Exception
    {
        Sudoku_1 fs = new Sudoku_1();
        fs.initialize1();

        fs.solve(0,0);

        fs.display();
    }

}