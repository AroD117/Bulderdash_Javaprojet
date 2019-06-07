package view;



import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.io.IOException;

import java.util.ArrayList;



import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;



import contract.IController;

import contract.IView;

import entity.*;





public class View implements Runnable, KeyListener, IView {

	

	/** The Constant squareSize. */

	private static final int squareSize = 50;



	/** The Constant closeView. */

	private Rectangle      window = null;



	/** The Map. */

	private IMap            map = null;



	/** Les Mobiles. */

	private IMobile    TheCharacter = null;

	

	/**Mobile entities list*/

	private ArrayList<Mobile> mobileEntity = null;

	

	private IController  orderPerformer;

	private  BoardFrame boardFrame;



	public View(final IMap Map, final IMobile TheCharacter, ArrayList<Mobile> mobileEntity) throws IOException {

	

		this.setMap(Map);

		this.setTheCharacter(TheCharacter);

		this.getTheCharacter().getSprite().loadImage();

		this.setEntity(mobileEntity);

		this.setWindow(new Rectangle(0, 0, Map.getWidth(), Map.getHeight()));

		SwingUtilities.invokeLater(this);

	}



	public void setMap(IMap map) throws IOException {

        this.map = map;

        for (int x = 0; x < map.getWidth(); x++) {

            for(int y = 0; y < map.getHeight(); y++) {

                this.getMap().getOnTheMapXY1(x, y).getSprite().loadImage();

            }

        }

    }



	public final void displayMessage(final String message) {

		JOptionPane.showMessageDialog(null, message);

	}



	@Override

	public final void run() {

		boardFrame = new BoardFrame("Мохамeд");

		boardFrame.setDimension(new Dimension(map.getWidth(), map.getHeight()));

		boardFrame.setDisplayFrame(this.window);

		boardFrame.setSize(this.window.width * squareSize, this.window.height * squareSize);

		boardFrame.setLocationRelativeTo(null);

		boardFrame.setHeightLooped(true);

		boardFrame.addKeyListener(this);

		boardFrame.setFocusable(true);

		boardFrame.setFocusTraversalKeysEnabled(false);



	for (int x = 0; x < map.getWidth(); x++) {

			for (int y = 0; y < map.getHeight(); y++) {

				boardFrame.addSquare(this.getMap().getOnTheMapXY1(x, y), x, y);

			}

		}

		

		boardFrame.addPawn(this.getTheCharacter());

		

		for(Mobile Entities: mobileEntity) {

			boardFrame.addPawn(Entities);

		}

		

		this.getMap().getObservable().addObserver(boardFrame.getObserver());



		boardFrame.setVisible(true);

	}



	/*

	 * (non-Javadoc)

	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)

	 */

	@Override

	public void keyTyped(final KeyEvent keyEvent) {

		// Nop

	}



	/*

	 * (non-Javadoc)

	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)

	 */

	@Override

	public  void keyPressed(final KeyEvent keyEvent) {

		try {

			this.getOrderPerformer().orderPerform(View.keyCodeToUserOrder(keyEvent.getKeyCode()));

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}



	protected static UserOrder keyCodeToUserOrder(int keyCode) {

		

		switch (keyCode) {

		case KeyEvent.VK_RIGHT:

			return UserOrder.RIGHT;

			

		case KeyEvent.VK_LEFT:

			return UserOrder.LEFT;

			

		case KeyEvent.VK_DOWN:

			return UserOrder.DOWN;

			

		case KeyEvent.VK_UP:

			return UserOrder.UP;

			

		default:

			return UserOrder.NOP;

		}

	}



	/*

	 * (non-Javadoc)

	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)

	 */

	@Override

	public void keyReleased(final KeyEvent keyEvent) {

		// None

	}



	/**

	 * Gets the map.

	 *

	 * @return the map

	 */

	private IMap getMap() {

		return map;

	}





	/**

	 * Gets my character.

	 *

	 * @return my character

	 */

	private IMobile getTheCharacter() {

		return this.TheCharacter;

	}



	private void setTheCharacter(final IMobile TheCharacter) {

		this.TheCharacter = TheCharacter;

	}





	/**

	 * Sets the close view.

	 *

	 * @param closeView

	 *            the new close view

	 */

	private void setWindow(final Rectangle window) {

		this.window = window;

	}



	/**

	 * Gets the order performer.

	 *

	 * @return the order performer

	 */

	private IController getOrderPerformer() {

		return this.orderPerformer;

	}



	/**

	 * Sets the order performer.

	 *

	 * @param orderPerformer

	 *            the new order performer

	 */

	public final void setOrderPerformer(final IController orderPerformer) {

		this.orderPerformer = orderPerformer;

	}





	@Override

	public void printMessage(String message) {

		JOptionPane.showMessageDialog(null, message);

	}



	public ArrayList<Mobile> getEntity() {

		return mobileEntity;

	}



	public void setEntity(ArrayList<Mobile> entity) {

		mobileEntity = entity;

	}



	public void updateBoard() {

		for (int x = 0; x < map.getWidth(); x++) {

			for (int y = 0; y< map.getHeight(); y++) {

				boardFrame.addSquare(this.map.getOnTheMapXY1(x, y), x, y);

			}

		}



		}

}

