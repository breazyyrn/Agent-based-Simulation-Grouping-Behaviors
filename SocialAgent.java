/**
 * SocialAgent
 * Bryan Thiam
 * project 5
 * Prof. Max Bender
 * Prof. Hannah Wolfe
 * 3/31/2022
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class SocialAgent extends Agent{
    boolean moved;
    int radiusValue;
    public Random randomVal = new Random();

    public SocialAgent(double x0, double y0, int radius){
        super(x0, y0);
        radiusValue = radius;
    }

    public void setRadius(int radius){
        radiusValue = radius;
    }

    public int getRadius(){
        return radiusValue;
    }

    public void draw(Graphics g){
        double xCorData = xPos;
        double yCorData = yPos;

        // This converts the xPos and yPos double values into Integers
        int xVal = (int)xCorData;
        int yVal = (int)yCorData;

        g.drawOval(xVal, yVal, radiusValue, 6);

        // if agent moves then sets circles color to blue
        if (moved == true){
            g.setColor(Color.BLUE);
            g.fillOval(xVal, yVal, radiusValue, 6);
        } else{
            // if agent moves then sets circles color to red
            g.setColor(Color.RED);
            g.fillOval(xVal, yVal, radiusValue, 6);   
        }
    }

    public void updateState(Landscape scape){
        double radius = 35; // radius sensitivity used 
        // IF there are more than 3 neighbors within the List only move up by 1% at a time
        if(scape.getNeighbors(getX(), getY(), radius).size() > 3){
            if (randomVal.nextDouble() < 0.1){
                // sets moved to true
                moved = true;
                Double offSetX = randomVal.nextDouble() * 20 - 10;
                Double offSetY = randomVal.nextDouble() * 20 - 10;

                Double newXCor = getX() + offSetX;
                Double newYCor = getY() + offSetY;

                setX(newXCor);
                setY(newYCor);
             }else{
                 moved = false;
             }
            return;
        } else {
            moved = true;
            Double offSetX = randomVal.nextDouble() * 20 - 10;
            Double offSetY = randomVal.nextDouble() * 20 - 10;
            Double newXCor = getX() + offSetX;
            Double newYCor = getY() + offSetY;
            setX(newXCor);
            setY(newYCor);
        }
    }

    public static void main(String[] args){
        SocialAgent bryAgent = new SocialAgent(5, 5, 10);
        System.out.println("Agent your X position is: " + bryAgent.getX() +
        " & your Y position is " + bryAgent.getY());
        System.out.println(bryAgent.toString());
        System.out.println(bryAgent.radiusValue);
        bryAgent.setRadius(10);
        System.out.println(bryAgent.radiusValue);
    }
}
