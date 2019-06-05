package view;
//salut
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import entity.Entity;
import entity.Map;
import entity.Mobile;
import entity.UserOrder;
import entity.IUserOrder;


public class Mainview implements Runnable, KeyListener {
	
	/** The Constant mapView. */
	private static final int MapView   = 50;

	/** The Constant squareSize. */
	private static final int squareSize = 50;

	/** The Constant closeView. */
	private Rectangle      closeView;

	/** The Map. */
	private Map    Map;

	/** Les Mobiles. */
	private Mobile    TheCharacter;
	
	private ArrayList<Mobile> mEntity;
	
	public static Map m;

	public ArrayList<Mobile> getEntity() {
		return mEntity;
	}


	public void setEntity(ArrayList<Mobile> entity) {
		mEntity = entity;
	}

	/** The view. */
	private int            view;


	private IUserOrder  orderPerformer;
	private  BoardFrame boardFrame;


	public Mainview(final Map Map, final Mobile TheCharacter, Mobile Boulder, Mobile Diamond, Mobile Ennemy) throws IOException {
	
		this.setMap(Map);
		this.setTheCharacter(TheCharacter);
		this.getTheCharacter().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getTheCharacter().getY(), m.getWidth(), m.getHeight()));
		SwingUtilities.invokeLater(this);
	}


	public void setMap(Map map) {
		Map = map;
	}


	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}


	@Override
	public final void run() {
		boardFrame = new BoardFrame("Close view");
		boardFrame.setDimension(new Dimension(m.getWidth(), m.getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.setHeightLooped(true);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);
		this.getMap();
		for (int x = 0; x < m.getWidth(); x++) {
			for (int y = 0; y < m.getHeight(); y++) {
				boardFrame.addSquare(this.Map.getOnTheMapXY(x, y), x, y);
			}
		}

		boardFrame.addPawn(this.getTheCharacter());
		for(Mobile Entities: mEntity) {
			boardFrame.addPawn(Entities);
		}
		

		this.getMap().getObservable().addObserver(boardFrame.getObserver());

		boardFrame.setVisible(true);
	}

	/**
	 * Prints the map and the player's character in the console.
	 *
	 * @param yStart
	 *            the y start
	 */
	public final void show(final int yStart) {
		this.getMap();
		int y = yStart % m.getHeight();
		for (int view = 0; view < this.getView(); view++) {
			this.getMap();
			for (int x = 0; x < m.getWidth(); x++) {
				if ((x == this.getTheCharacter().getX()) && (y == yStart)) {
					System.out.print(this.getTheCharacter().getSprite().getConsoleImage());
				} else {
					System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
				}
			}
			this.getMap();
			y = (y + 1) % m.getHeight();
			System.out.print("\n");
		}
	}

	/**
	 * Key code to user order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */



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
	public final void keyPressed(final KeyEvent keyEvent) {
		this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
	}

	private UserOrder keyCodeToUserOrder(int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}
	
	public void removeFromBoard(Entity en) {
		en = null;
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
	private Map getMap() {
		return this.Map;
	}

	/**
	 * Gets my character.
	 *
	 * @return my character
	 */
	private Mobile getTheCharacter() {
		return this.TheCharacter;
	}

	/**
	 * Sets my character.
	 *
	 * @param mycharacter
	 *            my new character
	 */
	private void setTheCharacter(final Mobile TheCharacter) {
		this.TheCharacter = TheCharacter;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private int getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the new view
	 */
	private void setView (final int view) {
		this.view = view;
	}


	/**
	 * Sets the close view.
	 *
	 * @param closeView
	 *            the new close view
	 */
	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	private IUserOrder getOrderPerformer() {
		return this.orderPerformer;
	}



	/**
	 * Sets the order performer.
	 * @param orderPerformer 
	 *
	 * @param orderPerformer
	 *            the new order performer
	 */
	public final void setOrderPerformer(final IUserOrder orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	public void updateBoard() {
		for(int x=0;x<Map.getWidth();x++) {
			for(int y=0;y<Map.getHeight();y++) {
				boardFrame.addSquare(this.Map.getOnTheMapXY(x, y),x,y);
			}
		}
	}
	
}




