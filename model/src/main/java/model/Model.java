package model;
//salut
import java.util.Observable;
import contract.IModel;
import entity.IMobile;
import entity.Map;

/*
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private Map map;

	/*
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = new Map(0, null, null);
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
	public Map getHelloWorld() {
		return this.map;
	}

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
	public IMobile getMyCharacter() {
		// TODO Auto-generated method stub
		return null;
	}

}
