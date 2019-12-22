package gui_rhythm_game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
//JFrame library inherited to create GUI-based programs in java
import javax.swing.JLabel;

public class RhythmGame extends JFrame {
	/* Two instances of image for full screen for double buffering technology */
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitMenuButton = new ImageIcon(Main.class.getResource("../images/menu/exit.png"));
	private ImageIcon exitMenuButtonOn = new ImageIcon(Main.class.getResource("../images/menu/exitOn.png"));

	private ImageIcon startbutton = new ImageIcon(Main.class.getResource("../images/buttens/startbutton.png"));
	private ImageIcon startbuttonOn = new ImageIcon(Main.class.getResource("../images/buttens/startbuttonOn.png"));
	private ImageIcon exitbutton = new ImageIcon(Main.class.getResource("../images/buttens/exitbutton.png"));
	private ImageIcon exitbuttonOn = new ImageIcon(Main.class.getResource("../images/buttens/exitbuttonOn.png"));

	private Image background; // background image object
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu/menubar.jpg")));
	private JButton exitMenubt = new JButton(exitMenuButton);
	private JButton startbt = new JButton(startbutton);
	private JButton exitbt = new JButton(exitbutton);
	// create a variable to mouse coordinates
	private int mouseX, mouseY;

	// initialization/RhythmGame.java
	public RhythmGame() {
		setUndecorated(true);
		setTitle("GUI_RhythmGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // set screen size
		setResizable(false); // screen resize option
		setLocationRelativeTo(null); // Place in center of game screen when running
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the game screen closes, the entire program shuts.
		// If not set, the program will continue to run and only the window will shut down
		setVisible(true); // if run program, show game screen
		setBackground(new Color(0, 0, 0, 0));
		// when drawing images such as buttons as paintComponents, make the background transparent.
		setLayout(null);

		exitMenubt.setBounds(1230, 0, 45, 30);
		exitMenubt.setBorderPainted(false);
		exitMenubt.setContentAreaFilled(false);
		exitMenubt.setFocusPainted(false);
		exitMenubt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitMenubt.setIcon(exitMenuButtonOn);
				exitMenubt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitMenubt.setIcon(exitMenuButton);
				exitMenubt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitMenubt);

		menubar.setBounds(0, 0, 1280, 30);
		menubar.addMouseListener(new MouseAdapter() {
			//process events when mouse pressed
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			//mouse drag event, moving screen
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menubar);

		// add start button and button default design setting -> false
		startbt.setBounds(20, 300, 420, 120);
		startbt.setBorderPainted(false);
		startbt.setContentAreaFilled(false);
		startbt.setFocusPainted(false);
		startbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startbt.setIcon(startbuttonOn);
				startbt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				startbt.setIcon(startbutton);
				startbt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				startbt.setVisible(false);
				exitbt.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/inMenuBackground.jpg")).getImage();
			}
		});
		add(startbt);
		
		exitbt.setBounds(20, 430, 420, 120);
		exitbt.setBorderPainted(false);
		exitbt.setContentAreaFilled(false);
		exitbt.setFocusPainted(false);
		exitbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitbt.setIcon(exitbuttonOn);
				exitbt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitbt.setIcon(exitbutton);
				exitbt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitbt);


		background = new ImageIcon(Main.class.getResource("../images/mainbackground.jpg")).getImage();
		// Based on the location of the main class, place the image file into the introbackground as an instance.
		Music introMusic = new Music("Hawn(mainbgm).mp3", true);
		introMusic.start();

	}

	/*
	 * pain method: first method to draw screen
	 * draw the image with screenDraw and call up the paint again to continuously redraw the screen every moment.
	 */
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		// simple image draw method, ex) background
		paintComponents(g);
		// additional pictures draw method -> implement always fixed menu button
		this.repaint();
	}
}
