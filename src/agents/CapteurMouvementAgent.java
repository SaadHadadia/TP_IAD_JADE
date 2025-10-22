package agents;

import behaviours.DetectionMouvementBehaviour;
import jade.core.Agent;

public class CapteurMouvementAgent extends Agent {
    private DetectionMouvementBehaviour comportement;

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " démarré.");
        comportement = new DetectionMouvementBehaviour(this);
        addBehaviour(comportement);
    }

    protected void takeDown() {
        System.out.println("Agent " + getLocalName() + " terminé. Total détections: " +
                (comportement != null ? comportement.getNombreDetections() : 0));
    }
}
