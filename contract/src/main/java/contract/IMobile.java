package contract;

public interface IMobile extends IEntity, IPawn{
	
	//Move up
	void moveUp();
	
	//Move left
	void moveLeft();
	
	//Move right
	void moveRight();
	
	//MoveDown
	void moveDown();
	
	//Do nothing 
	void doNothing();
	
	//Gets the x
	int getX();
	
	//Gets the y
	int getY();
	
	//Verify if the character is alive
	boolean isAlive();
	
	//Verify if the character is die
	boolean isDie();
	
	//The rock is falling
	public boolean isFalling();
	
}
