package entity;

import java.awt.Point;
import fr.exia.insanevehicles.model.IMap;
import fr.exia.insanevehicles.model.IRoad;
import fr.exia.insanevehicles.model.element.Permeability;
import fr.exia.insanevehicles.model.element.Sprite;

	public abstract class Mobile extends Entity implements IMobile{
		
		/* The points x and y */
	    private Point position;

	    /* The alive */
	    private Boolean alive = true;
	    
	    /* The map */
	    private IMap map;
	    
	    /**
	     * Instantiates a new mobile.
	     *
	     * @param sprite
	     *            the sprite
	     * @param road
	     *            the road
	     * @param permeability
	     *            the permeability
	     */
	    
	    Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
			super(sprite, permeability);
			this.map = map;
			this.position = new Point();
		}
	    

	    /**
	     * Instantiates a new mobile.
	     *
	     * @param x
	     *            the x
	     * @param y
	     *            the y
	     * @param sprite
	     *            the sprite
	     * @param road
	     *            the road
	     * @param permeability
	     *            the permeability
	     */
	    Mobile(final int x, final int y, final Sprite sprite, final IRoad road, final Permeability permeability) {
	        this(sprite, road, permeability);
	        this.setX(x);
	        this.setY(y);
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
		
		public void DoNothing() {
			this.setHasMoved();
		}

		private  void SetHasMoved() {
			this.getMap().setMobileHasChanged();
		}
		
		public int GetX() {
			return this.getPosition().x;
		}
		
		public void SetX(int x) {
			this.getPosition().x = x;
	        if (this.isCrashed()) {
	            this.die();
		}
		
		public int GetY() {
			return this.getPosition().y;
		}
		
		public void SetY(int y) {
			   this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
		       if (this.isCrashed()) {
		       this.die();
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
			return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
		}
		
		public boolean isWon() {
			return true;
		}
		
		public boolean isBlocked() {
			return true;
		}
		
		public boolean isLootable() {
			return true;
		}
		
		/* public boolean isDesappear() {
			return true;
		}*/
		
		public Point getPosition() {
	        return this.position;
	    }
		
		public void setPosition(final Point position) {
	        this.position = position;
	    }
		
	}


}
