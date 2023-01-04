package agent;

import jade.core.Agent;
import jade.core.Location;
import jade.core.behaviours.TickerBehaviour;

/**
 * Create agent Acheteur exteds from Agent
 * Methods (setup, takeDown,
 * 
 * @author Nacer
 */
public class Buyer extends Agent {
	
	private String book;
	
	@Override
	protected void setup() {
		Object[] args = getArguments();
		if(args.length == 1) {
			book = (String) args[0];
			System.out.println("Buyer Agent: " + this.getAID() 
			+ " I'm searching to buy the book: " + book);
			addBehaviour(new TickerBehaviour(this, 1000) {
				private int con = 0;
				@Override
				protected void onTick() {
					++con;
					System.out.println("attempt to buy number: " + con);
					
				}
			});
		} else {
			System.out.println("You should be enter one book");
			doDelete();
		}
		
		
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
