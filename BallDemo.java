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

        for(int i =0;i<bolas;i++)
        {
            int r = aleatorio.nextInt(256);
            int g = aleatorio.nextInt(256);
            int b = aleatorio.nextInt(256);
            Color colorAleatorio = new Color(r,g,b);
            //las bolas se crean en un espacio maximo de 50
            BouncingBall ball = new BouncingBall(aleatorio.nextInt(50), aleatorio.nextInt(100), aleatorio.nextInt(100),colorAleatorio,ground, myCanvas);
            listaBolas.add(ball);
            ball.draw();
        }

        // make them bounce
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);

            for(int i = 0 ;i< listaBolas.size();i++)
            {   
                listaBolas.get(i).move();
                if(listaBolas.get(i).getXPosition() >= 550) ///la animacion termina
                {
                    finished = true;
                }
            }
        }

    }
}
