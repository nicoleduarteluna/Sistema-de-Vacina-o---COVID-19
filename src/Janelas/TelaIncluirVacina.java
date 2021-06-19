package Janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controle.Vacina;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class TelaIncluirVacina extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField fabricanteField;
	private JTextField qtdeDosesField;
	private JTextField intervaloField;
	private JTextField validadeField;
	private JTextField eficaciaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIncluirVacina frame = new TelaIncluirVacina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaIncluirVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(601, 134, 45, 15);
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setForeground(Color.WHITE);
		lblFabricante.setBounds(601, 198, 81, 15);
		lblFabricante.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblQuantidadeDeDoses = new JLabel("Qtde. de doses:");
		lblQuantidadeDeDoses.setForeground(Color.WHITE);
		lblQuantidadeDeDoses.setBounds(601, 257, 93, 15);
		lblQuantidadeDeDoses.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblIntervaloEntreAs = new JLabel("Intervalo entre as doses: ");
		lblIntervaloEntreAs.setForeground(Color.WHITE);
		lblIntervaloEntreAs.setBounds(600, 322, 157, 15);
		lblIntervaloEntreAs.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblValidade = new JLabel("Dt. validade:");
		lblValidade.setForeground(Color.WHITE);
		lblValidade.setBounds(724, 257, 93, 15);
		lblValidade.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblEficcia = new JLabel("Efic\u00E1cia:");
		lblEficcia.setForeground(Color.WHITE);
		lblEficcia.setBounds(602, 391, 78, 15);
		lblEficcia.setFont(new Font("Segoe UI", Font.BOLD, 13));

		nomeField = new JTextField();
		nomeField.setForeground(Color.WHITE);
		nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nomeField.setCaretColor(Color.WHITE);
		nomeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		nomeField.setOpaque(false);
		nomeField.setBounds(601, 157, 235, 25);
		nomeField.setColumns(10);

		fabricanteField = new JTextField();
		fabricanteField.setForeground(Color.WHITE);
		fabricanteField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fabricanteField.setCaretColor(Color.WHITE);
		fabricanteField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		fabricanteField.setOpaque(false);
		fabricanteField.setBounds(601, 219, 235, 25);
		fabricanteField.setColumns(10);

		qtdeDosesField = new JTextField();
		qtdeDosesField.setForeground(Color.WHITE);
		qtdeDosesField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		qtdeDosesField.setCaretColor(Color.WHITE);
		qtdeDosesField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		qtdeDosesField.setOpaque(false);
		qtdeDosesField.setBounds(601, 279, 118, 25);
		qtdeDosesField.setColumns(10);

		intervaloField = new JTextField();
		intervaloField.setForeground(Color.WHITE);
		intervaloField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		intervaloField.setCaretColor(Color.WHITE);
		intervaloField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		intervaloField.setOpaque(false);
		intervaloField.setBounds(601, 347, 53, 25);
		intervaloField.setColumns(10);

		try {
			validadeField = new JFormattedTextField(new MaskFormatter("##/##/####"));
			validadeField.setHorizontalAlignment(SwingConstants.CENTER);
			validadeField.setForeground(Color.WHITE);
			validadeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			validadeField.setCaretColor(Color.WHITE);
			validadeField.setBorder(new MatteBorder(0, 1, 2, 0, (Color) new Color(0, 255, 255)));
			validadeField.setOpaque(false);
			validadeField.setBounds(724, 279, 112, 25);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validadeField.setColumns(10);

		eficaciaField = new JTextField();
		eficaciaField.setForeground(Color.WHITE);
		eficaciaField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		eficaciaField.setCaretColor(Color.WHITE);
		eficaciaField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		eficaciaField.setOpaque(false);
		eficaciaField.setBounds(601, 413, 53, 25);
		eficaciaField.setColumns(10);

		JLabel lblDias = new JLabel("dias.");
		lblDias.setForeground(Color.WHITE);
		lblDias.setBounds(656, 358, 68, 15);
		lblDias.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblDias_1 = new JLabel("%. ");
		lblDias_1.setForeground(Color.WHITE);
		lblDias_1.setBounds(657, 424, 26, 15);
		lblDias_1.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.setBounds(637, 469, 68, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicioVacina tela = new TelaInicioVacina();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.CYAN);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnIncluir.setBounds(734, 469, 71, 30);
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (nomeField.getText().equals("") || fabricanteField.getText().equals("")
						|| qtdeDosesField.getText().equals("") || intervaloField.getText().equals("")
						|| validadeField.getText().equals("") || eficaciaField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Para prosseguir, preencha todos os campos.");
				} else if (qtdeDosesField.getText().equals("0")) {
					JOptionPane.showMessageDialog(null, "Não é permitido cadastrar uma vacina de 0 dose.");
					nomeField.setText("");
					fabricanteField.setText("");
					qtdeDosesField.setText("");
					validadeField.setText("");
					intervaloField.setText("");
					eficaciaField.setText("");
					
				} else if (qtdeDosesField.getText().equals("3")) {
					JOptionPane.showMessageDialog(null, "O limite de doses permitidas por vacina são 2.");
					nomeField.setText("");
					fabricanteField.setText("");
					qtdeDosesField.setText("");
					validadeField.setText("");
					intervaloField.setText("");
					eficaciaField.setText("");
					
				}	else{
					String nome = nomeField.getText();
					String fabricante = fabricanteField.getText();
					int qtdeDoses = Integer.parseInt(qtdeDosesField.getText());
					int intervalo = Integer.parseInt(intervaloField.getText());
					String validade = validadeField.getText();
					int eficacia = Integer.parseInt(eficaciaField.getText());

					Vacina v = new Vacina();
					v.setNome(nome);
					v.setFabricante(fabricante);
					v.setQtdeDoses(qtdeDoses);
					v.setIntervalo(intervalo);
					v.setValidade(validade);
					v.setEficacia(eficacia);
					v.inserir();

					// Limpando campos

					nomeField.setText("");
					fabricanteField.setText("");
					qtdeDosesField.setText("");
					validadeField.setText("");
					intervaloField.setText("");
					eficaciaField.setText("");
				}
			}
		});
		btnIncluir.setForeground(Color.BLACK);
		btnIncluir.setBackground(Color.CYAN);
		contentPane.setLayout(null);
		contentPane.add(lblNome);
		contentPane.add(nomeField);
		contentPane.add(lblQuantidadeDeDoses);
		contentPane.add(qtdeDosesField);
		contentPane.add(lblFabricante);
		contentPane.add(fabricanteField);
		contentPane.add(lblIntervaloEntreAs);
		contentPane.add(intervaloField);
		contentPane.add(lblDias);
		contentPane.add(lblEficcia);
		contentPane.add(lblValidade);
		contentPane.add(eficaciaField);
		contentPane.add(lblDias_1);
		contentPane.add(validadeField);
		contentPane.add(btnNewButton);
		contentPane.add(btnIncluir);
		
		JLabel lblNewLabel = new JLabel("Fundo Tela Cadastro Vacina");
		lblNewLabel.setIcon(new ImageIcon(TelaIncluirVacina.class.getResource("/Imagens/Tela Cadastrar Vacina.png")));
		lblNewLabel.setBounds(0, 0, 846, 513);
		contentPane.add(lblNewLabel);
	}
}
