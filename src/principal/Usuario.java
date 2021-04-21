package principal;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Usuario {

	// Añadimos las funcionalidades a los componentes mediante la clase controlador

	// Controlador controlador = new Controlador(vista);

	// vista.getButtonBuscar().addActionListener(controlador);
	// frame.add(vista);

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("GUI");
				VistaDePaneles vista = new VistaDePaneles(); // vista
				PanelDeControl control = new PanelDeControl(vista); //control
				vista.getQueryButton().addActionListener(control);
				vista.setOpaque(true);
				frame.setContentPane(vista);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
