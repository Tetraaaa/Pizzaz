import java.util.ArrayList;
import java.util.Random;

public class Pizza {
	private Boolean grandeTaille;	//Si faux : pizza de taille normale
	private Boolean mozzaCrust;	
	private Sauce sauce;
	private Boolean jambon;
	private Boolean fromage;
	private Boolean champignon;
	
	public Pizza(Boolean grandeTaille, Boolean mozzaCrust, Sauce sauce, Boolean jambon, Boolean fromage, Boolean champignon) {
		this.grandeTaille = grandeTaille;
		this.mozzaCrust = mozzaCrust;
		this.sauce = sauce;
		this.jambon = jambon;
		this.fromage = fromage;
		this.champignon = champignon;
	}
	
	@Override
	public String toString(){
		
		String res = "Taille : " + this.getGrandeTaille() + "\n";		
		res += "Mozzacrust : " + this.getMozzaCrust() + "\n";		
		res += "Sauce : " + this.getSauce().toString() + "\n";		
		res += "Jambon : " + this.getJambon() + "\n";		
		res += "Fromage : " + this.getFromage() + "\n";
		res += "Champignon : " + this.getChampignon() + "\n";
		
		return res;		
	}	
	
	
	public static ArrayList<Pizza> generePizza(int n){
		
		Random r = new Random();
		
		ArrayList<Pizza> res = new ArrayList<Pizza>();
		
		for (int i = 0; i < n; i++){
			Pizza p = new Pizza(r.nextBoolean(), r.nextBoolean(), Sauce.randomSauce(), 
					r.nextBoolean(), r.nextBoolean(), r.nextBoolean());
			res.add(p);
		}
		
		return res;
	}
		
	

	public Boolean getGrandeTaille() {
		return grandeTaille;
	}

	public void setGrandeTaille(Boolean grandeTaille) {
		this.grandeTaille = grandeTaille;
	}

	public Boolean getMozzaCrust() {
		return mozzaCrust;
	}

	public void setMozzaCrust(Boolean mozzaCrust) {
		this.mozzaCrust = mozzaCrust;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public Boolean getJambon() {
		return jambon;
	}

	public void setJambon(Boolean jambon) {
		this.jambon = jambon;
	}

	public Boolean getFromage() {
		return fromage;
	}

	public void setFromage(Boolean fromage) {
		this.fromage = fromage;
	}

	public Boolean getChampignon() {
		return champignon;
	}

	public void setChampignon(Boolean champignon) {
		this.champignon = champignon;
	}	
	
	
	
}






/*
on choisi les piza 

taille : normal, grand
mozacrust : bool
sauce : pas de sauce, tomate, bbq, creme fraiche
jambon : bool
fromage : bool
champignon : bool
ananas : non
*/