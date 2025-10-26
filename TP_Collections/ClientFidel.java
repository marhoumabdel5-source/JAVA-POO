package TP;

public class ClientFidel extends Client{
	private String CodeFidelite;
	private float TauxReduction;
	
	public ClientFidel(int CodeClient, String NomClient, String AdrClient, String CodeFidelite, float TauxReduction) {
		super(CodeClient, NomClient, AdrClient);
		this.CodeFidelite = CodeFidelite;
		this.TauxReduction = TauxReduction;
	}
	
	@Override
	public String toString() {
	    return super.toString() + 
	           "\nCode Fidélité: " + CodeFidelite + 
	           ", Taux Réduction: " + (TauxReduction * 100) + "%";
	}
}
