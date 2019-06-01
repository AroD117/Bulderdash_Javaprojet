package entity;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

public class Rock extends Mobile {

	public Rock(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		sprite.loadImage();
		// TODO Auto-generated constructor stub
	}

	private static  final Sprite sprite = new Sprite('C',  Sprite,new Rectangle (48, 0, 16, 16));
	
	

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		super.moveDown();
	}



	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		super.moveRight();
	}



	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		super.moveLeft();
	}



	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		super.doNothing();
	}
	

	@Override
	public boolean entityAllowsmovementTo(UserOrder choice) {
		Point choicePosition = null;
		switch (choice) {
		case Up : 
			choicePosition = new Point(this.getX(), this.getY()-1);
			break;
		case Down : 
			choicePosition = new Point(this.getX(), this.getY()+1);
			break;
		case Right : 
			choicePosition = new Point(this.getX()+1, this.getY());
			break;
		case Left : 
			choicePosition = new Point(this.getX()-1, this.getY());
			break;
		case None : 
			default : 
				return true;
		
		}
		if (this.getMap().getCharacter().getPosition().equals(choicePosition)) {
			return false;
		}
		else {
			return super.entityAllowsmevementTo(choice);
		}
	}
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
