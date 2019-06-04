package entity;

import java.awt.Point;
import java.io.IOException;

import entity.IMap;


public abstract class Mobile extends Entity implements IMobile{
    private Point position;
    private Boolean alive = true;
    private IMap map;
    private Boolean fall = false;
    
public Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
  super(sprite, permeability);
  this.map = map;
  this.position = new Point();
 }

public Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        this.getPosition().x=x;
        this.getPosition().y=y;
        
    }
    
public int GetX() {
 return this.getPosition().x;
}

public void SetX(int x) {
 this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
}

public int GetY() {
 return this.getPosition().y;
}

public void SetY(int y) {
 this.getPosition().y = y;
    if (this.isCrashed()) {
    this.die();
    }
}
     
public void moveUp() {
 this.setY(this.getY() - 1);
 this.setHasMoved();

}
    
 public void moveDown() {
    this.setY(this.getY() + 1);
       this.setHasMoved();

}

 public void moveLeft() {
   this.setX(this.getX() - 1);
      this.setHasMoved();
 
}
   
 public void moveRight() {
  this.setX(this.getX() + 1);
        this.setHasMoved();
}
    
 public void doNothing() {
  this.setHasMoved();
 }

 public Point getPosition() {
        return position;
    }
 
 public void setPosition(final Point position) {
        this.position = position;
    }
 
 private  void SetHasMoved() {
  this.getMap().setMobileHasChanged();
 }
        
 public IMap getMap() {
        return this.map;
 }

 private void setMap(final IMap map) {
        this.map = map;
    }
 
 public boolean isAlive() {
   return this.alive;
 }
 
 
 public void Die() {
   this.alive = false;
      this.setHasMoved();
 }
 
 public boolean isCrashed() {
  for (IMobile mobEntity: this.getMap().getmobEntity()) {
   if (mobEntity.getSprite().getConsoleImage() == 'O' || mobEntity.getSprite().getConsoleImage() == 'V') {
    if (mobEntity.getPosition().x == this.getPosition().x && mobEntity.getPosition().y == this.getPosition().y - 1 && mobEntity.isFalling()) {
     return true;
    }
   }
  }
  return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
 }
 
 public void remove()  {
  this.setPosition(new Point(-1, 1));
  this.getMap().getmobEntity().remove(this);
  }
 
 public boolean canMove(UserOrder choice) {
  return this.mapAllowsMovementTo(choice)&&this.entityAllowsMovementTo(choice);
 }
 
 
 protected boolean mapAllowsMovementTo(final UserOrder choice) {
  switch (choice) {
  case UP:
   return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE;
  case DOWN:
   return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE;
  case RIGHT:
   return this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE;
  case LEFT:
   return this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE;
  case NOP:
  default:
   return true;
  }
 }
 
 
  protected Boolean entityAllowsMovementTo(final UserOrder choice) {
   Point choicePosition = this.getPositionFromUserOrder(choice);
   for (IMobile mobEntity : this.getMap().getmobEntity()) {
    if (mobEntity.getPosition().equals(choicePosition)) {
     if (mobEntity.getPermeability() != Permeability.PENETRABLE) {
      return false;
     } else {
      return true;
     }
    }
   }

   return true;
  }
  
  /*public Point getPositionFromUserOrder(final UserOrder direction){
   Point choicePosition = null;
   switch (Controller.choice) {
   case UP:
    choicePosition = new Point(this.getX(), this.getY() - 1);
    break;
   case DOWN:
    choicePosition = new Point(this.getX(), this.getY() + 1);
    break;
   case RIGHT:
    choicePosition = new Point(this.getX() + 1, this.getY());
    break;
   case LEFT:
    choicePosition = new Point(this.getX() - 1, this.getY());
    break;
   case NOP:
   default:
    choicePosition = new Point(this.getX(), this.getY());
    break;
   }
   
   return choicePosition;
  }*/
  
  public void digg() {
   this.getMap().setOnTheMapXY(this.getX(), this.getY(),EntityFactory.createBrokenSurface());
   try {
    this.getMap().getOnTheMapXY(getX(), getY()).getSprite().loadImage();
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
  
 public boolean isFalling() {
  return fall;
 }
}

