package org.qgeff.exo.tondeuse_xebia;

/**
 * @author QGd
 * 
 */
public enum Direction {
	NORTH("n"), EAST("e"), SOUTH("s"), WEST("w");

	private String name = "";

	Direction(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
