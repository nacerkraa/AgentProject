package agent;




import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
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
			
		addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage aclMessage = receive();
				if (aclMessage != null) {
					System.out.println("Receive a new message: ");
					System.out.println(aclMessage.getContent());
					System.out.println(aclMessage.getLanguage());
					System.out.println(ACLMessage.getPerformative(aclMessage.getPerformative()));
					System.out.println(aclMessage.getOntology());
					if (aclMessage.getOntology().equals("Commercial")) {
						System.out.println("Commercial Ontology");
						ACLMessage reply = aclMessage.createReply();
						reply.setContent("The message is sent succesfuly");
						send(reply);
					}
				} else {
					block();
				}
				
			}
		});
	}
	
	@Override
	protected void beforeMove() {
		System.out.println("Before moving "+ this.getAID().getName());
		System.out.println("from " + this.getContainerController().getName());
	}
	
	@Override
	protected void afterMove() {
		try {
			System.out.println("After moving "+ this.getAID().getName());
			System.out.println("To " + this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void takeDown() {
		System.out.println("Agent destroy");
	}
	

	

}
