package bouncing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame{
	public Game() {
		super("弹球游戏");
		Box verticall=Box.createVerticalBox();
	
		Icon icon=new ImageIcon("ball.png");
		JLabel label=new JLabel(icon);
		verticall.add(label);
		verticall.add(Box.createVerticalStrut(20));
		JButton start=new JButton("  开始游戏  ");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BouncingBall bouncingball = new BouncingBall();
				//bouncingball.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		verticall.add(start);
		verticall.add(Box.createVerticalStrut(20));
		JButton exit=new JButton("      退出       ");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		verticall.add(exit);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		c.add(verticall);
		setSize(300,300);
		setVisible(true);
	}
	 public static void main(String args[]) {
	      Game application = new Game();
	      application.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   }
}
