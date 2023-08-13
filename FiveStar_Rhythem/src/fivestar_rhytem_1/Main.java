package fivestar_rhytem_1;

public class Main {
	
	//public static -> 모든 프로젝트 내부에서 공유할 수 있는 변수라는 뜻
	//final -> 한번 선언되면 다시는 변하지 않는 상수라는 뜻
	//한번 선언되면 변하지 않는 상수는 변수를 설정할 때 전부 대문자를 사용해 작성한다
	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 720;
	//우리의 프로그램의 해상도가 1200 * 720이라는 뜻
	public static void main(String[] args) {
		
		new FivestarRhythem();
	}

}
