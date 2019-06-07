package entity;

import java.awt.Image;

//salut

public class BrokenSurface extends MotionLess{
	
	private static final String imageName ="surface2.png";
	private static final Sprite sprite1 = new Sprite('f', imageName);
	
	//Sprite for broken surface
	//private static final Sprite sprite = new Sprite('f', imageName)
	
	
	//Default constructor
	public BrokenSurface() {
		super(sprite1, Permeability.PENETRABLE);
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