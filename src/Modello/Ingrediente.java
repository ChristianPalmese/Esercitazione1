package Modello;

public class Ingrediente {
	private String nome;
	private int quantita;
	private boolean alcolico;
	private int id_cocktail;
	
	
	public Ingrediente(String nome, int quantita, boolean alcolico) {
		
		this.nome = nome;
		this.quantita = quantita;
		this.alcolico = alcolico;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public boolean isAlcolico() {
		return alcolico;
	}

	public void setAlcolico(boolean alcolico) {
		this.alcolico = alcolico;
	}

	public int getId_cocktail() {
		return id_cocktail;
	}

	public void setId_cocktail(int id_cocktail) {
		this.id_cocktail = id_cocktail;
	}

	@Override
	public String toString() {
		return "Ingrediente nome: " + nome + ", quantita: " + quantita + ", alcolico: " + alcolico + "";
	}
	
	
}
