import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Interaktivpanel extends JPanel {
private JPanel regel = new JPanel();
private JButton regelbutton = new JButton("Regeldarstellung");

	public Interaktivpanel() {
		zeichne();
	}

	private void zeichne() {
		setLayout(new BorderLayout());
		add(new JLabel("Hier wird die interaktive Baumdarstellung entstehen"), BorderLayout.NORTH);
		regel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(regel, BorderLayout.SOUTH);
		regel.add(regelbutton);
	}
	
}