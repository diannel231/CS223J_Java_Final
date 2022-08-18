package maze_game;

public class Bone extends Sprite{

	private final int BOARD_WIDTH = 560;
	private final int BONE_SPEED = 2;

	public Bone(int x, int y) {

		super(x, y);

		initBone();

	}

	private void initBone() {

		loadImage("./images/bone.png");
		getImageDimensions();
	}

	public void move() {

		x += BONE_SPEED;

		if(x > BOARD_WIDTH) {

			visible = false;
		}
	}

}
