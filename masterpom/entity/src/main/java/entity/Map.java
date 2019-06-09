package entity;
import java.awt.Image;
import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
//salut
/**
 * <h1>The Class Map provides a facade of the Model component.</h1>
 * @author Paul Combaldieu
 */
public class Map extends Observable implements IMap {

	/** The width */
	private int width;

	/** The height */
	private int height;

	/** The elements */
	private IEntity[][] map;

	/** The pawn list */
	private ArrayList<Mobile> pawns;

	/** The myCharacter */
	private IMobile myCharacter = null;

	/** The diamond count */
	private int diamondCount = 0;

	/**
	 * Default constructor.
	 * 
	 * @param newWidth
	 *          the new width
	 * @param newHeight
	 *          the new height
	 * @param newMap
	 *          the new map
	 * @throws SQLException
	 *           expection
	 */
	public Map(final int newWidth, final int newHeight, final IEntity[][] newMap) throws SQLException {
		super();
		this.map = newMap;
		this.width = newWidth;
		this.height = newHeight;
		this.pawns = new ArrayList<Mobile>();
	}


	public Map(int newWidth, Object object, Object newMap) {
		// TODO Auto-generated constructor stub
	}

	public void setMyCharacter(final IMobile newChara) {
		this.myCharacter = newChara;
	}

	public void decreaseDiamondCount() {
		this.diamondCount--;
	}

	public void addDiamondCount() {
		this.diamondCount++;
	}

	public int getDiamondCount() {
		return this.diamondCount;
	}

	/**
	 * @return the map in ASCII character
	 */
	@Override
	public final String toString() {
		String temp = new String();
		for (int y = 0; y < this.getHeight(); y++) {
			for (int x = 0; x < this.getWidth(); x++) {
				temp += map[x][y].getSprite().getConsoleImage();
			}
			temp += '\n';
		}
		return temp;
	}

	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	public IEntity getOnTheMapXY(final int x, final int y) {
		if(x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight())
			return this.map[x][y];
		else
			return this.map[0][0];
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	public void setOnTheMapXY1(int x, int y, IEntity elem, int id) {
		this.map[x][y] = elem;
	}

	public void addPawn(Mobile pawn) {
		this.pawns.add(pawn);
	}

	public IMobile getMyCharacter() {
		return this.myCharacter;
	}

	public ArrayList<Mobile> getPawns() {
		return this.pawns;
	}

	/**
	 * Returns the permeability of an element on the map. Note that this will return
	 * the permeability of a pawn if one is there at the given coordonates.
	 * @param x
	 * @param y
	 * @return x and y
	 */
	@Override
	public Permeability getSquareIsOccupiedXY(final int x, final int y) {
		Point point = new Point(x, y);
		for(IMobile pawn : this.getPawns()) {
			if (pawn.getPosition().equals(point))
				return pawn.getPermeability();
		}

		if(this.getMyCharacter().getPosition().equals(point))
			return this.getMyCharacter().getPermeability();

		return this.getOnTheMapXY(x, y).getPermeability();
	}

	

	public void decreaseDiamoundsCount() {
		// TODO Auto-generated method stub

	}

	public void addDiamoundsCount() {
		// TODO Auto-generated method stub

	}

	public int getDiamoudsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCharacter(IMobile character) {
		// TODO Auto-generated method stub

	}

	

	public Permeability getPermability() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setOnTheMapXY(int x, int y, IEntity elem) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addPawn(IMobile pawn) {
		// TODO Auto-generated method stub
		
	}

	


	
}