/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Random;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.Calendar;

/**
 *
 * @author eid.emary
 */
public class JavaApplication1 extends JApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame=new JFrame();
        frame.setTitle("hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applete =new JavaApplication1();
        applete.init();
        frame.getContentPane().add(applete);
        frame.pack();
        frame.setVisible(true);
    }
    @Override
    public void init(){
        JPanel panel=new JApp1Panel();
        getContentPane().add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
class JApp1Panel extends JPanel implements ActionListener/*, Runnable*/{
  //Cellular
  int n = 30;
  boolean[][] cells1;
  boolean[][] cells2;
//cellular      

public JApp1Panel(){
   setPreferredSize(new Dimension(640,480));
   Timer timer = new Timer(500, (ActionListener) this);
   timer.start();
    
    setPreferredSize(new Dimension(640, 480));
    setBackground(Color.gray);
    //cellular
        setPreferredSize(new Dimension(400, 400));
    setBackground(Color.white);
    cells1 = new boolean[n][n];
    cells2 = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cells1[i][j] = Math.random() < 0.1;
        cells2[i][j] = false;
      }
    }

    //endof cellular
 


}

  @Override
  public void actionPerformed(ActionEvent e) {
      
    //UpdateClock();
    UpdateCellular();
    repaint();
  }
public void UpdateCellular()
{
    boolean[][] cells = cells1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cells2[i][j] = cells[i][j];
        int nb = neighbors(cells, i, j);
        if (nb == 3)
          cells2[i][j] = true;
        if (nb < 2 || nb > 3)
          cells2[i][j] = false;
      }
    }
    
    cells1 = cells2;
    cells2 = cells;
}
  @Override
  public void paintComponent(Graphics g){
super.paintComponent(g);
Graphics2D g2=(Graphics2D) g;
PaintCellular(g2);

  }
  public void PaintCellular(Graphics2D g2)
  {
          g2.setColor(Color.lightGray);
    int p = 0;
    int c = 16;
    int len = c*n;
    for (int i = 0; i <= n; i++) {
      g2.drawLine(0, p, len, p);
      g2.drawLine(p, 0, p, len);
      p += c;
    }
    g2.setColor(Color.black);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (cells1[i][j]) {
          int x = i*c;
          int y = j*c;
          g2.fillOval(x, y, c, c);
        }
      }
    }
  }
  
  
  
private int neighbors(boolean[][] cells, int x, int y) {
    int x1 = (x>0)?x-1:x;
    int x2 = (x<n-1)?x+1:x;
    int y1 = (y>0)?y-1:y;
    int y2 = (y<n-1)?y+1:y;
    int count = 0;
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        count += (cells[i][j])?1:0;
      }
    }
    if (cells[x][y]) count--;
    return count;
  }
}// end of JApp1Panel class
