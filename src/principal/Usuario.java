package principal;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Usuario {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();

			}
		});
	}

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("BLAST");
		VistaDePaneles vista = new VistaDePaneles(); // vista
		PanelDeControl control = new PanelDeControl(vista); // control
		vista.getQueryButton().addActionListener(control);
		vista.setOpaque(true);
		frame.setContentPane(vista);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
