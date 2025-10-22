package agents;

import jade.core.Agent;

public class CapteurMouvementAgent extends Agent {

    private int nombreDetections = 0;

    protected void setup() {
        // TODO: Ajouter un CyclicBehaviour ou TickerBihavior
    }

    // Méthode pour simulier la détection
    private boolean detecterMouement() {
        return Math.random() < 0.4; // 40% de chance
    }

}
