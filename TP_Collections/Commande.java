package TP;

import java.util.Date;

public class Commande implements Comparable<Commande>{
	private int NumCommande;
	private Date DateCommande;
	private String NomFournisseur;
	
	public Commande(int NumCommande, 
	Date DateCommande, String NomFournisseur) {
		
		this.NumCommande = NumCommande;
		this.DateCommande = DateCommande;
		this.NomFournisseur = NomFournisseur;
		
	}
	
	// Getters
	
	public int getNumComm() {
		return NumCommande;
	}
	
	public Date getDateComm() {
		return DateCommande;
	}
	
	public String getNomFournisseur() {
		return NomFournisseur;
	}
	
	// Setters
	
	public void setNumComm(int NumCommande) {
		this.NumCommande = NumCommande;
	}
	
	public void setDateComm(Date DateCommande) {
		this.DateCommande = DateCommande;
	}
	
	public void setNomFournisseur(String NomFournisseur) {
		this.NomFournisseur = NomFournisseur;
	}
	
	public String toString() {
		return "Numero du Commande : "+NumCommande+
				", Date Commande : "+DateCommande+
				", Nom Fournisseur : "+NomFournisseur;
	}
	
	@Override
	public boolean equals(Object obj) {
	   
	    if (this == obj) {
	        return true;
	    }
	    
	    if (obj == null || this.getClass() != obj.getClass()) {
	        return false;
	    }
	    
	     Commande other = (Commande) obj;
	    
	    return this.NumCommande == other.NumCommande;
	}
	
	@Override
	public int compareTo(Commande autreCommande) {
	    return this.DateCommande.compareTo(autreCommande.DateCommande);
	}
	
}
