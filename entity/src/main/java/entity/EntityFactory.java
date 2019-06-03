package entity;

public abstract class EntityFactory {
	
	//The wall
	private static final Wall wall = new Wall();
	
	//The breakable surface
	private static final BreakableSurface breakableSurface = new BreakableSurface();
	
	//The broken surface
	private static final BrokenSurface brokenSurface = new BrokenSurface();
	
	//The door
	private static final Door door = new Door();
	
	//An array of all different MotionLess used for get from char symbol.
	private static Entity[] entity = {
			wall,
			breakableSurface,
			brokenSurface,
			door
	};
	
	//Create new wall
	public static Entity createWall() {
		return wall;
	}
	
	//Create new breakable surface
	public static Entity createBreakableSurface() {
		return breakableSurface;
	}
	
	//Create new broken surface
	public static Entity createBrokenSurface() {
		return brokenSurface;
	}
	
	//Create new door
	public static Entity createDoor() {
		return door;
	}
	
	public static Entity getFromFileSymbol(final char fileSymbol) {
		for (final Entity motionlessElement : entity) {
			if(motionlessElement.getSprite().getConsoleImage()==fileSymbol) {
				return motionlessElement;
			}
		}
		return brokenSurface;
	}

}
