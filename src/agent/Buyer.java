package agent;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.ControllerException;

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
			addBehaviour(new TickerBehaviour(this, 30000) {
				private int con = 0;
				@Override
				protected void onTick() {
					++con;
					System.out.println("attempt to buy number: " + con);
				}
			});
			
			addBehaviour(new CyclicBehaviour() {
				
				@Override
				public void action() {
					MessageTemplate messageTemplate = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("commerce"));
					ACLMessage message = receive(messageTemplate);
					if (message != null) {
						System.out.println(message.getContent());
					} else {
						block();
					}
				}
			});
		} else {
			System.out.println("You should be enter one book");
			doDelete();
		}
		
		
	}
	
	@Override
	protected void beforeMove() {
		System.out.println("Before moving agent: "+ this.getAID().getName());
		System.out.println("to " + this.getContainerController().getName());
	}
	
	@Override
	protected void afterMove() {
		try {
			System.out.println("After moving agent"+ this.getAID().getName());
			System.out.println("to " + this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void takeDown() {
		System.out.println("Agent destroy");
	}
	

	

}
