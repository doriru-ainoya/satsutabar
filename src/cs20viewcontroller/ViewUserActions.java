/*
 * The controller classes (like the ViewUserActions class) provides actions
 * that the user can trigger through the view classes.  Those actions are 
 * written in this class as private inner classes (i.e. classes 
 * declared inside another class).
 *
 * You can use all the public instance variables you defined in AllModelsForView, 
 * DrawnView, and ViewOutputs as though they were part of this class! This is 
 * due to the magic of subclassing (i.e. using the extends keyword).
 */
package cs20viewcontroller;

import cs20models.Backend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * ViewUserActions is a class that contains actions users can trigger.
 *
 * User actions are written as private inner classes that implements the
 * ActionListener interface. These actions must be "wired" into the DrawnView in
 * the ViewUserActions constructor, or else they won't be triggered by the user.
 *
 * Actions that the user can trigger are meant to manipulate some model classes
 * by sending messages to them to tell them to update their data members.
 *
 * Actions that the user can trigger can also be used to manipulate the GUI by
 * sending messages to the view classes (e.g. the DrawnView class) to tell them
 * to update themselves (e.g. to redraw themselves on the screen).
 *
 * @author cheng
 */
public class ViewUserActions {

    /*
     * Step 1 of 2 for writing user actions.
     * -------------------------------------
     *
     * User actions are written as private inner classes that implement
     * ActionListener, and override the actionPerformed method.
     *
     * Use the following as a template for writting more user actions.
     */
    Animation animation;
    int count;
    MainDisplay md;

    private class AllClear implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            count++;
            animation.playGif(count);
            try {
                Path p = Paths.get("data/demo.wav");
                String path = p.toAbsolutePath().toString();
//                md.printError(path);
                File f = new File(path);
                
                URL url = f.toURI().toURL();
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(url));
                clip.start();
            } catch (Exception e) {
            }
        }
    }

    public ViewUserActions(Backend backendModels, MainDisplay mainDisplay, Animation animation) {
        this.md = mainDisplay;
        this.md.button.addActionListener(new AllClear());
        this.animation = animation;
        this.count = 0;

    }
}
