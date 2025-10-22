package behaviours;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MesureTemperatueBehaviour extends TickerBehaviour {
    private int nombreMesures = 0;
    private final int MAX_MESURES = 20;
    private final double SEUIL_ALERTE = 28.0;

    public MesureTemperatueBehaviour(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        // Générer température aléatoire entre 15 et 30°C
        double temperature = 15 + Math.random() * 15;

        // Formater l'heure actuelle
        String heure = new SimpleDateFormat("HH:mm:ss").format(new Date());

        // Afficher la mesure
        System.out.println("[CapteurTemperatue] " + heure + " - Température: " + String.format("%.1f", temperature) + "°C");

        // Vérifier alerte
        if (temperature > SEUIL_ALERTE) {
            System.out.println("⚠ ALERTE: Température trop élevée!");
        }

        // Incrémenter compteur
        nombreMesures++;

        // Arrêter l'agent si MAX_MESURES atteint
        if (nombreMesures >= MAX_MESURES) {
            System.out.println("Arrêt du capteur de température après " + MAX_MESURES + " mesures.");
            getAgent().doDelete();
        }
    }
}
