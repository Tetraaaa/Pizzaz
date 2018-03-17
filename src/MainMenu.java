
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainMenu extends JFrame
{

	public MainMenu()
	{
		super("Générateur de pizzaz");
		Font f = new Font("Calibri", Font.PLAIN, 26);
		WindowListener l = new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		};
		
		addWindowListener(l);
		
		
		JPanel panel = new JPanel(new GridLayout(3,1));
		JButton bouton = new JButton("Générer des pizaz");
		JLabel label = new JLabel("Générateur de PIZZAZ v1.0", SwingConstants.CENTER);
		JLabel label2 = new JLabel("Par LUDWIG Axel et STROHL Nicolas.", SwingConstants.CENTER);
		
		bouton.setFont(f);
		label.setFont(f);
		
		
		bouton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new FramePizza(40);
			}
			
		});
		panel.add(label);
		panel.add(label2);
		panel.add(bouton);

		setContentPane(panel);
		setSize(320,480);
		setLocationRelativeTo(null); //Centre la fenêtre à l'écran
		setVisible(true);
	}
	
}
