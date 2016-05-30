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
		builder.append("Mower [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", direction=");
		builder.append(direction);
		builder.append("]");
		return builder.toString();
	}
}
