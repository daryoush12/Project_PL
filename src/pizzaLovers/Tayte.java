package pizzaLovers;

public class Tayte {

	int tayteId;
	String tayteNimi;

	// construktorit

	public Tayte(int tayteId, String tayteNimi) {
		this.tayteId = tayteId;
		this.tayteNimi = tayteNimi;
	}

	public Tayte() {
		this.tayteId = 0;
		this.tayteNimi = "";
	}

	// getterit ja setterit

	public int gettayteId() {
		return tayteId;
	}

	public void settayteId(int tayteId) {
		this.tayteId = tayteId;
	}

	public String getTayteNimi() {
		return tayteNimi;
	}

	public void setTayteNimi(String tayteNimi) {
		this.tayteNimi = tayteNimi;
	}

	// tostring

	public String toString() {
		return tayteNimi;
	}

}
