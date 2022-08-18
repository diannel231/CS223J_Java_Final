package maze_game;

public class Dummy extends Sprite{

	public Dummy(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub

		initDummy();
	}

	private void initDummy() {

        loadImage("./images/madDummy.gif");
        getImageDimensions();
	}

	public void move(int direction) {

		y += direction;
	}
	
	public Boolean isDead() {

		if(isVisible()) {

			return false;
		}

		else {

			return true;
		}
	}

}
