package entity;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import entity.IMap;

import entity.Permeability;
import entity.Sprite;
import entity.Map;
//salut

public class Character extends Mobile{
	private static final Sprite sprite = new Sprite('C', "Perso_orange.png");

	public Character(int x, int y, IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.BLOCKING);
	}
	
	public void setMap(Map map) {
		this.getMap().setMyCharacter(this);
	}

	public void moveUp() {
		super.digg();
		super.moveUp();
	}
	public void moveDown() {
		super.digg();
		super.moveDown();
	}
	public void moveRight() {
		super.digg();
		super.moveRight();
	}

	public void moveLeft() {
		super.digg();
		super.moveLeft();
	}
	public void doNothing() {
		super.doNothing();
		this.setSprite(sprite);
	}

	public boolean isCrashed() {
		// TODO Auto-generated method stub
		return super.isCrashed();
	}

	public Boolean entityAllowsMovementTo(final UserOrder choice) {
		Boolean push = false;
		switch (choice) {
		case RIGHT:
			push = this.getMap().getOnTheMapXY(getX() + 2, getY()).getPermeability() == Permeability.PENETRABLE;
			if (push) {
				for (IMobile pawns : this.getMap().getPawns()) {
					if (pawns.getPosition().x == getX() + 2 && pawns.getPosition().y == getY()
							&& pawns.getPermeability() != Permeability.PENETRABLE) {
						push = false;
						break;
					}
				}
			}
			break;
		case LEFT:
			push = this.getMap().getOnTheMapXY(getX() - 2, getY()).getPermeability() == Permeability.PENETRABLE;
			if (push) {
				for (IMobile pawns : this.getMap().getPawns()) {
					if (pawns.getPosition().x == getX() - 2 && pawns.getPosition().y == getY()
							&& pawns.getPermeability() != Permeability.PENETRABLE) {
						push = false;
						break;
					}
				}
			}
			break;
		case NOP:
		default:
			break;
		}


		final Point choicePosition = this.getPositionFromUserOrder(choice);
		for (IMobile pawns : this.getMap().getPawns()) {
			if (pawns.getPosition().equals(choicePosition)) {
				if (pawns.getPermeability() == Permeability.BLOCKING) {
					if (push) {
						if (choice == UserOrder.RIGHT)
							pawns.moveRight();
						else
							pawns.moveLeft();
						return true;
					} else {

						return false;
					}

				} else if (pawns.getPermeability() == Permeability.MINEABLE) {
					// Player stepped on a diamond

					pawns.remove();
					this.getMap().decreaseDiamondCount();

					return true;
				}
			}
		}
		return true;
	}


	public boolean mapAllowsMovementTo(final UserOrder choice) {
		switch (choice) {
		case UP : 
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() != Permeability.BLOCKING;
		case DOWN : 
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() != Permeability.BLOCKING;
		case RIGHT : 
			return this.getMap().getOnTheMapXY(this.getX()+1, this.getY()).getPermeability() != Permeability.BLOCKING;
		case LEFT : 
			return this.getMap().getOnTheMapXY(this.getX()-1, this.getY()).getPermeability() != Permeability.BLOCKING;
		case NOP:
		default:
			return true;
		}
	}


	public boolean canMove(final UserOrder choice) {
		// TODO Auto-generated method stub
		return this.entityAllowsMovementTo(choice) && this.mapAllowsMovementTo(choice);
	}


	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub

	}
	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}
	@Override
	public void setHasMoved() {
		// TODO Auto-generated method stub

	}
	@Override
	public Point getPositionFromUserOrder(UserOrder choice) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Permeability getPermeability1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}


}