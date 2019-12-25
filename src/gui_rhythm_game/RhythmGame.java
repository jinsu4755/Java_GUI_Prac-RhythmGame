package gui_rhythm_game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
//JFrame library inherited to create GUI-based programs in java
import javax.swing.JLabel;

public class RhythmGame extends JFrame {
	/* Two instances of image for full screen for double buffering technology */
	private Image screenImage;
	private Graphics screenGraphic;
	//
	private ImageIcon exitMenuButton = new ImageIcon(Main.class.getResource("../images/menu/exit.png"));
	private ImageIcon exitMenuButtonOn = new ImageIcon(Main.class.getResource("../images/menu/exitOn.png"));
	//
	private ImageIcon startbutton = new ImageIcon(Main.class.getResource("../images/buttons/startbutton.png"));
	private ImageIcon startbuttonOn = new ImageIcon(Main.class.getResource("../images/buttons/startbuttonOn.png"));
	private ImageIcon exitbutton = new ImageIcon(Main.class.getResource("../images/buttons/exitbutton.png"));
	private ImageIcon exitbuttonOn = new ImageIcon(Main.class.getResource("../images/buttons/exitbuttonOn.png"));
	//
	private ImageIcon leftButton = new ImageIcon(Main.class.getResource("../images/buttons/leftButton.png"));
	private ImageIcon leftButtonOn = new ImageIcon(Main.class.getResource("../images/buttons/leftButtonOn.png"));
	private ImageIcon rightButton = new ImageIcon(Main.class.getResource("../images/buttons/rightButton.png"));
	private ImageIcon rightButtonOn = new ImageIcon(Main.class.getResource("../images/buttons/rightButtonOn.png"));
	//
	private ImageIcon easyButton = new ImageIcon(Main.class.getResource("../images/buttons/easyButton.png"));
	private ImageIcon easyButtonOn = new ImageIcon(Main.class.getResource("../images/buttons/easyButtonOn.png"));
	private ImageIcon hardButton = new ImageIcon(Main.class.getResource("../images/buttons/hardButton.png"));
	private ImageIcon hardButtonOn = new ImageIcon(Main.class.getResource("../images/buttons/hardButtonOn.png"));
	//
    private ImageIcon backButton = new ImageIcon(Main.class.getResource("../images/buttons/backButton.png"));
    private ImageIcon backButtonOn = new ImageIcon(Main.class.getResource("../images/buttons/backButtonOn.png"));
    //
	private Image background = new ImageIcon(Main.class.getResource("../images/mainbackground.jpg")).getImage();
	// background image object
	// Based on the location of the main class, place the image file into the introbackground as an instance.
	//
	// game Image //
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/game/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/game/judgementLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/game/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/game/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/game/noteBasic.png")).getImage();
	//

	//----buttons----//
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu/menubar.jpg")));
	private JButton exitMenubt = new JButton(exitMenuButton);
	private JButton startbt = new JButton(startbutton);
	private JButton exitbt = new JButton(exitbutton);
	//
	private JButton leftBt = new JButton(leftButton);
	private JButton rightBt = new JButton(rightButton);
	//
	private JButton easyBt = new JButton(easyButton);
	private JButton hardBt = new JButton(hardButton);
    //
    private JButton backBt = new JButton(backButton);
	// create a variable to mouse coordinates//
	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	private boolean isGameScreen = false;

	// Music list//
	ArrayList<Track> trackList = new ArrayList<Track>();
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;

	private int nowSelected = 0;

	private Music introMusic = new Music("Hawn(mainbgm).mp3", true);

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

		introMusic.start();

		trackList.add(new Track("Drive_YuYoon.png",
				"Drive_with_my_friend_intro.png",
				"Drive_with_my_friend_main.png",
				"Drive_with_my_friend(select).mp3",
				"Drive_with_my_friend.mp3"));
		trackList.add(new Track("jack_YuYoon.png",
				"jack_O_Lantern_intro.png",
				"jack_O_Lantern_main.png",
				"Jack_O_Lantern(select).mp3",
				"Jack_O_Lantern.mp3"));
		trackList.add(new Track("Stellar_Beatmin.png",
				"Stellar_cocktail_intro.png",
				"Stellar_cocktail_main.png",
				"Stellar_cocktail(select).mp3",
				"Stellar_cocktail.mp3"));

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
				enterMain();
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

		leftBt.setVisible(false);
		leftBt.setBounds(250, 310, 60, 60);
		leftBt.setBorderPainted(false);
		leftBt.setContentAreaFilled(false);
		leftBt.setFocusPainted(false);
		leftBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftBt.setIcon(leftButtonOn);
				leftBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftBt.setIcon(leftButton);
				leftBt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				//left button event
				selectLeft();
			}
		});
		add(leftBt);

		rightBt.setVisible(false);
		rightBt.setBounds(960, 310, 60, 60);
		rightBt.setBorderPainted(false);
		rightBt.setContentAreaFilled(false);
		rightBt.setFocusPainted(false);
		rightBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightBt.setIcon(rightButtonOn);
				rightBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightBt.setIcon(rightButton);
				rightBt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				//right button event
				selectRight();
			}
		});
		add(rightBt);

		easyBt.setVisible(false);
		easyBt.setBounds(375, 480, 250, 67);
		easyBt.setBorderPainted(false);
		easyBt.setContentAreaFilled(false);
		easyBt.setFocusPainted(false);
		easyBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyBt.setIcon(easyButtonOn);
				easyBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyBt.setIcon(easyButton);
				easyBt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				//easy event
				gameStart(nowSelected, "easy");
			}
		});
		add(easyBt);

		hardBt.setVisible(false);
		hardBt.setBounds(655, 480, 250, 67);
		hardBt.setBorderPainted(false);
		hardBt.setContentAreaFilled(false);
		hardBt.setFocusPainted(false);
		hardBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardBt.setIcon(hardButtonOn);
				hardBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardBt.setIcon(hardButton);
				hardBt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				//hard event
				gameStart(nowSelected, "hard");
			}
		});
		add(hardBt);

        backBt.setVisible(false);
        backBt.setBounds(20, 50, 60, 60);
        backBt.setBorderPainted(false);
        backBt.setContentAreaFilled(false);
        backBt.setFocusPainted(false);
        backBt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backBt.setIcon(backButtonOn);
                backBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backBt.setIcon(backButton);
                backBt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                //back event -> to main screen
				backMain();
            }
        });
        add(backBt);


	}

	/*
	 * pain method: first method to draw screen
	 * draw the image with screenDraw and call up the paint again to continuously redraw the screen every moment.
	 */
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		// simple image draw method, ex) background
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 550, null);
		}
		if (isGameScreen) {
			g.drawImage(noteRouteImage, 228, 30, null);
			g.drawImage(noteRouteImage, 332, 30, null);
			g.drawImage(noteRouteImage, 436, 30, null);
			g.drawImage(noteRouteImage, 540, 30, null);
			g.drawImage(noteRouteImage, 640, 30, null);
			g.drawImage(noteRouteImage, 744, 30, null);
			g.drawImage(noteRouteImage, 848, 30, null);
			g.drawImage(noteRouteImage, 952, 30, null);

			g.drawImage(noteRouteLineImage, 224, 30, null);
			g.drawImage(noteRouteLineImage, 328, 30, null);
			g.drawImage(noteRouteLineImage, 432, 30, null);
			g.drawImage(noteRouteLineImage, 536, 30, null);
			g.drawImage(noteRouteLineImage, 740, 30, null);
			g.drawImage(noteRouteLineImage, 844, 30, null);
			g.drawImage(noteRouteLineImage, 948, 30, null);
			g.drawImage(noteRouteLineImage, 1052, 30, null);

			g.drawImage(noteBasicImage, 228, 120, null);
			g.drawImage(noteBasicImage, 332, 580, null);

			g.drawImage(gameInfoImage, 0, 660, null);
			g.drawImage(judgementLineImage, 0, 600, null);

			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("YuYoon - Drive with my Friend", 20, 702);
			g.drawString("Easy", 1190, 702);

			g.setFont(new Font("Arial", Font.PLAIN, 30));
			g.setColor(Color.darkGray);
			g.drawString("S",270,629);
			g.drawString("D",374,629);
			g.drawString("F",478,629);
			g.drawString("Space Bar",580,629);
			g.drawString("J",784,629);
			g.drawString("K",889,629);
			g.drawString("L",993,629);

			g.setColor(Color.lightGray);
			g.setFont(new Font("Elephant", Font.BOLD, 30));
			g.drawString("000000", 565, 702);

		}
		paintComponents(g);
		// additional pictures draw method -> implement always fixed menu button
		// add code is view with paintComponents method
		this.repaint();
	}

	public void selectedTrack(int nowSelected) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("../images/musicImage/"+trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/musicImage/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if (nowSelected == 0) {
			nowSelected = trackList.size() - 1;
		} else {
			nowSelected--;
		}
		selectedTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		} else {
			nowSelected++;
		}
		selectedTrack(nowSelected);
	}

	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		isMainScreen = false;
		setMainButton(false);
		background = new ImageIcon(Main.class.getResource("../images/musicImage/"+trackList.get(nowSelected).getGameImage())).getImage();
		backBt.setVisible(true);
		isGameScreen = true;
	}

	private void intoMain() {
		background = new ImageIcon(Main.class.getResource("../images/inMenuBackground.jpg")).getImage();
		isMainScreen = true;
	}

	private void setMainButton(boolean bool) {
		leftBt.setVisible(bool);
		rightBt.setVisible(bool);
		easyBt.setVisible(bool);
		hardBt.setVisible(bool);
	}

	public void backMain() {
		intoMain();
		setMainButton(true);

		backBt.setVisible(false);
		selectedTrack(nowSelected);
		isGameScreen = false;
	}

	public void enterMain() {
		intoMain();
		startbt.setVisible(false);
		exitbt.setVisible(false);
		setMainButton(true);
		introMusic.close();

		selectedTrack(0);
	}
}
