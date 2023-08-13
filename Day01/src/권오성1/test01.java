package 권오성1;
import java.awt.*;
import javax.swing.*;
public class test01 {
	public static void main(String[] args){
		JFrame frame = new JFrame("Nested Panels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inclusion of image
		ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop\\과제\\java\\다운로드 (1).jfif");
		
		//change Image size (icon_subpanel2 -> updateIcon)
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(400, 500, Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg);
		
        
		//Setup first panel
		JPanel subpanel1=new JPanel();
		subpanel1.setPreferredSize(new Dimension(150,300));
		subpanel1.setBackground(Color.green);
		
		//Creation of label
		JLabel label1=new JLabel ("First Panel", SwingConstants.CENTER);
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setVerticalTextPosition(SwingConstants.CENTER);
		subpanel1.add(label1);
		//Setup Second panel
		JPanel subpanel2= new JPanel ();
		subpanel2.setPreferredSize(new Dimension(200,600));
		subpanel2.setBackground(Color.cyan);
		
		//Creation of Label
		JLabel label2=new JLabel ("Second Panel" ,SwingConstants.CENTER);
		label2.setHorizontalTextPosition(SwingConstants.CENTER);
		label2.setVerticalTextPosition(SwingConstants.TOP);
		subpanel2.add(label2);
		subpanel2.add(subpanel1);
		//Setup Third panel
		JPanel subpanel3 = new JPanel ();
		subpanel3.setPreferredSize(new Dimension(500,600));
		subpanel3.setBackground(Color.orange);
		//Creation of Label
		JLabel label3 = new JLabel("세종대학교(Sejong University)", updateIcon, SwingConstants.CENTER);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		subpanel3.add(label3);
		
		
		
		//Set up primary panel
		JPanel primary=new JPanel();
		primary.setPreferredSize(new Dimension(800, 600));
		primary.setBackground(Color.blue);
		
		primary.add(subpanel2);
		primary.add(subpanel3);
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}
