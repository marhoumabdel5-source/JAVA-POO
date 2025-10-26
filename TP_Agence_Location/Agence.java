package TP;




public class Agence {
	private Vehicule[] vehicules;
    private static final int TAILLE_MAX = 100;
    private int nombreVehicules;
    
    public Agence() {
    	vehicules = new Vehicule[TAILLE_MAX];
    	nombreVehicules = 0;
    }
    
    public boolean ajouterVehicule(Vehicule vehicule) {

        if (nombreVehicules >= TAILLE_MAX) {
        	return false;
        }
        

        if (vehicule == null) {
            return false;
        }
        vehicules[nombreVehicules] = vehicule;
        nombreVehicules++;
        
        return true;
    }
    
    public void afficherDisponibles() {
        System.out.println("===== VÉHICULES DISPONIBLES =====");
        
        int compteur = 0;
        for (int i = 0; i < nombreVehicules; i++) {
            Vehicule vehicule = vehicules[i];
            if (vehicule.isDisponible()) { 
                System.out.println("--- Véhicule " + (compteur + 1) + " ---");
                vehicule.afficher();
                compteur++;
            }
        }
        
        if (compteur == 0) {
            System.out.println("Aucun véhicule disponible pour le moment."); 
        } else {
            System.out.println("Total : " + compteur + " véhicule(s) disponible(s)"); 
        }
    }
    
    public Vehicule[] rechercherParModele(String modele) {
        int count = 0;
        for (int i = 0; i < nombreVehicules; i++) {
            if (vehicules[i].getModele().equalsIgnoreCase(modele)) {
                count++;
            }
        }
        
        Vehicule[] resultats = new Vehicule[count];
        int index = 0;
        for (int i = 0; i < nombreVehicules; i++) {
            if (vehicules[i].getModele().equalsIgnoreCase(modele)) {
                resultats[index++] = vehicules[i];
            }
        }
        return resultats;
    }
    
    public Vehicule getVehicule(int index) {
        if (index >= 0 && index < nombreVehicules) {
            return vehicules[index];
        }
        return null;
    }
    
    public Vehicule[] getVehicules() {
        return vehicules;
    }
    
    public int getNombreVehicules() {
        return nombreVehicules;
    }
}


