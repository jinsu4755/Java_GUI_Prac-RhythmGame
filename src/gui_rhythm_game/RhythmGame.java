package gui_rhythm_game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
//JFrame: java���� GUI����� ���α׷��� ����� ���ؼ� ��ӹ޴� ���̺귯��

public class RhythmGame extends JFrame {
	/*���� ���۸� ����� ���ؼ� ��ü ȭ�鿡 ���ؼ� �̹����� ��� �� �ν��Ͻ� */
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground; //�̹����� ���� ��ü 
	
	//initialization/RhythmGame.java
	public RhythmGame() {
		setTitle("GUI_RhythmGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //ȭ�� ũ�� ����
		setResizable(false); //����ڰ� ���������� ȭ���� ũ�� ���� �Ұ���
		setLocationRelativeTo(null); //����� ����â �߾ӿ� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ��ü ����
		//���� �̼����� ���α׷��� ��� ����ǰ� â�� �����
		setVisible(true); //â ����
		
		introBackground = new ImageIcon(Main.class.getResource("../images/mainbackground.jpg")).getImage();
		//Main class�� ��ġ�� ������� �̹��������� �ν��Ͻ��� introbackground�� �ִ´�.
		Music introMusic = new Music("Hawn(mainbgm).mp3", true);
		introMusic.start();
		
	}
	
	/*paint�� ���� ó������ ȭ���� �׷��ִ� �޼ҵ�
	 *screenDraw�� �̹����� �׸��� �ٽ� paint�Լ��� �ҷ���
	 *�ż��� ���� ȭ���� ��� �ٽ� �׷��� */
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
