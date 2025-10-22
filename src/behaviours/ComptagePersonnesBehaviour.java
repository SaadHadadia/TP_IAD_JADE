package behaviours;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComptagePersonnesBehaviour extends TickerBehaviour {
    private int personnesPresentes = 0;
    private int totalEntrees = 0;
    private int totalSorties = 0;
    private int operations = 0;

    public ComptagePersonnesBehaviour(Agent a, long period) {
        super(a, period);
    }

    protected void onTick() {
        String heure = new SimpleDateFormat("HH:mm:ss").format(new Date());

        // Décider aléatoirement entre entrée (true) et sortie (false)
        boolean entree = Math.random() > 0.5;

        if (entree) {
            personnesPresentes++;
            totalEntrees++;
            System.out.println("[CompteurPersonnes] " + heure + " - Personnes présentes: " +
                    personnesPresentes + " (+1 entrée)");
        } else {
            // Ne pas descendre en dessous de 0
            if (personnesPresentes > 0) {
                personnesPresentes--;
                totalSorties++;
                System.out.println("[CompteurPersonnes] " + heure + " - Personnes présentes: " +
                        personnesPresentes + " (-1 sortie)");
            } else {
                System.out.println("[CompteurPersonnes] " + heure + " - Personnes présentes: 0 (tentative de sortie ignorée)");
            }
        }

        operations++;

        // Afficher statistiques toutes les 10 opérations
        if (operations % 10 == 0) {
            afficherStatistiques();
        }
    }

    private void afficherStatistiques() {
        System.out.println("\n== STATISTIQUES ===");
        System.out.println("Personnes actuelles: " + personnesPresentes);
        System.out.println("Total entrées: " + totalEntrees);
        System.out.println("Total sorties: " + totalSorties);
        System.out.println("Opérations effectuées: " + operations);
        System.out.println("===================\n");
    }
}
