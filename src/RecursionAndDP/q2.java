package RecursionAndDP;

import java.awt.POINT;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Imagine a robot sitting on the upper left corner of an X by Y grid. The robot
 * can only move in two directions: right and down. How many possible paths are
 * there for the robot to go from (0, 0) to (X, Y)? C(x+y)! x!
 * 
 * FOLLOW UP Imagine certain spots are "off limits", such that the robot cannot
 * step on them.
 * 
 */

public class q2 {
	
	public boolean getPath(int x, int y, ArrayList<POINT> path, Hashtable<POINT, Boolean> cache) {
		Point p = new POINT(x,y);
		path.add(p);
		
		if (cache.contains(p)) {
			return cache.get(p);
		}
		
		if (x == 0 && y == 0) {
			return true;
		}
		
		boolean success = false;
		if (x>=1 && isFree(x-1,y)) {
			success = getPath(x-1, y, path, cache);
		}
		if (!success && y>=1 && isFree(x, y-1)) {
			success = getPath(x, y-1, path, cache);
		}
		if (!success) {
			path.remove(p);
		}
		cache.put(p, success);
		return success;
		
		
		
	}

}
