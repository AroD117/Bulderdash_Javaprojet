package entity;
//salut
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    //The image
    private Image   image;

    //The name of image
    private String  imageName;

    //The console image
    private char    consoleImage;

    //The is image loaded
    private boolean imageLoaded;

    //Default constructor
    public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageName(imageName);
    }
    
    //Load image
    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("images/" + this.getImageName())));
    }
    
    //Getter for image
    public final Image getImage() {
        return this.image;
    }
    
    //Setter for image
    private void setImage(final Image image) {
        this.image = image;
    }

    //Getter for consoleImage
    public final char getConsoleImage() {
        return this.consoleImage;
    }

    //Setter for consoleImage
    private void setConsoleImage(final char consoleImage) {
        this.consoleImage = consoleImage;
    }

    //Getter for imageName
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }
    
    //Setter for imageName
    public final String getImageName() {
        return this.imageName;
    }

    //Verify if the image is loaded
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    //Setter for image
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }
}