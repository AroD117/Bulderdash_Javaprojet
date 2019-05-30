package entity;

public class Wall extends MotionLess{
	
	//Sprite for wall for each map
	//private static final Sprite sprite1 = new Sprite('a', imageName)
	//private static final Sprite sprite2 = new Sprite('g', imageName)
	//private static final Sprite sprite3 = new Sprite('k', imageName)
	//private static final Sprite sprite4 = new Sprite('g', imageName)
	//private static final Sprite sprite5 = new Sprite('t', imageName)
	
	//Default constructor
	public Wall() {
		super(sprite/*n°map*/, Permability.BLOCKING);
	}

}
