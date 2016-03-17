import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random aleatorio;
    private ArrayList<BouncingBall> listaBolas; 

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        aleatorio = new Random();
        listaBolas = new ArrayList<>();
    }

    /**
     * Simulate a bouncing balls
     */
    public void bounce(int bolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        int posX = 40;
        int posY = 40;
        int radio = 15;

        for(int i =0;i<bolas;i++)
        {
            BouncingBall ball = new BouncingBall(15, posX,posY,Color.BLUE,ground, myCanvas);
            listaBolas.add(ball);
            ball.draw();
            posX=posX+10;
            posY= posY+10;
            radio = radio+10;
        }

        // make them bounce
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);

            for(int i = 0 ;i< listaBolas.size();i++)
            {   

                listaBolas.get(i).move();
                if(listaBolas.get(i).getXPosition() >= 550) 
                {
                    finished = true;
                }

            }

            
        }

    }
}
