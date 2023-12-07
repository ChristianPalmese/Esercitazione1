package Modello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cocktail {
	
	private int id;
	private String nome;
	private double costo;
	List<Ingrediente> listaIngredienti = new ArrayList<>();
	
	public Cocktail(String nome, double costo) {
		
		this.nome = nome;
		this.costo = costo;
	}
	
	public Cocktail() {
		
	}
	
	

	public void addIngrediente(Ingrediente i) {
		listaIngredienti.add(i);
	}
	
	
	
	
	public void setListaIngredienti(List<Ingrediente> listaIngredienti) {
		this.listaIngredienti = listaIngredienti;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	
	
	
	
	public List<Ingrediente> getListaIngredienti() {
		return listaIngredienti;
	}


	public boolean containsIngredienteByNome(String nome) {
		for(Ingrediente i:listaIngredienti) {
			if(i.getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isAlcolico() {
		for(Ingrediente i :listaIngredienti) {
			if(i.isAlcolico()==true) {
				return true;
			}
		}return false;
	}
	
	public boolean isPreparabile(List<String> dispenza) {
		return dispenza.containsAll(soloNome());
	}
	
	private List<String> soloNome(){
		List<String> risultato = new ArrayList<>();
		for(Ingrediente i: listaIngredienti) {
			risultato.add(i.getNome());
		}
		return risultato;
	}



	@Override
	public String toString() {
	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append("Cocktail: \n");
	    stringBuilder.append("Nome = ").append(nome).append("\n");
	    stringBuilder.append("Costo = ").append(costo).append("\n");
	    
	    if (!listaIngredienti.isEmpty()) {
	        stringBuilder.append("Ingredienti = [\n");
	        for (int i = 0; i < listaIngredienti.size(); i++) {
	            stringBuilder.append("  ").append(listaIngredienti.get(i)).append("\n");
	        }
	        stringBuilder.append("]\n");
	    } else {
	        stringBuilder.append("Nessun ingrediente specificato\n");
	    }
	    
	    return stringBuilder.toString();
	}

	
	
	
	
	
}
