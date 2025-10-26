package TPBiblio;
public class Bibliotheque {
    private Catalogue catalogue;
    private Utilisateur[] utilisateurs;
    private int nombreUtilisateurs;
    private static final int MAX_UTILISATEURS = 50;
    
    public Bibliotheque() {
        this.catalogue = new Catalogue();
        this.utilisateurs = new Utilisateur[MAX_UTILISATEURS];
        this.nombreUtilisateurs = 0;
        
        System.out.println("🏛️  Bibliothèque initialisée !");
        System.out.println("   Capacité : " + MAX_UTILISATEURS + " utilisateurs");
    }
    
    public boolean inscrireUtilisateur(Utilisateur utilisateur) {
        if (nombreUtilisateurs >= MAX_UTILISATEURS) {
            System.out.println("❌ Capacité maximale atteinte");
            return false;
        }
        
        if (utilisateur == null) {
            System.out.println("❌ Utilisateur null");
            return false;
        }
        
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroId().equals(utilisateur.getNumeroId())) {
                System.out.println("❌ Un utilisateur avec cet ID existe déjà");
                return false;
            }
        }
        
        utilisateurs[nombreUtilisateurs] = utilisateur;
        nombreUtilisateurs++;
        System.out.println("✅ Utilisateur inscrit :");
        System.out.println(utilisateur);
        
        return true;
    }


    public boolean effectuerEmprunt(String numeroId, String titreLivre) {
        System.out.println("\n📖 Tentative d'emprunt...");
        Utilisateur utilisateur = null;
        
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroId().equals(numeroId)) {
                utilisateur = utilisateurs[i];
                break;  
            }
        }
        

        if (utilisateur == null) {
            System.out.println("❌ Utilisateur non trouvé (ID: " + numeroId + ")");
            return false;
        }
        

        Livre livre = catalogue.rechercher(titreLivre);
        
        if (livre == null) {
            System.out.println("❌ Livre '" + titreLivre + "' non trouvé dans le catalogue");
            return false;
        }
        return utilisateur.emprunterLivre(livre);
    }
    
    public boolean effectuerRetour(String numeroId, String titreLivre) {
        System.out.println("\n📥 Tentative de retour...");
        Utilisateur utilisateur = null;
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroId().equals(numeroId)) {
                utilisateur = utilisateurs[i];
                break;
            }
        }
        
        if (utilisateur == null) {
            System.out.println("❌ Utilisateur non trouvé");
            return false;
        }
        return utilisateur.retournerLivre(titreLivre);
    }
    
    public void afficherStatistiquesEmprunts() {
        System.out.println("\n📊 ===== STATISTIQUES DES EMPRUNTS =====");
        
        int empruntsEtudiants = 0;
        int empruntsProfesseurs = 0;
        int nombreEtudiants = 0;
        int nombreProfesseurs = 0;
        for (int i = 0; i < nombreUtilisateurs; i++) {
            Utilisateur user = utilisateurs[i];
            if (user instanceof Etudiant) {
                empruntsEtudiants += user.getNombreEmprunts();
                nombreEtudiants++;
            } else if (user instanceof Professeur) {
                empruntsProfesseurs += user.getNombreEmprunts();
                nombreProfesseurs++;
            }
        }
        System.out.println("👥 Étudiants      : " + nombreEtudiants + 
                         " | Emprunts : " + empruntsEtudiants);
        System.out.println("👨‍🏫 Professeurs    : " + nombreProfesseurs + 
                         " | Emprunts : " + empruntsProfesseurs);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📚 TOTAL EMPRUNTS : " + 
                         (empruntsEtudiants + empruntsProfesseurs));

        if (nombreUtilisateurs > 0) {
            double moyenne = (double)(empruntsEtudiants + empruntsProfesseurs) / 
                           nombreUtilisateurs;
            System.out.printf("📈 Moyenne par utilisateur : %.2f\n", moyenne);
        }
    }

    
    public void afficherTousLesUtilisateurs() {
        System.out.println("\n👥 ===== LISTE DES UTILISATEURS =====");
        
        if (nombreUtilisateurs == 0) {
            System.out.println("Aucun utilisateur inscrit.");
            return;
        }
        
        for (int i = 0; i < nombreUtilisateurs; i++) {
            System.out.println((i + 1) + ".");
            System.out.println(utilisateurs[i].toString());
            System.out.println("---");
        }
        
        System.out.println("Total : " + nombreUtilisateurs + " utilisateur(s)");
    }
    
    public void afficherUtilisateur(String numeroId) {
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroId().equals(numeroId)) {
                System.out.println("\n" + utilisateurs[i]);
                utilisateurs[i].afficherEmprunts();
                return;
            }
        }
        System.out.println("❌ Utilisateur " + numeroId + " non trouvé");
    }
    
    public void afficherTableauDeBord() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║     📊 TABLEAU DE BORD BIBLIOTHÈQUE        ║");
        System.out.println("╚════════════════════════════════════════════╝");
        

        System.out.println("\n📚 CATALOGUE :");
        System.out.println("   Livres au catalogue : " + catalogue.getNombreLivres());
        

        for (int i = 0; i < catalogue.getNombreLivres(); i++) {
        	
        }
        

        System.out.println("\n👥 UTILISATEURS :");
        System.out.println("   Utilisateurs inscrits : " + nombreUtilisateurs + 
                         "/" + MAX_UTILISATEURS);
        

        afficherStatistiquesEmprunts();
        
        catalogue.statistiquesParGenre();
    }


    public Catalogue getCatalogue() {
        return catalogue;
    }

    public int getNombreUtilisateurs() {
        return nombreUtilisateurs;
    }
}
