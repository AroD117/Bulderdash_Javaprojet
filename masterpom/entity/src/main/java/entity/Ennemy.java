package entity;

import java.awt.Rectangle;
import entity.IMap;
import entity.PERMEABILITY;
import entity.Sprite;

public class Ennemy extends Mobile {

	private static final Sprite sprite = new Sprite('M', Sprite.world, new Rectangle (144, 0, 16, 16));

	public Ennemy(int x, int y, IMap map) {
		super(x, y, sprite, map, PERMEABILITY.BLOCKING);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
