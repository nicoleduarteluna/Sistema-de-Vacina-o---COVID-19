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

public class TelaIncluirCidadao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField cpfField;
	private JTextField enderecoField;
	private JTextField telefoneField;
	private JTextField dtNascimentoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIncluirCidadao frame = new TelaIncluirCidadao();
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
	public TelaIncluirCidadao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(603, 142, 45, 15);
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBounds(603, 202, 45, 16);
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nasc.:");
		lblDataDeNascimento.setForeground(Color.WHITE);
		lblDataDeNascimento.setBounds(728, 202, 109, 15);
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(603, 325, 66, 16);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(603, 386, 64, 16);
		lblTelefone.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setBounds(603, 265, 65, 16);
		lblEndereo.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		nomeField = new JTextField();
		nomeField.setCaretColor(Color.WHITE);
		nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		nomeField.setForeground(Color.WHITE);
		nomeField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		nomeField.setOpaque(false);
		nomeField.setBounds(603, 158, 243, 25);
		nomeField.setColumns(10);
		
		try {
			cpfField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			cpfField.setCaretColor(Color.WHITE);
			cpfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			cpfField.setForeground(Color.WHITE);
			cpfField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
			cpfField.setOpaque(false);
			cpfField.setBounds(603, 219, 117, 25);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cpfField.setColumns(10);
		
		enderecoField = new JTextField();
		enderecoField.setCaretColor(Color.WHITE);
		enderecoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		enderecoField.setForeground(Color.WHITE);
		enderecoField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		enderecoField.setOpaque(false);
		enderecoField.setBounds(603, 284, 243, 25);
		enderecoField.setColumns(10);
		
		
		
		try {
			telefoneField = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			telefoneField.setHorizontalAlignment(SwingConstants.CENTER);
			telefoneField.setCaretColor(Color.WHITE);
			telefoneField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			telefoneField.setForeground(Color.WHITE);
			telefoneField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 255)));
			telefoneField.setOpaque(false);
			telefoneField.setBounds(603, 404, 117, 25);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		telefoneField.setColumns(10);
		
		JTextField emailField = new JTextField();
		emailField.setCaretColor(Color.WHITE);
		emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		emailField.setForeground(Color.WHITE);
		emailField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.CYAN));
		emailField.setOpaque(false);
		emailField.setBounds(603, 342, 243, 25);
		emailField.setColumns(10);
		
		try {
			dtNascimentoField = new JFormattedTextField(new MaskFormatter("##/##/####"));
			dtNascimentoField.setHorizontalAlignment(SwingConstants.CENTER);
			dtNascimentoField.setCaretColor(Color.WHITE);
			dtNascimentoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			dtNascimentoField.setForeground(Color.WHITE);
			dtNascimentoField.setBorder(new MatteBorder(0, 1, 2, 0, (Color) new Color(0, 255, 255)));
			dtNascimentoField.setOpaque(false);
			dtNascimentoField.setBounds(723, 219, 123, 25);
			dtNascimentoField.setMargin(new Insets(2, 18, 2, 2));
			dtNascimentoField.setText("    /  /    ");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dtNascimentoField.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnVoltar.setBounds(636, 457, 80, 30);
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
		
		JButton btnIncluir_1 = new JButton("Incluir");
		btnIncluir_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnIncluir_1.setBounds(728, 458, 81, 29);
		btnIncluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (nomeField.getText().equals("") || cpfField.getText().equals("") || dtNascimentoField.getText().equals("") || enderecoField.getText().equals("") || telefoneField.getText().equals("") || emailField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha TODOS os campos para realizar a inclusão.");
				} else {
				String nome = nomeField.getText();
				String cpf = cpfField.getText();
				String dtNascimento = dtNascimentoField.getText();
				String endereco = enderecoField.getText();
				String telefone = telefoneField.getText();
				String email = emailField.getText();
				
				Cidadao p = new Cidadao ();
				p.setNome(nome);
				p.setCpf(cpf);
				p.setEmail(email);
				p.setDtNascimento(dtNascimento);
				p.setEndereco(endereco);
				p.setTelefone(telefone);
				p.inserir();
								
				//Limpando campos 
				
				nomeField.setText("");
				cpfField.setText("");
				enderecoField.setText("");
				emailField.setText("");
				telefoneField.setText("");
				dtNascimentoField.setText("");
				}
			}
		});
		btnIncluir_1.setForeground(Color.BLACK);
		btnIncluir_1.setBackground(Color.CYAN);
		contentPane.setLayout(null);
		contentPane.add(lblTelefone);
		contentPane.add(lblEmail);
		contentPane.add(lblEndereo);
		contentPane.add(lblCpf);
		contentPane.add(enderecoField);
		contentPane.add(emailField);
		contentPane.add(telefoneField);
		contentPane.add(btnIncluir_1);
		contentPane.add(cpfField);
		contentPane.add(lblDataDeNascimento);
		contentPane.add(dtNascimentoField);
		contentPane.add(nomeField);
		contentPane.add(lblNome);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Fundo Tela Cadastro Cidad\u00E3o");
		lblNewLabel.setIcon(new ImageIcon(TelaIncluirCidadao.class.getResource("/Imagens/Tela Cadastrar Cidadao.png")));
		lblNewLabel.setBounds(0, 0, 857, 507);
		contentPane.add(lblNewLabel);
	}
}
