package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blast.BlastController;

public class PanelDeControl implements ActionListener {
	private VistaDePaneles vista;

	public PanelDeControl(VistaDePaneles vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean correctRequest = true;
		float percentage = -1;

		if (e.getSource().equals(vista.getQueryButton())) {

			if (vista.getComboOptions().getSelectedItem() == null || vista.getFieldPercentage().getText().isEmpty()) {
				vista.getResponseArea().setText("Error: Los campos introducidos no son correctos");
				correctRequest = false;
			} else {
				percentage = Float.parseFloat(vista.getFieldPercentage().getText());
				if (percentage < 0 || percentage > 1) {
					vista.getResponseArea().setText("Error: El porcentaje dado no es valido");
					correctRequest = false;
				}

			}
		}

		if (correctRequest) {
			SearchButton(percentage);

		}
	}

	public void SearchButton(float porcentaje) {
		BlastController bCnt = new BlastController();
		Boolean searchProtein = vista.getProtein().isSelected();
		char queryType;

		if (searchProtein) {
			queryType = 'p';

		} else {
			queryType = 'n';
		}

		String lastSearch = vista.getComboOptions().getSelectedItem().toString();
		if (vista.getSearchList().indexOf(lastSearch) == -1) {
			vista.getComboOptions().addItem(lastSearch);
			vista.getSearchList().add(lastSearch);

		}

		String file = vista.getTypeFile().getSelectedItem().toString();
		String indexFile = file + ".indexs";
		String result = null;
		try {
			result = bCnt.blastQuery(queryType, file, indexFile, porcentaje, lastSearch);
		} catch (Exception exc) {
			System.out.println("Error en la llamada: " + exc.toString());
			result = "No se ha podido buscar";
		}

		vista.getResponseArea().setText(result);

	}
}
