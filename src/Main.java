import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {	
		
//		Sauce bbq = Sauce.BBQ;
		
//		Pizza pizzaTest = new Pizza();
//		pizzaTest.setGrandeTaille(true);
//		pizzaTest.setChampignon(true);
//		pizzaTest.setFromage(true);
//		pizzaTest.setMozzaCrust(false);
//		pizzaTest.setJambon(true);
//		pizzaTest.setSauce(bbq);
//		pizzaTest.setSauce(Sauce.randomSauce());
//		
//		System.out.println(pizzaTest.toString());
		
//		int tomate = 0;
//		int bbq = 0;
//		int fraiche = 0;
//		int pasDeSauce = 0;
		
		ArrayList<Pizza> listePizza = Pizza.generePizza(10000);
		for (Pizza p : listePizza){
//			if (p.getSauce() == Sauce.Tomate){
//				tomate++;
//			}
//			else if (p.getSauce() == Sauce.BBQ){
//				bbq++;
//			}
//			else if (p.getSauce() == Sauce.Fraiche){
//				fraiche++;
//			}
//			else pasDeSauce++;
			
			System.out.println(p.toString());
			System.out.println("=====================================");
		}
		
//		System.out.println("tomate : " + tomate + "\n" + 
//				"bbq : " + bbq + "\n" + 
//				"fraiche : " + fraiche + "\n" + 
//				"pasDeSauce : " + pasDeSauce + "\n");
		
		System.out.println(listePizza.size());
		
	}

}
