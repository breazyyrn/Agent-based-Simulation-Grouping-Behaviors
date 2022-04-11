/**
 * CatSocialAgent
 * Bryan Thiam
 * project 5
 * Prof. Max Bender
 * Prof. Hannah Wolfe
 * 3/31/2022
 */
import java.util.ArrayList;
import java.awt.Graphics;

public class Landscape {
    int width;
    int height;
    LinkedList<Agent> AgentsList;

    public Landscape(int w, int h){
        width = w;
        height = h;
        AgentsList = new LinkedList<Agent>();
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void addAgent(Agent a){
        AgentsList.addFirst(a);
    }

    public String toString(){
        String s = "";
        if (AgentsList.size() != 0){
            String b = "There are: " + AgentsList.size() + " agents on the landscsape";
            s+=b;
        }

        return s;
    }

    // Find neighbors of Agents

    public ArrayList<Agent> getNeighbors(double x0, double y0, double radius){
        ArrayList AgentsNeighbors = new ArrayList<Agent>();

        // Foreach agent within agentList
        for(Agent agent : AgentsList){
            // Takes the Agent's current X position and subtracts it by the given X Pos which is passed on the parameter
            double offSetX = agent.xPos - x0;
            // Takes the Agent's current Y position and subtracts it by the given Y Pos which is passed on the parameter
            double offSetY = agent.yPos - y0;
            /**
             * If  Agents are far from each over then the sum of their Xcor and Ycor
             * Multiplied together would be greater than the radius multiplied by itself
             * which would mean that the agent is then far from within the radius' distance
             */
            if((radius * radius) >= (offSetX * offSetY) + (offSetX * offSetY) && (offSetX * offSetY) + (offSetX * offSetY) != 0){
                // If this is true then the agent is added onto the AgentsNeighbors list
                AgentsNeighbors.add(agent);
            }
        }
        return AgentsNeighbors;
    }

    public void draw(Graphics g){
        for(Agent agent : AgentsList) {
            agent.draw(g);
        }
    }

    public void updateAgents(){
        ArrayList<Agent> AgentsShuffle = new ArrayList<Agent>();
        // Includes a shuffled list of AgentsList into AgentsShuffle
        AgentsShuffle = AgentsList.toShuffledList();

        // foreach agent within agentsShuffle ArrayList
        for(Agent agent : AgentsShuffle){
            // Updates each agents current state
            agent.updateState(this);
        }
    }

    public static void main(String[] args){
        Landscape ourLandGame = new Landscape(5, 10);
        Agent bryAgent = new Agent(5, 5);
        for (int i=0; i<3; i++){
            ourLandGame.addAgent(bryAgent);
        }
        System.out.println(ourLandGame.toString());
    }
}
