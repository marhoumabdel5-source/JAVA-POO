package TPBiblio;


public class Livre {
    private String titre;
    private String auteur;
    private String isbn;  
    private String genre;
    private boolean disponible;    
    private int anneePublication;

    public Livre(String titre, String auteur, String isbn, 
                 String genre, int anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.genre = genre;
        this.anneePublication = anneePublication;
        this.disponible = true;
    }
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getAnneePublication() {
        return anneePublication;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }
    public String toString() {
        String statut = disponible ? "Disponible" : "Emprunté";
        return String.format("📚 Livre: %s\n" +
                           "   Auteur: %s\n" +
                           "   ISBN: %s\n" +
                           "   Genre: %s\n" +
                           "   Année: %d\n" +
                           "   Statut: %s",
                           titre, auteur, isbn, genre, anneePublication, statut);
    }
    public boolean emprunter() {
        if (disponible) {
            disponible = false; 
            System.out.println("✅ Le livre '" + titre + "' a été emprunté avec succès.");
            return true;
        } else {
            System.out.println("❌ Le livre '" + titre + "' n'est pas disponible.");
            return false;
        }
    }

    
    public void retourner() {
        if (!disponible) {
            disponible = true;
            System.out.println("✅ Le livre '" + titre + "' a été retourné.");
        } else {
            System.out.println("⚠️  Le livre '" + titre + "' était déjà disponible.");
        }
    }
}
