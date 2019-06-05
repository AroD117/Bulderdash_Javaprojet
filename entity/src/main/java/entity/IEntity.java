package entity;
//salut
import java.awt.Image;
import entity.Permeability;
import entity.Sprite; 

public interface IEntity extends ISquare{

	//Gets the sprite
		Sprite getSprite();
		
		//Gets the permability
		Permeability getPermeability();
		
		//Get the image
		Image getImage();

		Permeability getPermeability1();
		
}
