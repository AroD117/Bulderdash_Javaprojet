package contract;

import java.util.Observable;

import entity.Permability;

public interface IMap {
	
	//Gets Width
	public int getWidth();
	
	//Gets Height
	public int getHeight();
	
	//Gets the x and the y
	public IEntity getOnTheMapXY(int x, int y);
	
	//Sets the x and the y
	public void setOnTheMapXY(int x, int y, IEntity entity);
	
	//Notifies a changement
	public void setMobileHasChanged();
	
	//Gets the Observable
	public Observable getObservable();
	
	//Decrements the diamounds count
	public void decreaseDiamoundsCount();
	
	//Increments the diamounds count
	public void addDiamoundsCount();
	
	//Gets the diamounds count
	public int getDiamoudsCount();
	
	//Gets the character
	public void setCharacter(IMobile character);
	
	public Permability getSquareIsOccupiedXY(final int x, final int y);
}
