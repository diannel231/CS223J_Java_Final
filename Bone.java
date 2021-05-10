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

public class Bone extends Sprite{
	
	// This is used to limit how far the bones
	// will go
	private final int BOARD_WIDTH = 560;
	
	// This determines the bones' speed
	private final int BONE_SPEED = 2;

	// Coordinates for bone
	public Bone(int x, int y) {
		
		super(x, y);
		
		initBone();
	}
	
	// Loads image of bone and gets its dimensions for
	// hit box
	private void initBone() {
		
		loadImage("src/images/bone.png");
		getImageDimensions();
	}
	
	// Bone will keep moving until it's more than the
	// board width. Once it has reached its limit, it will become
	// invisible (the Battle class will remove it)
	public void move() {
		
		x += BONE_SPEED;
		
		if(x > BOARD_WIDTH) {
			
			visible = false;
		}
	}

}
