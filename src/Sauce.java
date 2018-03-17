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
	
	public static Sauce randomSauce()
	{
		int min = 0; int max = 4;	
		int randomInt = (int)(Math.random() * max + min);

		
		if (randomInt == 0){
			return Sauce.Tomate;
		}
		else if (randomInt == 1){
			return Sauce.BBQ;
		}
		else if (randomInt == 2){
			return Sauce.Fraiche;
		}
		else if (randomInt == 3){
			return Sauce.PasDeSauce;		
		}
		return null;
	}
}
	