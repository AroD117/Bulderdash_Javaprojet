package contract;

import java.awt.Image;

import entity.Permability;
import entity.Sprite;

public interface IEntity {
	
	//Gets the sprite
	Sprite getSprite();
	
	//Gets the permability
	Permability getPermability();
	
	//Get the image
	Image getImage();

}
