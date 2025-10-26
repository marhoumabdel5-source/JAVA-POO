package TPBiblio;

public class Professeur extends Utilisateur {

    private String departement;
    private boolean estTitulaire;

    
    public Professeur(String nom, String prenom, String numeroId, 
                      String departement, boolean estTitulaire) {
        super(nom, prenom, numeroId);
        
        this.departement = departement;
        this.estTitulaire = estTitulaire;
    }
    
    
    public boolean peutEmprunter() {
        int limite = estTitulaire ? 10 : 5;
        return nombreEmprunts < limite;
    }
    
    public int getLimiteEmprunt() {
        return estTitulaire ? 10 : 5;
    }
    
    public String toString() {
        String statut = estTitulaire ? "Titulaire" : "Non-titulaire";
        return "👨‍🏫 PROFESSEUR : " + prenom + " " + nom + "\n" +
               "   ID: " + numeroId + "\n" +
               "   Département: " + departement + "\n" +
               "   Statut: " + statut + "\n" +
               "   Emprunts: " + nombreEmprunts + "/" + getLimiteEmprunt();
    }
    
    
    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public boolean isEstTitulaire() {
        return estTitulaire;
    }

    public void setEstTitulaire(boolean estTitulaire) {
        this.estTitulaire = estTitulaire;
    }
  
}
