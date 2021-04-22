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
	
	private static final long serialVersionUID = 1L;
	protected JTextField textField;
	protected JTextArea queryResult,tResult;
	protected JPanel queryType, querySequence, queryPercentage,panelButtonQuery;
	protected JLabel lType, lIndex, labelQuerySelection,lPercentage;
	protected JButton queryButton;
	protected ButtonGroup group;
	protected JComboBox<String> comboOfOptions, typeFile, numberIndex;
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

		group = new ButtonGroup();
		group.add(proteinButton);
		group.add(nucleotidButton);
		queryType = new JPanel(new GridLayout(1, 0));
		queryType.add(proteinButton);
		queryType.add(nucleotidButton);
		add(queryType);

		// Panel querySequence
		
		querySequence = new JPanel();
		querySequence.setLayout(new GridLayout(5, 2));
		lType = new JLabel("Choose the database: ");
		lIndex = new JLabel("Index : ");
		labelQuerySelection = new JLabel("Enter the sequence to compare: ");
		typeFile = new JComboBox<String>();
		typeFile.setEditable(false);
		typeFile.addItem("yeast.aa");
		numberIndex = new JComboBox<String>();
		numberIndex.setEditable(false);
		numberIndex.addItem("yeast.aa.indexs");
		comboOfOptions = new JComboBox<String>();
		comboOfOptions.setEditable(true);
		lPercentage = new JLabel("Indicates the percentage: ");
		textField = new JTextField();
		textField.setEditable(true);
		querySequence.add(lType);
		querySequence.add(typeFile);
		querySequence.add(lIndex);
		querySequence.add(numberIndex);
		querySequence.add(labelQuerySelection);
		querySequence.add(comboOfOptions);
		querySequence.add(lPercentage);
		querySequence.add(textField);
		add(querySequence);

			// create button to make the query
		
		panelButtonQuery = new JPanel();
		queryButton = new JButton("Press to make the query");
		queryButton.setLayout(new GridLayout(1, 1));
		panelButtonQuery.add(queryButton);
		this.add(panelButtonQuery);

		JSplitPane makeQuery = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, querySequence, panelButtonQuery);

		// Panel queryResult

		queryResult = new JTextArea(20, 60);
		queryResult.setEditable(false);
		JScrollPane scroll = new JScrollPane(queryResult);
		add(scroll);
		
		// All panels

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Type", queryType);
		tabbedPane.addTab("Sequence", makeQuery);
		tabbedPane.addTab("Result", scroll);
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
		return queryResult;
	}

	public ArrayList<String> getSearchList() {
		return searchList;
	}

	public JComboBox<String> getTypeFile() {
		return typeFile;
	}

}
