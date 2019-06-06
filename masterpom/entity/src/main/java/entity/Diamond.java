package entity;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

public class Diamond extends Mobile{

	//salut
/* The Sprite corresponding */
	
private static  final Sprite sprite = new Sprite('C', "Diamond");


/*private static final IStrategy strategy = new DiamondStrategy();*/

public Diamond(final int x, final int y, final IMap map) throws IOException {
 super(x, y, sprite, map, Permeability.MINEABLE);
 sprite.loadImage();}

 @Override
 public final void moveLeft() {
  super.moveLeft();
 }

 
 @Override
 public final void moveRight() {
  super.moveRight();
 }

 
 @Override
 public final void moveUp() {
  
 }

 
 @Override
 public final void moveDown() {
  super.moveDown();
 }

 
 @Override
public final void die() {
  
 }

 @Override
 public final void doNothing() {
  super.doNothing();
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
 
 
}