package org.qgeff.exo.tondeuse_xebia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MowItNow {
	private static Logger logger = LoggerFactory.getLogger(MowItNow.class);

	private Grid grid;

	public MowItNow() {
	}

	public MowItNow(Grid grid) {
		super();
		this.grid = grid;
	}

	public String run(String actions) {
		logger.trace("Mow it now !");
		logger.trace(grid.toString());
		for (int i = 0; i < actions.length(); i++) {
			logger.trace("Turn - {}",i);
			
			String action = String.valueOf(actions.charAt(i));
			logger.trace(action);
			switch (action) {
			case "D":
				this.grid.getMower().right();
				break;
			case "G":
				this.grid.getMower().left();
				break;
			case "A":
				forward();
				break;
			default:
				break;
			}

			logger.trace("Grid state :");
			logger.trace(grid.toString());
		}
		
		logger.trace("Fin :");
		logger.trace(grid.getMower().toString());
		return grid.getMower().toString();
	}

	public void forward() {
		Mower mower = grid.getMower();
		switch (mower.getDirection().getCurrent()) {
		case Direction.NORTH:
			mower.setY((mower.getY().equals(grid.getMaxY()) ? mower.getY() : mower.getY() + 1));
			break;
		case Direction.EAST:
			mower.setX((mower.getX().equals(grid.getMaxX()) ? mower.getX() : mower.getX() + 1));
			break;
		case Direction.SOUTH:
			mower.setY((mower.getY().equals(grid.getMinY()) ? mower.getY() : mower.getY() - 1));
			break;
		case Direction.WEST:
			mower.setX((mower.getX().equals(grid.getMinX()) ? mower.getX() : mower.getX() - 1));
			break;
		default:
			break;
		}
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

}
