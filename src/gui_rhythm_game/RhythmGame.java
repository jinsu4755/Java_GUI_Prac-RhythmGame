package gui_rhythm_game;

import javax.swing.JFrame;
//JFrame: java에서 GUI기반의 프로그램을 만들기 위해서 상속받는 라이브러리

public class RhythmGame extends JFrame {
	
	//initialization/RhythmGame.java
	public RhythmGame() {
		setTitle("GUI_RhythmGame");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //화면 크기 설정
		setResizable(false); //사용자가 임의적으로 화면의 크기 변경 불가능
		setLocationRelativeTo(null); //실행시 게임창 중앙에 띄우기 위함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임창 종료시 프로그램 전체 종료
		//만약 미설정시 프로그램이 계속 실행되고 창만 종료됨
		setVisible(true); //창 띄우기
		
		
	}
}
