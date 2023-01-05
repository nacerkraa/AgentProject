package agent;




import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
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
		System.out.println("Starting the agent: " + this.getAID().getName());
			
		addBehaviour(new OneShotBehaviour() {
			
			@Override
			public void action() {
				System.out.println("One shot behaviour...");
				
			}
		});
	}
	
	@Override
	protected void beforeMove() {
		System.out.println("Avant migration de l'agent"+ this.getAID().getName());
		System.out.println("de " + this.getContainerController().getName());
	}
	
	@Override
	protected void afterMove() {
		try {
			System.out.println("Apres migration de l'agent"+ this.getAID().getName());
			System.out.println("Vers " + this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void takeDown() {
		System.out.println("Agent destroy");
	}
	

	

}
