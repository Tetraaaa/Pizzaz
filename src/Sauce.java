
public enum Sauce {
	Tomate("sauce tomate"), 
	BBQ("BBQ"), 
	Fraiche("sauce fraiche"), 
	PasDeSauce("pas de sauce");

	private String name = "";

	// Constructeur
	Sauce(String name){
	    this.name = name;
	  }

	public String toString() {
		return name;
	}
}
