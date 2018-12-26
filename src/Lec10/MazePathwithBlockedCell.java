package Lec10;

/**
 * created by : Juned Raghib
 * created on : 25-Dec-2018
 */
public class MazePathwithBlockedCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = {{0,1,0,0},
				{0,0,0,0},
				{0,1,0,0},
				{0,0,1,0}};
		printMazePath(maze, 0, 0, 3, 3, "", new boolean[4][4]);
	}
	
	public static void printMazePath(int[][] maze, int rowstart, int colstart, int rowend, int colend, String ans, boolean[][] visited)
	{
		if(rowstart == rowend && colstart == colend)
		{
			System.out.println(ans);
			return;
		}
		
		if(rowstart >= maze.length || colstart >= maze[0].length || rowstart < 0 || colstart < 0 || visited[rowstart][colstart] || maze[rowstart][colstart] == 1)
		{
			return;
		}
		
		visited[rowstart][colstart] = true;
		printMazePath(maze, rowstart + 1, colstart, rowend, colend, ans + "B", visited);
		printMazePath(maze, rowstart - 1, colstart, rowend, colend, ans + "T", visited);
		printMazePath(maze, rowstart, colstart - 1, rowend, colend, ans + "L", visited);
		printMazePath(maze, rowstart, colstart + 1, rowend, colend, ans + "R", visited);
		visited[rowstart][colstart] = false;
	}

}
