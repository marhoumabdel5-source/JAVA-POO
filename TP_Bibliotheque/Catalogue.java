package TPBiblio;

public class Catalogue {
   
    private Livre[] livres;
    private int nombreLivres;
    private static final int TAILLE_MAX = 100;
    public Catalogue() {
        livres = new Livre[TAILLE_MAX]; 
        nombreLivres = 0; 
        System.out.println("📖 Catalogue créé avec une capacité de " + TAILLE_MAX + " livres.");
    }

    public boolean ajouterLivre(Livre livre) {

        if (nombreLivres >= TAILLE_MAX) {
            System.out.println("❌ Le catalogue est plein, impossible d'ajouter le livre.");
            return false;
        }
        

        if (livre == null) {
            System.out.println("❌ Impossible d'ajouter un livre null.");
            return false;
        }
        livres[nombreLivres] = livre;
        nombreLivres++;
        
        System.out.println("✅ Livre '" + livre.getTitre() + "' ajouté au catalogue.");
        return true;
    }

    
    public Livre rechercher(String titre) {
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i].getTitre().equalsIgnoreCase(titre)) {
                System.out.println("🔍 Livre trouvé : " + livres[i].getTitre());
                return livres[i];
            }
        }
        System.out.println("🔍 Aucun livre trouvé avec le titre : " + titre);
        return null;
    }
    public Livre rechercher(String titre, String auteur) {
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i].getTitre().equalsIgnoreCase(titre) && 
                livres[i].getAuteur().equalsIgnoreCase(auteur)) {
                System.out.println("🔍 Livre trouvé : " + livres[i].getTitre() + 
                                 " par " + livres[i].getAuteur());
                return livres[i];
            }
        }
        
        System.out.println("🔍 Aucun livre trouvé avec le titre '" + titre + 
                         "' et l'auteur '" + auteur + "'");
        return null;
    }
    public Livre[] rechercher(int anneePublication) {
        int compteur = 0;
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i].getAnneePublication() == anneePublication) {
                compteur++;
            }
        }
        if (compteur == 0) {
            System.out.println("🔍 Aucun livre trouvé pour l'année " + anneePublication);
            return new Livre[0];
        }
        Livre[] resultats = new Livre[compteur];
        int index = 0;
        
        for (int i = 0; i < nombreLivres; i++) {
            if (livres[i].getAnneePublication() == anneePublication) {
                resultats[index] = livres[i];
                index++;
            }
        }
        
        System.out.println("🔍 " + compteur + " livre(s) trouvé(s) pour l'année " + 
                         anneePublication);
        return resultats;
    }
    public void afficherLivresDisponibles() {
        System.out.println("\n📚 ===== LIVRES DISPONIBLES =====");
        
        int compteur = 0;
        for (int i = 0; i < nombreLivres; i++) {
            Livre livre = livres[i];
            if (livre.isDisponible()) {
                System.out.println(livre);
                System.out.println("---");
                compteur++;
            }
        }
        
        if (compteur == 0) {
            System.out.println("Aucun livre disponible pour le moment.");
        } else {
            System.out.println("Total : " + compteur + " livre(s) disponible(s)");
        }
    }
    public void statistiquesParGenre() {
        System.out.println("===== STATISTIQUES PAR GENRE =====");
     
        int roman = 0, scienceFiction = 0, histoire = 0, 
            philosophie = 0, science = 0, autre = 0;
        
  
        for (int i = 0; i < nombreLivres; i++) {
            String genre = livres[i].getGenre().toLowerCase();
            
          
            if (genre.contains("roman")) {
                roman++;
            } else if (genre.contains("science-fiction") || genre.contains("sf")) {
                scienceFiction++;
            } else if (genre.contains("histoire")) {
                histoire++;
            } else if (genre.contains("philosophie")) {
                philosophie++;
            } else if (genre.contains("science")) {
                science++;
            } else {
                autre++;
            }
        }
        System.out.println("Roman            : " + roman);
        System.out.println("Science-Fiction  : " + scienceFiction);
        System.out.println("Histoire         : " + histoire);
        System.out.println("Philosophie      : " + philosophie);
        System.out.println("Science          : " + science);
        System.out.println("Autre            : " + autre);
        System.out.println("--------------------------------");
        System.out.println("TOTAL            : " + nombreLivres);
    }
    public void afficherTousLesLivres() {
        System.out.println("\n📚 ===== TOUS LES LIVRES DU CATALOGUE =====");
        
        if (nombreLivres == 0) {
            System.out.println("Le catalogue est vide.");
            return;
        }
        
        for (int i = 0; i < nombreLivres; i++) {
            System.out.println((i + 1) + ". " + livres[i]);
            System.out.println("---");
        }
    }
    public int getNombreLivres() {
        return nombreLivres;
    }
}
