import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
public class Main {
    public static void main(String[] args) {
        // Créer le runtime JADE
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.GUI, "true"); // Active RMA

        // Créer le conteneur principal
        AgentContainer mainContainer = rt.createMainContainer(p);

        try {
            // Créer et démarrer les agents
            AgentController tempAgent = mainContainer.createNewAgent(
                    "CapteurTemperature",
                    "agents.CapteurTemperatureAgent",
                    null
            );
            tempAgent.start();

            AgentController mouvAgent = mainContainer.createNewAgent(
                    "CapteurMouvement",
                    "agents.CapteurMouvementAgent",
                    null
            );
            mouvAgent.start();

            AgentController personnesAgent = mainContainer.createNewAgent(
                    "CompteurPersonnes",
                    "agents.CompteurPersonnesAgent",
                    null
            );
            personnesAgent.start();

            AgentController energieAgent = mainContainer.createNewAgent(
                    "AnalyseurEnergie",
                    "agents.AnnalyseurEnergieAgent",
                    null
            );
            energieAgent.start();

            System.out.println("Tous les agents ont été démarrés avec succès!");
            System.out.println("Agents démarrés:");
            System.out.println("- CapteurTemp (Capteur de Température)");
            System.out.println("- CapteurMouv (Capteur de Mouvement)");
            System.out.println("- CompteurPersonnes (Compteur de Personnes)");
            System.out.println("- AnalyseurEnergie (Analyseur d'Énergie)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}