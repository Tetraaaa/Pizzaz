import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JFrame
{
	public MainMenu()
	{
		super("Générateur de pizzaz");
		WindowListener l = new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		};
		
		addWindowListener(l);
		JPanel panel = new JPanel();

		JButton bouton = new JButton("Générer des pizaz");
		bouton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("ausecour");
				JFrame f = new FramePizza();
			}
			
		});
		panel.add(bouton);
		setContentPane(panel);
		setSize(320,480);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
