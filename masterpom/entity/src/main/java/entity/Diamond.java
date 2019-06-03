package entity;
import java.awt.Rectangle;

public class Diamond extends Mobile{

	/* The Sprite corresponding */
	
	private static final Sprite sprite = new Sprite('D', Sprite.mapTileSet, new Rectangle(0, 0, 16, 16));

	/*private static final IStrategy strategy = new DiamondStrategy();*/
	
	public Diamond(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.MINEABLE);
		sprite.loadImage();
	
		@Override
		public final void moveLeft() {
			super.moveLeft();
		}

		
		@Override
		public final void moveRight() {
			super.moveRight();
		}

		
		@Override
		public final void moveUp() {
			
		}

		
		@Override
		public final void moveDown() {
			super.moveDown();
		}

		
		@Override
		protected final void die() {
			
		}

		@Override
		public final void doNothing() {
			super.doNothing();
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
		
}
