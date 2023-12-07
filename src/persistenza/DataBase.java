package persistenza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

import Modello.Cocktail;
import Modello.Ingrediente;

public class DataBase {
	
	private Connection con;

	public Connection getConnection() throws SQLException {

	if(con == null) {

	MysqlDataSource dataSource = new MysqlDataSource();

	dataSource.setDatabaseName("esercitazione2");

	dataSource.setPortNumber(3306);

	dataSource.setServerName("localhost");

	dataSource.setUser("root");

	dataSource.setPassword("Palmese2002*");

	con = dataSource.getConnection();

	}

	return con;

	}

	public Connection getConnectionCreazioneBar() throws SQLException {

	MysqlDataSource dataSource = new MysqlDataSource();

	dataSource.setPortNumber(3306);

	dataSource.setServerName("localhost");

	dataSource.setUser("root");

	dataSource.setPassword("Palmese2002*");

	return dataSource.getConnection();

	}

	public void creazioneSchema () throws SQLException {

	String sql= "CREATE DATABASE IF NOT EXISTS `Bar`";

	PreparedStatement ps = getConnectionCreazioneBar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	ps.executeUpdate();

	}
	
	public void creazioneTabellaCockatail() throws SQLException {
	    String sql = "CREATE TABLE `Bar`.`Cocktail` ("
	            + "`id` INT NOT NULL AUTO_INCREMENT,"
	            + "`nome` VARCHAR(45) NOT NULL,"
	            + "`cognome` DOUBLE NOT NULL,"
	            + "PRIMARY KEY (`id`));";

	    PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	    ps.executeUpdate();
	}
	
	
	public void creazioneTabellaIngredienti() throws SQLException {
	    String sql = "CREATE TABLE `Bar`.`Ingredienti` ("
	            + "`idIngrediente` INT NOT NULL AUTO_INCREMENT,"
	            + "`idCocktail` INT,"
	            + "`nome` VARCHAR(50),"
	            + "`quantita` INT,"
	            + "`alcolico` BOOLEAN,"
	            + "PRIMARY KEY (`idIngrediente`));";

	    PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    ps.executeUpdate();
	}
	
	
	
	//metodo alessio
	public void insertCocktail2 (Cocktail cocktail) throws SQLException {

		String sql = "INSERT INTO Bar.Cocktail(nome, costo)" +

		"VALUES('"+cocktail.getNome()+"', '"+cocktail.getCosto()+"')"; //get ingresso calco

		PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();

		rs.next();
		}	



	//metodo alessio
	public void insertIngrediente2(Ingrediente ingrediente) throws SQLException {

		String sql = "INSERT INTO Bar.Ingredienti(nome, quantita, idCocktail)" +

		"VALUES('"+ingrediente.getNome()+"', '"+ingrediente.getQuantita()+"', '"+ingrediente.getId_cocktail()+"')"; //get ingresso calco

		PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();

		rs.next();

		}
	
	 public ArrayList <Cocktail> findAllCocktailWithNome () throws SQLException {

		 String sql ="SELECT * FROM Bar.Cocktail;";

		 PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		 ResultSet rs = ps.executeQuery();

		 ArrayList <Cocktail> listaCocktail = new ArrayList <Cocktail> ();

		 while(rs.next()) {

		 Cocktail cocktail = new Cocktail ();

		 cocktail.setNome(rs.getString(2));

		 cocktail.setCosto(rs.getInt(3));

		 listaCocktail.add(cocktail);

		 }
		 return listaCocktail;
	}
	 
	
	 
	 public void stampaCocktailByID(int idCocktail) throws SQLException {
		    String sql = "SELECT * FROM Bar.Cocktail WHERE id = ?";
		    
		    try (Connection connection = getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		        preparedStatement.setInt(1, idCocktail);
		        ResultSet resultSet = preparedStatement.executeQuery();
		        
		        if (resultSet.next()) {
		            String nome = resultSet.getString("nome");
		            double costo = resultSet.getDouble("costo");
		            System.out.println("ID: " + idCocktail);
		            System.out.println("Nome: " + nome);
		            System.out.println("Costo: " + costo);
		        } else {
		            System.out.println("Cocktail non trovato per l'ID specificato.");
		        }
		    }
		}
	 
	 
	

	 

	
}
