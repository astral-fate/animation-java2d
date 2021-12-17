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
class JApp1Panel extends JPanel implements ActionListener{
      Point2D.Double[] pts = new Point2D.Double[1200];

  AffineTransform rotH = new AffineTransform();
  AffineTransform rotM = new AffineTransform();
  AffineTransform rotS = new AffineTransform();
  

public JApp1Panel(){
   setPreferredSize(new Dimension(640,480));
   Timer timer = new Timer(500, (ActionListener) this);
   timer.start();
    
    setPreferredSize(new Dimension(640, 480));
    setBackground(Color.gray);
    //cellular
        setPreferredSize(new Dimension(400, 400));
    setBackground(Color.white);
    

  


}
    /*  @Override
      public void run() {
    while(true) {
      for (int i = 0; i < pts.length; i++) {
        double x = pts[i].getX();
        double y = pts[i].getY();
        y += 0.1*Math.random();
        if (y > 1) {
          y = 0.3*Math.random();
          x = Math.random();
        }
        pts[i].setLocation(x, y);
      }
      repaint();
      try {
        Thread.sleep(100);
      } catch (InterruptedException ex) {}
    }
  }  */

  @Override
  public void actionPerformed(ActionEvent e) {
      
    UpdateClock();
    repaint();
  }

  @Override
  public void paintComponent(Graphics g){
super.paintComponent(g);
Graphics2D g2=(Graphics2D) g;
DrawAnimatedClock(g2);
  }
  
  
  
public void UpdateClock()
{
    int hour = Calendar.getInstance().get(Calendar.HOUR);
    int min = Calendar.getInstance().get(Calendar.MINUTE);
    int sec = Calendar.getInstance().get(Calendar.SECOND);
    rotH.setToRotation(Math.PI * (hour+min/60.0)/6.0);
    rotM.setToRotation(Math.PI * min /30.0);
    rotS.setToRotation(Math.PI * sec /30.0);
}
public void DrawAnimatedClock(Graphics2D g2)
{
    g2.translate(320,240);
// clock face
    Paint paint = new GradientPaint(-150,-150,Color.white,150,150,Color.gray);
    g2.setPaint(paint);
    g2.fillOval(-190, -190, 380, 380);
    g2.setColor(Color.gray);
    g2.drawString("Java 2D", -20, 80);
    Stroke stroke = new BasicStroke(3);
    g2.setStroke(stroke);
    g2.drawOval(-190, -190, 380, 380);
    for (int i = 0; i < 12; i++) {
      g2.rotate(2*Math.PI/12);
      g2.fill3DRect(-3, -180, 6, 30, true);
    }
    // clock hands
Shape hour = new Line2D.Double(0, 0, 0, -80);
    hour = rotH.createTransformedShape(hour);
    Shape minute = new Line2D.Double(0, 0, 0, -120);
    minute = rotM.createTransformedShape(minute);
    Shape second = new Line2D.Double(0, 0, 0, -120);
    second = rotS.createTransformedShape(second);
g2.setColor(Color.black);
    g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    g2.draw(hour);
    g2.draw(minute);
    g2.setStroke(new BasicStroke(2));
    g2.draw(second);
}

}// end of JApp1Panel class
