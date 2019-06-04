package controller;
import java.io.IOException;

import contract.IModel;
import contract.IView;
import entity.UserOrder;


/**
 * <h1>The Class ControllerFacade provides the code of the Controller
 * component.</h1>
 * 
 * 
 * @author Tejesh Tailor
 * @version 1.0
 */
public class Controller implements IOrderPerformer, IBoulderDashController {

  /** The view. */
  private final IView view;

  /** The model. */
  private final IModel model;

  /** The Constant speed of Character. */
  private static final int speed = 200;

  /** The stack order. */
  private UserOrder stackOrder = UserOrder.NOP;

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
    this.view = view;
    this.model = model;
  }

  /**
   * Start.
   * 
   * @throws InterruptedException
   */
  public void start() throws InterruptedException {
    this.getModel().getMap().setMyCharacter(this.getModel().getMyCharacter());
    while (this.getModel().getMyCharacter().isAlive()) {
      Thread.sleep(speed);
      
      if (this.getModel().getMyCharacter().canMove(this.getStackOrder())) {
        switch (this.getStackOrder()) {
        case RIGHT:
          this.getModel().getMyCharacter().moveRight();
          break;
        case LEFT:
          this.getModel().getMyCharacter().moveLeft();
          break;
        case DOWN:
          this.getModel().getMyCharacter().moveDown();
          break;
        case UP:
          this.getModel().getMyCharacter().moveUp();
          break;
        case NOP:
        default:
          this.getModel().getMyCharacter().doNothing();
          break;
        }  
      }
      this.getModel().movePawns();
      this.clearStackOrder();

      this.getView().followMyCharacter();
      this.getView().updateBoardFrame();

      if (this.getModel().getMap().getDiamondCount() == 0) {
        this.getView().displayMessage("You won !! Congratulations ;) ");
        System.exit(0);
      }
    }
    this.getView().displayMessage("You are dead, GAME OVER. ");
    System.exit(0);
  }

  /**
   * Gets the view.
   *
   * @return the view
   */
  private IView getView() {
    return this.view;
  }

  /**
   * Gets the model.
   *
   * @return the model
   */
  private IModel getModel() {
    return this.model;
  }

  public IOrderPerformer getOrderPeformer() {
    return this;
  }
  
/*
 * (non-Javadoc)
 * @see 
 * controller.IOrderPerformer#orderPerform(controller.UserOrder)
 * 
 */
  
  public final void orderPerform(final UserOrder userOrder) throws IOException {
    this.setStackOrder(userOrder);
  }

  private UserOrder getStackOrder() {
    return this.stackOrder;
  }

  private void setStackOrder(UserOrder newOrder) {
    this.stackOrder = newOrder;
  }

  /**
   * Sets the stack to NOP.
   */
  private void clearStackOrder() {
    this.stackOrder = UserOrder.NOP;
  }
}