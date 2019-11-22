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
//JFrame: java에서 GUI기반의 프로그램을 만들기 위해서 상속받는 라이브러리
import javax.swing.JLabel;

public class RhythmGame extends JFrame {
	/* 더블 버퍼링 기술을 위해서 전체 화면에 대해서 이미지를 담는 두 인스턴스 */
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitMenuButton = new ImageIcon(Main.class.getResource("../images/menu/exit.png"));
	private ImageIcon exitMenuButtonOn = new ImageIcon(Main.class.getResource("../images/menu/exitOn.png"));

	private ImageIcon startbutton = new ImageIcon(Main.class.getResource("../images/buttens/startbutton.png"));
	private ImageIcon startbuttonOn = new ImageIcon(Main.class.getResource("../images/buttens/startbuttonOn.png"));
	private ImageIcon exitbutton = new ImageIcon(Main.class.getResource("../images/buttens/exitbutton.png"));
	private ImageIcon exitbuttonOn = new ImageIcon(Main.class.getResource("../images/buttens/exitbuttonOn.png"));

	private Image background; // 이미지를 담을 객체
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu/menubar.jpg")));
	private JButton exitMenubt = new JButton(exitMenuButton);
	private JButton startbt = new JButton(startbutton);
	private JButton exitbt = new JButton(exitbutton);
	// 마우스 좌표를 담을 변수 생성
	private int mouseX, mouseY;

	// initialization/RhythmGame.java
	public RhythmGame() {
		setUndecorated(true);
		setTitle("GUI_RhythmGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 화면 크기 설정
		setResizable(false); // 사용자가 임의적으로 화면의 크기 변경 불가능
		setLocationRelativeTo(null); // 실행시 게임창 중앙에 띄우기 위함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창 종료시 프로그램 전체 종료
		// 만약 미설정시 프로그램이 계속 실행되고 창만 종료됨
		setVisible(true); // 창 띄우기
		setBackground(new Color(0, 0, 0, 0));
		// button과 같은 이미지를 paintComponents로 그릴때 배경을 투명하게
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
			//마우스 입력에서 마우스를 눌렀을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			//마우스 이동을 감지하고 마우스 드레그 이벤트 발생시 창을 이동시킨다.
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menubar);

		// start button을 추가하고 해당 버튼의 기본 디자인 셋팅을 false로 한다.
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
		// Main class의 위치를 기반으로 이미지파일을 인스턴스로 introbackground에 넣는다.
		Music introMusic = new Music("Hawn(mainbgm).mp3", true);
		introMusic.start();

	}

	/*
	 * paint method paint는 가장 처음으로 화면을 그려주는 메소드 screenDraw로 이미지를 그리고 다시 paint함수를 불러옴
	 * 매순간 마다 화면을 계속 다시 그려줌
	 */
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		// 배경과 같은 간단이미지를 그리는 메소드
		paintComponents(g);
		// 따로 추가된 그림도 그려주는 메소드 호출 -> 항상 고정된 메뉴바 버튼은 해당 메소드로 구현
		this.repaint();
	}
}
