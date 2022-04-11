/**
 * SocialAgentSimulation
 * Bryan Thiam
 * project 5
 * Prof. Max Bender
 * Prof. Hannah Wolfe
 * 3/31/2022
 */
import java.util.Random;
public class SocialAgentSimulation {
    public static void main(String[] args){
        Landscape LordBryansLand = new Landscape(500, 500);

        Random ranVal = new Random();

        // For 200 times it will add a socialAgent which would be placed randomly on LordBryansLand Landscape
        for(int i=0;i<200;i++){
            LordBryansLand.addAgent( new SocialAgent( ranVal.nextDouble() * LordBryansLand.getWidth(), ranVal.nextDouble() * LordBryansLand.getHeight(), 5 ) );
        }

        LandscapeDisplay display = new LandscapeDisplay(LordBryansLand);

        // It iterates 100 times
        for (int i=0; i<100;i++){
            // Updates agents
            LordBryansLand.updateAgents();
            display.repaint();
            try{
                Thread.sleep(250);
            }
            catch (java.lang.InterruptedException ieException){

            }
        }
    }
}
