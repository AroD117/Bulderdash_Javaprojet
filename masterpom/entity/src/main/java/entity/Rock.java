package entity;
import java.awt.Image;
//salut
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

public class Rock extends Mobile {

public Rock(final int x, final int y, final IMap map) throws IOException {
 super(x, y, sprite, map, Permeability.BLOCKING);
 sprite.loadImage();
 // TODO Auto-generated constructor stub
}

private static  final Sprite sprite = new Sprite('c', "rock1.png");


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
public Boolean entityAllowsMovementTo(UserOrder choice) {
 Point choicePosition = null;
 switch (choice) {
 case UP : 
  choicePosition = new Point(this.getX(), this.getY()-1);
  break;
 case DOWN : 
  choicePosition = new Point(this.getX(), this.getY()+1);
  break;
 case RIGHT : 
  choicePosition = new Point(this.getX()+1, this.getY());
  break;
 case LEFT : 
  choicePosition = new Point(this.getX()-1, this.getY());
  break;
 case NOP : 
  default : 
   return true;
 
 }
 if (this.getMap().getMyCharacter().getPosition().equals(choicePosition)) {
  return false;
 }
 else {
  return super.entityAllowsMovementTo(choice);
 }
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
public void die() {
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
}