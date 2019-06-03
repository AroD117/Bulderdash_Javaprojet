package model;

import java.util.Observable;

import contract.IModel;
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

	/*
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setHelloWorld(final Map helloWorld) {
		this.map = helloWorld;
		this.setChanged();
		this.notifyObservers();
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
	public void loadHelloWorld(String code) {
		// TODO Auto-generated method stub
		
	}
}
