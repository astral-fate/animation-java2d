# animation-java2d
Java, java2d, animation, sleep, runable


to work with animation, we have to implement runable, from abstract class Jpanel extends runable (), as such:

           class JAppPanel extends JANELLE implements Runable{
           
           
           
           }
           
           
           
           
           
  then, for applying animation we have to define a new thread object, as such 
  
  
          Threads thread = new Threads(this);
          
          
          
          
  to work with thread, we have to use with it sleep(), which delays the thread per an amount we define ourselves as such 
  
  
  
  
             try(){
             
             
             Thread.sleep(100); 
             
             }
             
             catch(InterruptedException ex){
             
            
              
             }
