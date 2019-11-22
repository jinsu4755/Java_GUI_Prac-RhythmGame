package gui_rhythm_game;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; //javazoom 라이브러리 사용
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		// play할 음악 이름과 반복 여부를 받는다. 
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+ name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		//현재 플레이 음악이 어느 위치에서 플레이 되는지 반환 10초일경우 10,000 반환 0.001초 까지 분석 가능
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		// 특정 이유로 곡을 중단할 경우 해당 곡을 안전하게 종료하기 위한 함수
		isLoop = false;
		player.close();
		this.interrupt();
		// 해당 쓰레드를 중지 상태로 만든다.
	}
	
	@Override
	public void run() {
		//Thread를 상속한경우 필수
		try {
			do {
				//isLoop 가 true인경우 다시 재생
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
