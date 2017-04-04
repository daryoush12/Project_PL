package pizzaLovers;

import java.sql.*;
import java.util.*;

import pizzaLovers.Pizza;
import pizzaLovers.Tayte;


public class DBHoitaja {
	
    /**
     *Tietokantayhteyn hallinta.
     *@author Anne Benson
     *@since 14.5.2014
     *@version 0.9
     */
    private Connection tietokantayhteys;

    /**
     * Metodi, jolla asetetaan tietokantayhteyttä varten tiedot ja
     * otetaan yhteys tietokantaan. <br /> 
     * Heittää SQLException-poikkeuksen, jos tietokantaan
     * yhteyden tekemisessa on virheita
     *@return onnistuiko tietokantayhteyden avaus vai ei
     */
    public boolean yhdista()
    	throws SQLException 
    {
    	
    	String JDBCAjuri = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/projekti";
				
       boolean paluu = false;
       try
        {
			// ladataan tietokanta-ajuri
            Class.forName(JDBCAjuri).newInstance();
            System.out.println("Ajuri rekisteröity\n");
		}
		catch (Exception e)
        {
            
           	System.err.println("TIETOKANTALIITTYN VIRHETILANNE: " +
                "JDBC:n omaa tietokanta-ajuria ei loydy.\n\n" + e.getMessage() +
                " " + e.toString() + "\n");

            for (int i = 1; i <= 80; i++)
                System.out.print("=");

            System.out.print("\nTietokanta-ajuria ei loydy!");
        }
		try
		{
            // otetaan yhteys tietokantaan
			tietokantayhteys  = DriverManager.getConnection
					(url, "projekti", "deCIYs28z");
			

            System.out.println("Yhteyden muodostaminen onnistui");
            paluu = true;  // yhteyden otto onnistui
        }
        catch (SQLException sqlE)
      	{
        
            System.out.println(sqlE.getMessage() +  "\navaa " +  url +
                "\nTietokantayhteyden avaaminen ei onnistunut.");
            System.out.println("\n" + sqlE.getMessage());
            paluu = false;
        }
        return paluu;
    }
    /** Hakee pizzat-taulusta pizza tiedot. */
	public ArrayList<Pizza> haePizzat() {
		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		int edellinenPizzaId = 0;
		int nykyinenPizzaId = 0;
		Pizza pizza = null;
		Tayte tayte = null;
		//Tayte tayte = null;
    	Statement lause=null; // suoritettava SQL-lause
        ResultSet tulosjoukko = null; // SQL-kyselyn tulokset
        //tauluun ja sarakkeisiin oman kannan tiedot
        String sqlTeksti = "select p.pizzaId, p.nimi, p.hinta, t.tayteID, t.tayteNimi"
        					+ " from pizza_tayte pt"
        					+ " inner join pizza p on p.pizzaId=pt.pizzaId"
        					+ " inner join tayte t on t.tayteId=pt.tayteId"
							+ " where p.poistomerkitty is null;";
        try{

        	// Valmistellaan komento:
        	lause = tietokantayhteys.prepareStatement(sqlTeksti);
        
        	// Lähetetään komento:
        	tulosjoukko = lause.executeQuery(sqlTeksti);
        	        	
        	// Käydään tulostaulun rivit läpi ja luetaan read()-metodilla:
        	while(tulosjoukko.next()){
        		nykyinenPizzaId = tulosjoukko.getInt("pizzaId");
        		
        		
        		// -> jos pizza_id vaihtuu tee uusi pizzaolio
				if (nykyinenPizzaId != edellinenPizzaId) {
					pizza = readPizza(tulosjoukko);
					// lisätään pizza listaan
					pizzat.add(pizza);
					edellinenPizzaId = nykyinenPizzaId;
					System.out.println("haePizzat pizza " + pizza.toString());
				}
				
				// -> tee uusi täyteolio
				tayte = readTayte(tulosjoukko);
				// -> lisää täyteolio pizzan täytelistaan (arraylist pizza.java
				// -> add metodi pizzaluokassa)
				pizza.addTayte(tayte);
				System.out.println("haePizzat tayte " + tayte.toString());
				
        	}
        	if(pizzat.size() == 0)
        		pizzat = null;	
        }
        catch (SQLException poikkeus){
        	System.out.println("Tietokanta ilmoitti virhetilanteen \n" +
        			poikkeus.getMessage());
        	pizzat = null;
        }
        return pizzat;
    }
    
	public ArrayList<Tayte> haeTaytteet() {
		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
		Tayte tayte = null;
    	Statement lause=null; // suoritettava SQL-lause
        ResultSet tulosjoukko = null; // SQL-kyselyn tulokset
        //tauluun ja sarakkeisiin oman kannan tiedot
        String sqlTeksti = "SELECT tayteID, tayteNimi FROM tayte;";
		try {
			// Valmistellaan komento:
        	lause = tietokantayhteys.prepareStatement(sqlTeksti);
        
        	// Lähetetään komento:
        	tulosjoukko = lause.executeQuery(sqlTeksti);
        	
			while (tulosjoukko.next()) {
				tayte = readTayte(tulosjoukko);
				// lisataan listaan
				taytteet.add(tayte);
				System.out.println("haeTaytteet tayte " + tayte.toString());
			}
        	if(taytteet.size() == 0)
        		taytteet = null;	
        }
        catch (SQLException poikkeus){
        	System.out.println("Tietokanta ilmoitti virhetilanteen \n" +
        			poikkeus.getMessage());
        	taytteet = null;
        }
        return taytteet;
    }
	
    private Pizza readPizza(ResultSet tulosjoukko) {
		try {
			// Haetaan yhden pizzan tiedot kyselyn tulostaulun
			// (ResultSet-tyyppinen tulosjoukko-olion) aktiiviselta tietoriviltä
			int pizzaId = tulosjoukko.getInt("pizzaId");
			String nimi = tulosjoukko.getString("nimi");
			double hinta = tulosjoukko.getDouble("hinta");

			return new Pizza(pizzaId, nimi, hinta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    
 // read tayte ilman hintaa, koska hintaa ei tässä haeta
 	private Tayte readTayte(ResultSet tulosjoukko) {
 		try {
 			// yhden tiedot haetaan
 			int tayteId = tulosjoukko.getInt("tayteId");
 			String tayteNimi = tulosjoukko.getString("tayteNimi");
 			// luodaan uusi ja palautetaan
 			return new Tayte(tayteId, tayteNimi);
 		} catch (SQLException e) {
 			throw new RuntimeException(e);
 		}
 	}
    /** Sulkee tietokantayhteyden. */
    public boolean sulje()
        	throws SQLException
        {  
            boolean paluu = false;
            try
            {
                tietokantayhteys.close();
                System.out.println("Yhteys tietokantaan katkaistu!");
                paluu = true;
            }
            catch (SQLException sqlE)
            {
                System.out.println(sqlE.getMessage() +  "\nsulje" + 
                    "\nTietokantayhteyden sulkeminen ei onnistunut.");
                paluu = false;
            }
            return paluu;
        }
         
    }
    

