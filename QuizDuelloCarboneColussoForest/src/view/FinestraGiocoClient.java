package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class FinestraGiocoClient extends JFrame {

	private static final long serialVersionUID = -1966956274434527677L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JProgressBar progressBar;
	private JList<String> list;
	private DefaultListModel<String> modello;
	private JLabel lblInfo;
	private JLabel lblDomanda;
	private JButton btnRisposta;
	private JButton btnRisposta_1;
	private JButton btnRisposta_2;
	private JButton btnRisposta_3;

	public FinestraGiocoClient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\QuizDuelloCarboneColussoForest\\resources\\icon.png"));
		setTitle("QuizZello");
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setToolTipText("Timer per rispondere");
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(10, 238, 424, 22);
		contentPane.add(progressBar);
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 11, 104, 216);
		contentPane.add(scrollPane);
		
		list = new JList<String>();
		list.setToolTipText("Giocatori");
		
		modello = new DefaultListModel<String>();
		list.setModel(modello);
		scrollPane.setViewportView(list);
		
		lblInfo = new JLabel("Domanda:");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(243, 13, 71, 14);
		contentPane.add(lblInfo);
		
		lblDomanda = new JLabel("New label");
		lblDomanda.setToolTipText("Domanda");
		lblDomanda.setHorizontalAlignment(SwingConstants.CENTER);
		lblDomanda.setBounds(124, 38, 310, 58);
		contentPane.add(lblDomanda);
		
		btnRisposta = new JButton("Risposta1");
		btnRisposta.setBounds(124, 117, 310, 23);
		contentPane.add(btnRisposta);
		
		btnRisposta_1 = new JButton("Risposta2");
		btnRisposta_1.setBounds(124, 139, 310, 23);
		contentPane.add(btnRisposta_1);
		
		btnRisposta_2 = new JButton("Risposta3");
		btnRisposta_2.setBounds(124, 161, 310, 23);
		contentPane.add(btnRisposta_2);
		
		btnRisposta_3 = new JButton("Risposta4");
		btnRisposta_3.setBounds(124, 183, 310, 23);
		contentPane.add(btnRisposta_3);
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JList<String> getList() {
		return list;
	}

	public JLabel getLblDomanda() {
		return lblDomanda;
	}

	public JButton getBtnRisposta() {
		return btnRisposta;
	}

	public JButton getBtnRisposta_1() {
		return btnRisposta_1;
	}

	public JButton getBtnRisposta_2() {
		return btnRisposta_2;
	}

	public JButton getBtnRisposta_3() {
		return btnRisposta_3;
	}

	public DefaultListModel<String> getModello() {
		return modello;
	}

	public void setModello(DefaultListModel<String> modello) {
		this.modello = modello;
	}
	
	public void clearColors() {
		lblInfo.setBackground(null);
		btnRisposta.setBackground(null);
		btnRisposta_1.setBackground(null);
		btnRisposta_2.setBackground(null);
		btnRisposta_3.setBackground(null);
	}
	
}
