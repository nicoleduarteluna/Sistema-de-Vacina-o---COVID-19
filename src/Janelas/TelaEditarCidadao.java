package Janelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
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

import Controle.Cidadao;

public class TelaEditarCidadao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField telefoneField;
	private JTextField dtNascimentoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarCidadao frame = new TelaEditarCidadao();
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
	public TelaEditarCidadao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(596, 219, 45, 15);
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 14));

		JLabel lblDataDeNascimento = new JLabel("Data de Nasc.:");
		lblDataDeNascimento.setForeground(Color.WHITE);
		lblDataDeNascimento.setBounds(596, 346, 98, 15);
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.BOLD, 14));

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(596, 414, 66, 16);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(722, 345, 64, 16);
		lblTelefone.setFont(new Font("Segoe UI", Font.BOLD, 14));

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setBounds(596, 283, 81, 16);
		lblEndereo.setFont(new Font("Segoe UI", Font.BOLD, 14));

		JTextField nomeField = new JTextField();
		nomeField.setCaretColor(Color.WHITE);
		nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nomeField.setForeground(Color.WHITE);
		nomeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 255, 255)));
		nomeField.setOpaque(false);
		nomeField.setBounds(596, 236, 251, 25);
		nomeField.setColumns(10);

		JTextField enderecoField = new JTextField();
		enderecoField.setCaretColor(Color.WHITE);
		enderecoField.setForeground(Color.WHITE);
		enderecoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		enderecoField.setOpaque(false);
		enderecoField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		enderecoField.setBounds(596, 301, 251, 25);
		enderecoField.setColumns(10);

		try {
			telefoneField = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			telefoneField.setHorizontalAlignment(SwingConstants.CENTER);
			telefoneField.setCaretColor(Color.WHITE);
			telefoneField.setForeground(Color.WHITE);
			telefoneField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			telefoneField.setOpaque(false);
			telefoneField.setBorder(new MatteBorder(0, 1, 2, 0, (Color) new Color(0, 255, 255)));
			telefoneField.setBounds(722, 364, 125, 25);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		telefoneField.setColumns(10);

		JTextField emailField = new JTextField();
		emailField.setCaretColor(Color.WHITE);
		emailField.setForeground(Color.WHITE);
		emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		emailField.setOpaque(false);
		emailField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		emailField.setBounds(596, 432, 251, 25);
		emailField.setColumns(10);

		try {
			dtNascimentoField = new JFormattedTextField(new MaskFormatter("##/##/####"));
			dtNascimentoField.setHorizontalAlignment(SwingConstants.CENTER);
			dtNascimentoField.setCaretColor(Color.WHITE);
			dtNascimentoField.setForeground(Color.WHITE);
			dtNascimentoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			dtNascimentoField.setOpaque(false);
			dtNascimentoField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
			dtNascimentoField.setBounds(596, 364, 125, 25);
			dtNascimentoField.setMargin(new Insets(2, 18, 2, 2));
			dtNascimentoField.setText("    /  /    ");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dtNascimentoField.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnVoltar.setBounds(613, 482, 99, 30);
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
		btnPesquisar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnPesquisar.setBounds(741, 172, 100, 28);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (idField.getText().equals("   .   .   -  ")) {
					JOptionPane.showMessageDialog(null, "Digite o CPF do cidadão que deseja editar!");
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

						idField.setEditable(false);
					} catch (Exception e) {
						nomeField.setText("");
						idField.setText("");
						enderecoField.setText("");
						emailField.setText("");
						telefoneField.setText("");
						dtNascimentoField.setText("");
						idField.setText("");
					}
				}

			}
		});
		btnPesquisar.setBackground(Color.CYAN);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEditar.setBounds(736, 482, 99, 30);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (dtNascimentoField.getText().equals("") || idField.getText().equals("   .   .   -  ")) {
					JOptionPane.showMessageDialog(null, "Campo de CPF e/ou campo da data de nascimento em branco!");
				} else {
					String nome = nomeField.getText();
					String telefone = telefoneField.getText();
					String email = emailField.getText();
					String endereco = enderecoField.getText();
					String cpf = idField.getText();
					String dtNascimento = dtNascimentoField.getText();
					Cidadao c = new Cidadao();
					c.setNome(nome);
					c.setTelefone(telefone);
					c.setEndereco(endereco);
					c.setCpf(cpf);
					c.setDtNascimento(dtNascimento);
					c.setEmail(email);
					c.atualizar();

					JOptionPane.showMessageDialog(null, "Cidadão " + nomeField.getText() + " editado com sucesso!");
					nomeField.setText("");
					idField.setText("");
					enderecoField.setText("");
					emailField.setText("");
					telefoneField.setText("");
					dtNascimentoField.setText("");
					idField.setText("");
					idField.setEditable(true);

				}
			}
		});
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(Color.CYAN);

		try {
			idField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			idField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			idField.setForeground(Color.WHITE);
			idField.setCaretColor(Color.WHITE);
			idField.setOpaque(false);
			idField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
			idField.setBounds(596, 174, 143, 25);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idField.setColumns(10);

		JLabel lblIdCidado = new JLabel("CPF do cidad\u00E3o:");
		lblIdCidado.setForeground(Color.WHITE);
		lblIdCidado.setBounds(596, 155, 116, 16);
		lblIdCidado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		contentPane.setLayout(null);
		contentPane.add(lblEmail);
		contentPane.add(emailField);
		contentPane.add(lblNome);
		contentPane.add(lblIdCidado);
		contentPane.add(idField);
		contentPane.add(nomeField);
		contentPane.add(btnVoltar);
		contentPane.add(lblTelefone);
		contentPane.add(telefoneField);
		contentPane.add(lblEndereo);
		contentPane.add(enderecoField);
		contentPane.add(btnPesquisar);
		contentPane.add(lblDataDeNascimento);
		contentPane.add(dtNascimentoField);
		contentPane.add(btnEditar);
		
				JLabel lblNewLabel = new JLabel("Fundo Tela Fundo Editar Cidad\u00E3o");
				lblNewLabel
						.setIcon(new ImageIcon(TelaEditarCidadao.class.getResource("/Imagens/Tela Editar Cidad\u00E3o.png")));
				lblNewLabel.setBounds(0, 0, 857, 523);
				contentPane.add(lblNewLabel);
	}
}
