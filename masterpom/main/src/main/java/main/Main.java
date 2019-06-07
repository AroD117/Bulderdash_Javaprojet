/**

 * @author Jean-Aymeric DIET jadiet@cesi.fr

 * @version 1.0

 */

package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import model.Model;
import view.View;

/**

 * The Class Main.

 *

 * @author Jean-Aymeric Diet

 */

public abstract class Main {



    /**

     * The main method.

     *

     * @param args

     *            the arguments

     * @throws IOException

     * 			throws something

     * @throws InterruptedException

     * 			throws something
     * @throws SQLException 

     */

    public static void main(final String[] args) throws IOException, InterruptedException, SQLException {

        final Model model = new Model();

        final View view = new View(model.getMap(), model.getMap().getMyCharacter(), model.getMap().getPawns());

        final Controller controller = new Controller(view, model);

        view.setOrderPerformer(controller);

        controller.play();

    }

}