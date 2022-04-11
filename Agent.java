/**
 * Agent
 * Bryan Thiam
 * project 5
 * Prof. Max Bender
 * Prof. Hannah Wolfe
 * 3/31/2022
 */
import java.awt.Graphics;
public class Agent {
    double xPos;
    double yPos;

    public Agent(double x0, double y0){
        xPos = x0;
        yPos = y0;
    }

    public double getX(){
        return xPos;
    }

    public double getY(){
        return yPos;
    }

    public void setX(double newX){
        xPos = newX;
    }

    public void setY(double newY){
        yPos = newY;
    }

    public String toString(){
        String s = "";
        if (xPos != 0 && yPos !=0){
            String b = "X Position: " + xPos + ", Y Position: " + yPos;
            s += b;
        }
        return s;
    }


    public void updateState( Landscape scape ){}
    public void draw(Graphics g){}

    public static void main(String[] args){
        Agent bryAgent = new Agent(5, 10);
        System.out.println("Agent your X position is: " + bryAgent.getX() +
        " & your Y position is " + bryAgent.getY());
        System.out.println(bryAgent.toString());
    }
}
