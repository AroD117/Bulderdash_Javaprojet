package view;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
public class BufferedImageLoader {
	
	public BufferedImage loadImage(String pathRelativeToThis) throws IOException {
		java.net.URL url = this.getClass().getResource(pathRelativeToThis);
		BufferedImage img = ImageIO.read(url);
		return img;
		
	}

}
