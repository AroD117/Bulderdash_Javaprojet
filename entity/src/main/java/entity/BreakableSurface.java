package entity;

public class BreakableSurface extends MotionLess{
	
	//Sprite for breakable surface for each map
	//private static final Sprite sprite1 = new Sprite('b', imageName)
	//private static final Sprite sprite2 = new Sprite('h', imageName)
	//private static final Sprite sprite3 = new Sprite('i', imageName)
	//private static final Sprite sprite4 = new Sprite('p', imageName)
	//private static final Sprite sprite5 = new Sprite('u', imageName)
	
	//Default constructor
	public BreakableSurface() {
		super(sprite+num, Permeability.MINEABLE);
	}

}