import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
/**
 * @author mxn5054
 */
interface Callback{
void callback();
}
public class Racer extends Thread {
    //variable declaration  
    private RacerApplet myApplet;
    private Image animal;
    private int racerID;
    private JPanel myPanel;
    private int x=1,place=0;
    private String type ="";
    
    public Racer(String img, int id, RacerApplet a, JPanel p){//Constructor declaration
        this.animal = Toolkit.getDefaultToolkit().getImage(img);
        myApplet = a;
        racerID = id;
        myPanel = p;
    }//end Racer Constructor
    public Racer(RacerApplet a) {
        myApplet = a;
    }
    Racer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       /**
     *  run() is the thread's primary method. It runs while the racers x position is 
     *  less than 1000. This version has each thread sleep
     *  for a random interval. This will cause the threads
     *  to run at random speeds.
     */
   @Override
    public void run() {
        while (x < 1000) {//races reaches the finsih when x=1000
            try {
                Thread.sleep((int)(Math.random() * 65));//random number generation to determine "speed" of gif
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            draw();//redraws the screen/race
            x = x + 10; // change x value to move across the track   
        } // while
        if(this.x>=1000){//check if racer position equals the end of the race
             if(this.racerID==1)//check for the racerID to set racer for results
                 this.type="Bird";
             else if(this.racerID==2)
                 this.type="Ram";
             else if(this.racerID==3)
                 this.type="Bunny";
             else if(this.racerID==4)
                 this.type="Dino";
             else
                 this.type="Horse";
         }//end if x>1000
        myApplet.getResult(type);//call getResults to save results
    } // run()
  public void draw(){
      try{
          Graphics g = myPanel.getGraphics();
          g.drawImage(animal, x, 10, myApplet);//draws the image      
      }//end try
      catch (NullPointerException e) {
          System.out.println(e.getMessage());
      }//end catch
    }//end draw
}//end Racer
