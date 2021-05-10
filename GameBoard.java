package maze_game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import maze_game.Bone;

import java.util.List;

public class GameBoard extends JPanel implements ActionListener {

	private final int B_WIDTH = 600;
	private final int B_HEIGHT = 400;
	private final int IDOG_X = 10;
	private final int IDOG_Y = 200;
	private final int IDUMMY_X = 550;
	private final int IDUMMY_Y = 200;
    private Timer timer;
    private Dog dog;
    private Dummy dummy;
    private final int DELAY = 6;
    private boolean inGame;
    private int dummyHealth = 3;
    private int direction = -2;
    private Boolean done = false;
    
    public GameBoard() {

        initBoard();
    }

    private void initBoard() {
    	
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        
        inGame = true;
        
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        dummy = new Dummy(IDUMMY_X, IDUMMY_Y);

        dog = new Dog(IDOG_X, IDOG_Y);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);

        if(inGame) {
        	
        	drawObjects(g);
        }
        
        else {
        	
        	drawVictory(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawObjects(Graphics g) {
    
    	if(dog.isVisible()) {
    		
    		g.drawImage(dog.getImage(), dog.getX(), dog.getY(), this);
    	}
    	
    	List<Bone> bones = dog.getBones();
    	
    	for(Bone bone : bones) {
    		
    		if(bone.isVisible()) {
    			
    			g.drawImage(bone.getImage(),  bone.getX(),  bone.getY(), this);
    		}
    	}
    	
    	if(dummy.isVisible()) {
    		
    		g.drawImage(dummy.getImage(),  dummy.getX(), dummy.getY(), this);
    	}
    	
    }
    
    
    private void drawVictory(Graphics g) {
    	
        String msg = "You defeated the rude af dummy! (Press enter to exit)";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(small);
        
        //addKeyListener(new TAdapter());

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }
    
    /*public JButton getButton() {
    	
    	return exit;
    }*/
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    	Object source = e.getSource();
    	
    	gameIsRunning();
    	
    	updateBones();
    	updateDog();
    	updateDummy();
    	
    	checkCollisions();
    	
        repaint();
        
    }
    
    private void gameIsRunning() {
    	
    	if(!inGame) {
    		
    		timer.stop();
    	}
    }
    
    private void updateBones() {
    	
    	List<Bone> bones = dog.getBones();
    	
    	for(int i = 0; i < bones.size(); i++) {
    		
    		Bone bone = bones.get(i);
    		
    		if(bone.isVisible()) {
    			
    			bone.move();
    		}
    		
    		else {
    			
    			bones.remove(i);
    		}
    	}
    }
    
    private void updateDog() {
        
    	if(dog.isVisible()) {
    		
            dog.move();
    	}
            
    }
    
    private void updateDummy() {
    	
    	if(dummy.isDead()) {
    		
    		inGame = false;
    		return;
    	}
    	
    	if(dummy.isVisible()) {
    		
    		
    		dummy.move(direction);

    	}
    }
    
    public void checkCollisions() {
    	
    	Rectangle rDummy = dummy.getBounds();
    	
    	List<Bone> bones = dog.getBones();
    
    	for(Bone bone : bones) {
    		
    		Rectangle rBone = bone.getBounds();
    		
    		if(rBone.intersects(rDummy)) {
    			
    			dummyHealth--;
    			
    			bone.setVisible(false);
    			
    			if(dummyHealth == 0) {
    				
        			dummy.setVisible(false);
        			//won = true;
    			}
    		}

    	}
    	
    	Rectangle top = new Rectangle(0, 0, 600, 1);
    	Rectangle bot = new Rectangle(0, 390, 600, 1);
    	
    	if(rDummy.intersects(top)) {
    		
    		direction = 2;
    	}
    	
    	else if(rDummy.intersects(bot)) {
    	
    		direction = -2;
    	}
    }
    
    public Boolean isDone() {
    	
    	return done;
    }
    

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
        	
            dog.keyReleased(e);
            
        }

        @Override
        public void keyPressed(KeyEvent e) {

            dog.keyPressed(e);
            
           	int keyCode = e.getKeyCode();
           	
           /*	if(keyCode == KeyEvent.VK_ENTER) {
           		
           		done = true;*/
           	}
        }

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
    }
    
    
}