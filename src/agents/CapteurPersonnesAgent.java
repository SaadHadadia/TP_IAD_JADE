package agents;

import jade.core.Agent;

public class CapteurPersonnesAgent extends Agent {

    private int perssonesPresent = 0;
    private int totalEntrees = 0;
    private int totalsorties = 0;
    private int operation = 0;

    protected void setup() {
        // TODO: Comportement périodique
        // TODO: Comportement d'affichage statistiques
    }

    private void afficherStatistiques() {
        System.out.println(
                "\n============== STATISTIQUES ==============" +
                "\nPersonnes actuelles: " + perssonesPresent +
                "\nTotal Entré: " + totalEntrees +
                "\nTotal sorties: " + totalsorties +
                "\n============================\n"
        );
    }

}
