package fivestar_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FiveStarBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introbackground;
	
	public FiveStarBeat() {
		setTitle("Fivestar Rhythem");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);//한번 만들어진 게임창은 사용자의 임의대로 크기설정이 불가능하다
		setLocationRelativeTo(null);//실행했을때 프로그램이 컴퓨터 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 껐을 때 프로그램이 종료되게끔 해줌
		//넣지 않을 경우 게임창을 끄더라도 프로그램은 컴퓨터 내에서 계속 돌아가는 상태가 됨.
		setVisible(true);//우리가 만든 게임이 정상적으로 화면에 출력되게 도와줌.
		//기본값이 false이기 때문에 반드시 true를 써주어야 한다
		
		introbackground = new ImageIcon(Main.class.getResource("../images/Introbackground.jpg")).getImage();
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introbackground, 0, 0, null);
		this.repaint();
	}
}
