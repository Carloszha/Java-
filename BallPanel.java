// Exercise 23.10 Solution: BallPanel.java
// JPanel that creates a ball when the mouse is pressed.  Ball bounces
// around the JPanel.
package bouncing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.JFrame;*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.ArrayList;

public class BallPanel extends JPanel {

   public static int count=0;
   public static int c=0;
   public static ArrayList<Ball> ballarray = new ArrayList<Ball>(20);
   //private Ball[] ball= new Ball[MAX_BALL]; // bouncing ball
   private ExecutorService threadExecutor; // for running Ball runnable
   public static JFrame parentWindow; // parent window of JPanel
  
   public final static int MAX_X = 500; // horizontal edge of JPanel
   public final static int MAX_Y = 500; // vertical edge of JPanel
   private static Color[] color={Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,     
	 Color.ORANGE,Color.YELLOW,Color.RED,Color.PINK,Color.LIGHT_GRAY,Color.MAGENTA};
   private static final Random rand = new Random();   
     
   public static int  BALL_SIZE=30;    
  
   public double mouse_x=0;   
   public double mouse_y=0;   
   public static double board1=MAX_Y/2,board2=MAX_X/2;   
  
   public static Timer t1; 
   
   public BallPanel(JFrame window) {
      parentWindow = window; // set parent window of JPanel

      // create ExecutorService for running ball runnable
      threadExecutor = Executors.newCachedThreadPool();
     
      
      // anonymous inner class handles mouse events
   
      this.addMouseListener(
    		  new MouseAdapter() {
    			  public void mouseClicked(MouseEvent event) { 
     	              createBall(event); // delegate call to ball starter
     	            
     	        	 RepaintTimer timer = new RepaintTimer(parentWindow);
     	            threadExecutor.execute(timer);
     	            } 
    			  });
  	  this.addMouseMotionListener(
  			  new MouseAdapter() {
  				  public void mouseMoved(MouseEvent e) {  
  					  mouse_x=e.getX();  
  			          mouse_y=e.getY();  
  			          board1=mouse_y; 
  			          board2=mouse_y;
  			          repaint();
  			          }  
  				  });
  	  }
  
  			
   // create a ball if no ball exists and set it in motion
   private void createBall(MouseEvent event) {
	  //if(count<MAX_BALL) {
        // int x = event.getX(); // get x position of mouse press
        // int y = event.getY(); // get y position of mouse press
	     
         Ball ball=new Ball(MAX_X/2-BALL_SIZE/2,MAX_Y/2-BALL_SIZE/2);    // create new ball
         ball.C= color[rand.nextInt(color.length)]; 
         ballarray.add(ball); 
         threadExecutor.execute(ballarray.get(count)); // set ball in motion
         count++;
         //}
   }
   
   // return minimum size of animation
   public Dimension getMinimumSize() { 
      return getPreferredSize(); 
   }

   // return preferred size of animation
   public Dimension getPreferredSize() {
      return new Dimension(MAX_X, MAX_Y); 
   }

   // draw ball at current position
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
     for(int i=0;i<ballarray.size();i++) {
         g.setColor(ballarray.get(i).C); // set color 
         g.fillOval((int)ballarray.get(i).x, (int)ballarray.get(i).y, BALL_SIZE, BALL_SIZE); // draws
     }
     
	 //  g.setColor(Color.CYAN); 
	 //  g.fillOval((int)ball_x, (int)ball_y, BALL_SIZE, BALL_SIZE);  
	    g.setColor(Color.magenta);  
	    g.fillRect(0, (int)(MAX_X-board1), 20, 100);   
	    g.fillRect((int)MAX_X-20, (int)board2-100, 20, 100);
	    g.fillRect((int)(MAX_X-board1),0,100,20);
	    g.fillRect((int)board2-100,(int)MAX_Y-20,100,20);
    
   
     // if (blueBall != null)  {// if ball exists {
     
   }
}

