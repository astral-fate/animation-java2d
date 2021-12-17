package javaapplication1;

import java.awt.*;
import javax.swing.*;
public class MovingSquare extends JFrame
{
    public MovingSquare()
    {
        setTitle("Moving Square");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new SquarePanel();
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String s[])
    {
        new MovingSquare();
    }
}
class SquarePanel extends JPanel implements Runnable
{
    int x = 50;
    int y = 50;
    public SquarePanel()
    {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(200, 50, Color.RED, 400,
                100, Color.BLUE, false);
        g2.setPaint(gp);
        g2.fillRect(x, y, 200, 200);
    }
    public void run()
    {
        boolean increasing = true;
        while (true)
        {
            if (x < 400 && increasing)
                x += 1;
            else
            {
                x -= 1;
                increasing = false;
                if (x < 50)
                    increasing = true;
            }
            repaint();
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
    }
}
