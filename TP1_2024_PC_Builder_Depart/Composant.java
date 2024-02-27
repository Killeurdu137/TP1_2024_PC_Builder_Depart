/* INSCRIVEZ VOTRE (OU VOS) PRÉNOM ET NOM CI-DESSOUS
   1: Pascal Carbonneau
   2: Ayoub Rouqui
   Adresse URL de votre dépôt GitHub:
NE MODIFIEZ PAS LE RESTE DE CE FICHIER
(sauf si c'est pour mettre certaines sections en commentaire le temps de tester votre code)
*/
public class Composant {
    private final String categorie;
    private String marque, nom;
    private double prix;
    private double rabais = 0;

    public String getCategorie() {
        return categorie;
    }

    public String getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public double getRabais() {
        return rabais;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    public  void setRabais(double rabais){
        this.rabais = rabais;
    }
    public Composant(String categorie, String marque, String nom, double prix) {
        this.categorie = categorie.toUpperCase();
        this.marque = marque;
        this.nom = nom;
        this.prix = prix;
    }


    public Composant copier() {
        Composant copie = new Composant(this.categorie, this.marque, this.nom, this.prix);
        return copie;
    }


    public boolean estIdentique(Composant autre) {
        if (this.categorie.equals(autre.categorie) && this.marque.equals(autre.marque) && this.nom.equals(autre.nom)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "[" + this.categorie + "] " + this.marque + " " + this.nom;
    }
}
