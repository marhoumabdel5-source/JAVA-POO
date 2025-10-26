package TPBiblio;


public abstract class Utilisateur {
    protected String nom;
    protected String prenom;
    protected String numeroId;
    protected Livre[] livresEmpruntes;
    protected int nombreEmprunts;
    protected static final int MAX_EMPRUNTS = 10;
    
    public Utilisateur(String nom, String prenom, String numeroId) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroId = numeroId;
        this.livresEmpruntes = new Livre[MAX_EMPRUNTS];
        this.nombreEmprunts = 0;
    }
    
    
    public abstract boolean peutEmprunter();
    
    public abstract int getLimiteEmprunt();

    public boolean emprunterLivre(Livre livre) {
        if (!peutEmprunter()) {
            System.out.println("❌ " + prenom + " " + nom + 
                " a atteint la limite d'emprunts (" + getLimiteEmprunt() + ")");
            return false;
        }
        if (livre == null) {
            System.out.println("❌ Livre inexistant");
            return false;
        }

        if (!livre.isDisponible()) {
            System.out.println("❌ Le livre '" + livre.getTitre() + 
                "' n'est pas disponible");
            return false;
        }
        if (livre.emprunter()) {
            livresEmpruntes[nombreEmprunts] = livre;
            nombreEmprunts++;
            System.out.println("✅ " + prenom + " " + nom + 
                " a emprunté '" + livre.getTitre() + "'");
            return true;
        }

        return false;
    }
    
    
    public boolean retournerLivre(String titreLivre) {
        for (int i = 0; i < nombreEmprunts; i++) {
            if (livresEmpruntes[i].getTitre().equalsIgnoreCase(titreLivre)) {
                livresEmpruntes[i].retourner();
                for (int j = i; j < nombreEmprunts - 1; j++) {
                    livresEmpruntes[j] = livresEmpruntes[j + 1];
                }
                livresEmpruntes[nombreEmprunts - 1] = null;
                nombreEmprunts--;
                
                System.out.println("✅ " + prenom + " " + nom + 
                    " a retourné '" + titreLivre + "'");
                return true;
            }
        }
        
        System.out.println("❌ " + prenom + " " + nom + 
            " n'a pas emprunté ce livre");
        return false;
    }
    
    public void afficherEmprunts() {
        if (nombreEmprunts == 0) {
            System.out.println(prenom + " " + nom + " n'a aucun emprunt en cours.");
            return;
        }
        
        System.out.println("\n📚 Emprunts de " + prenom + " " + nom + " :");
        for (int i = 0; i < nombreEmprunts; i++) {
            System.out.println("  " + (i+1) + ". " + livresEmpruntes[i].getTitre());
        }
        System.out.println("Total : " + nombreEmprunts + "/" + getLimiteEmprunt());
    }
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroId() {
        return numeroId;
    }

    public int getNombreEmprunts() {
        return nombreEmprunts;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String toString() {
        return prenom + " " + nom + " (ID: " + numeroId + ") - " + 
               nombreEmprunts + " emprunt(s)";
    }
}