package maze_game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import maze_game.Bone;

public class Dog extends Sprite{

    private int dx;
    private int dy;
    private List<Bone> bones;

    public Dog(int x, int y) {

    	super(x, y);

        initDog();
    }

    private void initDog() {

        bones = new ArrayList<>();

        loadImage("./images/smalldoggo.gif");
        getImageDimensions();
    }

    public void move() {

    	y += dy;

    	if ( y < 1) {

    		y = 1;
    	}

    	else if(y > 360) {

    		y = 360;
    	}
    }

    public List<Bone> getBones(){

    	return bones;
    }

    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_SPACE) {

        	fire();
        }

        if(keyCode == KeyEvent.VK_UP) {
            dy = -2;
        }

        if(keyCode == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP) {
            dy = 0;
        }

        if(keyCode == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public void fire() {

    	bones.add(new Bone(x + width, y + height / 2));
    }
}
