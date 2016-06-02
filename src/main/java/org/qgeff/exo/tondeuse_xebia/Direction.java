package org.qgeff.exo.tondeuse_xebia;

/**
 * @author QGd
 * 
 */
public class Direction {
	public final static int NORTH = 0;
	public final static int EAST = 1;
	public final static int SOUTH = 2;
	public final static int WEST = 3;
	private Integer current;

	public Direction() {
	}
	
	public Direction(Integer current) {
		this.current = current;
	}
	
	public void right(){
		current = (current.equals(3)) ? 0 : current+1;
	}

	public void left(){
		current = (current.equals(0)) ? 3 : current-1;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public String toString() {
		return (current.equals(0)) ? "N" : 
					(current.equals(1)) ? "E" : 
						(current.equals(2)) ? "S" : 
							(current.equals(3)) ? "W" : "Error";
	}
	
	public static Integer toInteger(String direction) {
		return (direction.equals("N")) ? 0 :
					(direction.equals("E")) ? 1 :
						(direction.equals("S")) ? 2 :
							(direction.equals("W")) ? 3 : -1;
	}
	
}
