package entity;
//salut
import java.awt.Image;

public class Wall extends MotionLess{
	
	//Sprite for wall for each map

	private static final Sprite sprite = new Sprite('a', "Mur1.png");
	
	
	//Default constructor
	public Wall() {
		super(sprite, Permeability.BLOCKING);
	}
	@Override
	public Permeability getPermeability() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Permeability getPermeability1() {
		// TODO Auto-generated method stub
		return null;
	}

}