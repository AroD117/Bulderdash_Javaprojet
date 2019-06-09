package entity;

import java.awt.Image;

// salut
public class BreakableSurface extends MotionLess{

	private static final Sprite sprite1 = new Sprite('b', "surface1.png");
	
	//Sprite for breakable surface for each map
	//private static final Sprite sprite2 = new Sprite('h', imageName)
	//private static final Sprite sprite3 = new Sprite('i', imageName)
	//private static final Sprite sprite4 = new Sprite('p', imageName)
	//private static final Sprite sprite5 = new Sprite('u', imageName)
	
	//Default constructor
	public BreakableSurface() {
		super(sprite1 ,Permeability.MINEABLE);
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