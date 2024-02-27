/* INSCRIVEZ VOTRE (OU VOS) PRÉNOM ET NOM CI-DESSOUS
   1: Pascal Carbonneau
   2: Ayoub Rouqui
   Adresse URL de votre dépôt GitHub:
*/
public class Configuration{
    private final String description;
    private final double MAX_PRIX;
    private final int MAX_COMPOSANTS = 20;
    private Composant[] tabComposants = new Composant[MAX_COMPOSANTS];

    public int getNbComposants(){
        int nbre = 0;
        for (int i = 0; i < tabComposants.length; i++) {
            if (tabComposants[i] != null) {
                nbre++;
            }
        }
        return nbre;
    }

    public Composant[] getComposants() {
        return tabComposants;
    }


    public Configuration(String description, double maxPrix, Composant[] tabComposants){
        this.description = description;
        this.MAX_PRIX = maxPrix;
        for (int i = 0; i < tabComposants.length; i++) {
            this.tabComposants[i] = tabComposants[i];
        }
    }

    public Configuration(Configuration autreConfiguration) {
        this.description = autreConfiguration.description;
        this.MAX_PRIX = autreConfiguration.MAX_PRIX;
        this.tabComposants = autreConfiguration.tabComposants.clone();
    }


    public Configuration copier() {
        String nouvelleDescription = new String(this.description);
        double nouveauMaxPrix = this.MAX_PRIX;

        Composant[] nouveauTabComposants = new Composant[this.tabComposants.length];
        for (int i = 0; i < this.tabComposants.length; i++) {
            nouveauTabComposants[i] = new Composant(this.tabComposants[i].getCategorie(), this.tabComposants[i].getMarque(), this.tabComposants[i].getNom(), this.tabComposants[i].getPrix());
        }
        Configuration copie = new Configuration(nouvelleDescription, nouveauMaxPrix, nouveauTabComposants);
        return copie;
    }

    public double calculerTotal(double taxe) {
        double sommePrix = 0;
        for (Composant composant : tabComposants) {
            if (composant == null) {
                break;
            }
            sommePrix += composant.getPrix();
        }
        double totalAvecTaxe = 0.0;
        totalAvecTaxe = sommePrix + (sommePrix * taxe);
        return totalAvecTaxe;
    }

    public Composant rechercher(String categorie) {
        for (Composant composant : tabComposants) {
            if (composant == null) {
                break;
            } else if (composant.getCategorie().equalsIgnoreCase(categorie)) {
                return composant;
            }
        }
        return null;
    }


    public boolean ajouter(Composant composant) {
        for (int i = 0; i < tabComposants.length; i++) {
            if (tabComposants[i] == null && this.calculerTotal(0.15) + composant.getPrix() > MAX_PRIX) {
                return false;
            }
            if (tabComposants[i] == null) {
                tabComposants[i] = composant;
                return true;
            }
        }
        return false;
    }


    public boolean retirer (Composant composant) {
//            for (int i = 0; i < tabComposants.length; i++) {
//                if (tabComposants[i] != null && tabComposants[i].estIdentique(composant)) {
//                   tabComposants[i] = null;
//                   return true;
//                }
//            }
        return false;
    }

    public boolean remplacer (Composant composant){
        for (int i = 0; i < tabComposants.length; i++) {
            if (tabComposants[i] == null) {
                break;
            } else if (tabComposants[i].getCategorie().equals(composant.getCategorie())) {
                tabComposants[i] = composant.copier();
                return true;
            }
        }
        return false;
    }

        @Override
        public String toString () {
            String result = description + " (max " + MAX_PRIX + "$) :\n";

            for (int i = 0; i < this.tabComposants.length; i++) {
                if (this.tabComposants[i] == null) {
                    break;
                }
                Composant composant = this.tabComposants[i];
                result += "    " + (i + 1) + ": " + composant + " " + "(" + composant.getPrix() + "$)" + "\n";
            }
            return result;
        }

}
