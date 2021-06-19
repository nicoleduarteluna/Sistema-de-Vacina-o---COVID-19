package Janelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import Controle.Vacina;

public class TelaEditarVacina extends JFrame {

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
					TelaEditarVacina frame = new TelaEditarVacina();
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
	public TelaEditarVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(598, 170, 45, 15);
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblQtdeDeDoses = new JLabel("Qtde. de doses:");
		lblQtdeDeDoses.setForeground(Color.WHITE);
		lblQtdeDeDoses.setBounds(598, 281, 104, 15);
		lblQtdeDeDoses.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblIntervaloEntreAs = new JLabel("Intervalo entre as doses:");
		lblIntervaloEntreAs.setForeground(Color.WHITE);
		lblIntervaloEntreAs.setBounds(598, 330, 155, 15);
		lblIntervaloEntreAs.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setForeground(Color.WHITE);
		lblValidade.setBounds(718, 281, 81, 15);
		lblValidade.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblEficcia = new JLabel("Efic\u00E1cia:");
		lblEficcia.setForeground(Color.WHITE);
		lblEficcia.setBounds(600, 385, 81, 15);
		lblEficcia.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setForeground(Color.WHITE);
		lblFabricante.setBounds(598, 225, 81, 15);
		lblFabricante.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnPesquisar.setBounds(733, 135, 97, 25);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (idField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira o nome da vacina!");
				} else {
					try {
						idField.setEditable(false);
						nomeField.setEditable(false);
	
						String nome = idField.getText();
						Vacina v = new Vacina();
						v.setNome(nome);
						v.consultar();
						
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
						validadeField.setText("");
						eficaciaField.setText("");
						idField.setText("");
						nomeField.setEditable(true);
						idField.setEditable(true);
					}
				}
			}
		});
		btnPesquisar.setBackground(Color.CYAN);
		
		idField = new JTextField();
		idField.setOpaque(false);
		idField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		idField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		idField.setForeground(Color.WHITE);
		idField.setCaretColor(Color.WHITE);
		idField.setBounds(598, 135, 124, 25);
		idField.setColumns(10);
		
		JLabel lblIdDaVacina = new JLabel("Nome da vacina:");
		lblIdDaVacina.setForeground(Color.WHITE);
		lblIdDaVacina.setBounds(598, 115, 109, 19);
		lblIdDaVacina.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		nomeField = new JTextField();
		nomeField.setOpaque(false);
		nomeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nomeField.setForeground(Color.WHITE);
		nomeField.setCaretColor(Color.WHITE);
		nomeField.setBounds(598, 188, 239, 25);
		nomeField.setColumns(10);
		
		fabricanteField = new JTextField();
		fabricanteField.setOpaque(false);
		fabricanteField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		fabricanteField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fabricanteField.setForeground(Color.WHITE);
		fabricanteField.setCaretColor(Color.WHITE);
		fabricanteField.setBounds(598, 242, 239, 25);
		fabricanteField.setColumns(10);
		
		qtdeField = new JTextField();
		qtdeField.setOpaque(false);
		qtdeField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		qtdeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		qtdeField.setForeground(Color.WHITE);
		qtdeField.setCaretColor(Color.WHITE);
		qtdeField.setBounds(597, 296, 110, 25);
		qtdeField.setColumns(10);
		
		try {
			validadeField = new JFormattedTextField(new MaskFormatter("##/##/####"));
			validadeField.setText("");
			validadeField.setHorizontalAlignment(SwingConstants.CENTER);
		validadeField.setOpaque(false);
		validadeField.setBorder(new MatteBorder(0, 1, 2, 0, (Color) new Color(0, 255, 255)));
		validadeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		validadeField.setForeground(Color.WHITE);
		validadeField.setCaretColor(Color.WHITE);
		validadeField.setBounds(713, 296, 125, 25);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validadeField.setColumns(10);
		
		eficaciaField = new JTextField();
		eficaciaField.setOpaque(false);
		eficaciaField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		eficaciaField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		eficaciaField.setForeground(Color.WHITE);
		eficaciaField.setCaretColor(Color.WHITE);
		eficaciaField.setBounds(599, 400, 51, 25);
		eficaciaField.setColumns(10);
		
		JLabel label = new JLabel("%.");
		label.setForeground(Color.WHITE);
		label.setBounds(652, 409, 35, 15);
		label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		intervaloField = new JTextField();
		intervaloField.setOpaque(false);
		intervaloField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		intervaloField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		intervaloField.setForeground(Color.WHITE);
		intervaloField.setCaretColor(Color.WHITE);
		intervaloField.setBounds(599, 346, 52, 25);
		intervaloField.setColumns(10);
		
		JLabel lblDias = new JLabel("dias.");
		lblDias.setForeground(Color.WHITE);
		lblDias.setBounds(655, 356, 45, 15);
		lblDias.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnVoltar.setBounds(636, 447, 78, 31);
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
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnEditar.setBounds(724, 447, 81, 30);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (idField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira o nome da vacina que deseja editar!");
				} else {
					String nome = idField.getText();
					String fabricante = fabricanteField.getText();
					String qtdeDoses = qtdeField.getText();
					String intervalo = intervaloField.getText();
					String eficacia = eficaciaField.getText();
					String validade = validadeField.getText();

					Vacina v = new Vacina();
					v.setId(nome);
					v.setFabricante(fabricante);
					v.setQtdeDoses(Integer.parseInt(qtdeDoses));
					v.setIntervalo(Integer.parseInt(intervalo));
					v.setEficacia(Integer.parseInt(eficacia));
					v.setValidade(validade);
					v.atualizar();

					JOptionPane.showMessageDialog(null, "Vacina " + nomeField.getText() + " editada com sucesso!");
					nomeField.setText("");
					intervaloField.setText("");
					fabricanteField.setText("");
					qtdeField.setText("");
					validadeField.setText("");
					eficaciaField.setText("");
					idField.setText("");

					idField.setEditable(true);
					nomeField.setEditable(true);
				}
				
			}
		});
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(Color.CYAN);
		contentPane.setLayout(null);
		contentPane.add(lblEficcia);
		contentPane.add(eficaciaField);
		contentPane.add(label);
		contentPane.add(lblValidade);
		contentPane.add(validadeField);
		contentPane.add(btnVoltar);
		contentPane.add(lblNome);
		contentPane.add(lblQtdeDeDoses);
		contentPane.add(nomeField);
		contentPane.add(qtdeField);
		contentPane.add(lblIdDaVacina);
		contentPane.add(idField);
		contentPane.add(lblFabricante);
		contentPane.add(fabricanteField);
		contentPane.add(lblIntervaloEntreAs);
		contentPane.add(intervaloField);
		contentPane.add(lblDias);
		contentPane.add(btnEditar);
		contentPane.add(btnPesquisar);

		JLabel lblNewLabel_1 = new JLabel("Fundo Tela Editar Vacina");
		lblNewLabel_1.setIcon(new ImageIcon(TelaEditarVacina.class.getResource("/Imagens/Tela Editar Vacina.png")));
		lblNewLabel_1.setBounds(0, 2, 847, 495);
		contentPane.add(lblNewLabel_1);
	}
}
