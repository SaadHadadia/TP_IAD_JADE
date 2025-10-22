package agents;

import jade.core.Agent;

import java.util.ArrayList;
import java.util.List;

public class AnnalyseurEnergieAgent extends Agent {

    private List<Double> historique = new ArrayList<>();
    private final int TAILLE_HISTORIQUE = 5;
    private int nombreAnalyses = 0;

    protected void setup() {
        // TODO: Ajouter un compteur d'analyse
    }

    private double calculerMoyenne() {
        // TODO: calculer la moyenne des dernières mesures
    }

    private void suggererEconomies(double consomation) {
        if (consomation > 150) {
            System.out.println("[AnnalyseurEnergie] ⚠ RECOMENDATION: Réduire la consomation");
        }
    }
}
