package gui_rhythm_game;

import javax.swing.JFrame;
//JFrame: java���� GUI����� ���α׷��� ����� ���ؼ� ��ӹ޴� ���̺귯��

public class RhythmGame extends JFrame {
	
	//initialization/RhythmGame.java
	public RhythmGame() {
		setTitle("GUI_RhythmGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //ȭ�� ũ�� ����
		setResizable(false); //����ڰ� ���������� ȭ���� ũ�� ���� �Ұ���
		setLocationRelativeTo(null); //����� ����â �߾ӿ� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����â ����� ���α׷� ��ü ����
		//���� �̼����� ���α׷��� ��� ����ǰ� â�� �����
		setVisible(true); //â ����
		
		
	}
}
