/**
 * CatSocialAgent
 * Bryan Thiam
 * project 5
 * Prof. Max Bender
 * Prof. Hannah Wolfe
 * 3/31/2022
 */
import java.awt.Color;
import java.awt.Graphics;
public class CatSocialAgent extends SocialAgent {
    int category;

    public CatSocialAgent(double x0, double y0, int radius, int cat){
        super(x0, y0, radius);
        category = cat;
    }

    public int getCategory(){
        return category;
    }

    public String toString(){
        String b = "";
        if(category != 0){
            String v = "Category is: " + category;
            b += v;
        }
        return b;
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
            g.setColor(Color.blue);
            g.fillOval(xVal, yVal, radiusValue, 6);
        } else{
            // if agent moves then sets circles color to red
            g.setColor(Color.red);
            g.fillOval(xVal, yVal, radiusValue, 6);   
        }
    }

    public void updateState(Landscape scape){
        // radius sensitivity
        double radius = 35;

        boolean sameCatSocialAgent = false;

        int firstCounter = 0;
        int secondCounter = 0;

        // Foreach to loop through the agents and see which in the same category
        for(Agent agent : scape.getNeighbors(getX(), getY(), radius)){
            CatSocialAgent newAgent = (CatSocialAgent) agent;
            if(newAgent.getCategory() == getCategory()){
                firstCounter++;
            } else{
                secondCounter++;
            }
        }

        // If there are more than 2 neighbors are categorized the same then there shall be 1% of movement
        if(scape.getNeighbors(getX(), getY(), radius).size() >= 2 && firstCounter > scape.getNeighbors(getX(), getY(), radius).size()/2){
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
}
