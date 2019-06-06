package contract;

import java.util.Observable;

import entity.IMap;
import entity.IMobile;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	//Gets the map
	public IMap getMap();

	//Gets the character
	public IMobile getMyCharacter();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}