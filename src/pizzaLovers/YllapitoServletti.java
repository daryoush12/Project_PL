package pizzaLovers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzaLovers.Pizza;
import pizzaLovers.DBHoitaja;

/**
 * Servlet implementation class YllapitoServlet
 */
@WebServlet("/YllapitoServletti")
public class YllapitoServletti extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	HttpSession istunto;
	private RequestDispatcher disp;

    private ArrayList <Pizza> pizzat;
    DBHoitaja kanta;
   
    public YllapitoServletti() {
        
        // TODO Auto-generated constructor stub
    }
    public void init ()
    {
    	// Luodaan pizzat ja kanta oliot
    	// Pizzat olion alkuarvo on null ja kanta oliolle uusi DBHoitaja objekti
    	pizzat = null;
    	kanta = new DBHoitaja();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// M‰‰ritet‰‰n istunto HttpSession oliolle, ett‰ palaa takaisin nykyiseen sessioon, jos sessionia ei ole olemassa, luodaan uusi. (scope="session")
		istunto  = request.getSession(true);
		// M‰‰ritet‰‰n ett‰ kaikki action pyynnˆt otetaan String actionilla kiinni
		String action = request.getParameter("action");
		
		// k‰ytt‰j‰ aloittaa ohjelman, klikkaa alkuun-painiketta tai palaa muista servleteist‰
		// Jos action sis‰ltˆ on null, Pizzalistaan tai Takaisin pizzalistaan menn‰‰n naytaPizzatSivu metodiin.
    	if(action == null || action.equalsIgnoreCase("Pizzalistaan") || 
    			action.equalsIgnoreCase("Takaisin pizzalistaan")){
    		naytaPizzatSivu(request, response);
    	}
    	else
    	{
    		// Jos mik‰‰n yll‰olevista actioneista ei toteudu, siirryt‰‰n toimintailmoitus.jsp sivulle
    		disp = request.getRequestDispatcher("toimintailmoitus.jsp");
			System.out.println("L‰hdet‰‰n sivulle");
			// Ohjataan eteenp‰in request ja response pyynnˆt
			disp.forward(request, response);
    		
    	}
	}
    	  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
			
	}

	public void naytaPizzatSivu(HttpServletRequest request, HttpServletResponse response){
			try{
				if (kanta.yhdista())
				{
					
								
					System.out.println("Sivun luonnissa");
					// Luodaan pizzat olio, jonne tuodaan Pizza listaus
					pizzat = new ArrayList<Pizza>();
					// Haetaan pizzat olioon tiedot DBHoitajan findAll metodista
					pizzat = kanta.haePizzat();
					// Jos kantayhteys on suljettu, tulostetaan "Kanta suljettu"
					if (kanta.sulje())
						System.out.println("Kanta suljettu");
					// .. jos ei, niin tulostetaan "Kanta auki"
					else
						System.out.println("Kanta auki");
					// Ilmoitetaan, ett‰ pizzatiedot on haettu
					System.out.println("pizzat haettu");
					// M‰‰ritet‰‰n doGet istunnon pizzat muuttujalle, pizzat olion tiedot.
					istunto.setAttribute("pizzat", pizzat);
					// Ilmoitetaan, ett‰ attribuutit on asetettu
					System.out.println("attribuutit asetettu");
					//String action = request.getParameter("action");
					// M‰‰ritet‰‰n disp oliolle, ett‰ getRequestDispatcher metodi ohjaa pyynnˆt ko. jsp sivustolle
					disp = request.getRequestDispatcher("index.jsp");
					System.out.println("L‰hdet‰‰n sivulle");
					// Ohjataan eteenp‰in request ja response pyynnˆt
					disp.forward(request, response);
				}
				else
					System.out.println("Nyt meni jotain pieleen!!!");
			}
			catch (Exception  e){
				System.out.println(e.getMessage());
					
			}
		}// TODO Auto-generated method stub
		
	}

