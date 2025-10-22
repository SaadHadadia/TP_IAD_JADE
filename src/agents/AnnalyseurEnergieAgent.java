package agents;

import behaviours.AnalyseEnergieBehaviour;
import jade.core.Agent;

public class AnnalyseurEnergieAgent extends Agent {
    protected void setup() {
        System.out.println("Agent " + getLocalName() + " démarré.");
        addBehaviour(new AnalyseEnergieBehaviour(this));
    }
}
