package TP;

import java.util.Scanner;

public class AppComplete {
    private static Agence agence = new Agence();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        initialiserDonneesTest();
        afficherMenuPrincipal();
    }
    
    private static void initialiserDonneesTest() {
        agence.ajouterVehicule(new Voiture("Renault", "Clio", 2020, true, 5));
        agence.ajouterVehicule(new Voiture("Peugeot", "208", 2021, true, 5));
        agence.ajouterVehicule(new Moto("Yamaha", "MT-07", 2022, true, 689));
        agence.ajouterVehicule(new Moto("Honda", "CBR", 2023, false, 600));
        agence.ajouterVehicule(new Camion("Mercedes", "Actros", 2019, true, 19.0));
        agence.ajouterVehicule(new Velo("Decathlon", "Riverside", 2021, true, "VTT"));
    }
    
    private static void afficherMenuPrincipal() {
        while (true) {
            System.out.println("===== SYSTEME DE GESTION D'AGENCE =====");
            System.out.println("1. Ajouter un vehicule");
            System.out.println("2. Afficher tous les vehicules");
            System.out.println("3. Afficher les vehicules disponibles");
            System.out.println("4. Rechercher un vehicule par modele");
            System.out.println("5. Louer un vehicule");
            System.out.println("6. Retourner un vehicule");
            System.out.println("7. Quitter");
            System.out.print("Votre choix : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine();
            
            switch (choix) {
                case 1: ajouterVehicule(); break;
                case 2: afficherTousVehicules(); break;
                case 3: afficherVehiculesDisponibles(); break;
                case 4: rechercherParModele(); break;
                case 5: louerVehicule(); break;
                case 6: retournerVehicule(); break;
                case 7: 
                    System.out.println("Au revoir !");
                    return;
                default: 
                    System.out.println("Choix invalide !");
            }
        }
    }
    
    private static void ajouterVehicule() {
        System.out.println("===== AJOUT D'UN VEHICULE =====");
        System.out.print("Type (1=Voiture, 2=Moto, 3=Camion, 4=Velo) : ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Marque : ");
        String marque = scanner.nextLine();
        
        System.out.print("Modele : ");
        String modele = scanner.nextLine();
        
        System.out.print("Annee : ");
        int annee = scanner.nextInt();
        
        System.out.print("Disponible (true/false) : ");
        boolean disponible = scanner.nextBoolean();
        
        Vehicule vehicule = null;
        
        switch (type) {
            case 1:
                System.out.print("Nombre de places : ");
                int places = scanner.nextInt();
                vehicule = new Voiture(marque, modele, annee, disponible, places);
                break;
            case 2:
                System.out.print("Cylindree (cm3) : ");
                int cylindree = scanner.nextInt();
                vehicule = new Moto(marque, modele, annee, disponible, cylindree);
                break;
            case 3:
                System.out.print("Capacite de chargement (tonnes) : ");
                double capacite = scanner.nextDouble();
                vehicule = new Camion(marque, modele, annee, disponible, capacite);
                break;
            case 4:
                scanner.nextLine();
                System.out.print("Type de velo : ");
                String typeVelo = scanner.nextLine();
                vehicule = new Velo(marque, modele, annee, disponible, typeVelo);
                break;
            default:
                System.out.println("Type invalide !");
                return;
        }
        
        if (agence.ajouterVehicule(vehicule)) {
            System.out.println("Vehicule ajoute avec succes !");
        } else {
            System.out.println("Erreur lors de l'ajout du vehicule !");
        }
    }
    
    private static void afficherTousVehicules() {
        System.out.println("===== TOUS LES VEHICULES =====");
        Vehicule[] vehicules = agence.getVehicules();
        int count = agence.getNombreVehicules();
        
        if (count == 0) {
            System.out.println("Aucun vehicule dans l'agence.");
            return;
        }
        
        for (int i = 0; i < count; i++) {
            System.out.println("--- Vehicule " + (i + 1) + " ---");
            vehicules[i].afficher();
            System.out.println();
        }
    }
    
    private static void afficherVehiculesDisponibles() {
        agence.afficherDisponibles();
    }
    
    private static void rechercherParModele() {
        System.out.print("Entrez le modele a rechercher : ");
        String modele = scanner.nextLine();
        
        Vehicule[] resultats = agence.rechercherParModele(modele);
        
        if (resultats.length == 0) {
            System.out.println("Aucun vehicule trouve avec le modele : " + modele);
        } else {
            System.out.println("Resultats de la recherche pour : " + modele);
            for (Vehicule v : resultats) {
                v.afficher();
                System.out.println();
            }
        }
    }
    
    private static void louerVehicule() {
        System.out.print("Entrez l'index du vehicule a louer : ");
        int index = scanner.nextInt();
        
        Vehicule vehicule = agence.getVehicule(index - 1);
        
        if (vehicule == null) {
            System.out.println("Vehicule introuvable !");
            return;
        }
        
        if (vehicule instanceof Louable) {
            ((Louable) vehicule).louer();
        } else {
            System.out.println("Ce type de vehicule ne peut pas etre loue !");
        }
    }
    
    private static void retournerVehicule() {
        System.out.print("Entrez l'index du vehicule a retourner : ");
        int index = scanner.nextInt();
        
        Vehicule vehicule = agence.getVehicule(index - 1);
        
        if (vehicule == null) {
            System.out.println("Vehicule introuvable !");
            return;
        }
        
        if (vehicule instanceof Louable) {
            ((Louable) vehicule).retourner();
        } else {
            System.out.println("Ce type de vehicule ne peut pas etre retourne !");
        }
    }
}
