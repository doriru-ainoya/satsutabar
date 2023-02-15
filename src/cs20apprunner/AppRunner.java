/*
 * This project is a template of a Java GUI (Graphical User Interface) program.
 * It uses the Swing library, and a simplified "MVC" pattern structure,
 * but broken up into files that are more "single purpose" to enable a more
 * "straight through" procedural approach to what codes needs to be written
 * to create a custom GUI.
 *
 * "MVC" means "Model View Controller".  Read a bit more about it first:
 * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
 * 
 * See especially:
 * https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller#Component_interactions
 * 
 * AppRunner only creates a single CompleteViewController object to set up the GUI.
 * In fact, a series of subclass hierarchy means that the CompleteViewController object
 * automatically sets itself up with the necessary models, view, and controller.
 *
 * AppRunner also sets up GUI settings of the operating system to display your 
 * program using the "native" GUI "skin".
 * 
 * The "meat" of your program is created through the Java classes that are
 * representing the models, views, and controller, contained in the other
 * cs20models and cs20viewcontroller packages.
 */

/*
 * WARNING: There is nothing in this file for students to edit or change.
 *          This file is intended to have no student-serviceable code.
 */

package cs20apprunner;

import cs20models.Backend;
import cs20viewcontroller.*;

/**
 *
 * @author cheng
 */
public class AppRunner {
    
        public static void main(String[] args) throws InterruptedException {
        Animation animation = new Animation();
        Backend backendModels = new Backend();
        MainDisplay mainDisplay = new MainDisplay(backendModels);
        
        ViewUserActions mdc = new ViewUserActions(backendModels, mainDisplay, animation);
    }
}
