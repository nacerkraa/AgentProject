package agent;

import jade.core.Agent;
import jade.core.Location;

/**
 * Create agent Acheteur exteds from Agent
 * Methods (setup, takeDown,
 * 
 * @author Nacer
 */
public class Buyer extends Agent {

	@Override
	protected void setup() {
		System.out.println("Buyer Agent: " + this.getAID());
		
	}
	
	@Override
	protected void takeDown() {
		System.out.println("Agent destroy");
	}
	
	@Override
	public void doMove(Location loc) {
		System.out.println("Move to: " + loc.getName());
	}
	
	

}
