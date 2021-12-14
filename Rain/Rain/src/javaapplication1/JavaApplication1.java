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
class JApp1Panel extends JPanel implements Runnable{




      Point2D.Double[] pts = new Point2D.Double[1200];
  public JApp1Panel() {


    setPreferredSize(new Dimension(640, 480));

    setBackground(Color.gray);


    for (int i = 0; i < pts.length; i++) {
      pts[i] = new Point2D.Double(Math.random(), Math.random());
    }
    Thread thread = new Thread(this);
    thread.start();  

  }  

    @Override

        public void run () {
            while (true) {
                for (int i = 0; i < pts.length; i++) {
                    double x = pts[i].getX();
                    double y = pts[i].getY();
                    y += 0.1*Math.random ();
                    if (y > 1) {
                        y = 0.3*Math.random ();
                        x = Math.random ();
                        pts[i].setLocation (x, y);
                        repaint ();
                        try {
                            Thread.sleep(100);
                        }
                        catch (InterruptedException ex) {}  }
                        }
                               }
                                    }


                public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.white);
    for (int i = 0; i < pts.length; i++) {
      int x = (int)(640*pts[i].x);
      int y = (int)(480*pts[i].y);
      int h = (int)(25*Math.random());
      g.drawLine(x, y, x, y+h);



    }




  }


  
}// end of JApp1Panel class
