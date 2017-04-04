package pizzaLovers;

import java.io.Serializable;
import java.util.ArrayList;

import pizzaLovers.Tayte;


public class Pizza implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pizzaId;
	private String nimi;
	private double hinta;
	public ArrayList<Tayte> taytteet;


	public Pizza() {
		pizzaId = 0;
		nimi = "";
		hinta = 0;
		this.taytteet = new ArrayList<>();
	}

	// construktori
	public Pizza(int pizzaId, String nimi, double hinta) {
		this.pizzaId = pizzaId;
		this.nimi = nimi;
		this.hinta = hinta;
		this.taytteet = new ArrayList<>();
	}


	/**
	 * @return the pizzaId
	 */
	public int getPizzaId() {
		return pizzaId;
	}

	/**
	 * @param pizzaId the pizzaId to set
	 */
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	/**
	 * @return the nimi
	 */
	public String getNimi() {
		return nimi;
	}

	/**
	 * @param nimi the nimi to set
	 */
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	/**
	 * @return the hinta
	 */
	public double getHinta() {
		return hinta;
	}

	/**
	 * @param hinta the hinta to set
	 */
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public void addTayte(Tayte tayte) {
		taytteet.add(tayte);
	}

	public Tayte getTayte(int index) {
		return taytteet.get(index);
	}

	
	//allaoleva ei periaatteessa tarpeen
	public ArrayList<Tayte> getTaytteet() {
		return this.taytteet;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pizza pizzaId=" + pizzaId + ", nimi=" + nimi + ", hinta="
				+ hinta;
	}
}
