package entity;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import entity.IMap;

import entity.PERMEABILITY;
import entity.Sprite;
//salut

public class Character extends Mobile{
private static final Sprite sprite = new Sprite('C', Sprite.Character,new Rectangle (0, 0, 16, 16));
private static final Sprite spriteLeft = new Sprite('C', Sprite.Character, new Rectangle (0, 0, 16, 16));
private static final Sprite spriteRight = new Sprite('C', Sprite.Character,new Rectangle (0, 0, 16, 16));
private static final Sprite spriteDown = new Sprite('C', Sprite.Character, new Rectangle (0, 0, 16, 16));
private static final Sprite spriteUp = new Sprite('C', Sprite.Character, new Rectangle (0, 0, 16, 16));
private static final Sprite spriteDeath = new Sprite('C', Sprite.Character, new Rectangle (0, 0, 16, 16));


public Character(int x, int y, IMap map) throws IOException {
 super(x, y, sprite, map, Permeability.BLOCKING);
 spriteLeft.loadImage();
 spriteRight.loadImage();
 spriteDown.loadImage();
 spriteUp.loadImage();
 spriteDeath.loadImage();
}
public void moveUp() {
 super.digg();
 super.moveUp();
 this.setSprite(spriteUp); 
}
public void moveDown() {
 super.digg();
 super.moveDown();
 this.setSprite(spriteDown);
}
public void moveRight() {
 super.digg();
 super.moveRight();
 this.setSprite(spriteRight);
}

public void moveLeft() {
 super.digg();
 super.moveLeft();
 this.setSprite(spriteLeft);
}
public void doNothing() {
 super.doNothing();
 this.setSprite(sprite);
}
public void die() {
 // TODO Auto-generated method stub
 super.die();
 this.setSprite(spriteDeath);
}
public boolean isCrashed() {
 // TODO Auto-generated method stub
 return super.isCrashed();
}

public boolean entityAllowsMovementTo(final UserOrder choice) {
 Boolean push = false;
 switch (choice) {
 case Right:
  push = this.getMap().getOnTheMapXY(getX() + 2, getY()).getPermeability() == PERMEABILITY.PENETRABLE;
  if (push) {
   for (IMobile mobEntity : this.getMap().getmEntity()) {
    if (mobEntity.getPosition().x == getX() + 2 && mobEntity.getPosition().y == getY()
      && mobEntity.getPermeability() != PERMEABILITY.PENETRABLE) {
     push = false;
     break;
    }
   }
  }
  break;
 case Left:
  push = this.getMap().getOnTheMapXY(getX() - 2, getY()).getPermeability() == PERMEABILITY.PENETRABLE;
  if (push) {
   for (IMobile mEntity : this.getMap().getmobEntity()) {
    if (mobEntity.getPosition().x == getX() - 2 && mobEntity.getPosition().y == getY()
      && mobEntity.getPermeability() != PERMEABILITY.PENETRABLE) {
     push = false;
     break;
    }
   }
  }
  break;
 case None:
 default:
  break;
 }
 
 
 final Point choicePosition = this.getPositionAfterOrder(choice);
 for (IMobile mobEntity : this.getMap().getmobEntity()) {
  if (mobEntity.getPosition().equals(choicePosition)) {
   if (mobEntity.getPermeability() == PERMEABILITY.BLOCKING) {
    if (push) {
     if (choice == UserOrder.Right)
      mobEntity.moveRight();
     else
      mobEntity.moveLeft();
     return true;
    } else {

     return false;
    }

   } else if (mobEntity.getPermeability() == PERMEABILITY.MINEABLE) {
    // Player stepped on a diamond

    mobEntity.remove();
    this.getMap().decreaseDiamond();

    return true;
   }
  }
 }
 return true;
}


public boolean mapAllowsMovementTo(final UserOrder choice) {
 switch (choice) {
 case UP : 
  return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() != PERMEABILITY.BLOCKING;
 case Down : 
  return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() != PERMEABILITY.BLOCKING;
 case Right : 
  return this.getMap().getOnTheMapXY(this.getX()+1, this.getY()).getPermeability() != PERMEABILITY.BLOCKING;
 case Left : 
  return this.getMap().getOnTheMapXY(this.getX()-1, this.getY()).getPermeability() != PERMEABILITY.BLOCKING;
 case None:
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


}

