package fivestar_beat_13;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	@Override
	//키를 눌렀을 때 어떠한 키를 눌렀는지 전반적인 것 감지
	public void keyPressed(KeyEvent e) {
		if(FiveStarBeat.game == null)
			return;
		if(e.getKeyCode() == KeyEvent.VK_S) {
			FiveStarBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			FiveStarBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			FiveStarBeat.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			FiveStarBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			FiveStarBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			FiveStarBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			FiveStarBeat.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(FiveStarBeat.game == null)
			return;
		if(e.getKeyCode() == KeyEvent.VK_S) {
			FiveStarBeat.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			FiveStarBeat.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			FiveStarBeat.game.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			FiveStarBeat.game.releaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			FiveStarBeat.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			FiveStarBeat.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			FiveStarBeat.game.releaseL();
		}
	}
}
