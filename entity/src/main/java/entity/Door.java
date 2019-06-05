package entity;
//salut
public class Door extends MotionLess{
	
	//Open door
	//private static final Sprite sprite = new Sprite('a def', imageName)
	
	//Close door
	//private static final Sprite sprite = new Sprite('a def', imageName)
	
	//Number of diamounds
	Diamond diamond;
	
	//Change the 
	if (diamond.getDiamoudsCount()==12) {
		//private static final Sprite sprite = new Sprite('a def', imageName)
	} else {
		//private static final Sprite sprite = new Sprite('a def', imageName)
	}
	
	//Default constructor
	public Door() {
		super(sprite, Permeability.PENETRABLE);
	}
	
	//Verify if the door is open or close 
	public boolean state() {
		if(diamond.getDiamoudsCount()==12){
			return true;
		}else {
			return false;
		}
	}

}
