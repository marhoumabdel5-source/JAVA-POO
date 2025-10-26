package TP;

import java.util.*;


public class Client {
	private int CodeClient;
	private String NomClient;
	private String AdrClient;
	private String TelClient;
	Vector<Commande> ListCommandes;
	
	public  Client(int CodeClient, 
		String NomClient, String AdrClient) {
		
		this.CodeClient = CodeClient;
		this.NomClient = NomClient;
		this.AdrClient = AdrClient;
		
		this.ListCommandes = new Vector<Commande>();
	}
	
	// Getters
	
	public int getCodeClient() {
		return CodeClient;
	}
	
	public String getNomClient() {
		return NomClient;
	}
	public String getAdrClient() {
		return AdrClient;
	}
	
	public String getTelClient() {
		return TelClient;
	}
	
	// Setters
	
		public void setCodeClient(int CodeClient) {
			this.CodeClient = CodeClient;
		}
		
		public void setNomClient(String NomClient) {
			this.NomClient = NomClient;
		}
		public void setAdrClient(String AdrClient) {
			this.AdrClient = AdrClient;
		}
		
		public void setTelClient(String TelClient) {
			this.TelClient = TelClient;
		}
		
		
	
	public void EnregistrerCommande(Commande C) {
		ListCommandes.add(C);
	}
	
	public List<Commande> getListCommandes() {
		return ListCommandes;
	}
	
	public boolean supprimerCommande(int numCommande) {
	    for (Commande cmd : ListCommandes) {
	        if (cmd.getNumComm() == numCommande) {
	            ListCommandes.remove(cmd);
	            return true; 
	        }
	    }
	    return false; 
	}
	
	@Override
	public String toString() {
	    String info = "Client [Code=" + CodeClient + 
	                  ", Nom=" + NomClient + 
	                  ", Adresse=" + AdrClient;
	    
	    if (ListCommandes.isEmpty()) {
	        info += "Aucune commande.\n";
	    } else {
	        info += "Commandes :\n";
	        for (Commande cmd : ListCommandes) {
	            info += "  - " + cmd.toString() + "\n";
	        }
	    }
	    return info;
	}

	
}
