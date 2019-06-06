package entity;
//salut
/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IUserOrder{

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(UserOrder userOrder);
}