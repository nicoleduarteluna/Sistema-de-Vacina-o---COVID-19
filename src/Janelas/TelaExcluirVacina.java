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
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Controle.Vacina;

public class TelaExcluirVacina extends JFrame {

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
					TelaExcluirVacina frame = new TelaExcluirVacina();
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
	public TelaExcluirVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		idField = new JTextField();
		idField.setCaretColor(Color.WHITE);
		idField.setBorder(new MatteBorder(0, 1, 2, 1, (Color) Color.CYAN));
		idField.setOpaque(false);
		idField.setForeground(Color.WHITE);
		idField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		idField.setBounds(616, 176, 210, 30);
		idField.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir Vacina");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcluir.setBounds(649, 219, 145, 31);
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setBackground(Color.CYAN);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vacina vacina = new Vacina();
				String nome = idField.getText();
				vacina.setNome(nome);
				String IDVacina = vacina.consultarID();
				Controle.CarteiraVacinacao c = new Controle.CarteiraVacinacao();
				c.setId_vacina(IDVacina);

				try {
					if (vacina.existeVacina()) {
						JOptionPane.showMessageDialog(null,
								"Esta vacina não pode ser deletado, há registros em carteiras de vacinações.");
						idField.setText("");
					} else {
						vacina.apagarC();
						idField.setText("");
					}
				} catch (Exception e) {
					
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Insira o nome da vacina");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(610, 141, 225, 29);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltar.setBounds(688, 453, 76, 30);
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
		
		JLabel lblObrigatorio = new JLabel("");
		lblObrigatorio.setBounds(176, 72, 45, 0);
		contentPane.setLayout(null);
		contentPane.add(btnExcluir);
		contentPane.add(lblObrigatorio);
		contentPane.add(btnVoltar);
		contentPane.add(idField);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fundo Tela Excluir Vacina");
		lblNewLabel_1.setIcon(new ImageIcon(TelaExcluirVacina.class.getResource("/Imagens/Tela Excluir Vacina.png")));
		lblNewLabel_1.setBounds(1, 2, 855, 497);
		contentPane.add(lblNewLabel_1);
	}
}
