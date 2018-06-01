// Exercise 23.10 Solution: Ball.java
// Create a ball to bounce around a JPanel.
package bouncing;
import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

public class Ball implements Runnable {
   public double x; // horizontal position of ball
   public double y; // vertical position of ball
   public double dx; // change in horizontal position of ball
   public double dy; // change in vertical position of ball
  // private final int MAX_X = 500; // horizontal edge of JPanel
 //  private final int MAX_Y = 500; // vertical edge of JPanel
   public boolean flag=true;
  
   private static final Random generator = new Random();
   public Color C; 
	
   public Ball(int xPos, int yPos) {
      dx = generator.nextInt(5) + 1; // change in x (1-5 pixels)
      dy = generator.nextInt(5) + 1; // change in y (1-5 pixels)
      x = xPos; // set ball to horizontal position of mouse press
      y = yPos; // set ball to vertical position of mouse press
   }

   // bounces ball perpetually until window is closed
   public void run() {
      while (flag)  {// infinite loop {
         try {
            Thread.sleep(30); // sleep for 20 milliseconds
         }
         // process InterruptedException during sleep
         catch (InterruptedException exception) {
            exception.printStackTrace();
         } 
           if(((x>=BallPanel.MAX_X-BallPanel.BALL_SIZE-16)&&(x<=BallPanel.MAX_X)&&(y>=BallPanel.board1-100)&&(y<=BallPanel.board1))
					 ||((x<=20)&&(x>=0)&&(y>=BallPanel.MAX_Y-BallPanel.board2)&&(y<=BallPanel.MAX_Y-BallPanel.board2+100))){  
        	 dx=-dx;
        	 BallPanel.c++;
			 } 
         else if((y>=0)&&(y<=20)&&(x>=BallPanel.MAX_Y-BallPanel.board2)&&(x<=BallPanel.MAX_Y-BallPanel.board2+100)
					 ||((y>=BallPanel.MAX_Y-BallPanel.BALL_SIZE-18)&&(y<=BallPanel.MAX_Y)&&(x>=BallPanel.board2-100-5)&&(x<=BallPanel.board2+5))){  
        	 dy=-dy; 
        	 BallPanel.c++;
        	 } 
         else if((x<20)||(x>BallPanel.MAX_X-20)||(y<20)||(y>BallPanel.MAX_Y-20)){  
        	 
        	 for(int i=0;i<BallPanel.ballarray.size();i++) {
        		 BallPanel.ballarray.get(i).flag=false;
        	 } 
        	 JOptionPane.showMessageDialog(BallPanel.parentWindow, "Game Over"+"\n"+"你的得分："+ BallPanel.c,"提示", JOptionPane.INFORMATION_MESSAGE);
		     BallPanel.parentWindow.dispose();
		     BallPanel.c=0;
        	 BallPanel.ballarray.clear();
        	 BallPanel.count=0;
        	 
			 } 
         x += dx; // determine new x-position 
         y += dy; // determine new y-position

         
         /*// if bounce off top or bottom of JPanel
         if (y <= 0 || y >= MAX_Y - 10) {
            dy = -dy; // reverse velocity in y direction
         }

         // if bounce off left or right of JPanel
         if (x <= 0 || x >= MAX_X - 10) {
            dx = -dx; // reverse velocity in x direction
         }*/
      }  
    }
  
   

   // get horizontal position of ball
   public double getX() {
      return x; // return x value
   }

   // get vertical position of ball
   public double getY() {
      return y; // return y value
   }
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
