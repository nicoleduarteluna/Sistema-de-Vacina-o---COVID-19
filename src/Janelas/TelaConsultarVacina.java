package Janelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Controle.Vacina;

public class TelaConsultarVacina extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField nomeField;
	private JTextField fabricanteField;
	private JTextField qtdeField;
	private JTextField validadeField;
	private JTextField eficaciaField;
	private JTextField intervaloField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarVacina frame = new TelaConsultarVacina();
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
	public TelaConsultarVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(599, 191, 45, 15);
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblQtdeDeDoses = new JLabel("Qtde. de doses:");
		lblQtdeDeDoses.setForeground(Color.WHITE);
		lblQtdeDeDoses.setBounds(599, 292, 104, 15);
		lblQtdeDeDoses.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblIntervaloEntreAs = new JLabel("Intervalo entre as doses:");
		lblIntervaloEntreAs.setForeground(Color.WHITE);
		lblIntervaloEntreAs.setBounds(598, 342, 157, 15);
		lblIntervaloEntreAs.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setForeground(Color.WHITE);
		lblValidade.setBounds(721, 292, 81, 15);
		lblValidade.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblEficcia = new JLabel("Efic\u00E1cia:");
		lblEficcia.setForeground(Color.WHITE);
		lblEficcia.setBounds(598, 399, 81, 15);
		lblEficcia.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setForeground(Color.WHITE);
		lblFabricante.setBounds(599, 242, 81, 15);
		lblFabricante.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(748, 154, 94, 28);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (idField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira o nome da vacina que deseja consultar!");
				} else {
					try {
						String id = idField.getText();
						Vacina v = new Vacina();
						v.setNome(id);
						v.consultar();

						// setando os campos do formulario com os dados vindos do banco.
						nomeField.setText(v.getNome());
						intervaloField.setText(String.valueOf(v.getIntervalo()));
						fabricanteField.setText(v.getFabricante());
						qtdeField.setText(String.valueOf((v.getQtdeDoses())));
						eficaciaField.setText(String.valueOf((v.getEficacia())));
						validadeField.setText(String.valueOf((v.getValidadeFormatado())));
					} catch (Exception e) {
						nomeField.setText("");
						intervaloField.setText("");
						fabricanteField.setText("");
						qtdeField.setText("");
						eficaciaField.setText("");
						validadeField.setText("");
						idField.setText("");
					}
				}
			}
		});
		btnPesquisar.setBackground(Color.CYAN);

		idField = new JTextField();
		idField.setCaretColor(Color.WHITE);
		idField.setOpaque(false);
		idField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		idField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		idField.setForeground(Color.WHITE);
		idField.setBounds(598, 156, 145, 25);
		idField.setColumns(10);

		JLabel lblIdDaVacina = new JLabel("Nome da vacina:");
		lblIdDaVacina.setForeground(Color.WHITE);
		lblIdDaVacina.setBounds(599, 136, 107, 19);
		lblIdDaVacina.setFont(new Font("Segoe UI", Font.BOLD, 13));

		nomeField = new JTextField();
		nomeField.setCaretColor(Color.WHITE);
		nomeField.setOpaque(false);
		nomeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nomeField.setForeground(Color.WHITE);
		nomeField.setBounds(598, 207, 238, 25);
		nomeField.setEditable(false);
		nomeField.setColumns(10);

		fabricanteField = new JTextField();
		fabricanteField.setCaretColor(Color.WHITE);
		fabricanteField.setOpaque(false);
		fabricanteField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		fabricanteField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fabricanteField.setForeground(Color.WHITE);
		fabricanteField.setBounds(598, 257, 239, 25);
		fabricanteField.setEditable(false);
		fabricanteField.setColumns(10);

		qtdeField = new JTextField();
		qtdeField.setCaretColor(Color.WHITE);
		qtdeField.setOpaque(false);
		qtdeField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		qtdeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		qtdeField.setForeground(Color.WHITE);
		qtdeField.setBounds(598, 307, 113, 25);
		qtdeField.setEditable(false);
		qtdeField.setColumns(10);

		validadeField = new JTextField();
		validadeField.setCaretColor(Color.WHITE);
		validadeField.setOpaque(false);
		validadeField.setBorder(new MatteBorder(0, 1, 2, 0, (Color) new Color(0, 255, 255)));
		validadeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		validadeField.setForeground(Color.WHITE);
		validadeField.setHorizontalAlignment(SwingConstants.CENTER);
		validadeField.setBounds(721, 307, 115, 25);
		validadeField.setEditable(false);
		validadeField.setColumns(10);

		eficaciaField = new JTextField();
		eficaciaField.setCaretColor(Color.WHITE);
		eficaciaField.setOpaque(false);
		eficaciaField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		eficaciaField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		eficaciaField.setForeground(Color.WHITE);
		eficaciaField.setBounds(598, 415, 51, 25);
		eficaciaField.setEditable(false);
		eficaciaField.setColumns(10);

		JLabel label = new JLabel("%.");
		label.setForeground(Color.WHITE);
		label.setBounds(652, 426, 35, 15);
		label.setFont(new Font("Segoe UI", Font.BOLD, 13));

		intervaloField = new JTextField();
		intervaloField.setCaretColor(Color.WHITE);
		intervaloField.setOpaque(false);
		intervaloField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		intervaloField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		intervaloField.setForeground(Color.WHITE);
		intervaloField.setBounds(598, 359, 52, 25);
		intervaloField.setEditable(false);
		intervaloField.setColumns(10);

		JLabel lblDias = new JLabel("dias.");
		lblDias.setForeground(Color.WHITE);
		lblDias.setBounds(653, 369, 45, 15);
		lblDias.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnVoltar.setBounds(682, 461, 80, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicioVacina tela = new TelaInicioVacina();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(Color.CYAN);
		contentPane.setLayout(null);
		contentPane.add(lblEficcia);
		contentPane.add(eficaciaField);
		contentPane.add(label);
		contentPane.add(lblValidade);
		contentPane.add(validadeField);
		contentPane.add(lblNome);
		contentPane.add(lblQtdeDeDoses);
		contentPane.add(nomeField);
		contentPane.add(qtdeField);
		contentPane.add(lblFabricante);
		contentPane.add(fabricanteField);
		contentPane.add(lblIntervaloEntreAs);
		contentPane.add(intervaloField);
		contentPane.add(lblDias);
		contentPane.add(lblIdDaVacina);
		contentPane.add(idField);
		contentPane.add(btnPesquisar);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel = new JLabel("Fundo Tela Consultar Vacina");
		lblNewLabel.setIcon(new ImageIcon(TelaConsultarVacina.class.getResource("/Imagens/Tela Consultar Vacina.png")));
		lblNewLabel.setBounds(-1, 1, 860, 510);
		contentPane.add(lblNewLabel);
	}
}
