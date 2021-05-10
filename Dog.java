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

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import maze_game.Bone;

// Dog class uses Sprite class for its properties
public class Dog extends Sprite{

	// dy determines where the user will move the dog
    private int dy;
    
    // Since it shoots bones, it has a List of bones
    // to use (creates one every time it shoots)
    private List<Bone> bones;

    // Dog uses Sprite class properties for its coordinates
    public Dog(int x, int y) {
    	
    	super(x, y);
    	
        initDog();
    }
    
    // Creates the dog
    private void initDog() {
        
    	// The bones turns into an array
        bones = new ArrayList<>();
        
        // Gets the picture of the dog
        loadImage("src/images/smalldoggo.gif");
    }
    
    // Will update the y coordinate(since it just moves up and
    // down) with dy
    public void move() {
    	
    	y += dy;
    	
    	// These set the boundaries
    	if ( y < 1) {
    		
    		y = 1;
    	}
    	
    	else if(y > 360) {
    		
    		y = 360;
    	}
    }

    // Returns the bones
    public List<Bone> getBones(){
    	
    	return bones;
    }

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        
        // Will fire bone when user enters the spacebar
        if(keyCode == KeyEvent.VK_SPACE) {
        	
        	fire();
        }
        
        // dy is assigned a value to use it to move the dog
        if(keyCode == KeyEvent.VK_UP) {
            dy = -2;
        }

        if(keyCode == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int keyCode = e.getKeyCode();
        
        // When the keys are released, it will stop
        // moving the dog since dy is set to zero
        if(keyCode == KeyEvent.VK_UP) {
            dy = 0;
        }

        if(keyCode == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    // This function adds a bone to the array
    public void fire() {
    	
    	bones.add(new Bone(x + width, y + height / 2));
    }
}
