package contract;
import java.awt.Image;
import entity.Permeability;
import entity.Sprite; 

public interface IEntity {

	//Gets the sprite
		Sprite getSprite();
		
		//Gets the permability
		Permeability getPermability();
		
		//Get the image
		Image getImage();
		
}
