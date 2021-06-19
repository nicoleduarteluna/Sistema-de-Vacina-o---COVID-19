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
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import Controle.Cidadao;
import javax.swing.SwingConstants;

public class TelaConsultarCidadao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarCidadao frame = new TelaConsultarCidadao();
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
	public TelaConsultarCidadao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCidado = new JLabel("Cidad\u00E3o");
		lblCidado.setBounds(726, 15, 105, 28);
		lblCidado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(597, 196, 45, 15);
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblDataDeNascimento = new JLabel("Data de Nasc.:");
		lblDataDeNascimento.setForeground(Color.WHITE);
		lblDataDeNascimento.setBounds(721, 327, 88, 15);
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(597, 399, 52, 16);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(597, 326, 64, 16);
		lblTelefone.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setBounds(596, 258, 65, 16);
		lblEndereo.setFont(new Font("Segoe UI", Font.BOLD, 13));

		JTextField nomeField = new JTextField();
		nomeField.setCaretColor(Color.WHITE);
		nomeField.setForeground(Color.WHITE);
		nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nomeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		nomeField.setOpaque(false);
		nomeField.setBounds(597, 218, 251, 25);
		nomeField.setEditable(false);
		nomeField.setColumns(10);

		JTextField enderecoField = new JTextField();
		enderecoField.setCaretColor(Color.WHITE);
		enderecoField.setForeground(Color.WHITE);
		enderecoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		enderecoField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		enderecoField.setOpaque(false);
		enderecoField.setBounds(597, 280, 251, 25);
		enderecoField.setEditable(false);
		enderecoField.setColumns(10);

		JTextField telefoneField = new JTextField();
		telefoneField.setCaretColor(Color.WHITE);
		telefoneField.setForeground(Color.WHITE);
		telefoneField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		telefoneField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
		telefoneField.setOpaque(false);
		telefoneField.setBounds(597, 352, 123, 25);
		telefoneField.setEditable(false);
		telefoneField.setColumns(10);

		JTextField emailField = new JTextField();
		emailField.setCaretColor(Color.WHITE);
		emailField.setForeground(Color.WHITE);
		emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		emailField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		emailField.setOpaque(false);
		emailField.setBounds(597, 425, 251, 25);
		emailField.setEditable(false);
		emailField.setColumns(10);

		JTextField dtNascimentoField = new JTextField();
		dtNascimentoField.setHorizontalAlignment(SwingConstants.CENTER);
		dtNascimentoField.setCaretColor(Color.WHITE);
		dtNascimentoField.setForeground(Color.WHITE);
		dtNascimentoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		dtNascimentoField.setBorder(new MatteBorder(0, 1, 2, 0, (Color) new Color(0, 255, 255)));
		dtNascimentoField.setOpaque(false);
		dtNascimentoField.setBounds(721, 352, 127, 25);
		dtNascimentoField.setEditable(false);
		dtNascimentoField.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(676, 466, 80, 25);
		btnVoltar.setBackground(Color.CYAN);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicioCidadao tela = new TelaInicioCidadao();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.BLACK);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.BLACK);
		btnPesquisar.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnPesquisar.setBounds(750, 153, 90, 25);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (idField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite o CPF do cidadão que deseja consultar!");
				} else {
					try {
						String cpf = idField.getText();
						Cidadao c = new Cidadao();
						c.setCpf(cpf);
						c.consultarCPF();

						// setando os campos do formulario com os dados vindos do banco.
						nomeField.setText(c.getNome());
						telefoneField.setText(c.getTelefone());
						emailField.setText(c.getEmail());
						enderecoField.setText(c.getEndereco());
						dtNascimentoField.setText(c.getDtNascimentoFormatado());
					} catch (Exception e) {
						idField.setText("");
					}
				}
			}
		});
		btnPesquisar.setBackground(Color.CYAN);

		try {
			idField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			idField.setCaretColor(Color.WHITE);
			idField.setForeground(Color.WHITE);
			idField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			idField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
			idField.setOpaque(false);
			idField.setBounds(597, 153, 149, 25);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idField.setColumns(10);

		JLabel lblIdCidado = new JLabel("CPF do cidad\u00E3o:");
		lblIdCidado.setForeground(Color.WHITE);
		lblIdCidado.setBounds(597, 132, 112, 15);
		lblIdCidado.setFont(new Font("Segoe UI", Font.BOLD, 13));
		contentPane.setLayout(null);
		contentPane.add(lblIdCidado);
		contentPane.add(idField);
		contentPane.add(lblTelefone);
		contentPane.add(lblEndereo);
		contentPane.add(lblEmail);
		contentPane.add(lblNome);
		contentPane.add(nomeField);
		contentPane.add(emailField);
		contentPane.add(enderecoField);
		contentPane.add(telefoneField);
		contentPane.add(btnPesquisar);
		contentPane.add(lblDataDeNascimento);
		contentPane.add(dtNascimentoField);
		contentPane.add(lblCidado);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel_1 = new JLabel("Fundo Tela Consultar Cidad\u00E3o");
		lblNewLabel_1.setIcon(
				new ImageIcon(TelaConsultarCidadao.class.getResource("/Imagens/Tela Consultar Cidad\u00E3o.png")));
		lblNewLabel_1.setBounds(1, -1, 857, 509);
		contentPane.add(lblNewLabel_1);
	}
}
