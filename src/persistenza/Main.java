package persistenza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Modello.Cocktail;
import Modello.Ingrediente;
import Vista.VistaUtente;

public class Main {

	public static void main(String[] args) throws SQLException {
		DataBase db = new DataBase();
		VistaUtente vistaUtente= new VistaUtente();
		
		
		/*
		 try {
	            
	            db.creazioneSchema();
	            System.out.println("Database 'Bar' creato con successo.");
	        } catch (SQLException e) {
	            System.err.println("Errore durante la creazione del database: " + e.getMessage());
	        }
		 try {
	            db.creazioneTabellaCockatail();
	            System.out.println("La tabella del cocktail è stata creata.");
	        } catch (SQLException e) {
	            System.err.println("Errore durante la creazione della tabella: " + e.getMessage());
	        }
		 
		 try {
	            
	            db.creazioneTabellaIngredienti();;
	            System.out.println("La tabella degli ingredienti è stata creata.");
	        } catch (SQLException e) {
	            System.err.println("Errore durante la creazione della tabella: " + e.getMessage());
	        }
		
		 */
		 
		 try {
			 	Cocktail cocktail=vistaUtente.leggiCocktail();
	            db.insertCocktail2(cocktail);;;
	            System.out.println("Il cocktail è stato inserito.");
	        } catch (SQLException e) {
	            System.err.println("Errore durante la creazione del cocktail " + e.getMessage());
	        }
		 try {
			 	Ingrediente ingrediente=vistaUtente.leggiIngrediente();
	            db.insertIngrediente2(ingrediente);;;
	            System.out.println("L'ingrediente è stato inserito.");
	        } catch (SQLException e) {
	            System.err.println("Errore durante la creazione dell'ingrediente " + e.getMessage());
	        }
		 
		 /*
		 try {
	            List <Cocktail> listaCocktail=db.findAllCocktailWithNome();
	            System.out.println("i cocktail sono: "+ listaCocktail );
	        } catch (SQLException e) {
	            System.err.println("Errore durante la creazione della lista" + e.getMessage());
	        }
		 
		
		
		try {
			
            List <Cocktail> listaCocktail=db.findAllCocktailWithNome();
            String cocktail=vistaUtente.insersciNomeSearchList();
            Cocktail cocktailSearch=db.findCocktailByNome(cocktail, listaCocktail);
            if(cocktailSearch==null) {
            	vistaUtente.stampaMessaggio("il cocktail non è presente nella lista");
            }else {
            	vistaUtente.stampaMessaggio("il cocktail è presente nella lista");
            }
        } catch (SQLException e) {
            System.err.println("Errore durante la creazione della lista" + e.getMessage());
        }
		 
		
		try {
			int id=4;
			db.stampaCocktailByID(id);
	
			
        } catch (SQLException e) {
            System.err.println("Errore durante la creazione della lista" + e.getMessage());
        }
		 */
		 
		 
	}
	
	
	static void insertDati() {
		DataBase db = new DataBase();
		VistaUtente vistaUtente= new VistaUtente();
		
		int idCocktail;
		
		try {
		 	Cocktail cocktail=vistaUtente.leggiCocktail();
            db.insertCocktail2(cocktail);
            System.out.println("Il cocktail è stato inserito.");
        } catch (SQLException e) {
            System.err.println("Errore durante la creazione del cocktail " + e.getMessage());
        }
		
		try {
		 	Ingrediente ingrediente=vistaUtente.leggiIngrediente();
            db.insertIngrediente2(ingrediente);;;
            System.out.println("L'ingrediente è stato inserito.");
        } catch (SQLException e) {
            System.err.println("Errore durante la creazione dell'ingrediente " + e.getMessage());
        }
	}

}
