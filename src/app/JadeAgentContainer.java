package app;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class JadeAgentContainer {

	public static void main(String[] args) {
		try {
			Runtime runtime = Runtime.instance();
			ProfileImpl profileImpl = new ProfileImpl(false);
			profileImpl.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			AgentContainer container = runtime.createAgentContainer(profileImpl);
			/* Create and agent and add it to the container */
			AgentController agentController = container.createNewAgent
					("Acheteur-1", "agent.Buyer", new Object[] {});
			agentController.start();
		} catch (ControllerException e) {
			e.printStackTrace();
		}

	}

}
