import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.*;

public class MyMouseListener2 extends MouseAdapter {
   private LoadaColorGrid loadacolorGrid;
  

   public MyMouseListener2(LoadaColorGrid loadacolorGrid) {
      this.loadacolorGrid = loadacolorGrid;
   }

   @Override
   public void mousePressed(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON1) {
         loadacolorGrid.labelPressed((JLabel)e.getSource());
      }
      
      else if (e.getButton() == MouseEvent.BUTTON3) {
         MyColor[][] myColors = loadacolorGrid.getMyColors();
         for (int row = 0; row < myColors.length; row++) {
            for (int col = 0; col < myColors[row].length; col++) {
               System.out.print(myColors[row][col] + " ");
            }
            System.out.println();
         }
         System.out.println();
      } 
      
      
      else if (e.getButton() == MouseEvent.BUTTON2) {
    	  
		  String myfile = JOptionPane.showInputDialog("What would you like to name the file? Be sure it is a .txt file!!!!");
    	  
    	  Writer writer = null;

    	  try {
    	      writer = new BufferedWriter(new OutputStreamWriter(
    	            new FileOutputStream(myfile), "utf-8"));
	            MyColor[][] myColors = loadacolorGrid.getMyColors();
	            for (int row = 0; row < myColors.length; row++) {
	               for (int col = 0; col < myColors[row].length; col++) {
	              	 writer.write(myColors[row][col] + " ");
	                  System.out.print(myColors[row][col] + " ");
	               }
	               writer.write(System.getProperty("line.separator"));
	               System.out.println();
	            }
	               writer.write(System.getProperty("line.separator"));
	            System.out.println();

    	  } catch (IOException ex) {
    	    // report
    	  } finally {
    	     try {writer.close();} catch (Exception ex) {}
    	  }
    	      	  
    	  System.out.println("Button pressed");
      }
       }
    	  
      }