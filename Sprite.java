package maze_game;

/* This code is entirely based on a tutorial from this website:
 * http://zetcode.com/tutorials/javagamestutorial/collision/
 * 
 * Author: Jan Bodnar
 * 
 * It is very similar to a space invaders code he's written, but
 * I made my own version to create the mini game I wanted
 * 
 */

import java.awt.*;
import javax.swing.ImageIcon;

// The sprite class is created because all the sprites shares
// similar properties
public class Sprite {
	
	// This is the coordinates
	protected int x;
	protected int y;
	
	// Width and height of the sprite
	protected int width;
	protected int height;
	
	// Visiblility of the sprite
	protected boolean visible;
	
	// Image of the sprite
	protected Image image;
	
	// This function sets up the coordinates of the sprites and
	// sets is visibility to true
	public Sprite(int x, int y) {
		
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	// Gets the image source
	protected void loadImage(String name) {
		
		ImageIcon sprite = new ImageIcon(name);
		image = sprite.getImage();
	}
	
	// Gets the image's dimensions
	protected void getImageDimensions() {
		
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	// Returns the image
	public Image getImage() {
		
		return image;
	}
	
	// Returns the x-coordinate
	public int getX() {
		
		return x;
	}
	
	// Returns the y-coordinate
	public int getY() {
		
		return y;
	}
	
	// Returns if it's visible
	public boolean isVisible() {
		
		return visible;
	}
	
	// Sets it to visible or not
	public void setVisible(Boolean visible) {
		
		this.visible = visible;
	}
	
	// Returns it's rectangle bounds for the hit boxes
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, width, height);
	}

}
