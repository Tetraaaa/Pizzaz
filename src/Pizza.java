import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLayeredPane;

import weka.core.DenseInstance;
import weka.core.Instance;

public class Pizza {
	private Boolean grandeTaille;	//Si faux : pizza de taille normale
	private Boolean mozzaCrust;	
	private Sauce sauce;
	private Boolean jambon;
	private Boolean fromage;
	private Boolean champignon;
	private boolean selected = false;
	private JLayeredPane panel;
	
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
	
	public boolean getSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean s)
	{
		this.selected = s;
	}
	
	public JLayeredPane getPanel()
	{
		return this.panel;
	}
	
	public void setPanel(JLayeredPane p)
	{
		this.panel = p;
	}
	
	public Instance setInstance()
	{
		Instance i = new DenseInstance(7);
		if(getSauce() == Sauce.PasDeSauce)
		{
			i.setValue(0, 3);
		}
		else if(getSauce() == Sauce.Tomate)
		{
			i.setValue(0, 0);
		}
		else if(getSauce() == Sauce.Fraiche)
		{
			i.setValue(0, 2);
		}
		else
		{
			i.setValue(0, 1);
		}
		
		if(getMozzaCrust())
		{
			i.setValue(1, 1);
		}
		else
		{
			i.setValue(1, 0);
		}
		
		if(jambon)
		{
			i.setValue(2, 1);
		}
		else
		{
			i.setValue(2, 0);
		}
		
		if(fromage)
		{
			i.setValue(3, 1);
		}
		else
		{
			i.setValue(3, 0);
		}
		
		if(champignon)
		{
			i.setValue(4, 1);
		}
		else
		{
			i.setValue(4, 0);
		}
		if(grandeTaille)
		{
			i.setValue(5, 1);
		}
		else
		{
			i.setValue(5, 0);
		}
		
		if(selected)
		{
			i.setValue(6, 1);
		}
		else
		{
			i.setValue(6, 0);
		}
		
		return i;	
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