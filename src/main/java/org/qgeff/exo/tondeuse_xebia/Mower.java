package org.qgeff.exo.tondeuse_xebia;

/**
 * @author QGd
 */
public class Mower {
	private Integer x;
	private Integer y;
	private Direction direction;
	
	public Mower() {
	}

	public Mower(Integer x, Integer y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public Mower(String[] split) {
		this.x = Integer.parseInt(split[0]);
		this.y = Integer.parseInt(split[1]);
		this.direction = new Direction(Direction.toInteger(split[2]));
	}

	public void right(){
		direction.right();
	}
	
	public void left(){
		direction.left();
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	} 

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(x);
		builder.append(" ");
		builder.append(y);
		builder.append(" ");
		builder.append(direction);
		return builder.toString();
	}
}
