package org.qgeff.exo.tondeuse_xebia;

public class Grid {
	private Integer maxX;
	private Integer maxY;
	private Integer minX = 0;
	private Integer minY = 0;
	private Mower mower;

	public Grid(Integer maxX, Integer maxY, Mower mower) {
		super();
		this.maxX = maxX;
		this.maxY = maxY;
		this.mower = mower;
	}

	public Integer getMaxX() {
		return maxX;
	}

	public void setMaxX(Integer maxX) {
		this.maxX = maxX;
	}

	public Integer getMaxY() {
		return maxY;
	}

	public void setMaxY(Integer maxY) {
		this.maxY = maxY;
	}

	public Integer getMinX() {
		return minX;
	}

	public void setMinX(Integer minX) {
		this.minX = minX;
	}

	public Integer getMinY() {
		return minY;
	}

	public void setMinY(Integer minY) {
		this.minY = minY;
	}

	public Mower getMower() {
		return mower;
	}

	public void setMower(Mower mower) {
		this.mower = mower;
	}

	@Override
	public String toString() {
		StringBuffer strBuf = new StringBuffer();

		for (int i = maxY; i >= minY; i--) {
			strBuf.append("\n");
			for (int j = minX; j <= maxX; j++) {
				if (i == mower.getY().intValue() && j == mower.getX().intValue()) {
					strBuf.append(" " + mower.getDirection().toString() + " ");
				} else {
					strBuf.append(" _ ");
				}
			}
		}

		return strBuf.toString();
	}

}
