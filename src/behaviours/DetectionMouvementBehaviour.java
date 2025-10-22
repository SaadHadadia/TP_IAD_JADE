package behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetectionMouvementBehaviour extends CyclicBehaviour {
    private int nombreDetections = 0;

    public DetectionMouvementBehaviour(Agent a) {
        super(a);
    }

    private boolean detectorMouvement() {
        return Math.random() < 0.4; // 40% de chance
    }

    public void action() {
        // Simuler la détection
        boolean mouvementDetecte = detectorMouvement();
        String heure = new SimpleDateFormat("HH:mm:ss").format(new Date());

        if (mouvementDetecte) {
            nombreDetections++;
            System.out.println("[CapteurMouvement] " + heure + " - MOUVEMENT DÉTECTÉ !");
        } else {
            System.out.println("[CapteurMouvement] " + heure + " - Aucun mouvement");
        }

        // Pause de 3 secondes
        block(3000);
    }

    public int getNombreDetections() {
        return nombreDetections;
    }
}