import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



public class Main {
   private static void createAndShowGui() throws IOException {
	  String loadornew = JOptionPane.showInputDialog( "Would you like to load(enter 'load') or start a new map(enter 'new')? ");
	  if(loadornew.equals("new")) {
      int rows = 50;
      int cols = 100;
      int cellWidth = 20;
      ColorGrid mainPanel = new ColorGrid(rows, cols, cellWidth);
      

      JFrame frame = new JFrame("Color Grid");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
	  }
	  if(loadornew.equals("load")){
		  int cellWidth = 20;
		  int rows = 10;
		  int cols = 10;
		  String tobeloaded = JOptionPane.showInputDialog("What file would you like to load? Be sure it is a .txt file!!!!");
		  LoadaColorGrid loader = new LoadaColorGrid(rows, cols, tobeloaded, cellWidth);
		  JFrame frame = new JFrame("Color Grid");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().add(loader);
	      frame.pack();
	      frame.setLocationByPlatform(true);
	      frame.setVisible(true);
	  }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            try {
				createAndShowGui();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
      });
   }
}