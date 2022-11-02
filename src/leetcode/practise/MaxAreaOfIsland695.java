package leetcode.practise;

 class Solution695 {
	
	private boolean[][] seen;
	public int area(int row, int col, int[][] grid) {
	    
		if ( 
			row < 0 || col < 0 
			|| row >= grid.length || col >= grid[0].length
			|| seen[row] [col] == true
			|| grid[row][col] == 0 ) {
			return 0 ;
		}
		seen[row][col] = true;
		return ( 1 
				 + area(row,col+1, grid) + area(row, col-1, grid) 
		         + area (row-1, col, grid) + area (row+1, col, grid));
		
		
	};
    public int maxAreaOfIsland(int[][] grid) {
    	int numberOfRows = grid.length;
     	int numberOfColumns = grid[0].length;
    	int maxArea =0;
    	seen = new boolean[numberOfRows][numberOfColumns];
    
   
    	for (int i =0 ; i < numberOfRows ; i++)
    		for (int j = 0; j < numberOfColumns; j++) {
    			maxArea = Math.max(maxArea, area(i, j, grid));
    			
    		}	
    	return maxArea;
    }
};
public class MaxAreaOfIsland695 {
	
	public static void main(String[] args) {
		int[][] inputArray =  {
					  {0,0,1,0,0,0,0,1,0,0,0,0,0} ,
					  {0,0,0,0,0,0,0,1,1,1,0,0,0},
					  {0,1,1,0,1,0,0,0,0,0,0,0,0},
				      {0,0,0,0,0,0,0,1,1,1,0,0,0},
					  {0,1,0,0,1,1,0,0,1,0,1,0,0},
					  {0,1,0,0,1,1,0,0,1,1,1,0,0},
					  {0,0,0,0,0,0,0,0,0,0,1,0,0},
				      {0,0,0,0,0,0,0,1,1,0,0,0,0}
				 };

		
		Solution695 solution = new Solution695();
		System.out.println( solution.maxAreaOfIsland(inputArray));
	
	}
}

/*
 * 
 *  Courtesy: https://www.youtube.com/watch?v=Us6LBYBVko4

    Pleae observe that: The Or conditions are very crucial, 
    1) if we first check grid[row][col] == 0 before checking boundary conditions
    This will lead to ArrayIndexOutOfBounds Exception
*/