package gui_rhythm_game;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; //javazoom ���̺귯�� ���
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		// play�� ���� �̸��� �ݺ� ���θ� �޴´�. 
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
		//���� �÷��� ������ ��� ��ġ���� �÷��� �Ǵ��� ��ȯ 10���ϰ�� 10,000 ��ȯ 0.001�� ���� �м� ����
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		// Ư�� ������ ���� �ߴ��� ��� �ش� ���� �����ϰ� �����ϱ� ���� �Լ�
		isLoop = false;
		player.close();
		this.interrupt();
		// �ش� �����带 ���� ���·� �����.
	}
	
	@Override
	public void run() {
		//Thread�� ����Ѱ�� �ʼ�
		try {
			do {
				//isLoop �� true�ΰ�� �ٽ� ���
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
