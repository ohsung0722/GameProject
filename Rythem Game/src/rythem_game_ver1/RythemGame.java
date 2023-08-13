
package rythem_game_ver1;

import javax.swing.JFrame;

public class RythemGame extends JFrame{

	public RythemGame() {
		setTitle("Rythem Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
