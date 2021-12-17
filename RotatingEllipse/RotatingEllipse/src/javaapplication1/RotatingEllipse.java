package javaapplication1;

import java.awt.*;// Using AWT's Graphics
import java.awt.geom.*;// Using AWT's geometric shapes
import java.awt.event.*;// Using AWT's events
import javax.swing.*;// Using Swing's components and containers
public class RotatingEllipse extends JFrame
{
    public RotatingEllipse()
    {
        setTitle("Rotating Ellipse");
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new EllipsePanel();
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String s[])
    {
        new RotatingEllipse();
    }
}
class EllipsePanel extends JPanel implements ActionListener
{
    int rotationAngle = 0;
    public EllipsePanel()
    {
        Timer timer = new Timer(100, this);
        timer.start();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.YELLOW);
        Ellipse2D ellipse = new Ellipse2D.Double(100, 140, 200, 120);
        AffineTransform at = new AffineTransform();
        at.setToRotation(Math.toRadians(rotationAngle), 200, 200);
        g2.fill(at.createTransformedShape(ellipse));
    }
    public void actionPerformed(ActionEvent e)
    {
        rotationAngle++;
        repaint();
    }
}
