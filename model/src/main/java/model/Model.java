package model;
import java.io.IOException;
import java.sql.SQLException;
//salut
import java.util.Observable;
import contract.IModel;
import entity.IMap;
import entity.IMobile;
import entity.Map;
import entity.Mobile;
import entity.Character;
import entity.IEntity;

/*
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private IMap map;
	private IMobile character;
	private DAOMap dao;

	public IMobile getCharacter() {
		return character;
	}

	public void setCharacter(IMobile character2) {
		this.character = character2;
	}

	/*
	 * Instantiates a new model.
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	public Model() throws SQLException, IOException { 
		super();
		this.setMap(DAOMap.find(1));
		this.setCharacter(new Character(2, 2, this.map));
	}

	/*
     * Gets the hello world.
     *
     * @return the hello world
     */
	
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}



	@Override
	public IMap getMap() {
		// TODO Auto-generated method stub
		return this.map;
	}

}