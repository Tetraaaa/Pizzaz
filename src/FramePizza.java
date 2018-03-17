import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FramePizza extends JFrame
{
	ArrayList<Pizza> listePizzas;
	JPanel panelPizzas;
	
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
						for(Component b : panelPizzas.getComponents())
						{
							if(b.getClass() == JButton.class)
							{
								b.setBackground(Color.RED);
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
	}
		

	/**
	 * Génère nb instances de la classe Pizza et remplit le panelPizzas avec un bouton par Objet généré
	 * @param nb Nombre de Pizzas à générer et afficher
	 */
	public void GenererPizzas(int nb)
	{
		this.listePizzas = Pizza.generePizza(nb);
		for (Pizza p : listePizzas)
		{
			JButton btn = new JButton(p.toString());
			btn.setBackground(Color.RED);
			btn.addActionListener(new ActionListener()
					{

						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							if(btn.getBackground() == Color.RED)
							{
								btn.setBackground(Color.GREEN);
								System.out.println(btn.getText());
							}
							else
							{
								btn.setBackground(Color.RED);
							}
						}
				
					});
			panelPizzas.add(btn);
		}
		
		System.out.println(listePizzas.size() + " pizzaz générées.");
		
	}
}
