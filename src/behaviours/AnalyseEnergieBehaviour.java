package behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnalyseEnergieBehaviour extends Behaviour {
    private List<Double> historique = new ArrayList<>();
    private final int TAILLE_HISTORIQUE = 5;
    private int nombreAnalyses = 0;
    private final int MAX_ANALYSES = 15;
    private long dernierTemps = 0;
    private final long INTERVALLE = 7000; // 7 secondes

    public AnalyseEnergieBehaviour(Agent a) {
        super(a);
    }

    private double calculerMoyenne() {
        if (historique.isEmpty()) return 0;

        double somme = 0;
        for (Double valeur : historique) {
            somme += valeur;
        }
        return somme / historique.size();
    }

    private void suggererEconomies(double consommation) {
        if (consommation > 150) {
            System.out.println("[AnalyseurEnergie] ⚠ RECOMMANDATION: Réduire la consommation (actuelle: " +
                    String.format("%.1f", consommation) + " kW)");
        }
    }

    public void action() {
        long tempsActuel = System.currentTimeMillis();

        if (tempsActuel - dernierTemps >= INTERVALLE) {
            // Générer consommation aléatoire entre 50 et 200 kW
            double consommation = 50 + Math.random() * 150;
            String heure = new SimpleDateFormat("HH:mm:ss").format(new Date());

            // Ajouter à l'historique
            historique.add(consommation);

            // Garder seulement les TAILLE_HISTORIQUE dernières valeurs
            if (historique.size() > TAILLE_HISTORIQUE) {
                historique.remove(0);
            }

            // Calculer moyenne mobile
            double moyenne = calculerMoyenne();

            // Afficher résultats
            System.out.println("[AnalyseurEnergie] " + heure + " - Consommation: " +
                    String.format("%.1f", consommation) + " kW | Moyenne (" +
                    historique.size() + " dernières): " + String.format("%.1f", moyenne) + " kW");

            // Suggérer des économies si nécessaire
            suggererEconomies(consommation);

            nombreAnalyses++;
            dernierTemps = tempsActuel;
        }

        // Petite pause pour éviter de surcharger le CPU
        block(1000);
    }

    public boolean done() {
        return nombreAnalyses >= MAX_ANALYSES;
    }

    public int onEnd() {
        System.out.println("Analyseur d'énergie terminé après " + MAX_ANALYSES + " analyses.");
        getAgent().doDelete();
        return super.onEnd();
    }
}
