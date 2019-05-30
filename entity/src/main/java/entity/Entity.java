package entity;

import contract.IEntity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity implements IEntity{
	//Sprite
	private Sprite sprite;
	
	//Permability
	private Permability permability;
	
	//Default constructor
	public Entity(final Sprite sprite, final Permability permability) {
		this.setSprite(sprite);
		this.setPermability(permability);
	}
	
	//Getter for sprite
	public Sprite getSprite() {
		return sprite;
	}
	
	//Setter for sprite
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	//Getter for permability
	public Permability getPermability() {
		return permability;
	}
	
	//Setter for permability
	public void setPermability(Permability permability) {
		this.permability = permability;
	}
	
	

}
