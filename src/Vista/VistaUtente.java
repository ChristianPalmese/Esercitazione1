package Vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modello.Cocktail;
import Modello.Ingrediente;

public class VistaUtente {
	private Scanner scanner = new Scanner(System.in);
	
	
	public Ingrediente leggiIngrediente() {
		System.out.println("insierisci il nome dell'ingrediente");
		String nome = scanner.next();
		
		System.out.println("inserisci le quantita");
		int quantita = scanner.nextInt();
		
		System.out.println("l'ingrediente è alcolico?");
		boolean alcolico = scanner.nextBoolean();
		
		return new Ingrediente(nome, quantita, alcolico);
	}
	
	
	
	public Cocktail leggiCocktail() {
		System.out.println("come si chiama il Cocktail? ");
		String nome = scanner.next();
		
		System.out.println("Quanto costa il Cocktail ?");
		double costo = scanner.nextDouble();
		
		return new Cocktail(nome, costo);
	}
	
	
	
	public int menu() {
		System.out.println("---------------------------------");
		System.out.println("GESTIONE LISTE ELETTORALI");
		System.out.println("---------------------------------");
		System.out.println("1: inserisci Cocktail");
		System.out.println("2: inserisci Ingrediente");
		System.out.println("3: calcola cocktail analcolico più costoso");
		System.out.println("4: cocktail preparabili con gli ingredienti che mi fornisci ");
		System.out.println();
		System.out.println("0: esci");
		System.out.println("---------------------------------");
		System.out.println("INSERISCI LA TUA SCELTA: ");
		return scanner.nextInt();
	}

	public void stampaMessaggio(String s) {
		System.out.println(s);
	}
	
	public String insersciNomeSearch() {
		System.out.println("in quale cocktail vuoi inserire gli ingredienti?");
		String nomeCocktail= scanner.next();
		return nomeCocktail;
	}

	public List<String> leggiListaIngredienti(){
		System.out.println("quanti ingredienti vuoi aggiungere?");
		int numIngredienti = scanner.nextInt();
		
		List<String> listaIngredienti = new ArrayList<>();
		for(int i = 0 ; i < numIngredienti ; i++ ) {
			System.out.println("dammi il nome dell'ingrediente");
			String nomeIngrediente = scanner.next();
			listaIngredienti.add(nomeIngrediente);
		}
		return listaIngredienti;
	}
	
	public String insersciNomeSearchList() {
		System.out.println("inserisci il nome del cocktail che vuoi cercare?");
		String nomeCocktail= scanner.next();
		return nomeCocktail;
	}
	
	



	
}
