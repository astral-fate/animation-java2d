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
