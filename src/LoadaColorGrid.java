import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import java.io.*;
import java.nio.charset.Charset;

@SuppressWarnings("serial")
public class LoadaColorGrid extends JPanel {
   private MyColor[][] myColors;
   private JLabel[][] myLabels;

   public LoadaColorGrid(int rows, int cols, String filename, int width) throws IOException {
	   

	   
	   BufferedReader reader = new BufferedReader(new FileReader(filename));
	   rows = 0;
	   while (reader.readLine() != null) rows++;
	   rows = rows-1;
	   System.out.println("made it here" + " " + rows);
	   reader.close();
	   
       Charset encoding = Charset.defaultCharset();
           File file = new File(filename);
       try (InputStream in = new FileInputStream(file);
            Reader reader1 = new InputStreamReader(in, encoding);
            // buffer for efficiency
            Reader buffer = new BufferedReader(reader)){

       int r;
       int numofchars = 0;
       char[] chararray;
       chararray = new char[20000];
       while ((r = reader1.read()) != -1) {
           char ch = (char) r;
           if (ch == 'b' || ch == 'r' || ch == 'g' || ch == 'a' ) {
           System.out.println("Do something with " + ch);
           chararray[numofchars] = ch;
           numofchars++;
           }
       }
       System.out.println(chararray);
       cols = numofchars/rows;
       System.out.println(cols);
       System.out.println(rows);
       System.out.println(numofchars);
	   
	   	   
      myColors = new MyColor[rows][cols];
      myLabels = new JLabel[rows][cols];

      MyMouseListener2 myListener = new MyMouseListener2(this);
      Dimension labelPrefSize = new Dimension(width, width);
      setLayout(new GridLayout(rows, cols));
      int tracker = 0;
      for (int row = 0; row < myLabels.length; row++) {
         for (int col = 0; col < myLabels[row].length; col++) {
         	char color = chararray[tracker];
        	System.out.println("Made it here" + " " + tracker + " " + color);
        	tracker++;
            JLabel myLabel2 = new JLabel();
            myLabel2 = new JLabel();
            myLabel2.setOpaque(true);
            
            if(color == 'g'){
            MyColor myColor = MyColor.GREEN;
            myColors[row][col] = myColor;
            myLabel2.setBackground(myColor.getColor());
            myLabel2.addMouseListener(myListener);
            myLabel2.setPreferredSize(labelPrefSize);
            add(myLabel2);
            myLabels[row][col] = myLabel2;
            }
            
            else if(color == 'a'){
            MyColor myColor = MyColor.GRAY;
            myColors[row][col] = myColor;
            myLabel2.setBackground(myColor.getColor());
            myLabel2.addMouseListener(myListener);
            myLabel2.setPreferredSize(labelPrefSize);
            add(myLabel2);
            myLabels[row][col] = myLabel2;
            }
            
            else if(color == 'b'){
            MyColor myColor = MyColor.BLUE;
            myColors[row][col] = myColor;
            myLabel2.setBackground(myColor.getColor());
            myLabel2.addMouseListener(myListener);
            myLabel2.setPreferredSize(labelPrefSize);
            add(myLabel2);
            myLabels[row][col] = myLabel2;
            }
            
            else if(color == 'r'){
            MyColor myColor = MyColor.RED;
            myColors[row][col] = myColor;
            myLabel2.setBackground(myColor.getColor());
            myLabel2.addMouseListener(myListener);
            myLabel2.setPreferredSize(labelPrefSize);
            add(myLabel2);
            myLabels[row][col] = myLabel2;
            }
            
         }
      }
   }
   }

   public MyColor[][] getMyColors() {
      return myColors;
   }

   public void labelPressed(JLabel label) {
      for (int row = 0; row < myLabels.length; row++) {
         for (int col = 0; col < myLabels[row].length; col++) {
            if (label == myLabels[row][col]) {
               MyColor myColor = myColors[row][col].next();
               myColors[row][col] = myColor;
               myLabels[row][col].setBackground(myColor.getColor());
            }
         }
      }
   }
}