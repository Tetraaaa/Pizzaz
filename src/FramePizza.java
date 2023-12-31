import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

@SuppressWarnings("serial")
public class FramePizza extends JFrame
{
	ArrayList<Pizza> listePizzas;
	JPanel panelPizzas;
	ArrayList<JLabel> images = new ArrayList<JLabel>();
	
	public FramePizza(int nbPizzas)
	{
		super("G�n�rateur de pizzaz");
		
		//Cr�ation panel principal
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		
		//Cr�ation et ajout d'un panel pour les pizzas et un panel pour les boutons au panel principal
		panelPizzas = new JPanel(new GridLayout(4,10));
		JPanel panelBoutons = new JPanel(new FlowLayout());		
		
		
		panelPrincipal.add(panelPizzas);
		panelPrincipal.add(panelBoutons, BorderLayout.PAGE_END);
		
		
		//Cr�ation des boutons reset et valider, bind des �v�nements et ajout au panel boutons
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						for(JLabel j : images)
						{
							j.setIcon(new ImageIcon("src/Assets/red_bg.png"));
							
						}
						for(Pizza p : listePizzas)
						{
							p.setSelected(false);
						}
						
					}
			
				});
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						//////////////////////////////////////////////////////////////////////////////
						//Weka cancer
						//////////////////////////////////////////////////////////////////////////////		 
						 
						 // Declare a nominal attribute along with its values
						 ArrayList<String> fvSauce = new ArrayList<String>();
						 fvSauce.add("tomate");
						 fvSauce.add("barbecue");
						 fvSauce.add("cremefraiche");
						 fvSauce.add("pasdesauce");
						 Attribute attributSauce = new Attribute("sauce", fvSauce);
						 
						 // Declare the class attribute along with its values
						 ArrayList<String> fvMozzacrust = new ArrayList<String>();
						 fvMozzacrust.add("false");
						 fvMozzacrust.add("true");
						 Attribute attributMozza = new Attribute("mozzacrust", fvMozzacrust);
						 
						 ArrayList<String> fvJambon = new ArrayList<String>();
						 fvJambon.add("false");
						 fvJambon.add("true");
						 Attribute attributJambon = new Attribute("jambon", fvJambon);
						 
						 ArrayList<String> fvFromage = new ArrayList<String>();
						 fvFromage.add("false");
						 fvFromage.add("true");
						 Attribute attributFromage = new Attribute("fromage", fvFromage);
						 
						 ArrayList<String> fvChampignon = new ArrayList<String>();
						 fvChampignon.add("false");
						 fvChampignon.add("true");
						 Attribute attributChampi = new Attribute("champignon", fvChampignon);
						 
						 ArrayList<String> fvOlive = new ArrayList<String>();
						 fvOlive.add("false");
						 fvOlive.add("true");
						 Attribute attributOlive = new Attribute("olives", fvOlive);
						 
						 ArrayList<String> fvSelected = new ArrayList<String>();
						 fvSelected.add("false");
						 fvSelected.add("true");
						 Attribute attributSelected = new Attribute("selected", fvSelected);
						 
						 // Declare the feature vector
						 ArrayList<Attribute> fvWekaAttributes = new ArrayList<Attribute>();
						 fvWekaAttributes.add(attributSauce);
						 fvWekaAttributes.add(attributMozza);
						 fvWekaAttributes.add(attributJambon);
						 fvWekaAttributes.add(attributFromage);
						 fvWekaAttributes.add(attributChampi);
						 fvWekaAttributes.add(attributOlive);
						 fvWekaAttributes.add(attributSelected);
						 
						 
						 
						// Create an empty training set
						 Instances isTrainingSet = new Instances("Rel", fvWekaAttributes, 10);
						 // Set class index
						 isTrainingSet.setClassIndex(6);	//selected 
						 		 
						 
						 // Create the instance
						 for(Pizza p : listePizzas)
						 {
							 Instance i = p.setInstance();
							 isTrainingSet.add(i);
						 }

						 
						 
						 
						 //Contruction d'un arbre
						 
						 J48 cls = new J48();	     
					     try {
							cls.buildClassifier(isTrainingSet);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 
					     // display classifier
					     final javax.swing.JFrame jf = 
					       new javax.swing.JFrame("Arbre");
					     jf.setSize(1920,1080);
					     jf.getContentPane().setLayout(new BorderLayout());
					     TreeVisualizer tv;
						try {
							tv = new TreeVisualizer(null,
							     cls.graph(),
							     new PlaceNode2());
						     jf.getContentPane().add(tv, BorderLayout.CENTER);
						     tv.setSize(1920, 1080);
						    
						     tv.fitToScreen();
						     jf.addWindowListener(new java.awt.event.WindowAdapter() {
						       public void windowClosing(java.awt.event.WindowEvent e) {
						         jf.dispose();
						       }
						     });
						
						     jf.setVisible(true);
						     jf.setLocationRelativeTo(null);
						     jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
						     tv.fitToScreen();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
						
				});
		
		panelBoutons.add(btnReset, BorderLayout.LINE_START);
		panelBoutons.add(btnValider, BorderLayout.LINE_END);
					
		WindowListener l = new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		};
		addWindowListener(l);
		
		
		GenererPizzas(nbPizzas);

		
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	
	public Pizza getPizza(JLayeredPane pa)
	{
		for(Pizza p : listePizzas)
		{
			if(p.getPanel() == pa) return p;
		}
		return null;
	}
	
	
	
		

	/**
	 * G�n�re nb instances de la classe Pizza et remplit le panelPizzas avec un bouton par Objet g�n�r�
	 * @param nb Nombre de Pizzas � g�n�rer et afficher
	 */
	public void GenererPizzas(int nb)
	{
		int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
		int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		
		this.listePizzas = Pizza.generePizza(nb);
		for (Pizza p : listePizzas)
		{
			p.setSelected(false);
			JLayeredPane jp = new JLayeredPane();
			p.setPanel(jp);
			jp.setToolTipText(p.toString());
			jp.setSize(width/10,height/4);
			
			
			ArrayList<JLabel> layers = new ArrayList<JLabel>();
			JLabel layerPate = new JLabel();
			layerPate.setSize(192, 260);
			if(p.getMozzaCrust())
			{
				layerPate.setIcon(new ImageIcon("src/Assets/MozzaCrust.png"));
				layers.add(layerPate);
			}
			else
			{
				layerPate.setIcon(new ImageIcon("src/Assets/PateNormale.png"));
				layers.add(layerPate);
			}
			JLabel layerSauce = new JLabel();
			layerSauce.setSize(192, 260);
			
			if(p.getSauce() == Sauce.PasDeSauce)
			{
				layerSauce.setIcon(new ImageIcon("src/Assets/FondPasDeSauce.png"));
				layers.add(layerSauce);
			}
			else if(p.getSauce() == Sauce.Tomate)
			{
				layerSauce.setIcon(new ImageIcon("src/Assets/FondTomate.png"));
				layers.add(layerSauce);
			}
			else if(p.getSauce() == Sauce.Fraiche)
			{
				layerSauce.setIcon(new ImageIcon("src/Assets/FondCremeFraiche.png"));
				layers.add(layerSauce);
			}
			else
			{
				layerSauce.setIcon(new ImageIcon("src/Assets/FondBarbecue.png"));
				layers.add(layerSauce);
			}
			
			if(p.getChampignon())
			{
				JLabel layerChampignonPignon = new JLabel();
				layerChampignonPignon.setSize(192, 260);
				layerChampignonPignon.setIcon(new ImageIcon("src/Assets/Champignons.png"));
				layers.add(layerChampignonPignon);
			}
			
			if(p.getJambon())
			{
				JLabel layerJambon = new JLabel();
				layerJambon.setSize(192, 260);
				layerJambon.setIcon(new ImageIcon("src/Assets/Jambon.png"));
				layers.add(layerJambon);
			}
			
			if(p.getGrandeTaille())
			{
				JLabel layerOlives = new JLabel();
				layerOlives.setSize(192, 260);
				layerOlives.setIcon(new ImageIcon("src/Assets/Olive.png"));
				layers.add(layerOlives);
			}
			
			if(p.getFromage())
			{
				JLabel layerFromage = new JLabel();
				layerFromage.setSize(192, 260);
				layerFromage.setIcon(new ImageIcon("src/Assets/Fromage.png"));
				layers.add(layerFromage);
			}

			
			JLabel image = new JLabel(new ImageIcon("src/Assets/red_bg.png"));
			
			
			
			image.setSize(jp.getWidth(), jp.getHeight());
			images.add(image);
			
			jp.add(image, new Integer(-1));
			
			for(int i = 0; i<layers.size(); i++)
			{
				jp.add(layers.get(i), new Integer(i));
			}

			jp.addMouseListener(new MouseAdapter()
					{
				public void mouseClicked(MouseEvent e)
				{
					if(!(getPizza(jp).getSelected()))
					{
						image.setIcon(new ImageIcon("src/Assets/green_bg.png"));
						getPizza(jp).setSelected(true);
					}
					else
					{
						image.setIcon(new ImageIcon("src/Assets/red_bg.png"));
						getPizza(jp).setSelected(false);
					}
				}
					});
			panelPizzas.add(jp);
		}
		
		System.out.println(listePizzas.size() + " pizzaz g�n�r�es.");
		
	}
}
