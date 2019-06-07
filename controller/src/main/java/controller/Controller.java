package controller;



import entity.UserOrder;

import contract.IController;

import contract.IModel;

import contract.IView;



/**

 * The Class Controller.

 */

public final class Controller implements IController {



	private UserOrder order = UserOrder.NOP;



	private int x, y;



	public IView getView() {

		return view;

	}

	/** The view. **/

	private IView view;



	/** The model. */

	private IModel	model;




	/**

	 * Instantiates a new controller.

	 *

	 * @param view

	 *          the view

	 * @param model

	 *          the model

	 */

	public Controller(final IView view, final IModel model) {

		super();

		this.setView(view);

		this.setModel(model);

	}





	/**
	 * Sets the view.
	 *
	 * @param pview
	 *            the new view
	 */
	
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *            the controller order
	 * @throws InterruptedException 
	 */

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	@Override
	public void orderPerform(final UserOrder userorder) throws InterruptedException {

		this.setOrder(userorder);

		if(this.getModel().getCharacter().canMove(this.getOrder())) {
			switch(this.getOrder()) {
			case RIGHT:
				this.getModel().getCharacter().moveRight();
				break;
			case LEFT:
				this.getModel().getCharacter().moveLeft();
				break;

			case UP:

				this.getModel().getCharacter().moveUp();

				break;

			case DOWN:

				this.getModel().getCharacter().moveDown();

				break;

			default:

				this.getModel().getCharacter().doNothing();

				break;

			}

			

			this.getView().updateBoard();



		}

	}







	public final void play() throws InterruptedException{



		this.getModel().getMap().setMyCharacter(this.getModel().getCharacter());



		while(this.getModel().getCharacter().isAlive()) {


			if(this.getModel().getCharacter().canMove(this.getOrder())) {

				switch(this.getOrder()) {

				case RIGHT:

					this.getModel().getCharacter().moveRight();

					break;

				case LEFT:

					this.getModel().getCharacter().moveLeft();

					break;

				case UP:

					this.getModel().getCharacter().moveUp();

					break;

				case DOWN:

					this.getModel().getCharacter().moveDown();

					break;

				default:

					this.getModel().getCharacter().doNothing();

					break;

				}

			}



			x = this.getModel().getMap().getMyCharacter().getX();

			y = this.getModel().getMap().getMyCharacter().getY();



			
			this.clearOrder();



//			this.getView().updateBoard();



			if(this.getModel().getMap().getDiamondCount()==0) {

				this.getView().printMessage("Well Played");

				System.exit(0);

			}





		}



		this.getView().printMessage("You Loose");

		System.exit(0);



	}

	public UserOrder getOrder() {

		return order;

	}





	public void setOrder(UserOrder order) {

		this.order = order;

	}

	public IModel getModel() {

		return model;

	}





	@Override

	public void control() {



	}



	private void clearOrder() {

		this.order=UserOrder.NOP;

	}



}