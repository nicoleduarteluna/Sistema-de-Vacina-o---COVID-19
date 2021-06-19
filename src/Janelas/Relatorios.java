package Janelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Controle.ConnectionFactory;

public class Relatorios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCpf;
	private JTextField textNome;
	private JTextField textDataNasc;
	private JTextField textEndereco;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JTable tableRelatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios frame = new Relatorios();
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
	@SuppressWarnings("serial")
	public Relatorios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		try {
			textCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		textCpf.setBounds(87, 149, 119, 19);
		textCpf.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				textCpf.setText("");
			}
		});
		textCpf.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBounds(87, 126, 35, 13);

		textNome = new JTextField();
		textNome.setBounds(243, 149, 145, 19);
		textNome.setEditable(false);
		textNome.setColumns(10);

		textDataNasc = new JTextField();
		textDataNasc.setBounds(408, 149, 102, 19);
		textDataNasc.setEditable(false);
		textDataNasc.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(408, 201, 293, 19);
		textEndereco.setEditable(false);
		textEndereco.setColumns(10);

		textEmail = new JTextField();
		textEmail.setBounds(87, 201, 119, 19);
		textEmail.setEditable(false);
		textEmail.setColumns(10);

		textTelefone = new JTextField();
		textTelefone.setBounds(243, 201, 145, 19);
		textTelefone.setEditable(false);
		textTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(87, 178, 119, 13);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(243, 178, 145, 13);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setBounds(408, 178, 62, 13);

		JLabel lblCNome = new JLabel("Nome");
		lblCNome.setForeground(Color.WHITE);
		lblCNome.setBounds(243, 126, 62, 13);

		JLabel lblDataNasc = new JLabel("Data de Nascimento");
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setBounds(414, 126, 130, 13);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 247, 723, 123);

		JButton btnRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnRelatorio.setBackground(Color.CYAN);
		btnRelatorio.setBounds(445, 397, 130, 21);
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textCpf.getText().equals("Digite o CPF") || textCpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor informe o CPF!");
				} else {
					ConnectionFactory factory = new ConnectionFactory();
					try {
						Connection c = factory.obtemConexao();

						// Raquel, esse script não esta buscando a segunda dose

						String sql = "select vac.nome, vac.intervalo_doses, cv.primeira_dose,cv.segunda_dose, cd.nome, cd.cpf, cd.dtNascimento, cd.email, cd.telefone, cd.endereco, (primeira_dose + INTERVAL intervalo_doses DAY) as previsao  \r\n"
								+ "from carteira_vacinacao cv, Cidadao cd, vacina vac\r\n"
								+ "where cv.id_cidadao= cd.id_cidadao \r\n" + "and  cv.id_vacina= vac.id_vacina \r\n"
								+ "and cd.cpf = ? ";

						/**
						 * esse script aqui embaixo está buscando a segunda dose String sql = select
						 * cv.segunda_dose, cd.nome, cd.cpf, cd.dtNascimento, cd.email, cd.telefone,
						 * cd.endereco, (primeira_dose + INTERVAL intervalo_doses DAY) as previsao from
						 * carteira_vacinacao cv, Cidadao cd, vacina vac where cv.id_cidadao=
						 * cd.id_cidadao and cv.id_vacina= vac.id_vacina and cd.cpf = ?
						 * 
						 */

						PreparedStatement ps = c.prepareStatement(sql);

						ps.setString(1, textCpf.getText());

						ResultSet rs = ps.executeQuery();

						DefaultTableModel modelo = (DefaultTableModel) tableRelatorio.getModel();

						modelo.setNumRows(0);

						while (rs.next() && rs.getString("cv.segunda_dose") == null) {

							String dataNascimento = rs.getString("cd.dtNascimento");
							String previsao = rs.getString("previsao");
							String dataPrimeiraDose = rs.getString("cv.primeira_dose");
							// String dataSegundaDose = rs.getString("cv.segunda_dose");

							SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

							Date dateNascimento = parser.parse(dataNascimento);
							Date datePrevisao = parser.parse(previsao);
							Date datePrimeiraDose = parser.parse(dataPrimeiraDose);
							// Date dateSegundaDose = parser.parse(dataSegundaDose);

							SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
							String formatoDateNascimento = formatter.format(dateNascimento);
							String formatoPrevisao = formatter.format(datePrevisao);
							String formatoPrimeiraDose = formatter.format(datePrimeiraDose);
							// String formatoSegundaDose = formatter.format(dateSegundaDose);

							// if (formatoPrimeiraDose.equals("") && formatoSegundaDose.equals("")) {
							// JOptionPane.showMessageDialog(null,
							// "Esse cidadão ainda não tomou nenhuma dose de vacina.");
							// } else {

							textNome.setText(rs.getString("cd.nome"));
							textDataNasc.setText(formatoDateNascimento);
							textEmail.setText(rs.getString("cd.email"));
							textTelefone.setText(rs.getString("cd.telefone"));
							textEndereco.setText(rs.getString("cd.endereco"));

							modelo.addRow(new Object[] { rs.getString("cd.nome"), rs.getString("cd.cpf"),
									rs.getString("vac.nome"), formatoPrimeiraDose, formatoPrevisao });

						}

						if (rs.getString("cv.segunda_dose") != null) {

							@SuppressWarnings("unused")
							PreparedStatement ps1 = c.prepareStatement(sql);

							ps.setString(1, textCpf.getText());

							ResultSet rs1 = ps.executeQuery();

							modelo.setNumRows(0);
							while (rs1.next()) {

								String dataNascimento = rs1.getString("cd.dtNascimento");
								String previsao = rs1.getString("previsao");
								String dataPrimeiraDose = rs1.getString("cv.primeira_dose");
								String dataSegundaDose = rs1.getString("cv.segunda_dose");

								SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

								Date dateNascimento = parser.parse(dataNascimento);
								Date datePrevisao = parser.parse(previsao);
								Date datePrimeiraDose = parser.parse(dataPrimeiraDose);
								Date dateSegundaDose = parser.parse(dataSegundaDose);

								SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
								String formatoDateNascimento = formatter.format(dateNascimento);
								String formatoPrevisao = formatter.format(datePrevisao);
								String formatoPrimeiraDose = formatter.format(datePrimeiraDose);
								String formatoSegundaDose = formatter.format(dateSegundaDose);

								textNome.setText(rs1.getString("cd.nome"));
								textDataNasc.setText(formatoDateNascimento);
								textEmail.setText(rs1.getString("cd.email"));
								textTelefone.setText(rs1.getString("cd.telefone"));
								textEndereco.setText(rs1.getString("cd.endereco"));

								modelo.addRow(new Object[] { rs1.getString("cd.nome"), rs1.getString("cd.cpf"),
										rs1.getString("vac.nome"), formatoPrimeiraDose, formatoPrevisao,
										formatoSegundaDose });

							}

						}

						if (rs.getString("cv.primeira_dose") == null && rs.getString("cv.segunda_dose") == null) {
							JOptionPane.showMessageDialog(null, "Esse cidadão ainda não tomou nenhuma dose de vacina.");
						}

					} catch (SQLException | ParseException e1) {
						// e1.printStackTrace();
					}

				}
			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.CYAN);
		btnVoltar.setBounds(700, 397, 103, 21);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EscolhaRelatorios tela = new EscolhaRelatorios();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.CYAN);
		btnLimpar.setBounds(586, 397, 105, 21);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textCpf.getText().equals("") || textCpf.getText().equals("Digite o CPF")) {
					JOptionPane.showMessageDialog(null,
							"Funcionalidade indisponível, nenhum campo necessita ser limpo.");
				} else {
					textCpf.setText("");
					textNome.setText("");
					textDataNasc.setText("");
					textEmail.setText("");
					textTelefone.setText("");
					textEndereco.setText("");
					DefaultTableModel modelo = (DefaultTableModel) tableRelatorio.getModel();
					modelo.removeRow(0);
				}
			}

		});

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Relatorios.class.getResource("/Imagens/Tela Cadastrar-1.png")));
		label.setBounds(0, 0, 994, 453);

		tableRelatorio = new JTable();
		tableRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableRelatorio.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Nome", "CPF", "Vacina", "Primeira Dose", "Previs\u00E3o Segunda Dose",
						"Segunda Dose" }) {
			boolean[] columnEditables = new boolean[] { true, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableRelatorio.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableRelatorio.getColumnModel().getColumn(2).setPreferredWidth(90);
		tableRelatorio.getColumnModel().getColumn(3).setPreferredWidth(94);
		tableRelatorio.getColumnModel().getColumn(4).setPreferredWidth(146);
		tableRelatorio.getColumnModel().getColumn(5).setPreferredWidth(113);
		// tableRelatorio.getColumnModel().getColumn(5).setPreferredWidth(108);
		scrollPane.setViewportView(tableRelatorio);
		contentPane.setLayout(null);
		contentPane.add(lblCpf);
		contentPane.add(lblEmail);
		contentPane.add(textCpf);
		contentPane.add(textEmail);
		contentPane.add(textTelefone);
		contentPane.add(lblCNome);
		contentPane.add(lblTelefone);
		contentPane.add(textNome);
		contentPane.add(textEndereco);
		contentPane.add(lblEndereco);
		contentPane.add(lblDataNasc);
		contentPane.add(textDataNasc);
		contentPane.add(btnRelatorio);
		contentPane.add(btnLimpar);
		contentPane.add(btnVoltar);
		contentPane.add(scrollPane);
		contentPane.add(label);
	}
}