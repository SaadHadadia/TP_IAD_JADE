package agents;

import jade.core.Agent;
import behaviours.MesureTemperatueBehaviour;

public class CapteurTemperatureAgent extends Agent {

    private int nombreMesures = 0;

    protected void setup() {
        System.out.println("Agent : " + getLocalName() + "a démarré");
        // Ajouter un TickerBehaviour pour tous les 5 seconds
        addBehaviour(new MesureTemperatueBehaviour(this, 5000));
    }

    protected void takeDown() {
        System.out.println(
                "Agent : " + getLocalName() + "a terminé"
                + "\n Total des mesures: " + nombreMesures);
    }

}
