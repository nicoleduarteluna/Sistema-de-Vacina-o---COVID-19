package Janelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Controle.CarteiraVacinacao;
import Controle.Cidadao;
import Controle.Vacina;
import javax.swing.ImageIcon;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.MaskFormatter;
import javax.swing.event.PopupMenuEvent;

public class TelaCarteiraVacinacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idCidadaoField;
	private JTextField nomeField;
	private JTextField cpfField;
	private JTextField qtdeDosesField;
	private JTextField primeiraDoseField;
	private JTextField segundaDoseField;
	private JTextField intervaloField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarteiraVacinacao frame = new TelaCarteiraVacinacao();
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
	public TelaCarteiraVacinacao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblIdDoCidado = new JLabel("CPF do cidad\u00E3o:");
		lblIdDoCidado.setForeground(Color.WHITE);
		lblIdDoCidado.setBounds(162, 111, 183, 23);
		lblIdDoCidado.setFont(new Font("Dialog", Font.PLAIN, 16));

		idCidadaoField = new JTextField();
		try {
			idCidadaoField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		idCidadaoField.setBounds(296, 116, 190, 20);
		idCidadaoField.setColumns(10);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(162, 154, 79, 15);
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 16));

		nomeField = new JTextField();
		nomeField.setEditable(false);
		nomeField.setBounds(238, 155, 172, 20);
		nomeField.setColumns(10);
		nomeField.setCaretColor(Color.WHITE);
		nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nomeField.setForeground(Color.WHITE);
		nomeField.setOpaque(false);


		JLabel lblCPF = new JLabel("Data de nascimento:");
		lblCPF.setForeground(Color.WHITE);
		lblCPF.setBounds(483, 154, 163, 15);
		lblCPF.setFont(new Font("Dialog", Font.PLAIN, 16));

		cpfField = new JTextField();
		cpfField.setColumns(10);
		cpfField.setCaretColor(Color.WHITE);
		cpfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cpfField.setForeground(Color.WHITE);
		cpfField.setOpaque(false);
		cpfField.setBounds(645, 155, 104, 20);
		cpfField.setEditable(false);
		cpfField.setColumns(10);

		JLabel lblIdDaVacina = new JLabel("Vacina:");
		lblIdDaVacina.setForeground(Color.WHITE);
		lblIdDaVacina.setBounds(162, 213, 117, 15);
		lblIdDaVacina.setFont(new Font("Dialog", Font.PLAIN, 16));

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new Vacina().listarVacinas()));
			}
		});
		comboBox.setBounds(238, 212, 115, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
		
		setLocationRelativeTo(null);

		JButton btnRegistrarPrimeiraDose = new JButton("Registrar Aplica\u00E7\u00E3o");
		btnRegistrarPrimeiraDose.setBounds(483, 351, 163, 23);
		btnRegistrarPrimeiraDose.setEnabled(false);
		
		JButton btnConfirmarCidadao_1 = new JButton("Confimar");
		btnConfirmarCidadao_1.setBounds(483, 212, 104, 23);
		btnConfirmarCidadao_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (idCidadaoField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira o CPF para continuar!");
				} else {
					String nome = (String) comboBox.getSelectedItem();
					Vacina v = new Vacina();
					v.setNome(nome);
					v.consultarNomeVacina();

					intervaloField.setText(String.valueOf(v.getIntervalo()));
					qtdeDosesField.setText(String.valueOf((v.getQtdeDoses())));
					
					String cpf = idCidadaoField.getText();
					Cidadao c = new Cidadao();
					c.setCpf(cpf);
					c.consultarPeloCPF();

					// setando os campos do formulario com os dados vindos do banco.
					nomeField.setText(c.getNome());
					cpfField.setText(c.getDtNascimentoFormatado());
					

				}

				
				try {
					String nome = (String) comboBox.getSelectedItem();
					Vacina v = new Vacina();
					v.setNome(nome);
					v.consultarNomeVacina();

					String id = idCidadaoField.getText();
					Cidadao cc = new Cidadao();
					cc.setCpf(id);
					cc.consultarPeloNome();

					v.setNome(nome);
					v.consultarID();

					CarteiraVacinacao c = new CarteiraVacinacao();
					c.setId_cidadao(cc.getId());
					c.setId_vacina(v.getId());

					primeiraDoseField.setEditable(true);
					btnRegistrarPrimeiraDose.setEnabled(true);
					
					if (c.existe(cc.getId(), v.getId())) {

						c.consultarPrimeiraDose();
						primeiraDoseField.setText(String.valueOf((c.getPrimeiraDoseFormatada())));

						// segundaDoseField.setEditable(true);

						if (qtdeDosesField.getText().equals("1")) {
							JOptionPane.showMessageDialog(null,
									"Esse cidadão já tomou a dose única da vacina " + comboBox.getSelectedItem() + "!");
							segundaDoseField.setEditable(false);
							btnRegistrarPrimeiraDose.setEnabled(false);
						}
						if (c.existeSegundaDose(cc.getId(), v.getId())) {

							c.consultarSegundaDose();
							segundaDoseField.setText(String.valueOf((c.getSegundaDoseFormatada())));

							segundaDoseField.setEditable(false);
							primeiraDoseField.setEditable(false);
							btnRegistrarPrimeiraDose.setEnabled(false);

							if (segundaDoseField.getText().equals("") && qtdeDosesField.getText().equals("2")) {
								segundaDoseField.setEditable(true);
								btnRegistrarPrimeiraDose.setEnabled(true);
								// btnRegistrarPrimeiraDose.setEnabled(true);
							}

						}

					}
				} catch (Exception e) {
					// JOptionPane.showMessageDialog(null, "Problemas técnicos, volte mais tarde.");
				
				}
			}
		});

		JLabel lblQtdeDeDoses = new JLabel("Qtde. de doses:");
		lblQtdeDeDoses.setForeground(Color.WHITE);
		lblQtdeDeDoses.setBounds(162, 255, 143, 15);
		lblQtdeDeDoses.setFont(new Font("Dialog", Font.PLAIN, 16));

		qtdeDosesField = new JTextField();
		qtdeDosesField.setBounds(299, 256, 54, 20);
		qtdeDosesField.setEditable(false);
		qtdeDosesField.setColumns(10);
		qtdeDosesField.setCaretColor(Color.WHITE);
		qtdeDosesField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		qtdeDosesField.setForeground(Color.WHITE);
		qtdeDosesField.setOpaque(false);


		JLabel lblPrimeiraDose = new JLabel("Primeira dose:");
		lblPrimeiraDose.setForeground(Color.WHITE);
		lblPrimeiraDose.setBounds(162, 348, 136, 23);
		lblPrimeiraDose.setFont(new Font("Dialog", Font.PLAIN, 16));

		primeiraDoseField = new JTextField();
		primeiraDoseField.setBounds(296, 353, 163, 20);
		primeiraDoseField.setEditable(false);
		primeiraDoseField.setColumns(10);

		JLabel lblSegundaDose = new JLabel("Segunda dose:");
		lblSegundaDose.setForeground(Color.WHITE);
		lblSegundaDose.setBounds(162, 396, 169, 23);
		lblSegundaDose.setFont(new Font("Dialog", Font.PLAIN, 16));

		segundaDoseField = new JTextField();
		segundaDoseField.setBounds(296, 401, 163, 20);
		segundaDoseField.setEditable(false);
		segundaDoseField.setColumns(10);


		btnRegistrarPrimeiraDose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = (String) comboBox.getSelectedItem();
				Vacina v = new Vacina();
				v.setNome(nome);
				v.consultarNomeVacina();

				String id = idCidadaoField.getText();
				Cidadao cc = new Cidadao();
				cc.setCpf(id);
				cc.consultarPeloNome();

				v.setNome(nome);
				v.consultarID();

				CarteiraVacinacao c = new CarteiraVacinacao();
				c.setId_cidadao(cc.getId());
				c.setId_vacina(v.getId());

				try {

					if (idCidadaoField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Insira o CPF para continuar!");
					} else if (qtdeDosesField.getText().equals("1")) {

						String primeiraDose = primeiraDoseField.getText();

						c.setPrimeiraDose(primeiraDose);
						c.inserirRegistrosPrimeiraDose();

					} else if (qtdeDosesField.getText().equals("2") && segundaDoseField.getText().equals("")) {

						String primeiraDose = primeiraDoseField.getText();

						v.consultarID();

						c.setPrimeiraDose(primeiraDose);

						c.inserirRegistrosPrimeiraDose();

					} else {
						
						String segundaDose = segundaDoseField.getText();

						v.consultarNomeVacina();
						cc.consultarPeloNome();
						v.consultarID();
						c.setSegundaDose(segundaDose);
						c.atualizar();

					}

					c.consultarSegundaDose();
					segundaDoseField.setText(String.valueOf((c.getSegundaDoseFormatada())));

					segundaDoseField.setEditable(false);
					primeiraDoseField.setEditable(false);

					if (segundaDoseField.getText().equals("")) {
						segundaDoseField.setEditable(true);
					}

					nomeField.setText("");
					cpfField.setText("");
					idCidadaoField.setText("");
					primeiraDoseField.setText("");
					segundaDoseField.setText("");
					intervaloField.setText("");
					qtdeDosesField.setText("");

					segundaDoseField.setEditable(false);
					primeiraDoseField.setEditable(false);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório!");
					btnRegistrarPrimeiraDose.setEnabled(true);
				}
			}
		});

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(15, 825, 75, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicio tela = new TelaInicio();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);

		JLabel lblNewLabel_1 = new JLabel("Intervalo entre doses:\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(483, 266, 163, 20);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 16));

		intervaloField = new JTextField();
		intervaloField.setBounds(645, 270, 30, 20);
		intervaloField.setEditable(false);
		intervaloField.setColumns(10);
		intervaloField.setCaretColor(Color.WHITE);
		intervaloField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		intervaloField.setForeground(Color.WHITE);
		intervaloField.setOpaque(false);


		JLabel lblDias = new JLabel("dias.");
		lblDias.setForeground(Color.WHITE);
		lblDias.setBounds(687, 271, 45, 15);
		lblDias.setFont(new Font("Dialog", Font.PLAIN, 16));
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(421, 825, 75, 36);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeField.setText("");
				cpfField.setText("");
				idCidadaoField.setText("");
				primeiraDoseField.setText("");
				segundaDoseField.setText("");
				intervaloField.setText("");
				qtdeDosesField.setText("");

				primeiraDoseField.setEditable(false);
				segundaDoseField.setEditable(false);
				btnRegistrarPrimeiraDose.setEnabled(false);
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(SystemColor.activeCaptionBorder);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(883, 308, 912, 535);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\rafam\\Desktop\\Rectangle 17.png"));
		contentPane.setLayout(null);
		contentPane.add(lblNome);
		contentPane.add(nomeField);
		contentPane.add(lblIdDoCidado);
		contentPane.add(idCidadaoField);
		contentPane.add(lblIdDaVacina);
		contentPane.add(comboBox);
		contentPane.add(lblQtdeDeDoses);
		contentPane.add(qtdeDosesField);
		contentPane.add(btnConfirmarCidadao_1);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblCPF);
		contentPane.add(intervaloField);
		contentPane.add(lblDias);
		contentPane.add(cpfField);
		contentPane.add(lblPrimeiraDose);
		contentPane.add(primeiraDoseField);
		contentPane.add(btnRegistrarPrimeiraDose);
		contentPane.add(btnNewButton);
		contentPane.add(btnLimpar);
		contentPane.add(lblSegundaDose);
		contentPane.add(segundaDoseField);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeField.setText("");
				cpfField.setText("");
				idCidadaoField.setText("");
				primeiraDoseField.setText("");
				segundaDoseField.setText("");
				intervaloField.setText("");
				qtdeDosesField.setText("");

				primeiraDoseField.setEditable(false);
				segundaDoseField.setEditable(false);
				btnRegistrarPrimeiraDose.setEnabled(false);
			}
		});
		btnNewButton_1.setBounds(733, 424, 85, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicio tela = new TelaInicio();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnNewButton_2.setBounds(15, 424, 85, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(TelaCarteiraVacinacao.class.getResource("/Imagens/Tela Cadastrar.png")));
		lblNewLabel_3.setBounds(0, -202, 1170, 823);
		contentPane.add(lblNewLabel_3);
	}
}
