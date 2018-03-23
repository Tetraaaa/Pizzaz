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
						System.out.println("sa f� rien mdr");
						
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
			JLayeredPane jp = new JLayeredPane();
			jp.setBackground(Color.RED);
			jp.setToolTipText(p.toString());
			jp.setSize(width/10,height/4);
			System.out.println("width : " + jp.getWidth() + " height : " + jp.getHeight());
			JLabel image = new JLabel(new ImageIcon("src/Assets/red_bg.png"));
			JLabel text = new JLabel(new ImageIcon("src/Assets/test.png"));
			
			
			
			image.setSize(jp.getWidth(), jp.getHeight());
			
			images.add(image);
			
			text.setSize(173, 234);
			jp.add(image, new Integer(-1));
			jp.add(text, new Integer(0));
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
		
		System.out.println(listePizzas.size() + " pizzaz g�n�r�es.");
		
	}
}
