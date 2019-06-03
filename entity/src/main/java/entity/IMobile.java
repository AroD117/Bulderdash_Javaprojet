package entity;


import java.awt.Point;
import java.io.IOException;
import contract.IEntity;



public interface IMobile extends IEntity {
 public int getX();
 public int getY();
 public void setX(int x);
 public void setY(int y);
 public void moveUp();
 public void moveDown();
 public void moveLeft();
 public void moveRight();
 public void doNothing();
 public void die();
 public Point getPosition();
 public void setPosition(Point position);
 public boolean isAlive();
 public boolean isCrashed();
 public void setHasMoved();
 public boolean canMove(UserOrder choice); 
 public void remove();
 public Point getPositionFromUserOrder (UserOrder choice);
 public boolean isFalling();
 public void digg();
}

