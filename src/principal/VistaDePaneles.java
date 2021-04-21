package principal;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaDePaneles extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textField;
	protected JTextArea textArea;
	protected JPanel querySequence;
	protected JButton queryButton;
	protected JComboBox<String> comboOfOptions, typeFile;
	protected JRadioButton proteinButton;
	protected JRadioButton nucleotidButton;
	protected ArrayList<String> searchList;

	public VistaDePaneles() {
		searchList = new ArrayList<String>();

		// Panel queryType

		// Create the radio button
		String proteinString = new String("Protein");
		String nucleotidString = new String("Nucleotide sequence");
		proteinButton = new JRadioButton(proteinString, true);
		nucleotidButton = new JRadioButton(nucleotidString, false);

		// Group the radio buttons

		ButtonGroup group = new ButtonGroup();
		group.add(proteinButton);
		group.add(nucleotidButton);
		JPanel queryType = new JPanel(new GridLayout(1, 0));
		queryType.add(proteinButton);
		queryType.add(nucleotidButton);
		add(queryType);

		// Panel querySequence

		JLabel labelQuerySelection = new JLabel("Enter the sequence to compare: ");
		typeFile = new JComboBox<String>();
		typeFile.setEditable(false);
		typeFile.addItem("yeast.aa");
		querySequence = new JPanel(new GridLayout(1, 0));
		comboOfOptions = new JComboBox<String>();
		comboOfOptions.setEditable(true);
		querySequence.add(labelQuerySelection);
		querySequence.add(typeFile);
		querySequence.add(comboOfOptions);
		add(querySequence);

		// Panel queryPercentage

		textField = new JTextField("Query percentage: ", 12);
		textArea = new JTextArea(1, 3);
		textArea.setEditable(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(textField);
		add(scrollPane);

		JPanel panel1 = new JPanel();
		panel1.add(textField);

		JPanel panel2 = new JPanel();
		panel2.add(scrollPane);

		JSplitPane queryPercentage = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);

		// Panel queryButton // A ESTE PANEL LE FALTA ALGO

		JPanel panelButtonQuery = new JPanel();
		queryButton = new JButton("Press the button to make the query");
		queryButton.setLayout(new GridLayout(2, 1));
		panelButtonQuery.add(queryButton);
		this.add(panelButtonQuery);

		// Panel queryResult

		JTextArea queryResult = new JTextArea(10, 20);
		queryResult.setEditable(false);
		JScrollPane scroll = new JScrollPane(queryResult);
		add(scroll);

		// Unimos los paneles

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Type", queryType);
		tabbedPane.addTab("Sequence", querySequence);
		tabbedPane.addTab("Percentage", queryPercentage);
		tabbedPane.addTab("To make a query", panelButtonQuery);
		tabbedPane.addTab("Result", queryResult);
		add(tabbedPane);

	}

	public JButton getQueryButton() {
		return queryButton;
	}

	public JComboBox<String> getComboOptions() {
		return comboOfOptions;
	}

	public JRadioButton getProtein() {
		return proteinButton;
	}

	public JTextField getFieldPercentage() {
		return textField;
	}

	public JTextArea getResponseArea() {
		return textArea;
	}

	public ArrayList<String> getSearchList() {
		return searchList;
	}

	public JComboBox<String> getTypeFile() {
		return typeFile;
	}

}
