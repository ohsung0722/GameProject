package inheritance;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HybridInheritance {

	public static void main(String[] args) {
		JFrame frame=new JFrame("Java Programming");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel primary= new JPanel();
		primary.setBackground(Color.green);
		primary.setPreferredSize(new Dimension(300,100));
		JTextField text1=new JTextField("Enter your name");
		JTextField text2=new JTextField("Enter your city");
		JTextField text3=new JTextField("Enter your age");
		primary.add(text1);
		primary.add(text2);
		primary.add(text3);
		frame.add(primary);
		frame.pack();
		frame.setVisible(true);
	}

}
