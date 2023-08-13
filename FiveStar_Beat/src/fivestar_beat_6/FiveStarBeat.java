 package fivestar_beat_6;

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
	
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/StartButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/StartButtonBasic.png"));
	private ImageIcon finishButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/FinishButtonEntered.png"));
	private ImageIcon finishButtonBasicImage = new ImageIcon(Main.class.getResource("../images/FinishButtonBasic.png"));
	
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftbuttonentered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftbuttonbasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightbuttonentered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightbuttonbasic.png"));
	
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/heroes tonight title image.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/Introbackground.jpg")).getImage();
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/heroes tonight start image.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton quitButton = new JButton(new ImageIcon(Main.class.getResource("../images/quitButton.png")));
	
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton finishButton = new JButton(finishButtonBasicImage);
	
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	
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
		
		//quitButton 생성
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
		
		//leftButton 생성
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 120, 120);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			//마우스를 leftbutton위에 올려놨을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			//마우스를 leftbutton위에서 땠을 때 이벤트
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			//마우스로 leftbutton을 클릭했을 때 콘솔창 종료
			public void mousePressed(MouseEvent e) {
				//왼쪽 버튼 이벤트
			}
		});
		add(leftButton);
		
		//rightButton생성
		rightButton.setVisible(false);
		rightButton.setBounds(1040, 310, 120, 120);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			//마우스를 rightButton위에 올려놨을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			//마우스를 rightButton위에서 땠을 때 이벤트
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			//마우스로 rightButton을 클릭했을 때 콘솔창 종료
			public void mousePressed(MouseEvent e) {
				//오른쪽 버튼 이벤트
			}
		});
		add(rightButton);
		
		//startButton 생성
		startButton.setBounds(40, 150, 393, 200);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			//마우스를 startbutton위에 올려놨을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			//마우스를 startbutton위에서 땠을 때 이벤트
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			//마우스로 startbutton을 클릭했을 때 이벤트
			public void mousePressed(MouseEvent e) {
				//게임시작 이벤트
				startButton.setVisible(false);//시작버튼이 안보이게 하는 것
				finishButton.setVisible(false);//마찬가지
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/Mainbackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		//finishButton 생성
		finishButton.setBounds(40, 400, 393, 200);
		finishButton.setBorderPainted(false);
		finishButton.setContentAreaFilled(false);
		finishButton.setFocusPainted(false);
		finishButton.addMouseListener(new MouseAdapter() {
			//마우스를 finishButton위에 올려놨을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				finishButton.setIcon(finishButtonEnteredImage);
				finishButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			//마우스를 startbutton위에서 땠을 때 이벤트
			@Override
			public void mouseExited(MouseEvent e) {
				finishButton.setIcon(finishButtonBasicImage);
				finishButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			//마우스로 finishButton을 클릭했을 때 이벤트
			public void mousePressed(MouseEvent e) {
				//게임종료 이벤트
				System.exit(0);
			}
		});
		add(finishButton);
		
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
		g.drawImage(background, 0, 0, null);
		if(isMainScreen)//ismainscreen값이 true일 때 이미지 생성해주는 코드
		{
			//어떤 움직임을 보여주는 이미지는 이 이미지 함수를 이용해 표현
			g.drawImage(selectedImage, 290, 150, null);
			g.drawImage(titleImage, 310, 500, null);
		}
		paintComponents(g);//항상 고정된 이미지를 추가할 때 사용하는 것(add가 된 부분이 paintcomponent에 의해 보여지는 것
		this.repaint();
	}
}
