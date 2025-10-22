package agents;

import behaviours.ComptagePersonnesBehaviour;
import jade.core.Agent;

public class CompteurPersonnesAgent extends Agent {
    protected void setup() {
        System.out.println("Agent " + getLocalName() + " démarré.");
        addBehaviour(new ComptagePersonnesBehaviour(this, 4000));
    }
}
