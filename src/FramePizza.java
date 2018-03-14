import java.awt.BorderLayout;
import java.awt.Color;
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

public class FramePizza extends JFrame
{
	ArrayList<Pizza> listePizzas;
	
	public FramePizza()
	{
		super("Générateur de pizzaz");
		JPanel panelPrincipal = new JPanel(new GridLayout(2,1));
		
		JPanel panel = new JPanel(new GridLayout(4,10));
		JPanel panelBoutons = new JPanel(new FlowLayout());		
		
		
		panelPrincipal.add(panel);
		panelPrincipal.add(panelBoutons);
		
		panelBoutons.add(new JButton("Reset"), BorderLayout.LINE_START);
		panelBoutons.add(new JButton("Valider"), BorderLayout.LINE_END);
		
		
		
		
		
		WindowListener l = new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		};
		
		listePizzas = Pizza.generePizza(40);
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
							}
							else
							{
								btn.setBackground(Color.RED);
							}
						}
				
					});
			panel.add(btn);
		}
		
		System.out.println(listePizzas.size() + " pizzaz générées.");
		
		addWindowListener(l);

		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
