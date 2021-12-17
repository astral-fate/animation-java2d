# animation-java2d

to work with animation, we have to implement Runable, from abstract class Jpanel extends JPANLE, as such:

           class JAppPanel extends JANELLE implements Runable{
           
           
           
           }
           
           
           
           
           
  then, for applying animation we have to define a new thread object, as such 
  
  
  
  
  
  
  
  
          class JAppPanel extends JPANEL implements Runable{
          Threads thread = new Threads(this);
          thread.start()
                         }
          
          
  to work with thread, we have to use with it sleep(), which delays the thread per an amount we define ourselves as such:
  
  
  
  
             try(){
             
             
             Thread.sleep(100); 
             
             }
             
             catch(InterruptedException ex){
             ex.getMessage();
            
              
             }
             
             
 Examples: 
 
 Write a java code to draw a square with non-cyclic diagonal gradient paint

from red to blue moving slowly from left to right, then returns back from right 

to left.




we first define the class runnable, and the try catch statement


              Class JAppPanel extends JPANEL implement Runnable() {
               Thread thread = new Thread();
               thread.start()
               
               }
               
               
     
               
               
               
               
               
now in our familiar paint Component class, we just draw a normal Rectangle, and define a new GradientPaint object.               
               
               super.paintComponent (Graphics g);
               Graphics2D g2 = (Graphics2D) g;
               Shape rec = Rectangle2D.Double(0,0,100,200);
               GradientPaint grad = new GradientPaint(0,0 Color.red, 0,0 Color.Blue, 0,0, false);
               g2.setPaint(grad);
               g2.fill(rec);
               


now we want the Rectangle to move from right to left, so we have to change the value of x, so it can horizontally change value, without changing the value of y, so for this reason, we have to define a new variable for x, y 


                int x =50;
                int y = 50;








and now, we want to creative a for loop to change the value of x, once it moves forward, and once it moves backwards. So we will define a new Boolean variable will name it increases, and set it to true


               
               Boolean increasing = true;
               while(true)
                       if ( x < 400  && increasing)
                       x +=1;
                        else {
                        x -=1;
                        increasing = false;
                          if (x<50)
                          increasing = true
                          }
                          repaint();
                       
                       
                       
then, since we are dealing with thread, that might run into infinite loop, we have to define out try catch statementas follows

                      try {
               Thread.sleep(100)
               
               }
               catch(InterruptedException ex){
               
              ex.getMessage();
               }
               
               
               
               
               
               
               
               
 Game of life example:
 
 
 Inorder to create a grid square system, we will be drawing number of vertical & horizintal lines, just as we learned before as follows:

        g2.translate(150,150);
        g2.drawLine(0,0, 100,0);
        g2.drawLine(0,20, 100,20);
        g2.drawLine(0,40, 100,40);
        g2.drawLine(0,60, 100,60);
        g2.drawLine(0,80, 100,80);
        g2.drawLine(0,100, 100,100);



        g2.drawLine(20,0, 20,100);
        g2.drawLine(40,0, 40,100);
        g2.drawLine(60,0, 60,100);
        g2.drawLine(80,0, 80,100);
        g2.drawLine(100,0, 100,100);
        g2.drawLine(0,0, 0,100);
        
        

![image](https://user-images.githubusercontent.com/63984422/146608728-e9a2f3c8-4d33-46a5-97f5-3d4b8efe59e4.png)




This method works. Only that it would take lots of time to draw number of lines. We noticed that we have repated the number (100), both in x and y coordinates. 
Another way to represent it is to refer to it as the wideth value, for x, and the hight value, for y. so our code will look something like this:




                     
        int width = 100;
        int hight=100; 
        
        
        g2.translate(150,150);
        g2.drawLine(0, 0, width, 0);
        g2.drawLine(0, 20, width, 20);
        g2.drawLine(0, 40, width, 40);
        g2.drawLine(0, 60, width, 60);
        g2.drawLine(0, 80, width, 80);
        g2.drawLine(0, 100, width, 100);



        g2.drawLine(20,0, 20,height);
        g2.drawLine(40,0, 40,height);
        g2.drawLine(60,0, 60,height);
        g2.drawLine(80,0, 80,height);
        g2.drawLine(100,0, 100,height);
        g2.drawLine(0,0, 0, height);
        
     



now, we have also notcied that we increased the spaces between the rows and columns, or the cellSize, with quantm equals +20.
We can also reprsent this with a defined value as follows:


 
        int cellSize = 20;
        x = x+cellSize;
        y = y+cellSize; 
        
        
        
now to apply that every row of x, and every column of y is increased by this value. we have to create a for loop, so it draw this for us, and that as follows:


      int x = 0;
      int y =0;
      int width = 100;
      int hight=100; 
      int cellSize = 20;
      //for drawing (x,y) for the length of the grid square
      for (int i=0; i<=cellSize; i++) {
      //for drwaing the horizntal line
      g2.drawline(0,y, width, y );
      //for drawing the vertical line(0,y , width ,0 );
      g2.drawline(x, 0, x, hight);


      //for increasing x and y by the value of cell size
        x = x+cellSize;
        y = y+cellSize; 
      }
      
      
      
another way to phrase it too, instead of stating two statments; one for adding the cellSize to x, and the other to y. We can create a variable named current, intilize it to zero, then use it as the coordinates of x and y alike, then increasing its value to x and y 




        
        int current = 0;
        int cellSize = 10;
        int cellSpace = 40;
        int len = cellSapce*cellSize;
        //for drawing (x,y) for the length of the grid square
        for (int i=0; i<=cellSpace; i++) {
        //for drwaing the horizntal line
        g2.drawLine(0, current , len ,current );
        //for drawing the vertical line
        g2.drawLine(current, 0, current, len);
        //for increasing x and y by the value of cell size
        current += cellSize;
           
        }

