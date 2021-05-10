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

public class Dummy extends Sprite{
	
	// Creates the dummy
	public Dummy(int x, int y) {
		
		super(x, y);
		
		initDummy();
	}
	
	// Load image of dummy
	private void initDummy() {
		
        loadImage("src/images/madDummy.gif");
        getImageDimensions();
	}
	
	// Direction changes in Battle class
	public void move(int direction) {
		
		// Only y is changed since it only goes up and down
		y += direction;
	}
	
	// This function returns true or false
	public Boolean isDead() {
		
		// Visiblity is changed during the battle
		// If it's still visible, it's still alive
		if(isVisible()) {
			
			return false;
		}
		
		else {
			
			// If not, then true is returned
			return true;
		}
	}
}
