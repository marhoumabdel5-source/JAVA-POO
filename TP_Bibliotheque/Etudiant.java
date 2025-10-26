package TPBiblio;

public class Etudiant extends Utilisateur {
    private String niveauEtude; 
    
    
    public Etudiant(String nom, String prenom, String numeroId, String niveauEtude) {
        super(nom, prenom, numeroId);
        this.niveauEtude = niveauEtude;
    }
    
    public boolean peutEmprunter() {
        return nombreEmprunts < 3;
    }
    
    public int getLimiteEmprunt() {
        return 3;
    }

    
    public String toString() {
        return "🎓 ÉTUDIANT : " + prenom + " " + nom + "\n" +
               "   ID: " + numeroId + "\n" +
               "   Niveau: " + niveauEtude + "\n" +
               "   Emprunts: " + nombreEmprunts + "/" + getLimiteEmprunt();
    }
    
    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }
}

