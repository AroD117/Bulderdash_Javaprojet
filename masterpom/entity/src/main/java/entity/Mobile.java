package entity;

import java.awt.Point;


	public abstract class Mobile extends Entity implements IMobile{
	    private Point position;
	    private Boolean alive = true;
	    private IMap map;
	    
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
	
	public int GetY() {
		return this.getPosition().y;
	}
	
	public void SetY(int y) {
		this.getPosition().y = y;
	    if (this.isCrashed()) {
	    this.die();
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
				if (mobEntity.getSprite().getCharImage() == 'O' || mobEntity.getSprite().getCharImage() == 'V') {
					if (mobEntity.getPosition().x == this.getPosition().x	&& mobEntity.getPosition().y == this.getPosition().y - 1 && mEntity.isFalling()) {
						return true;
					}
				}
			}
			return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == PERMEABILITY.BLOCKING;
		}
		
		public void remove()  {
			this.setPosition(new Point(-1, 1));
			this.getMap().getmEntity().remove(this);
			}
		
		public boolean canMove(ControllerOrder choice) {
			return this.mapAllowsMvt(choice)&&this.entityAllowsmvt(choice);
		
		
		protected boolean mapAllowsMovementTo(final UserOrder direction) {
			switch (direction) {
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
		
		
			protected Boolean elementAllowsMovementTo(final UserOrder direction) {
				Point choicePosition = this.getPositionFromUserOrder(direction);
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
			
			protected Point getPositionFromUserOrder(final UserOrder direction){
				Point desiredPosition = null;
				switch (direction) {
				case UP:
					desiredPosition = new Point(this.getX(), this.getY() - 1);
					break;
				case DOWN:
					desiredPosition = new Point(this.getX(), this.getY() + 1);
					break;
				case RIGHT:
					desiredPosition = new Point(this.getX() + 1, this.getY());
					break;
				case LEFT:
					desiredPosition = new Point(this.getX() - 1, this.getY());
					break;
				case NOP:
				default:
					desiredPosition = new Point(this.getX(), this.getY());
					break;
				}
				
				return desiredPosition;
			}
			
			
	}



