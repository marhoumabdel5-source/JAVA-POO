package TP;

import java.io.*;
import java.util.*;

public class TestCommande {

	public static void main(String[] args) {
		Commande cmd1 = new Commande(1, new Date("2025/10/23"),"X");
		Commande cmd2 = new Commande(2, new Date("2025/10/24"),"Y");
		Commande cmd3 = new Commande(3, new Date("2025/10/25"),"Z");

		Client cli1 = new Client(102,"Adil","Cali");
		Client cli2 = new Client(103,"Wadii","Ezzoubir");
		Client cli3 = new Client(102,"Amine","Oualfa");
		
		cli1.EnregistrerCommande(cmd1);
		cli1.EnregistrerCommande(cmd3);
		cli2.EnregistrerCommande(cmd2);
		cli3.EnregistrerCommande(cmd3);
		
		List<Client> Clients = new ArrayList<>();
		Clients.add(cli1);
		Clients.add(cli2);
		Clients.add(cli3);
		
		Collections.sort(cli1.getListCommandes());
		
		Set<Commande> setCommandes = new HashSet<>();
		setCommandes.add(cmd1);
		setCommandes.add(cmd1);
		setCommandes.add(cmd2);
		
		Map<Integer, Client> mapClients = new HashMap<>();
		mapClients.put(cli1.getCodeClient(), cli1);
		mapClients.put(cli2.getCodeClient(), cli2);
		mapClients.put(cli3.getCodeClient(), cli3);
		
		try (PrintWriter writer = new PrintWriter("clients.txt")) {
		    for (Client client : Clients) {
		        writer.println(client.toString());
		        writer.println("-------------------");
		    }
		    System.out.println("Fichier créé avec succès !");
		} catch (FileNotFoundException e) {
		    System.out.println("Erreur : " + e.getMessage());
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader("clients.txt"))) {
		    String ligne;
		    System.out.println("\n=== CONTENU DU FICHIER ===");
		    while ((ligne = reader.readLine()) != null) {
		        System.out.println(ligne);
		    }
		} catch (IOException e) {
		    System.out.println("Erreur de lecture : " + e.getMessage());
		}

	}

}
