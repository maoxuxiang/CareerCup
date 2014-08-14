package RecursionAndDP;

/**
 * Implement the "paint fill" function that one might see on many image editing
 * programs. That is, given a screen (represented by a two-dimensional array of
 * colors), a point, and a new color, fill in the surrounding area until the
 * color changes from the original color.
 * 
 */

public class q7 {
	
	public static void fill(char[][] screen, int x, int y, char newcolor) {
		if (screen == null || screen.length == 0 || screen[0].length == 0) {
			return;
		}
		
		char orginalColor = screen[y][x];
		boolean[][] visited = new boolean[screen.length][screen[0].length];
		
		fill(screen, x, y, newcolor, visited, orginalColor);
	}
	
	private static void fill(char[][] screen, int x, int y, char newcolor, boolean[][] visited, char orginalColor) {
		if (visited[y][x] || screen[y][x] != orginalColor) {
			return;
		}
		
		visited[y][x] = true;
		screen[y][x] = newcolor;
		
		if (y < screen.length-1)
			fill (screen, x, y+1, newcolor, visited, orginalColor);
		if (y > 0)
			fill (screen, x, y-1, newcolor, visited, orginalColor);
		if (x < screen[0].length -1)
			fill (screen, x+1, y, newcolor, visited, orginalColor);
		if (x > 0)
			fill (screen, x-1, y, newcolor, visited, orginalColor);
		
	}

}
