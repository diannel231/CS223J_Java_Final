src maze_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Game extends JFrame implements KeyListener, ActionListener{

	private final int rows1 = 11;
	private final int cols1 = 11;

	private final int rows2 = 15;
	private final int cols2 = 15;

	private final int rows3 = 19;
	private final int cols3 = 19;

	private JPanel cards;

	private JPanel introCard = new JPanel();
	private JLabel description;
	private JLabel dogLabel = new JLabel();
	private JButton start = new JButton("Start");

	ImageIcon fastDog = new ImageIcon("./images/fastDog.gif");

	Image fastTransformed = fastDog.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_DEFAULT);

	private JPanel maze1 = new JPanel
			(new GridLayout(rows1, cols1, 0, 0));

	private JPanel[][] mazePanel1 = new JPanel[rows1][cols1];
	private JLabel[][] mazeLabel1 = new JLabel[rows1][cols1];

	private JPanel maze2 = new JPanel
			(new GridLayout(rows2, cols2, 0, 0));

	private JPanel[][] mazePanel2 = new JPanel[rows2][cols2];
	private JLabel[][] mazeLabel2 = new JLabel[rows2][cols2];

	private JPanel maze3 = new JPanel
			(new GridLayout(rows3, cols3, 0, 0));

	private JPanel[][] mazePanel3 = new JPanel[rows3][cols3];
	private JLabel[][] mazeLabel3 = new JLabel[rows3][cols3];

	private JPanel endingCard = new JPanel();
	private JPanel subPanel1 = new JPanel();
	private JPanel subPanel2 = new JPanel();
	private JPanel subPanel3 = new JPanel();
	private JPanel subPanel4 = new JPanel();
	private JPanel subPanel5 = new JPanel();
	private JPanel subPanel6 = new JPanel();
	private JPanel subPanel7 = new JPanel();
	private JPanel subPanel8 = new JPanel();
	private JPanel subPanel9 = new JPanel();
	private JLabel background = new JLabel();
	private JLabel congrats1;
	private JLabel congrats2;
	private JButton close = new JButton("Uh... ok");

	private GameBoard miniGame1 = new GameBoard();
	private JPanel miniGame2 = new GameBoard();
	private JPanel miniGame3 = new GameBoard();

	ImageIcon closeDog = new ImageIcon("./images/closeUpDog.PNG");

	ImageIcon dog = new ImageIcon("./images/AnnoyingDog.gif");
	ImageIcon overDummy = new ImageIcon("./images/Dummy.png");
	ImageIcon artifact = new ImageIcon("./images/Artifact.png");

	Image dogTransformed = dog.getImage().getScaledInstance(67, 67, java.awt.Image.SCALE_DEFAULT);
	Image smallerDog = dog.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT);
	Image evenSmallerDog = dog.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT);

	Image dummyTransformed = overDummy.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
	Image smallerDummy = overDummy.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	Image evenSmallerDummy = overDummy.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);

	Image smolArtifact = artifact.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);

	private int x1 = 9;
	private int y1 = 0;

	private int x2 = 13;
	private int y2 = 0;

	private int x3 = 17;
	private int y3 = 0;

	public Game() {

		super("Maze Game");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(450, 350);
		setResizable(false);

		cards = new JPanel(new CardLayout());

		description = new JLabel("Help the dog get to the legendary artifact!");
		description.setFont(new Font("Dialog", Font.BOLD, 20));
		description.setForeground(Color.WHITE);

		dogLabel.setIcon(new ImageIcon(fastTransformed));

		introCard.setLayout(new FlowLayout());
		introCard.setBackground(Color.BLACK);

		introCard.add(dogLabel);
		introCard.add(description);
		introCard.add(start);

		start.addActionListener(this);

		cards.add(introCard, "Intro Card");

		for(int i = 0; i < rows1; i++) {
			for(int j = 0; j < cols1; j++) {

				mazePanel1[i][j] = new JPanel();
				maze1.add(mazePanel1[i][j]);

				mazeLabel1[i][j]= new JLabel();

				if(Mazes.mazeDesign1(i, j) == true)	{

					mazePanel1[i][j].setBackground(Color.BLACK);
				}

				else {

					mazePanel1[i][j].setBackground(Color.GRAY);
				}


				if(i == 9 && j == 0) {

					mazeLabel1[i][j].setIcon(new ImageIcon(dogTransformed));
				}

				else if(i == 2 && j == 5) {

					mazeLabel1[i][j].setIcon(new ImageIcon(dummyTransformed));
				}

				else {

					mazeLabel1[i][j] = new JLabel("");
				}

				mazePanel1[i][j].add(mazeLabel1[i][j]);
			}
		}

		maze1.setName("Maze 1");

		cards.add(maze1, maze1.getName());

		for(int i = 0; i < rows2; i++) {
			for(int j = 0; j < cols2; j++) {

				mazePanel2[i][j] = new JPanel();
				maze2.add(mazePanel2[i][j]);

				mazeLabel2[i][j]= new JLabel();

				if(Mazes.mazeDesign2(i, j) == true)	{

					mazePanel2[i][j].setBackground(Color.BLACK);
				}

				else {

					mazePanel2[i][j].setBackground(Color.GRAY);
				}


				if(i == 13 && j == 0) {

					mazeLabel2[i][j].setIcon(new ImageIcon(smallerDog));
				}

				else {

					mazeLabel2[i][j] = new JLabel("");
				}

				mazePanel2[i][j].add(mazeLabel2[i][j]);
			}
		}

		miniGame1.setName("Dummy Boss 1");

		cards.add(miniGame1, miniGame1.getName());

		maze2.setName("Maze 2");

		cards.add(maze2, maze2.getName());

		miniGame2.setName("Dummy Boss 2");

		cards.add(miniGame2, miniGame2.getName());

		for(int i = 0; i < rows3; i++) {
			for(int j = 0; j < cols3; j++) {

				mazePanel3[i][j] = new JPanel();
				maze3.add(mazePanel3[i][j]);

				mazeLabel3[i][j]= new JLabel();

				if(Mazes.mazeDesign3(i, j) == true)	{

					mazePanel3[i][j].setBackground(Color.BLACK);
				}

				else {

					mazePanel3[i][j].setBackground(Color.GRAY);
				}


				if(i == 17 && j == 0) {

					mazeLabel3[i][j].setIcon(new ImageIcon(evenSmallerDog));
				}

				else {

					mazeLabel3[i][j] = new JLabel("");
				}

				mazePanel3[i][j].add(mazeLabel3[i][j]);
			}
		}

		maze3.setName("Maze 3");

		cards.add(maze3, maze3.getName());

		congrats1 = new JLabel("                	" + "The dog is grateful" + "                	");
		congrats1.setFont(new Font("Dialog", Font.BOLD, 30));

		congrats2 = new JLabel("                	" + "for your help" + "                	");
		congrats2.setFont(new Font("Dialog", Font.BOLD, 30));

		close.setFont(new Font("Dialog", Font.BOLD, 25));

		close.addActionListener(this);

		subPanel1.setOpaque(false);
		subPanel1.setLayout(new FlowLayout());

		subPanel2.setOpaque(false);
		subPanel2.setLayout(new FlowLayout());

		subPanel3.setOpaque(false);
		subPanel3.setLayout(new FlowLayout());

		subPanel4.setOpaque(false);
		subPanel4.setLayout(new FlowLayout());

		subPanel5.setOpaque(false);
		subPanel5.setLayout(new FlowLayout());

		subPanel6.setOpaque(false);
		subPanel6.setLayout(new FlowLayout());

		subPanel7.setOpaque(false);
		subPanel7.setLayout(new FlowLayout());

		subPanel8.setOpaque(false);
		subPanel8.setLayout(new FlowLayout());

		subPanel9.setOpaque(false);
		subPanel9.setLayout(new FlowLayout());

		background.setLayout(new FlowLayout());
		background.setIcon(closeDog);
		background.setLayout(new GridLayout(3, 3));

		subPanel6.add(congrats1);
		subPanel6.add(congrats2);
		subPanel9.add(close);

		background.add(subPanel1);
		background.add(subPanel2);
		background.add(subPanel3);
		background.add(subPanel4);
		background.add(subPanel5);
		background.add(subPanel6);
		background.add(subPanel7);
		background.add(subPanel8);
		background.add(subPanel9);

		endingCard.add(background);

		cards.add(endingCard, "End");

		addKeyListener(this);
		setFocusable(true);

		add(cards);

	}

	public JPanel getCurrentPanel() {

	    JPanel card = null;

	    for (Component comp : cards.getComponents() ) {
	        if (comp.isVisible() == true) {
	            card = (JPanel)comp;
	            System.out.println(card.getName() );
	        }
	    }
	    System.out.println();

	    return card;

    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object source = e.getSource();


		if(source == start) {

			setSize(650, 450);
			CardLayout cl = (CardLayout)(cards.getLayout() );

			 cl.next(cards);

		}

		if(getCurrentPanel() == miniGame1) {

			miniGame1.setFocusable(true);
			miniGame1.requestFocusInWindow();
		}

		else if(source == close) {

			super.dispose();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		int keyCode = e.getKeyCode();

		if(miniGame1.isDone() == true) {

			CardLayout cl = (CardLayout)(cards.getLayout() );
			cl.show(maze1.getParent(), maze1.getName());
		}

		if(getCurrentPanel() == maze1) {

			if(keyCode == KeyEvent.VK_UP) {

				if(x1 < 11 && x1 > 0 && mazePanel1[x1-1][y1].getBackground() == Color.GRAY) {

					mazeLabel1[x1][y1].setIcon(null);
					mazeLabel1[x1-1][y1].setIcon(new ImageIcon(dogTransformed));

					x1 -= 1;
				}

			}

			if(keyCode == KeyEvent.VK_DOWN) {

				if(x1 < 10 && x1 >= 0 && mazePanel1[x1+1][y1].getBackground() == Color.GRAY) {

					mazeLabel1[x1][y1].setIcon(null);
					mazeLabel1[x1+1][y1].setIcon(new ImageIcon(dogTransformed));

					x1 += 1;
				}

			}

			if(keyCode == KeyEvent.VK_LEFT) {

				if(y1 < 11 && y1 > 0 && mazePanel1[x1][y1 - 1].getBackground() == Color.GRAY) {

					mazeLabel1[x1][y1].setIcon(null);
					mazeLabel1[x1][y1-1].setIcon(new ImageIcon(dogTransformed));

					y1 -= 1;
				}

			}

			if(keyCode == KeyEvent.VK_RIGHT) {

				if(y1 < 10 && y1 >= 0 && mazePanel1[x1][y1 +  1].getBackground() == Color.GRAY) {

					mazeLabel1[x1][y1].setIcon(null);
					mazeLabel1[x1][y1+1].setIcon(new ImageIcon(dogTransformed));

					y1 += 1;
				}

			}

			if(x1 == 2 && y1 == 5) {

				CardLayout cl = (CardLayout)(cards.getLayout() );

				cl.next(cards);

				mazePanel1[4][6].setBackground(Color.gray);


			}

			else if(x1 == 1 && y1 == 10) {

				CardLayout cl = (CardLayout)(cards.getLayout() );

				cl.next(cards);

			}

		}

		else if(getCurrentPanel() == maze2) {

			if(keyCode == KeyEvent.VK_UP) {

				if(x2 < 15 && x2 > 0 && mazePanel2[x2-1][y2].getBackground() == Color.GRAY) {

					mazeLabel2[x2][y2].setIcon(null);
					mazeLabel2[x2-1][y2].setIcon(new ImageIcon(smallerDog));

					x2 -= 1;
				}

			}

			else if(keyCode == KeyEvent.VK_DOWN) {

				if(x2 < 14 && x2 >= 0 && mazePanel2[x2+1][y2].getBackground() == Color.GRAY) {

					mazeLabel2[x2][y2].setIcon(null);
					mazeLabel2[x2+1][y2].setIcon(new ImageIcon(smallerDog));

					x2 += 1;
				}

			}

			else if(keyCode == KeyEvent.VK_LEFT) {

				if(y2 < 15 && y2 > 0 && mazePanel2[x2][y2 - 1].getBackground() == Color.GRAY) {

					mazeLabel2[x2][y2].setIcon(null);
					mazeLabel2[x2][y2-1].setIcon(new ImageIcon(smallerDog));

					y2 -= 1;
				}

			}

			else if(keyCode == KeyEvent.VK_RIGHT) {

				if(y2 < 14 && y2 >= 0 && mazePanel2[x2][y2 +  1].getBackground() == Color.GRAY) {

					mazeLabel2[x2][y2].setIcon(null);
					mazeLabel2[x2][y2+1].setIcon(new ImageIcon(smallerDog));

					y2 += 1;
				}

			}

			if(x2 == 1 && y2 == 14) {

				CardLayout cl = (CardLayout)(cards.getLayout() );

				cl.next(cards);

			}
		}

		else if(getCurrentPanel() == maze3) {

			if(keyCode == KeyEvent.VK_UP) {

				if(x3 < 19 && x3 > 0 && mazePanel3[x3-1][y3].getBackground() == Color.GRAY) {

					mazeLabel3[x3][y3].setIcon(null);
					mazeLabel3[x3-1][y3].setIcon(new ImageIcon(evenSmallerDog));

					x3 -= 1;
				}

			}

			else if(keyCode == KeyEvent.VK_DOWN) {

				if(x3 < 18 && x3 >= 0 && mazePanel3[x3+1][y3].getBackground() == Color.GRAY) {

					mazeLabel3[x3][y3].setIcon(null);
					mazeLabel3[x3+1][y3].setIcon(new ImageIcon(evenSmallerDog));

					x3 += 1;
				}

			}

			else if(keyCode == KeyEvent.VK_LEFT) {

				if(y3 < 19 && y3 > 0 && mazePanel3[x3][y3 - 1].getBackground() == Color.GRAY) {

					mazeLabel3[x3][y3].setIcon(null);
					mazeLabel3[x3][y3-1].setIcon(new ImageIcon(evenSmallerDog));

					y3 -= 1;
				}

			}

			else if(keyCode == KeyEvent.VK_RIGHT) {

				if(y3 < 18 && y3 >= 0 && mazePanel3[x3][y3 +  1].getBackground() == Color.GRAY) {

					mazeLabel3[x3][y3].setIcon(null);
					mazeLabel3[x3][y3+1].setIcon(new ImageIcon(evenSmallerDog));

					y3 += 1;
				}

			}

			if(x3 == 1 && y3 == 18) {

				setSize(1220, 718);

				CardLayout cl = (CardLayout)(cards.getLayout() );

				cl.next(cards);
			}
		}

		else if(getCurrentPanel() == miniGame1) {

			miniGame1.requestFocusInWindow();

		}


	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


        EventQueue.invokeLater(() -> {
    		Game myGame = new Game();
    		myGame.setVisible(true);
        });


	}


}
