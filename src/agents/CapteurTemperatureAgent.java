package agents;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class CapteurTemperatureAgent extends Agent {

    private int nombreMesures = 0;
    private final int MAX_MESURES = 20;

    protected void setup() {
        System.out.println("Agent : " + getLocalName() + "a démarré");
        // TODO : Ajouter un TickerBehaviour pour tous les 5 seconds
    }

    protected void takeDown() {
        System.out.println(
                "Agent : " + getLocalName() + "a terminé"
                + "\n Total des mesures: " + nombreMesures);
    }

    // Class intern pour le comportement
    private class MesureTemperatueBehaviour extends TickerBehaviour {
        public MesureTemperatueBehaviour (Agent a, long period) {
            super(a,period);
        }

        protected void onTick() {
            // TODO: Générer une température aléatoire
            // TODO: Afficher la mesure
            // TODO: Vérifier alert si > 28°C
            // TODO: Arrêter l'agent si MAX_MESURE attient
        }

    }
}
