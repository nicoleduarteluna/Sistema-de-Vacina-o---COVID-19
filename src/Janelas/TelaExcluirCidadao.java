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
import javax.swing.text.MaskFormatter;

import Controle.CarteiraVacinacao;
import Controle.Cidadao;

public class TelaExcluirCidadao extends JFrame {

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
					TelaExcluirCidadao frame = new TelaExcluirCidadao();
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
	public TelaExcluirCidadao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		try {
			idField = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		idField.setFont(new Font("Roboto Cn", Font.PLAIN, 14));
		idField.setForeground(Color.WHITE);
		idField.setBackground(new Color(0, 45, 91));
		idField.setBorder(null);
		idField.setBounds(664, 173, 174, 19);
		idField.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnExcluir.setBounds(697, 212, 103, 30);
		btnExcluir.setForeground(new Color(0, 0, 0));
		btnExcluir.setBackground(Color.CYAN);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cidadao cidadao = new Cidadao();
				String cpf = idField.getText();
				cidadao.setCpf(cpf);
				cidadao.consultarPeloNome();
				CarteiraVacinacao c = new CarteiraVacinacao();
				c.setId_cidadao(cidadao.getId());

				try {
					if (cidadao.existeCidadao()) {
						JOptionPane.showMessageDialog(null,
								"Este cidadão não pode ser deletado, já iniciou sua fase de vacinação.");
						idField.setText("");
					} else {
						cidadao.apagarC();
						idField.setText("");
					}
				} catch (Exception e) {
				}

			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnVoltar.setBounds(703, 477, 97, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicioCidadao tela = new TelaInicioCidadao();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnVoltar.setForeground(new Color(0, 0, 0));
		btnVoltar.setBackground(Color.CYAN);
		
		JLabel lblObrigatorio = new JLabel("");
		lblObrigatorio.setBounds(176, 72, 45, 0);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(664, 150, 64, 19);
		contentPane.add(lblNewLabel);
		contentPane.add(btnExcluir);
		contentPane.add(idField);
		contentPane.add(lblObrigatorio);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("Voltar\r\n");
		lblNewLabel_1.setFont(new Font("Roboto Cn", Font.PLAIN, 28));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setIcon(new ImageIcon(TelaExcluirCidadao.class.getResource("/Imagens/Excluir cidadao Atualizado.png")));
		lblNewLabel_1.setBounds(0, -183, 1440, 900);
		contentPane.add(lblNewLabel_1);
	}
}
