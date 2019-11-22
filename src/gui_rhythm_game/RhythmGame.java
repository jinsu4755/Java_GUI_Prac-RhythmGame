package gui_rhythm_game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
//JFrame: java에서 GUI기반의 프로그램을 만들기 위해서 상속받는 라이브러리

public class RhythmGame extends JFrame {
	/*더블 버퍼링 기술을 위해서 전체 화면에 대해서 이미지를 담는 두 인스턴스 */
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground; //이미지를 담을 객체 
	
	//initialization/RhythmGame.java
	public RhythmGame() {
		setTitle("GUI_RhythmGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //화면 크기 설정
		setResizable(false); //사용자가 임의적으로 화면의 크기 변경 불가능
		setLocationRelativeTo(null); //실행시 게임창 중앙에 띄우기 위함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 전체 종료
		//만약 미설정시 프로그램이 계속 실행되고 창만 종료됨
		setVisible(true); //창 띄우기
		
		introBackground = new ImageIcon(Main.class.getResource("../images/mainbackground.jpg")).getImage();
		//Main class의 위치를 기반으로 이미지파일을 인스턴스로 introbackground에 넣는다.
		Music introMusic = new Music("Hawn(mainbgm).mp3", true);
		introMusic.start();
		
	}
	
	/*paint는 가장 처음으로 화면을 그려주는 메소드
	 *screenDraw로 이미지를 그리고 다시 paint함수를 불러옴
	 *매순간 마다 화면을 계속 다시 그려줌 */
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
}
