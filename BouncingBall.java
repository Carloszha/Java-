// Exercise 23.10 Solution: BouncingBall.java
// Program bounces a ball around a JPanel.
package bouncing;
import javax.swing.JFrame;

public class BouncingBall extends JFrame {
   private final BallPanel ballCanvas; // JPanel in which ball bounces

   public BouncingBall() {
	   
      ballCanvas = new BallPanel(this); // create new BallPanel
      add(ballCanvas); // add BallPanel to JFrame

      pack(); // make window just large enough for its GUI
      setVisible(true); // show window
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
