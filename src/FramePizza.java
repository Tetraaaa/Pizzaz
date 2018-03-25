import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

@SuppressWarnings("serial")
public class FramePizza extends JFrame
{
	ArrayList<Pizza> listePizzas;
	JPanel panelPizzas;
	ArrayList<JLabel> images = new ArrayList<JLabel>();
	
	public FramePizza(int nbPizzas)
	{
		super("Générateur de pizzaz");
		
		//Création panel principal
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		
		//Création et ajout d'un panel pour les pizzas et un panel pour les boutons au panel principal
		panelPizzas = new JPanel(new GridLayout(4,10));
		JPanel panelBoutons = new JPanel(new FlowLayout());		
		
		
		panelPrincipal.add(panelPizzas);
		panelPrincipal.add(panelBoutons, BorderLayout.PAGE_END);
		
		
		//Création des boutons reset et valider, bind des évènements et ajout au panel boutons
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						for(JLabel j : images)
						{
							j.setIcon(new ImageIcon("src/Assets/red_bg.png"));
							
						}
						for(Component c : panelPizzas.getComponents())
						{
							if(c.getClass() == JLayeredPane.class)
							{
								c.setBackground(Color.RED);
							}
						}
						
					}
			
				});
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("sa fé rien mdr");
						
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
		
/*		
		//////////////////////////////////////////////////////////////////////////////
		//Weka cancer
		//////////////////////////////////////////////////////////////////////////////
		
		
		
		 // Declare two numeric attributes
		 Attribute Sauce = new Attribute("sauce");
		 Attribute Mozzacrust = new Attribute("mozzacrust");
		 
		 // Declare a nominal attribute along with its values
		 FastVector fvSauce = new FastVector(4);
		 fvSauce.addElement("tomate");
		 fvSauce.addElement("barbecue");
		 fvSauce.addElement("cremefraiche");
		 fvSauce.addElement("pasdesauce");
		 Attribute Attribute3 = new Attribute("aNominal", fvSauce);
		 
		 // Declare the class attribute along with its values
		 FastVector fvMozzacrust = new FastVector(2);
		 fvMozzacrust.addElement("positive");
		 fvMozzacrust.addElement("negative");
		 Attribute ClassAttribute = new Attribute("theClass", fvMozzacrust);
		 
		 // Declare the feature vector
		 FastVector fvWekaAttributes = new FastVector(5);
		 fvWekaAttributes.addElement(Sauce);
		 fvWekaAttributes.addElement(Mozzacrust);
		 fvWekaAttributes.addElement(Attribute3);
		 fvWekaAttributes.addElement(ClassAttribute);
		 
		 
		 
		// Create an empty training set
		 Instances isTrainingSet = new Instances("Rel", fvWekaAttributes, 10);
		 // Set class index
		 isTrainingSet.setClassIndex(3);
		 
		 
		 
		 
		 
		 // Create the instance
		 Instance iExample = new DenseInstance(4);
		 iExample.setValue((Attribute)fvWekaAttributes.get(0), 1.0);
		 iExample.setValue((Attribute)fvWekaAttributes.get(1), 0.5);
		 iExample.setValue((Attribute)fvWekaAttributes.get(2), "tomate");
		 iExample.setValue((Attribute)fvWekaAttributes.get(3), "positive");
		 
		 // add the instance
		 isTrainingSet.add(iExample);
		 
		 
		 
		 
		 
		 
		 
		 // Create a naïve bayes classifier
		 Classifier cModel = (Classifier)new NaiveBayes();
		 cModel.buildClassifier(isTrainingSet);
		 
		 
		 
		 
		 
		 
		// Test the model
		 Evaluation eTest = new Evaluation(isTrainingSet);
		 eTest.evaluateModel(cModel, isTestingSet);
		 
		 
		 
		// Print the result à la Weka explorer:
		 String strSummary = eTest.toSummaryString();
		 System.out.println(strSummary);
		 
		 // Get the confusion matrix
		 double[][] cmMatrix = eTest.confusionMatrix();
		 
		 
		 
		 
		// Specify that the instance belong to the training set
		 // in order to inherit from the set description
		 iUse.setDataset(isTrainingSet);
		 
		 // Get the likelihood of each classes
		 // fDistribution[0] is the probability of being "positive"
		 // fDistribution[1] is the probability of being "negative"
		 double[] fDistribution = cModel.distributionForInstance(iUse);

		 System.out.println("cancer");
		 */
	}
	
	
	
		

	/**
	 * Génère nb instances de la classe Pizza et remplit le panelPizzas avec un bouton par Objet généré
	 * @param nb Nombre de Pizzas à générer et afficher
	 */
	public void GenererPizzas(int nb)
	{
		int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
		int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		
		this.listePizzas = Pizza.generePizza(nb);
		for (Pizza p : listePizzas)
		{
			JLayeredPane jp = new JLayeredPane();
			jp.setBackground(Color.RED);
			jp.setToolTipText(p.toString());
			jp.setSize(width/10,height/4);
			System.out.println("width : " + jp.getWidth() + " height : " + jp.getHeight());
			
			
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
					if(jp.getBackground() == Color.RED)
					{
						image.setIcon(new ImageIcon("src/Assets/green_bg.png"));
						jp.setBackground(Color.GREEN);
						System.out.println(jp.getToolTipText());
					}
					else
					{
						image.setIcon(new ImageIcon("src/Assets/red_bg.png"));
						jp.setBackground(Color.RED);
					}
				}
					});
			panelPizzas.add(jp);
		}
		
		System.out.println(listePizzas.size() + " pizzaz générées.");
		
	}
}
