 package fivestar_beat_11;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	
	private ImageIcon gameStartButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/gamestartbuttonentered.png"));
	private ImageIcon gameStartButtonBasicImage = new ImageIcon(Main.class.getResource("../images/gamestartbuttonbasic.png"));
	
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backbuttonentered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backbuttonbasic.png"));
	
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/Introbackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton quitButton = new JButton(new ImageIcon(Main.class.getResource("../images/quitButton.png")));
	
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton finishButton = new JButton(finishButtonBasicImage);
	
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	private JButton gameStartButton= new JButton(gameStartButtonBasicImage);
	
	private JButton backButton= new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;//게임 화면으로 넘어왔는지에 대한 변수
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("introMusic.mp3", true);

	
	private int nowSelected = 0;
	
	public static Game game = new Game();
	
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
		
		addKeyListener(new KeyListener());
		introMusic.start();
		 
		trackList.add(new Track("heroes tonight title image.png", 
				"heroes tonight start image.jpg", 
				"heroes tonight game image.jpg", 
				"Janji - Heroes Tonight (feat. Johnning).mp3", 
				"Janji - Heroes Tonight (feat. Johnning).mp3"));
		trackList.add(new Track("My heart title image.png", 
				"my heart start image.jpg", 
				"my heart game image.jpg", 
				"Different Heaven & EH!DE - My Heart.mp3", 
				"Different Heaven & EH!DE - My Heart.mp3"));
		trackList.add(new Track("invincible title image.png", 
				"invincible start image.jpg", 
				"invincible game image.jpg", 
				"DEAF KEV - Invincible.mp3", 
				"DEAF KEV - Invincible.mp3"));
		
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
				selectLeft();
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
				selectRight();
			}
		});
		add(rightButton);
		
		//gameStartButton생성
		gameStartButton.setVisible(false);
		gameStartButton.setBounds(520, 620, 250, 67);
		gameStartButton.setBorderPainted(false);
		gameStartButton.setContentAreaFilled(false);
		gameStartButton.setFocusPainted(false);
		gameStartButton.addMouseListener(new MouseAdapter() {
			//마우스를 gameStartButton위에 올려놨을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				gameStartButton.setIcon(gameStartButtonEnteredImage);
				gameStartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			//마우스를 gameStartButton위에서 땠을 때 이벤트
			@Override
			public void mouseExited(MouseEvent e) {
				gameStartButton.setIcon(gameStartButtonBasicImage);
				gameStartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			//마우스로 gameStartButton을 클릭했을 때 콘솔창 종료
			public void mousePressed(MouseEvent e) {
				//start버튼 클릭 후 이벤트
				gameStart(nowSelected);
			}
		});
		add(gameStartButton);
		
		//backButton생성
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			//마우스를 gameStartButton위에 올려놨을 때 이벤트
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			//마우스를 gameStartButton위에서 땠을 때 이벤트
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			//마우스로 gameStartButton을 클릭했을 때 콘솔창 종료
			public void mousePressed(MouseEvent e) {
				//뒤로가기 이벤트(메인화면으로 돌아가기)
				backMain();
			}
		});
		add(backButton);

		
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
				enterMain();
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
		
		
		
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen)//ismainscreen값이 true일 때 이미지 생성해주는 코드
		{
			//어떤 움직임을 보여주는 이미지는 이 이미지 함수를 이용해 표현
			g.drawImage(selectedImage, 290, 150, null);
			g.drawImage(titleImage, 310, 500, null);
		}
		if(isGameScreen)
		{
			//그래픽변수 g 넣어줌
			game.screenDraw(g);
		}
		paintComponents(g);//항상 고정된 이미지를 추가할 때 사용하는 것(add가 된 부분이 paintcomponent에 의해 보여지는 것
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
		{
			//어떠한 곡이 실행되고 있다면 바로 닫아주는 코드
			selectedMusic.close();
		}
		//현재 선택된 트랙(즉, 곡)이 가지고 있는 titleimage값을 가져와서 넣어줌
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		//현재 선택된 곡의 이미지를 그 트랙의 곡 이미지로 바꾸어줌
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;//메인화면이 아님을 알려줌
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		gameStartButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		setFocusable(true);
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		gameStartButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}
	
	public void enterMain() {
		startButton.setVisible(false);//시작버튼이 안보이게 하는 것
		finishButton.setVisible(false);//마찬가지
		background = new ImageIcon(Main.class.getResource
				("../images/Mainbackground.jpg")).getImage();
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		gameStartButton.setVisible(true);
		isMainScreen = true;
		introMusic.close();
		selectTrack(0);
	}
}
