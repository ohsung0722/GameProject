package fivestar_beat_4;

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
import javax.swing.JLabel;

public class FiveStarBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introbackground = new ImageIcon(Main.class.getResource("../images/Introbackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton quitButton = new JButton(new ImageIcon(Main.class.getResource("../images/quitButton.png")));
	
	private int mouseX, mouseY;
	public FiveStarBeat() {
		setUndecorated(true);
		setTitle("Fivestar Rhythem");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);//한번 만들어진 게임창은 사용자의 임의대로 크기설정이 불가능하다
		setLocationRelativeTo(null);//실행했을때 프로그램이 컴퓨터 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 껐을 때 프로그램이 종료되게끔 해줌
		//넣지 않을 경우 게임창을 끄더라도 프로그램은 컴퓨터 내에서 계속 돌아가는 상태가 됨.
		setVisible(true);//우리가 만든 게임이 정상적으로 화면에 출력되게 도와줌.
		//기본값이 false이기 때문에 반드시 true를 써주어야 한다
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);//버튼을 삽입했을 때 그 위치 그대로 위치시켜주는 방법
		
		quitButton.setBounds(1245, 0, 30, 30);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			//마우스를 quitbutton위에 올려놨을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			//마우스를 quitbutton위에서 땠을 때 이벤트
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			//마우스로 quitbutton을 클릭했을 때 콘솔창 종료
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(quitButton);
		
		menuBar.setBounds(0,0,1280,30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			//마우스로 해당 버튼을 눌렀을 때에 대한 이벤트 처리
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();//실제로 이벤트가 발생했을 때 마우스의 각 좌표를 얻어오는 역할
			}
		});
		//마우스로 메뉴바를 클릭하고 움직였을 때 게임창이 따라서 움직일 수 있도록 해주는 이벤트
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		
		
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
		paintComponents(g);//항상 고정된 이미지를 추가할 때 사용하는 것
		this.repaint();
	}
}
