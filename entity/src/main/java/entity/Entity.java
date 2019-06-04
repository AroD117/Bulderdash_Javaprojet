package entity;

import entity.IEntity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity implements IEntity{
	//Sprite
	private Sprite sprite;
	
	//Permability
	private Permeability permability;
	
	//Default constructor
	public Entity(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermability(permeability);
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
	public Permeability getPermability() {
		return permability;
	}
	
	//Setter for permability
	public void setPermability(Permeability permability) {
		this.permability = permability;
	}
	
	

}
