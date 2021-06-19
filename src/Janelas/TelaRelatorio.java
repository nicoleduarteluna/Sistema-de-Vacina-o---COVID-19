package Janelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Controle.ConnectionFactory;

public class TelaRelatorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable Cidadao;
	private JTextField dtInicioField;
	private JTextField dtFimField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	public TelaRelatorio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 170, 792, 159);

		Cidadao = new JTable();
		Cidadao.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
				new String[] { "Cidadão", "Primeira Dose", "Vacina", "Intervalo entre doses (dias)",
						"Previsão p/ Segunda Dose" }));
		scrollPane.setViewportView(Cidadao);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		
		try {
			dtInicioField = new JFormattedTextField(new MaskFormatter("##/##/####"));
			dtInicioField.setHorizontalAlignment(SwingConstants.CENTER);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		dtInicioField.setBackground(SystemColor.textHighlightText);
		dtInicioField.setBounds(241, 121, 96, 19);
		contentPane.add(dtInicioField);
		dtInicioField.setColumns(10);
		
		try {
			dtFimField = new JFormattedTextField(new MaskFormatter("##/##/####"));
			dtFimField.setHorizontalAlignment(SwingConstants.CENTER);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		dtFimField.setColumns(10);
		dtFimField.setBackground(Color.WHITE);
		dtFimField.setBounds(541, 121, 96, 19);
		contentPane.add(dtFimField);
		
		JLabel lblNewLabel = new JLabel("Data Inicial:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(166, 124, 77, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setForeground(Color.WHITE);
		lblDataFinal.setBounds(449, 124, 77, 13);
		contentPane.add(lblDataFinal);
		
		JButton btnNewButton = new JButton("Gerar Relat\u00F3rio");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

						String dtInicio = dtInicioField.getText();
						String dtFim = dtFimField.getText();

						SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");

						try {
							java.util.Date date = parser.parse(dtInicio);
							java.util.Date date2 = parser.parse(dtFim);

							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							String formatoFinal1 = formatter.format(date);
							String formatoFinal2 = formatter.format(date2);

							String sql = "select c.nome as 'Cidadao', cv.primeira_dose, v.nome as 'Vacina', v.intervalo_doses, (primeira_dose + INTERVAL intervalo_doses DAY) as previsao\r\n"
									+ "from Cidadao c, carteira_vacinacao cv, vacina v\r\n"
									+ "where c.id_cidadao = cv.id_cidadao\r\n" + "and cv.id_vacina = v.id_vacina\r\n"
									+ "and v.qtde_doses > 1\r\n"
									+ "and (primeira_dose + INTERVAL intervalo_doses DAY) between '" + formatoFinal1 + "' and '"
									+ formatoFinal2 + "' and cv.segunda_dose is null order by cv.primeira_dose asc;";

							ConnectionFactory factory = new ConnectionFactory();

							try (Connection c = factory.obtemConexao()) {

								PreparedStatement ps = c.prepareStatement(sql);
								ResultSet rs = ps.executeQuery();
								DefaultTableModel modelo = (DefaultTableModel) Cidadao.getModel();
								modelo.setNumRows(0);

								while (rs.next()) {

									try {

										SimpleDateFormat kk = new SimpleDateFormat("yyyy-MM-dd");
										SimpleDateFormat pp = new SimpleDateFormat("dd/MM/yyyy");
										
										String dtprimeiradose = rs.getString("cv.primeira_dose");
										java.util.Date dateprimeiradose = kk.parse(dtprimeiradose);
										String formatodtprimeiradose = pp.format(dateprimeiradose);

										String previsao = rs.getString("previsao");
										java.util.Date datePrevisao = kk.parse(previsao);
										String formatoPrevisao = pp.format(datePrevisao);

										modelo.addRow(new Object[] { rs.getString("Cidadao"), formatodtprimeiradose,
												rs.getString("Vacina"), rs.getString("intervalo_doses"), formatoPrevisao });

									} catch (Exception n) {
										n.printStackTrace();
									}

								}

							} catch (Exception e) {
								e.printStackTrace();
							}

						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Por favor, insira a data inicial e a final.");
						}
					}
				});
		
		btnNewButton.setBounds(697, 389, 127, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicio tela = new TelaInicio();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnNewButton_1.setBounds(34, 389, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel btnListarDados = new JLabel("Gerar Relat\u00F3rio");
		btnListarDados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnListarDados.setForeground(Color.CYAN);
		btnListarDados.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/Imagens/Tela Cadastrar-2.png")));
		btnListarDados.setBounds(0, -20, 856, 507);
		contentPane.add(btnListarDados);
	}
}
